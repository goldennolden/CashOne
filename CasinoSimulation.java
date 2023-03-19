/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.casinosimulation;
import java.util.Scanner;

/**
 *
 * @author nolde
 */
public class CasinoSimulation {

    public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    String name;
    double input;
    System.out.println("Please enter your name: ");
    name = myScanner.nextLine();
    System.out.println("Welcome " + name + ", to Creepy Casino");
    System.out.println("Please deposit an starting amount: ");
    input = myScanner.nextDouble();
    BankAccount.Deposit(input);
    System.out.println("Your balance is " + BankAccount.getBalance());
    mainMenu();
    }
    public static void mainMenu()
    {
    System.out.println("Please pick an option below:");
    System.out.println("Select 1 to play BlackJack");
    System.out.println("Select 2 to play Slot Machine");
    System.out.println("Select 3 to deposit more money");
    System.out.println("Select 4 to exit the casino");
    selectGame();
    }
    public static void selectGame()
    {
        int playerChoice;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose a choice: ");
        playerChoice = myScanner.nextInt();
        switch (playerChoice)
        {
            case 1:
                Blackjack();
                break;
            case 2:
                SlotMachine();
                break;
            case 3:
                System.out.println("Please enter an amount to deposit: ");
                double deposit = myScanner.nextDouble();
                BankAccount.Deposit(deposit);
                mainMenu();
                break;
            case 4:
                System.out.println("Thanks for playing. Come back soon!");
                BankAccount.displayRes();
                break;
            default:
                System.out.println("Invalid selection. Pick again! \n");
                BankAccount.displayRes();
    }
    }
    public static void Blackjack()
    {
        System.out.println();
        System.out.println("You have chosen Blackjack!");
        Blackjack.setBet();
        Blackjack.playBlackjack();
        mainMenu();
    }
    public static void SlotMachine()
    {
        System.out.println();
        SlotMachine game = new SlotMachine();
        System.out.println("You have chosen Slot Machine!");
        game.setBet();
        game.Slots();
        game.replaySlots();
        mainMenu();
    }
}