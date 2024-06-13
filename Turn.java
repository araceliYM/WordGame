// Purpose:         Program used for activities for each player's turn.
// Programmer:      Araceli YM
// Created on:      5/15/2024

import java.util.Scanner;
import java.util.Random;

public class Turn
{
   public boolean takeTurn(Players player, Hosts host)
   {
      Scanner scan = new Scanner(System.in);
      String guess;
      int prizeType;
      int prizeAmnt;
      double currMoney;
      boolean guessResult = false;
      boolean gameResult = false;      // Remains false until phrase is fully completed
      Random randomNum = new Random();
      prizeType = randomNum.nextInt(100);
      Phrases phrase = new Phrases();
      
      System.out.println("The phrase to guess is: " + phrase.getPlayingPhrase()); 
      
      System.out.println(host.getFirstName() + " " + host. getLastName() + " says, \"" + 
                        player.getFirstName() + " " + player.getLastName() + 
                        ", " +"enter your guess for a letter in my phrase.\" ");
                                        
     // guess = scan.next();
      
      try
      {  
         guess = scan.next();
         
         if(!Character.isLetter(guess.charAt(0)) )
         {
            throw new IllegalArgumentException("Input is not a letter.");
         }

         guessResult = phrase.findLetters(guess);
      }
      catch(MultipleLettersException|IllegalArgumentException e)
      {
         System.out.println(e.getMessage() + " Enter new guess: ");
         guess = scan.next();
      }
         
      if(prizeType > 50)
      {
         Physical physicalPrize = new Physical();
         prizeAmnt = physicalPrize.displayWinnings(player, guessResult);
            
         System.out.println(player.toString());
      }
      else if (prizeType < 50)
      {
         Money moneyPrize = new Money();
         prizeAmnt = moneyPrize.displayWinnings(player, guessResult);
            
         player.setPlayerMoney(player.getPlayerMoney() + prizeAmnt);
         System.out.println(player.toString());
      }
      
      if(phrase.playingPhraseComplete())
      {
         gameResult = true;
         System.out.println("Congratulations! You guessed all the letters in the phrase!");
         System.out.println("The phrase is: " + phrase.getPlayingPhrase());
         
         Physical physicalPrize = new Physical();
         prizeAmnt = physicalPrize.displayWinnings(player, gameResult);
         System.out.println(player.toString());
      }
      else
      {
         gameResult = false;
      } 
      
      return gameResult; 
             
   }
}
