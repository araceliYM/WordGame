// Purpose:       Java program used for the gameplay of WordGame
// Programmer:    Araceli YM
// Created on:    5/8/2024

import java.util.Scanner;

public class GamePlay
{
   private static Players player;
   
   public static void main(String[] args)
   {
      Scanner scnr = new Scanner(System.in);
      String answer;
      String lastName;
      String firstName;
      Boolean stillPlaying = true;
      Boolean guessResult = false;
      GamePlay game = new GamePlay(); // Using this in order to use player variable
      
      Hosts host = new Hosts("Sapphire", "Fire");
      host.randomizeNum();
      
      System.out.println("What is your first name?");
      firstName = scnr.next();
      
      System.out.println("Would you like to enter a last name? Type Yes or No");
      answer = scnr.next();
      
      if (answer.equals("yes") || answer.equals("Yes"))
      {
         System.out.println("What is your last name?");
         lastName = scnr.next();
         
         game.player = new Players(firstName, lastName);      
      }
      else if (answer.equals("no") || answer.equals("No"))
      {
         game.player = new Players(firstName);
      }
      else
      {
         System.out.println("Error: answer must be yes or no.");
      }
      
      Turn newTurn = new Turn();
      
      while(stillPlaying)
      {
         System.out.println("Do you want to continue playing? Type Yes or No");
         answer = scnr.next();
         
         if(answer.equals("yes") || answer.equals("Yes"))
         {
            while (!guessResult)
            {
               guessResult = newTurn.takeTurn(player, host);
            }
            stillPlaying = true;
            
         }
         else if (answer.equals("no") || answer.equals("No"))
         {
            System.out.println("Thanks for playing!");
            stillPlaying = false;
            host.randomizeNum();
         }
      }
   }
}