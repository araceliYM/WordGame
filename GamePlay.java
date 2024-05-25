// Purpose:       Java program used for the gameplay of WordGame
// Programmer:    Araceli YM
// Created on:    5/8/2024

import java.util.Scanner;

public class GamePlay
{
   private static Players player;
   private static Players[] currentPlayers = new Players[3];
   
   public static void main(String[] args)
   {
      Scanner scnr = new Scanner(System.in);
      String answer;
      String continuePlay;
      String lastName;
      String firstName;
      Boolean stillPlaying = true;
      Boolean guessResult = false;
      GamePlay game = new GamePlay(); // Using this in order to use player variable
      
      Hosts host = new Hosts("Sapphire", "Fire");
      host.randomizeNum();
      
      for(int i = 0; i < currentPlayers.length; i++)  // Prompt users for names and create 3 players
      {
         System.out.println("Player #" + (i + 1) + ", What is your first name?");
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
         
         currentPlayers[i] = game.player;
      }
      
      Turn newTurn = new Turn();
      
      while(stillPlaying)
      {
         while(!guessResult)
         {
            for(int i = 0; i < currentPlayers.length; ++i)
            {
               
               guessResult = newTurn.takeTurn(currentPlayers[i], host);
               
               if(guessResult == true)
               {
                  break;      // Ends game once a user guesses correctly
               }
            }
         }
          
         System.out.println("Do you want to continue playing? Type Yes or No");
         answer = scnr.next();
         
         if(answer.equals("yes") || answer.equals("Yes"))
         {
            stillPlaying = true;
            guessResult = false; // Reset the guess to allow players to play again
            host.randomizeNum(); // Gives players new number to guess
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