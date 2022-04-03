package BankAcc;

public class BankAccount {
    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount < 0){
            System.out.println("Negative amount deposited.");
        }else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount){
        if(amount < 0){
            System.out.println("Negative amount withdrawn.");
        }
        else if(this.balance < amount){
            System.out.println("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
