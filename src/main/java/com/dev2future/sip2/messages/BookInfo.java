package com.dev2future.sip2.messages;

import java.util.Date;

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TaggedField;
import com.ceridwen.circulation.SIP.fields.FieldPolicy;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.Language;

@Command("17")
public class BookInfo extends Message {

	private static final long serialVersionUID = 7398126890693645623L;
	@PositionedField(start = 2, end = 4)
	private Language language;
	@PositionedField(start = 5, end = 22)
	private Date transactionDate;
	@TaggedField
	private String institutionId;
	@TaggedField(FieldPolicy.REQUIRED)
	private String itemIdentifier;
	@TaggedField(FieldPolicy.NOT_REQUIRED)
	private String terminalPassword;

	public String getInstitutionId() {
		return this.institutionId;
	}

	public String getItemIdentifier() {
		return this.itemIdentifier;
	}

	public String getTerminalPassword() {
		return this.terminalPassword;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void setTerminalPassword(String terminalPassword) {
		this.terminalPassword = terminalPassword;
	}

	public void setItemIdentifier(String itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
}
