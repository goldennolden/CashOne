/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casinosimulation;
import java.util.Scanner;

/**
 *
 * @author nolde
 */
public class BankAccount {
    
    private static double totalDeposit;
    private static double balance;
    private static double accumulatedWL;
    
    public BankAccount()
    {
        totalDeposit = 0.0;
        balance = 0.0;
        accumulatedWL = 0.0;
    }
    public BankAccount(double startBalance)
    {
       balance = startBalance;
    }
    public BankAccount(String str)
    {
       balance = Double.parseDouble(str);
    }
    public void deposit(double amount)
    {
        balance += amount;
    }
    public void deposit(String str)
    {
        balance += Double.parseDouble(str);
    }
    public void withdraw(double amount)
    {
        balance -= amount;
    }
    public void withdraw(String str)
    {
        balance -= Double.parseDouble(str);
    }
    public void setBalance(double b)
    {
        balance = b;
    }
    public void setBalance(String str)
    {
        balance = Double.parseDouble(str);
    }
    public static double getBalance()
    {
        return balance;
    }
    public static void Deposit(double depositAmnt)
    {
        Scanner myScanner = new Scanner(System.in);
        if(depositAmnt < 20 || depositAmnt > 1000)
        {
            while (depositAmnt < 20 || depositAmnt > 1000)
            {
                System.out.println("Error! Please enter an amount between"
                        + " $20 and $1000");
                System.out.println("Please enter amount: ");
                depositAmnt = myScanner.nextDouble();
                if(depositAmnt >= 20 && depositAmnt <=1000)
                {
                    balance += depositAmnt;
                    totalDeposit += depositAmnt;
                }
            }
        }
        else
            balance += depositAmnt;
            totalDeposit += depositAmnt;
    }
    
    public static double trackWL(double wlAmnt)
    {
        accumulatedWL = wlAmnt;
        return accumulatedWL;
    }
    public static void Win(double winAmnt)
    {
        balance = balance + winAmnt;
    }
    public static void Lose(double loseAmnt)
    {
        balance = balance - loseAmnt;
    }
    public static void displayRes()
    {
        String displayBalance;
        String displayAcc;
        String displayTotalDeposit;
        displayBalance = "Your current bank is $" + balance;
        displayAcc = "Your win/loses are $" + accumulatedWL;
        displayTotalDeposit = "The total amount deposited thus far $" + totalDeposit;
        System.out.println(displayBalance);
        System.out.println(displayAcc);
        System.out.println(displayTotalDeposit);
    }
}
