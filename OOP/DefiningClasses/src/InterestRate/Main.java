package InterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String command = reader.readLine();
            if("End".equals(command)) {
                break;
            }
            String[] commandArgs = command.split("\\s+");
            switch (commandArgs[0]){
                case "Create":
                    createAcc(accounts);
                    break;
                case "Deposit":
                    deposit(commandArgs[1],commandArgs[2],accounts);
                    break;
                case "SetInterest":
                    setInterest(commandArgs[1]);
                    break;
                case "GetInterest":
                    getInterest(commandArgs[1], commandArgs[2],accounts);
                    break;
            }
        }
    }

    private static void getInterest(String arg, String arg2, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(arg);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            System.out.println(String.format("%.2f", acc.getInterest(Integer.valueOf(arg2))));
        }
    }

    private static void setInterest(String arg1) {
        double interest = Double.valueOf(arg1);
        InterestRate.BankAccount.setInterestRate(interest);
    }

    private static void deposit(String arg1, String arg2, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(arg1);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            acc.deposit(Double.valueOf(arg2));
            accounts.put(id, acc);
            System.out.println(String.format("Deposited %d to %s", Integer.valueOf(arg2), acc));
        }
    }

    private static void createAcc(HashMap<Integer, BankAccount> accounts) {
            BankAccount acc = new BankAccount();
            accounts.put(acc.getId(), acc);
            System.out.println(String.format("Account %s created", acc));
    }
}
