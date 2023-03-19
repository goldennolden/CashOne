/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casinosimulation;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nolde
 */
public class SlotMachine {
    private static double bet;
    private static boolean betComplete;
    private static double accumulated;
    private static int value1 ,value2, value3;
    public SlotMachine()
            {
                bet = 0;
                accumulated = 0;
                betComplete = false;
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
    public static void Slots()
    {
        Random rand = new Random();
        value1 = rand.nextInt(6)+1;
        value2 = rand.nextInt(6)+1;
        value3 = rand.nextInt(6)+1;

            switch (value1) {
                case 0 -> System.out.println("Cherries");
                case 1 -> System.out.println("Oranges");
                case 2 -> System.out.println("Plums");
                case 3 -> System.out.println("Bells");
                case 4 -> System.out.println("Melons");
                case 5 -> System.out.println("Bars");
                default -> {
                }
            }
            switch(value2) {
                case 0 -> System.out.println("Cherries");
                case 1 -> System.out.println("Oranges");
                case 2 -> System.out.println("Plums");
                case 3 -> System.out.println("Bells");
                case 4 -> System.out.println("Melons");
                case 5 -> System.out.println("Bars");
                default -> {
                }
            }
            switch(value3) {
                case 0 -> System.out.println("Cherries");
                case 1 -> System.out.println("Oranges");
                case 2 -> System.out.println("Plums");
                case 3 -> System.out.println("Bells");
                case 4 -> System.out.println("Melons");
                case 5 -> System.out.println("Bars");
                default -> {
                }
            }
            displayResults();
    }
    public static void displayResults()
{
    if(value1 == value2 || value1 == value3)
    {
        if (value2 == value3)
        {
        System.out.println("Lucky! You hit the Jackpot!");
        BankAccount.Win(bet*3);
        accumulated = BankAccount.trackWL(bet*3);
        System.out.println("The current winnings/losses is &" + accumulated);
        System.out.println("The current balance is $" + BankAccount.getBalance());
        System.out.println();
    }
    else
    {
        System.out.println("2 Matches! You get double the amount!");
        BankAccount.Win(bet*2);
        accumulated = BankAccount.trackWL(bet*2);
        System.out.println("The current winnings/losses is &" + accumulated);
        System.out.println("The current balance is $" + BankAccount.getBalance());
        System.out.println();
    }
    }
    else if (value2 == value3)
    {
        System.out.println("2 Matches! You get double the amount!");
        BankAccount.Win(bet*2);
        accumulated = BankAccount.trackWL(bet*2);
        System.out.println("The current winnings/losses is &" + accumulated);
        System.out.println("The current balance is $" + BankAccount.getBalance());
        System.out.println();
    }
    else if(value1 != value2 && value1 != value3)
    {
        System.out.println("You lost! HAHAHAHAHA!");
        BankAccount.Lose(bet);
        accumulated = BankAccount.trackWL(bet);
        System.out.println("The current winnings/losses is &" + accumulated);
        System.out.println("The current balance is $" + BankAccount.getBalance());
        System.out.println();
    }
}
    public static void replaySlots()
    {
        Scanner myScanner = new Scanner(System.in);
        int playerChoice;
        boolean playAgain;
        System.out.println("Would you like to play again? 1 for yes,"
                + " 2 for no: ");
          playerChoice = myScanner.nextInt();
          if(playerChoice == 1)
          {
              playAgain = true;
              Slots();
          }
          else if(playerChoice == 2)
          {
              playAgain = false;
              CasinoSimulation.mainMenu();
          }
    }
}
