import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    static double balance = 10000;
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userId = "Haritha";
        String pin = "1234";

        System.out.println("===== ATM INTERFACE =====");

        System.out.print("Enter User ID: ");
        String id = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (!id.equals(userId) || !enteredPin.equals(pin)) {
            System.out.println("Invalid Login!");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nTransaction History:");
                    if (history.isEmpty()) {
                        System.out.println("No Transactions Yet");
                    } else {
                        for (String t : history) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= balance) {
                        balance -= withdraw;
                        history.add("Withdraw: Rs." + withdraw);
                        System.out.println("Withdrawal Successful");
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                    break;

                case 3:
                    System.out.print("Enter Amount: ");
                    double deposit = sc.nextDouble();

                    balance += deposit;
                    history.add("Deposit: Rs." + deposit);

                    System.out.println("Deposit Successful");
                    break;

                case 4:
                    System.out.println("Current Balance: Rs." + balance);
                    break;

                case 5:
                    System.out.println("Thank You For Using ATM");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}