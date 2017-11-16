package com.mybank.bankAccout.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mybank.bankAccount.service.BankAccount;

public class TransactionsManagerTests {

	private static final String HISTORY = "====================\n" + "Your balance is: 300.0\n" + "Transactions:\n"
			+ "2017-11-16 21:51:06  amount: 100.0 is accepted. balance: 100.0\n"
			+ "2017-11-16 21:51:09  amount: 200.0 is accepted. balance: 300.0\n" + "====================";

	@Test
	public void depositTest() {
		BankAccount tm = new BankAccount();
		int res1 = tm.executeTransaction(1000, "");
		assertEquals(res1, 1, 0);
	}

	@Test
	public void withdrawlTest() {
		BankAccount tm = new BankAccount();
		int res1 = tm.executeTransaction(1000, "");
		assertEquals(res1, 1, 0);
		int res2 = tm.executeTransaction(200, "");
		assertEquals(res2, 1, 0);
	}

	@Test
	public void haveEnoughMoneyTest() {
		BankAccount tm = new BankAccount();
		int res1 = tm.executeTransaction(100, "");
		assertEquals(res1, 1, 0);
		int res2 = tm.executeTransaction(200, "");
		assertEquals(res2, 1, 0);
		int res3 = tm.executeTransaction(-300, "");
		assertEquals(res3, 1, 0);
	}

	@Test
	public void dontHaveEnoughMoneyTest() {
		BankAccount tm = new BankAccount();
		int res1 = tm.executeTransaction(100, "");
		assertEquals(res1, 1, 0);
		int res2 = tm.executeTransaction(200, "");
		assertEquals(res2, 1, 0);
		int res3 = tm.executeTransaction(-301, "");
		assertEquals(res3, -1, 0);
	}

	// TODO: Split History to remove TimeStamp
	@Test
	public void getHistoryTest() {
		BankAccount tm = new BankAccount();
		int res1 = tm.executeTransaction(100, "");
		assertEquals(res1, 1, 0);
		int res2 = tm.executeTransaction(200, "");
		assertEquals(res2, 1, 0);
		String st = tm.getHistory();
		assertEquals(st, HISTORY);
	}
}
