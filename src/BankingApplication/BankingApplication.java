package BankingApplication;

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        SavingsAccount savingsAccount = new SavingsAccount("MJ","SA001", 10000, 7);
        CurrentAccount currentAccount = new CurrentAccount("Mic","CA001", 50000);

        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Current Account Balance: " + currentAccount.getBalance());

        System.out.print("Enter amount to deposit into savings account: ");
        double depositAmount = scanner.nextDouble();
        savingsAccount.deposit(depositAmount);

        System.out.print("Enter amount to withdraw from savings account: ");
        double withdrawAmount = scanner.nextDouble();
        savingsAccount.withdraw(withdrawAmount);
        savingsAccount.calculateInterest();

        System.out.print("Enter amount to deposit into current account: ");
        depositAmount = scanner.nextDouble();
        currentAccount.deposit(depositAmount);

        System.out.print("Enter amount to withdraw from current account: ");
        withdrawAmount = scanner.nextDouble();
        currentAccount.withdraw(withdrawAmount);

        System.out.println("Updated Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Updated Current Account Balance: " + currentAccount.getBalance());
    }
}
