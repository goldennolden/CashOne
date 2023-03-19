/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casinosimulation;
import java.util.Random;

/**
 *
 * @author nolde
 */
public class Dice {
    private final int sides = 6;
    private int value;
    public static int userSum;
    public static int computerSum;
    
  Dice()
{
   roll();
}
public void roll()
{
    Random rand = new Random();
    value = rand.nextInt(sides)+1;
}
public int getComputerSum()
{
    return computerSum;
}
public int getUserSum()
{
    return userSum;
}
public int getValue()
{
    return value;
}
}
