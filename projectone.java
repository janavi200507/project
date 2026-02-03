import java.util.Scanner;

// Parent class
class BankAccount {
    protected double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    double getBalance() {
        return balance;
    }
}

// Child class
class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
    }

    void addInterest() {
        balance = balance + (balance * 0.05);
        System.out.println("Interest added");
    }
}

// Child class
class CurrentAccount extends BankAccount {

    CurrentAccount(double balance) {
        super(balance);
    }

    void deductCharge() {
        balance = balance - 200;
        System.out.println("Service charge deducted");
    }
}
public class projectone{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount acc;

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = sc.nextInt();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        if (choice == 1)
            acc = new SavingsAccount(balance);
        else
            acc = new CurrentAccount(balance);

        acc.deposit(1000);
        acc.withdraw(500);

        if (acc instanceof SavingsAccount)
            ((SavingsAccount) acc).addInterest();
        else
            ((CurrentAccount) acc).deductCharge();

        System.out.println("Final Balance: " + acc.getBalance());
        sc.close();
    }
}
