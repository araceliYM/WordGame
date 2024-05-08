// Purpose:       Java program used for the gameplay of WordGame
// Programmer:    Araceli YM
// Created on:    5/8/2024

import java.util.Scanner;

public class GamePlay
{
   private Person userInfo;
   
   public static void main(String[] args)
   {
      Scanner scnr = new Scanner(System.in);
      String answer;
      String lastName;
      String firstName;
      boolean guessResult = false;
      GamePlay game = new GamePlay(); // Using this in order to use userInfo variable
      
      System.out.println("What is your first name?");
      firstName = scnr.next();
      
      System.out.println("Would you like to enter a last name? Type Yes or No");
      answer = scnr.next();
      
      if (answer.equals("yes") || answer.equals("Yes"))
      {
         //FIXME: validate user input
         System.out.println("What is your last name?");
         lastName = scnr.next();
         
         game.userInfo = new Person(firstName, lastName);      
      }
      else if (answer.equals("no") || answer.equals("No"))
      {
         game.userInfo = new Person(firstName);
      }
      else
      {
         System.out.println("Error: answer must be yes or no.");
      }
      
      Numbers randNum = new Numbers();
      randNum.generateNumber();
      
      while (!guessResult)
      {
         System.out.print(game.userInfo.getFirstName() + " " + game.userInfo.getLastName() + ", ");
         System.out.println("guess what number I picked between 0 and 100.");
         
         int guess = scnr.nextInt();
         guessResult = randNum.compareNumber(guess);
      }
   }
}