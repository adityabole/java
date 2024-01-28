import java.util.Scanner;

public class ATM {
    private static double balance = 1000; // Initial balance
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        
        while (!quit) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        
        scanner.close();
    }
    
    private static void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }
    
    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposited $" + amount + " successfully.");
    }
    
    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}
