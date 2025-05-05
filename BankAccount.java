public class BankAccount {
    int accountNumber;
    String accountHolder;
    int balance;
    public BankAccount(int accountNumber, String accountHolder , int balance) throws InvalidAmountException {
        if (balance < 0){
            throw new InvalidAmountException("An account can't have negative balance");
        }else{
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }
    }

    public int checkingBalance (){
        return getBalance();
    }

    public void depositFounds(int deposit) throws InvalidAmountException {
        if (deposit < 0 ){
            throw new InvalidAmountException("You can't deposit a negative number");
        }
        this.balance += deposit;
    }

    public void withdrawingFunds(int withdraw) throws InsufficientFundsException, InvalidAmountException {
        if ( withdraw <0){
            throw new InvalidAmountException("Withdraw amount needs to be more than zero");
        }
        else if (withdraw > balance){
            throw new InsufficientFundsException("You can't withdraw more than your balance");
        }
        balance -= withdraw;
    }


    //Setters and Getters

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String toString(){
        return "Account ID: " + accountNumber+"\n"+"Account holder: "+accountHolder+"\n"+"Account Balance: "+balance+"\n";
    }
}
