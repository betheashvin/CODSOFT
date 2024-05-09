package Task3;
import java.util.Scanner;

public class ATM {
    Scanner scan = new Scanner(System.in);
    BankAccount acc = new BankAccount(500);
    double balance = acc.getBalance();
    public int display()
    {
        System.out.println("----------Standard Bank----------");
        System.out.println("\tMain Menu");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.View Balance");
        System.out.println("4.Exit"); // IS THERE A NEED?

        while(true) {
            System.out.println("Kindly enter a number: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the amount that you wish to deposit: ");
                    double dAmount = scan.nextDouble();
                    deposit(dAmount);
                    break;
                }
                case 2: {
                    System.out.println("Enter the amount that you wish to withdraw: ");
                    double wAmount = scan.nextDouble();
                    withdraw(wAmount);
                    break;
                }
                case 3:
                {
                    checkBalance();
                    break;
                }
                case 4:
                {
                    System.out.println("Goodbye! Hope to see you again.");
                    return 0;
                }
            }
        }
        // return 1;
    }

    public void deposit(double amount)
    {
        if (amount<=0)
            System.out.println("Sorry. The deposit has failed. Kindly enter the amount more than 0 (zero).");
        else {
            this.balance += amount;
            acc.setBalance(this.balance);
            System.out.println("Deposit successful! The new balance is " + acc.getBalance() + ".");
        }    }

    public void withdraw(double amount)
    {
        if (amount>this.balance)
            System.out.println("Sorry. The withdrawal has failed due to insufficient funds.");
        else if (amount<=0)
            System.out.println("Sorry. The withdrawal has failed. Kindly enter the amount more than 0 (zero).");
        else {
            balance -= amount;
            acc.setBalance(this.balance);
            System.out.println("Withdrawal successful! The new balance is " + acc.getBalance() + ".");
            }
    }

    public void checkBalance() {
        System.out.println("The current balance is " + acc.getBalance() + ".");
    }


}
