package InterestRate;

public class BankAccount {
    private static final double DEFAULT_RATE = 0.02;

    private static double rate = DEFAULT_RATE;
    private static int accCount;

    private int id;
    private double balance;

    public int getId() {
        return id;
    }

    public BankAccount() {
        this.id = ++accCount;
        this.balance = 0.0;
    }

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

    public static void setInterestRate(Double interest){
        rate = interest;
    }

    public double getInterest(Integer years){
        return this.balance*rate*years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
