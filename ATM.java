
import java.util.Scanner;

class ATM_Machine {
    private float balance;
    private int count = 0;
    private final int pin = 1234;
    private final Scanner sc = new Scanner(System.in);

   public void checkPin() {
    while (count < 3) {
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt(); 
        
        if (enteredPin == pin) {
            mainMenu();
            return; // exit once PIN is correct and main menu is done
        } else {
            count++;
            System.out.println("Incorrect PIN! Attempts left: " + (3 - count));
        }
    }
    
    System.out.println("Too many incorrect attempts. Your account is locked.");
}

    

    public void mainMenu() {
        while (true) {
            System.out.println("\n==== ATM Main Menu ====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            
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
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return; // exit the method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance + " Rs");
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        float amount = sc.nextFloat();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            System.out.println(amount + " Rs deposited successfully.");
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        float amount = sc.nextFloat();
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println(amount + " Rs withdrawn successfully.");
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        ATM_Machine obj = new ATM_Machine();
        obj.checkPin();
    }
}
