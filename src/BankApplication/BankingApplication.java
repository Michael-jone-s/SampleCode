package BankApplication;

import java.util.Scanner;

public class BankingApplication {

    private static final int MAX_TRANSACTIONS_PER_DAY = 3;
    private static final int MAX_TRANSACTION_AMOUNT_PER_DAY = 100000;
    private static final int MINIMUM_BALANCE = 1000;

    private double balance;
    private int transactionCount;

    public BankingApplication(double balance) {
        this.balance = balance;
        this.transactionCount = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactionCount++;
        System.out.println("Deposited " + amount + " successfully.");
    }

    public void withdraw(double amount) throws Exception {
        if (this.balance < MINIMUM_BALANCE) {
            throw new Exception("Account balance is less than " + MINIMUM_BALANCE);
        }
        if (amount > this.balance) {
            throw new Exception("Withdrawal amount is greater than account balance");
        }
        if (this.transactionCount >= MAX_TRANSACTIONS_PER_DAY) {
            throw new Exception("Transaction count limit exceeded for the day");
        }
        if (amount + getTotalTransactionsAmount() > MAX_TRANSACTION_AMOUNT_PER_DAY) {
            throw new Exception("Transaction amount limit exceeded for the day");
        }
        this.balance -= amount;
        this.transactionCount++;
        System.out.println("Withdrawn " + amount + " successfully.");
    }

    private double getTotalTransactionsAmount() {
        // TODO: Implement logic to get total transaction amount for the day
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        BankingApplication bankingApp = new BankingApplication(balance);

        while (true) {
            System.out.println("Enter the number of the operation you want to perform: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");

            int operation = scanner.nextInt();

            try {
                switch (operation) {
                    case 1 -> {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        bankingApp.deposit(depositAmount);
                    }
                    case 2 -> {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        bankingApp.withdraw(withdrawalAmount);
                    }
                    case 3 -> System.exit(0);
                    default -> System.out.println("Invalid operation number. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
