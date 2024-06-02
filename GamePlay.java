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
      Phrases usingPhrase = new Phrases();            // Using Phrases object in order to call testing method and convert to guess format
      GamePlay game = new GamePlay();                 // Using this in order to use player variable
      
      
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
      
      Hosts host = new Hosts("Sapphire", "Fire");     // Hosts object will also prompt user to enter a phrase.
      usingPhrase.convertToGuessFormat();             // Converts the phrase users need to guess into a specified format
      Turn newTurn = new Turn();
      
      while(stillPlaying)
      {
         while(!guessResult)
         {
            for(int i = 0; i < currentPlayers.length; ++i)
            {
               guessResult = newTurn.takeTurn(currentPlayers[i], host);
               
               if(guessResult == true);
               {
                  break;
               }
            }
         }
          
         System.out.println("Do you want to continue playing? Type Yes or No");
         answer = scnr.next();
         
         if(answer.equals("yes") || answer.equals("Yes"))
         {
            stillPlaying = true;
            guessResult = false; // Reset the guess to allow players to play again
            host.enterNewPhrase();
         }
         else if (answer.equals("no") || answer.equals("No"))
         {
            System.out.println("Thanks for playing!");
            stillPlaying = false;
         }
      }
   }
}