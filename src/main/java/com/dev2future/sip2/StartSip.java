package com.dev2future.sip2;

import java.util.Date;

<<<<<<< HEAD
import org.junit.Test;

=======
>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0
import com.ceridwen.circulation.SIP.exceptions.ChecksumError;
import com.ceridwen.circulation.SIP.exceptions.InvalidFieldLength;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.exceptions.RetriesExceeded;
import com.ceridwen.circulation.SIP.exceptions.SequenceError;
import com.ceridwen.circulation.SIP.messages.ItemInformation;
import com.ceridwen.circulation.SIP.messages.Login;
import com.ceridwen.circulation.SIP.messages.LoginResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.PatronInformation;
import com.ceridwen.circulation.SIP.messages.PatronInformationResponse;
import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.transport.Connection;
import com.ceridwen.circulation.SIP.transport.SocketConnection;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
<<<<<<< HEAD
import com.dev2future.sip2.messages.BookInfo;
=======
>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0

/**
 * Sip2 测试
 *
 */
public class StartSip {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		SocketConnection connect = new SocketConnection();
		connect.setHost("202.118.225.181");
		connect.setPort(2007);
		connect.setConnectionTimeout(30000);
		connect.setIdleTimeout(30000);
		connect.setRetryAttempts(2);
		connect.setRetryWait(500);
<<<<<<< HEAD
		userInfo(connect);
		try {
			//connect.connect();
=======

		try {
			connect.connect();
>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0
			System.out.println("==>" + connect.getHost() + "连接成功");
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("==>" + connect.getHost() + "连接失败" + e1.getMessage());
			return;
		}

		// 登录
		if (login(connect)) {
			// 查询图书信息
<<<<<<< HEAD
			bookInfo(connect);

			// 查询用户信息
			// userInfo(connect);
=======
			// bookInfo(connect);

			// 查询用户信息
			userInfo(connect);
>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0
		}

		try {
			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 登录
	 * 
	 * @param connect
	 */
	public static boolean login(Connection connect) {

		System.out.println("==>开始登录");

		Message requestLogin = null, responseLogin = null;

		requestLogin = new Login();

		((Login) requestLogin).setUIDAlgorithm("Y");
		((Login) requestLogin).setPWDAlgorithm("Y");
		((Login) requestLogin).setLoginUserId("AC14");
		((Login) requestLogin).setLoginPassword("123456");
		((Login) requestLogin).setLocationCode("ER-WORD05");

		try {
			System.out.println("==>Send:" + requestLogin.encode());
			responseLogin = connect.send(requestLogin);

			System.out.println("<==Receive:" + responseLogin.encode());
			if (((LoginResponse) responseLogin).isOk()) {
				System.out.println("<==Login Success.");
				return true;
			} else {
				System.out.println("<==Login Fail.");
				return false;
			}

		} catch (RetriesExceeded | ChecksumError | SequenceError | MessageNotUnderstood | MandatoryFieldOmitted
				| InvalidFieldLength e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param connect
	 */
	public static void userInfo(Connection connect) {

		System.out.println("==>查询用户信息");

		PatronInformation patronInformationRequest = new PatronInformation();

		// 语言
		patronInformationRequest.setLanguage(Language.ENGLISH);

<<<<<<< HEAD
		// patronInformationRequest.setInstitutionId("HGD");
=======
		//patronInformationRequest.setInstitutionId("HGD");
>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0

		patronInformationRequest.setTransactionDate(new Date());

		patronInformationRequest.setPatronIdentifier("W9911005");

		try {
			System.out.println("==>Send:");

			System.out.println(patronInformationRequest.encode());

			PatronInformationResponse patronInformationResponse = (PatronInformationResponse) connect
					.send(patronInformationRequest);

<<<<<<< HEAD
			System.out.println("<==Receive:");
=======
			System.out.println("Receive:");
>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0

			System.out.println(patronInformationResponse.encode());

		} catch (MandatoryFieldOmitted | InvalidFieldLength | MessageNotUnderstood | RetriesExceeded | ChecksumError
				| SequenceError e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取图书信息
	 * 
	 * @param connect
	 */
	public static void bookInfo(Connection connect) {

		System.out.println("==>查询书籍信息");

<<<<<<< HEAD
		Message bookInfoRequest = new BookInfo();// new ItemInformation();

		((BookInfo) bookInfoRequest).setLanguage(Language.CHINESE);

		((BookInfo) bookInfoRequest).setTransactionDate(new Date());
		// 机构标识
		((BookInfo) bookInfoRequest).setInstitutionId("AC14");
		// 书籍标识
		((BookInfo) bookInfoRequest).setItemIdentifier("4011486276");

//		((ItemInformation) bookInfoRequest).setTransactionDate(new Date());
//		// 机构标识
//		((ItemInformation) bookInfoRequest).setInstitutionId("AC14");
//		// 书籍标识
//		((ItemInformation) bookInfoRequest).setItemIdentifier("4011486276");
		// ((ItemInformation) bookInfoRequest).setTerminalPassword("123456");
=======
		Message bookInfoRequest = new ItemInformation();
		((ItemInformation) bookInfoRequest).setTransactionDate(new Date());
		// 机构标识
		((ItemInformation) bookInfoRequest).setInstitutionId("AC14");
		// 书籍标识
		((ItemInformation) bookInfoRequest).setItemIdentifier("010200A16A130044CCF70200");
		// ((ItemInformation) bookInfoRequest).setTerminalPassword("123456");

>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0
		try {

			System.out.println("==>Send:");

			System.out.println(bookInfoRequest.encode());

			Message bookInfoResponse = connect.send(bookInfoRequest);

			System.out.println("<==Receive:");

			System.out.println(bookInfoResponse.encode());

		} catch (RetriesExceeded | ChecksumError | SequenceError | MessageNotUnderstood | MandatoryFieldOmitted
				| InvalidFieldLength e) {
			e.printStackTrace();
		}
	}

	/**
	 * 请求用户状态
	 * 
	 * @param connect
	 */
	public static void patronStatus(Connection connect) {
		PatronStatusRequest psr = new PatronStatusRequest();
<<<<<<< HEAD

=======
		
		
>>>>>>> cfcfe9c3741bff8f647c3898b2e82fe11276edd0
	}
}
