package com.mybank.bankAccount.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mybank.bankAccount.dto.Transaction;

public class BankAccount {

	private List<Transaction> dealTransactions = new ArrayList<Transaction>();

	private double amountBalance = 0;

	/**
	 * execute Transaction
	 * 
	 * @param amount
	 * @param summary
	 * @return
	 */
	public int executeTransaction(double amount, String summary) {
		int ret = 0;
		boolean accepted = false;
		if (amount < 0) {
			// if withdrawl check if amount < amountBalance
			// check if amount is less than amountBalance
			if (haveEnoughMoneyInAccount(amount)) {
				accepted = true;
				ret = 1;
			} else {
				System.out.println("your don't have enough money in this Account.");
				ret = -1;
			}
		} else {
			// deposit
			accepted = true;
			ret = 1;
		}
		saveDeal(amount, summary, accepted);
		return ret;
	}

	/**
	 * save Deal
	 * @param amount
	 * @param summary
	 * @param accepted
	 */
	private void saveDeal(double amount, String summary, boolean accepted) {
		dealTransactions.add(new Transaction(new Timestamp(System.currentTimeMillis()), amount, summary, accepted));
		// if it is rejected i don't change amountBalance
		if (accepted) {
			amountBalance += amount;
		}
		System.out.println("====================");
		System.out.println("Your savings account's balance is " + amountBalance);
		System.out.println("====================");
	}

	/**
	 * get History
	 * 
	 * @return
	 */
	public String getHistory() {
		double balance = 0;

		StringBuilder st = new StringBuilder();

		st.append("====================");
		st.append("\n");
		st.append("Your balance is: " + amountBalance);
		st.append("\n");
		st.append("Transactions:");
		st.append("\n");
		for (Transaction transaction : dealTransactions) {
			if (transaction.isAccepted()){
				balance += transaction.getAmount();
			}
			st.append(transaction.toString() + " balance: " + balance);
			st.append("\n");
		}
		st.append("====================");
		st.append("\n");

		return st.toString();
	}

	/**
	 * have Enough Money In Account
	 * 
	 * @param amount
	 * @return
	 */
	private boolean haveEnoughMoneyInAccount(double amount) {
		return (amountBalance >= -amount);
	}
}
