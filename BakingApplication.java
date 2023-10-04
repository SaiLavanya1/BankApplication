import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount("Sai", "A20516764");
        obj1.showMenu();

    }

}

class BankAccount {
    int balance;
    int previousTranscation;
    String customerName;
    String customerId;

    public BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTranscation = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTranscation = -amount;
        }
    }

    void getPreviousTranscation() {
        if (previousTranscation > 0) {
            System.out.println("Deposited: " + previousTranscation);
        } else if (previousTranscation < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTranscation));
        } else {
            System.out.println("No Transcation Occured");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID " + customerId);
        System.out.println("\n");

        System.out.println("A : Check your Balance");
        System.out.println("B : Deposit");
        System.out.println("c : Withdraw");
        System.out.println("D : Previous Transcation");
        System.out.println("E : Exit the System");

        do {
            System.out.println("=*=*=*=*=*");
            System.out.println("Enter your option");
            System.out.println("=*=*=*=*=*");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("---------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("---------------------------------");
                    System.out.println("Enter an amount to deposit ");
                    System.out.println("---------------------------------");

                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("---------------------------------");
                    System.out.println("Enter an amount to withdraw ");
                    System.out.println("---------------------------------");

                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("---------------------------------");
                    getPreviousTranscation();
                    System.out.println("---------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("===================================");
                    break;

                default:
                    System.out.println("Invalid Option! Please Enter Correct Option...");
                    break;
            }
        } while (option != 'E');
        System.out.println("This is a simple Banking Application");
    }
}