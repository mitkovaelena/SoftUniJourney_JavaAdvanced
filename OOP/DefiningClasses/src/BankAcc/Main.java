package BankAcc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        HashMap<Integer,BankAccount> accounts = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String command = reader.readLine();
            if("End".equals(command)) {
                break;
            }
            String[] commandArgs = command.split("\\s+");
            switch (commandArgs[0]){
                case "Create":
                    createAcc(commandArgs[1],accounts);
                    break;
                case "Deposit":
                    deposit(commandArgs[1],commandArgs[2],accounts);
                    break;
                case "Withdraw":
                    withdraw(commandArgs[1],commandArgs[2],accounts);
                    break;
                case "Print":
                    printAcc(commandArgs[1],accounts);
                    break;
            }
        }
    }

    private static void printAcc(String commandArg, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(commandArg);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            System.out.println(String.format("Account %s, balance %.2f", acc, acc.getBalance()));
        }
    }

    private static void withdraw(String arg1, String arg2, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(arg1);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            acc.withdraw(Integer.valueOf(arg2));
            accounts.put(id, acc);
        }
    }

    private static void deposit(String arg1, String arg2, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(arg1);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            acc.deposit(Integer.valueOf(arg2));
            accounts.put(id, acc);
        }
    }

    private static void createAcc(String commandArg, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(commandArg);
        if (accounts.containsKey(id)){
            System.out.println("Account already exists");
        } else {
            BankAccount acc = new BankAccount();
            acc.setId(id);
            accounts.put(id, acc);
        }
    }
}
