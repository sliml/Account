package com.mybank.bankAccount;

import java.util.Scanner;

import com.mybank.bankAccount.service.BankAccount;

/**
 * @author slim.lassoued
 *
 */

public class AccountControllerFromConsole {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Scanner
		Scanner scan = new Scanner(System.in);
		// Transaction that we can store if we want
		int numChoice = 0;

		BankAccount tm = new BankAccount();

		double amount = 0;
		do {
			numChoice = intiChoicePrint(scan);

			// DEPOSIT
			if (numChoice == 1) {
				amount = 0;
				// chose positive amount for deposit
				System.out.println("====================");
				System.out.println("Enter amount to deposit in the account: ");
				System.out.println("====================");

				do {
					System.out.println("Please chose a positive amount");
					while (!scan.hasNextDouble()) {
						scan.next();
						System.out.println("Please chose an amount");
					}
					amount = scan.nextDouble();
				} while (amount <= 0);

				int confirmTran = confirmeTransaction(scan, amount);

				if (confirmTran == 1) {
					int result = tm.executeTransaction(amount, "Deposit");
					if (result > 0) {
						System.out.println("Transaction is accepted.");
					} else {
						System.out.println("Transaction is rejected.");
					}
				} else {
					System.out.println("Transaction is canceled.");
				}

			} else if (numChoice == 2) {
				// WITHDRAWAL
				amount = 0;
				// chose positive amount to be withdrawl
				System.out.println("====================");
				System.out.println("Enter amount to withdrawal: ");
				System.out.println("====================");

				do {
					System.out.println("Please chose a positive amount");
					while (!scan.hasNextDouble()) {
						scan.next();
						System.out.println("Please chose an amount");
					}
					amount = scan.nextDouble();
				} while (amount <= 0);
				int confirmTran = confirmeTransaction(scan, amount);
				if (confirmTran == 1) {
					int result = tm.executeTransaction(-amount, "withdrawal");
					if (result > 0) {
						System.out.println("Transaction is accepted.");
					} else {
						System.out.println("Transaction is rejected.");
					}
				} else {
					System.out.println("Transaction is canceled.");
				}

			} else if (numChoice == 3) {
				// HISTORY
				String history = tm.getHistory();
				System.out.println(history);
			}
		} while (numChoice != 4);

		scan.close();
		System.out.println("====================");
		System.out.println("Good Bye!");
		System.out.println("====================");

	}

	/**
	 * @param scan
	 * @return
	 */
	private static int confirmeTransaction(Scanner scan, double amount) {
		// confirm Transaction
		System.out.println("====================");
		System.out.println("Do you confirme this transaction with amount:" + amount + "?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println("====================");

		int num2 = 0;
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("Please chose a number:[1/2]");
		}
		num2 = scan.nextInt();
		return num2;
	}

	/**
	 * 
	 * @param scan
	 * @return
	 */
	public static int intiChoicePrint(Scanner scan) {
		System.out.println("====================");
		System.out.println("Chose a number please");
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawal");
		System.out.println("3. Balance");
		System.out.println("4. Exit");
		System.out.println("====================");

		int num = 0;
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("Please chose a number:[1/2/3/4]");
		}
		num = scan.nextInt();

		return num;
	}
}
