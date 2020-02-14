package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         String command=reader.readLine();
        Map<Integer,BankAccount> bankAccountMap=new HashMap<>();
         while (!"End".equals(command)){
String[] tokens=command.split(" ");
if (tokens[0].equalsIgnoreCase("Create")){
    BankAccount bankAccount = new BankAccount();
    bankAccountMap.put(bankAccount.getId(),bankAccount);
    System.out.println(String.format("Account ID%d created",bankAccount.getId()));
}else if (tokens[0].equalsIgnoreCase("Deposit")){
    if (bankAccountMap.containsKey(Integer.parseInt(tokens[1]))){
        bankAccountMap.get(Integer.parseInt(tokens[1])).deposit(Double.parseDouble(tokens[2]));
        System.out.println(String.format("Deposited %s to ID%s",tokens[2],tokens[1]));
    }else {
        System.out.println("Account does not exist");
    }
}else if (tokens[0].equalsIgnoreCase("SetInterest")){
    BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
}else if (tokens[0].equalsIgnoreCase("GetInterest")){
    if (bankAccountMap.containsKey(Integer.parseInt(tokens[1]))){
        System.out.println(String.format("%.2f",bankAccountMap.get(Integer.parseInt(tokens[1])).getInterest(Integer.parseInt(tokens[2]))));
    }else {
        System.out.println("Account does not exist");
    }
}
command=reader.readLine();
         }
    }
}
