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
public class Blackjack {
   private static double bet;
   private static boolean betComplete;
   private static double accumulated;
   private static int userSum;
   private static int computerSum;
   Scanner myScanner = new Scanner(System.in);
   public Blackjack()
   {
       userSum = 0;
       computerSum = 0;
   }
   public static void computerRoll()
{
    boolean keepRolling = false;
    String displayTotal;
    Dice die = new Dice();
    die.roll();
    int roll1Value = die.getValue();
    die.roll();
    int roll2Value = die.getValue();
    computerSum = roll1Value + roll2Value;
    if(computerSum <= 15)
    {
        keepRolling =true;
        while(keepRolling = true)
        {
    die.roll();
    int roll3Value = die.getValue();
    computerSum += roll3Value;
    if(computerSum>15)
    {
        keepRolling = false;
        break;
    }
        }
    }
}
   public static void userRollValue()
{
    Dice die = new Dice();
    die.roll();
    int roll1Value = die.getValue();
    die.roll();
    int roll2Value = die.getValue();
    userSum = roll1Value + roll2Value;
    getDecision();
}
   public static void setBet()
    {
        double tempbet;
        BankAccount.getBalance();
        BankAccount.displayRes();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter amount to bet: ");
        tempbet = myScanner.nextDouble();
        if(tempbet > BankAccount.getBalance())
        {
            while(tempbet>BankAccount.getBalance())
            {
                System.out.println("Try Again. You don't have that many funds!");
                System.out.println("Enter new bet: ");
                tempbet = myScanner.nextDouble();
                if(bet<=BankAccount.getBalance() && tempbet > 0)
                {
                    System.out.println("Your current bet is: $" + tempbet);
                    bet=tempbet;
                    betComplete = true;
                    break;
                }
                else
                {
                    System.out.println("Invalid Bet. Try Again!");
                    tempbet = myScanner.nextDouble();
                    if(bet<=BankAccount.getBalance() && tempbet > 0)
                    {
                    System.out.println("Your current bet is: $" + tempbet);
                    bet=tempbet;
                    betComplete = true;
                    break;
                    }
                }
            }
        }
        else
        {
            System.out.println("Your current bet is: $" + tempbet);
                    bet=tempbet;
                    betComplete = true;
        }
    }
    public static void playBlackjack()
    {
        if(betComplete = true);
        {
            computerRoll();
            userRollValue();
            betComplete = false;
        }    
            
    }
    public static void getDecision()
    {
        Scanner myScanner = new Scanner(System.in);
        int userChoice;
        String displayTotal;
        displayTotal = "Your current total is " + userSum;
        System.out.println(displayTotal);
        System.out.println("Want to roll again? (1 = Yes, 2 = No:)");
        userChoice = myScanner.nextInt();
        if(userChoice == 1 && userSum <= 21)
        {
            rollAgain();
        }
        else if(userChoice == 2)
        {
            displayResults();
        }
    }
    public static void rollAgain()
{
    Dice die = new Dice();
    int roll1Value = die.getValue();
    die.roll();
    userSum += roll1Value;
    while (userSum > 21)
    {
        System.out.println("You went over 21! You Lost! HAHAHAHAHA!");
        BankAccount.Lose(bet);
        break;
    }
     getDecision();
}

public static void displayResults()
{
    System.out.println("Your points: " + userSum);
    System.out.println("My Points:" + computerSum);
    System.out.println("Game Over Man");
    if(userSum > computerSum && userSum <=21)
    {
        System.out.println("Lucky! You won!");
        BankAccount.Win(bet*2);
        accumulated = BankAccount.trackWL(bet*2);
        System.out.println("The current winnings/losses is &" + accumulated);
        System.out.println("The current balance is $" + BankAccount.getBalance());
        System.out.println();
    }
    else if (userSum == computerSum)
    {
        System.out.println("Tie Game");
        System.out.println("The current balance is $" + BankAccount.getBalance());
        System.out.println();
    }
    else
    {
        System.out.println("You lost! HAHAHAHAHA!");
        BankAccount.Lose(bet);
        accumulated = BankAccount.trackWL(bet);
        System.out.println("The current winnings/losses is &" + accumulated);
        System.out.println("The current balance is $" + BankAccount.getBalance());
        System.out.println();
    }
}
}
