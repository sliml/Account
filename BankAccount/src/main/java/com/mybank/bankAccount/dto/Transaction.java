package com.mybank.bankAccount.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Deal
 * 
 * @author slim.lassoued
 *
 */
public final class Transaction {

	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	private final Timestamp date;

	private final double amount;

	private final String summary;
	
	private final boolean accepted;
	
	/**
	 * @return the accepted
	 */
	public boolean isAccepted() {
		return accepted;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param date
	 * @param amount
	 */
	public Transaction(Timestamp date, double amount, String summary, boolean accepted) {
		this.date = date;
		this.amount = amount;
		this.summary = summary;
		this.accepted = accepted;
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		st.append(formatter.format(date))
		.append(" ")
		.append(summary)
		.append(" amount: ")
		.append(String.valueOf(amount));
		if (accepted) {
			st.append(" is accepted.");
		}else {
			st.append(" is rejected.");
		}
		return st.toString();
	}

}
