package BankingApplication;

public class Account {
    private String accountNumber;

    private String name;
    private double balance;

    public Account(String name,String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String name,String accountNumber, double balance, double interestRate) {
        super(name,accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
}

class CurrentAccount extends Account {
    private static final double FEE_PER_10000 = 5;
    private static final double FEE_LIMIT = 50000;

    public CurrentAccount(String name,String accountNumber, double balance) {
        super(name,accountNumber, balance);
    }

    public void withdraw(double amount) {
        if (amount > FEE_LIMIT) {
            double fee = Math.floor(amount / 10000) * FEE_PER_10000;
            super.withdraw(amount + fee);
        } else {
            super.withdraw(amount);
        }
    }
}

