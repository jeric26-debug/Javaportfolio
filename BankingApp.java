import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private int id;
    private int pin;
    private String name;
    private double balance;

    public User(int id, int pin, String name, double balance) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class BankingApp {
    private static Map<Integer, User> users = new HashMap<>();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        users.put(412435, new User(412435, 7452, "Chris Sandoval", 32000));
        users.put(264863, new User(264863, 1349, "Marc Yim", 1000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Check Balance");
            System.out.println("3. Cash-in");
            System.out.println("4. Money Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    cashIn(scanner);
                    break;
                case 4:
                    moneyTransfer(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter user ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        User user = users.get(id);
        if (user != null && user.getPin() == pin) {
            loggedInUser = user;
            System.out.println("Login successful. Welcome, " + user.getName() + "!");
        } else {
            System.out.println("Invalid user ID or PIN.");
        }
    }

    private static void checkBalance() {
        if (loggedInUser != null) {
            System.out.println("Current balance: " + loggedInUser.getBalance());
        } else {
            System.out.println("Please login first.");
        }
    }

    private static void cashIn(Scanner scanner) {
        if (loggedInUser != null) {
            System.out.print("Enter amount to cash-in: ");
            double amount = scanner.nextDouble();
            loggedInUser.setBalance(loggedInUser.getBalance() + amount);
            System.out.println("Cash-in successful. New balance: " + loggedInUser.getBalance());
        } else {
            System.out.println("Please login first.");
        }
    }

    private static void moneyTransfer(Scanner scanner) {
        if (loggedInUser != null) {
            System.out.print("Enter recipient user ID: ");
            int recipientId = scanner.nextInt();
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();

            User recipient = users.get(recipientId);
            if (recipient != null && loggedInUser.getBalance() >= amount) {
                loggedInUser.setBalance(loggedInUser.getBalance() - amount);
                recipient.setBalance(recipient.getBalance() + amount);
                System.out.println("Transfer successful. New balance: " + loggedInUser.getBalance());
            } else {
                System.out.println("Transfer failed. Check recipient ID and balance.");
            }
        } else {
            System.out.println("Please login first.");
        }
    }
}
