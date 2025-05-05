
import java.util.Scanner;
public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int accountID;
        String  accountHolder;
        int balance;
        BankAccount account;
        int option = 0;
        int deposit;
        int withdraw;
        
        System.out.println("===================Bank Accounting App=========================");
        try {
            System.out.println("Write the id of the account: ");
            accountID = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Write the name of the account holder: ");
            accountHolder = scanner.next();
            System.out.println("Write the initial balance for the accont");
            balance = scanner.nextInt();
            scanner.nextLine();
            account = new BankAccount(accountID,accountHolder,balance);
            System.out.println("Account created");


            while(option != 5){
                System.out.println("===================Bank Accounting App=========================");
                System.out.println("What do you want to do?");
                System.out.println("1) Check Balance");
                System.out.println("2) Deposit Founds");
                System.out.println("3) Withdraw founds");
                System.out.println("4) Check Account info");
                System.out.println("5) Exit");
                
                option = scanner.nextInt();
                scanner.nextLine();
                
                switch (option){
                    case 1:
                        System.out.println("======================Check Balance============================");
                        System.out.println("Your balance is: ");
                        System.out.println(account.getBalance());
                        break;
                    case 2:
                        System.out.println("===========================Deposit Founds==============================");
                        try {
                            System.out.println("Write the amount you want to deposit:");
                            deposit = scanner.nextInt();
                            scanner.nextLine();
                            account.depositFounds(deposit);
                        }catch (InvalidAmountException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try{
                            System.out.println("===========================Withdraw Founds==============================");
                            System.out.println("Write the amount you want to withdraw: ");
                            withdraw = scanner.nextInt();
                            scanner.nextLine();
                            account.withdrawingFunds(withdraw);
                        }catch (InsufficientFundsException | InvalidAmountException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("===========================Check account info==================================");
                        System.out.println(account.toString());
                        break;
                    case 5:
                        System.out.println("Exiting");
                        break;

                }
            }
        }catch (InvalidAmountException e){
            System.out.println("Error with deposit: " + e.getMessage());
        }
        finally {
            System.out.println("Try to add a new account with valid data");
        }

        scanner.close();
    }
}
