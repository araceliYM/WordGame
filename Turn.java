// Purpose:         Program used for activities for each player's turn.
// Programmer:      Araceli YM
// Created on:      5/15/2024

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;
public class Turn
{
   public boolean takeTurn(Players player, Hosts host, String guess)
   {
      Scanner scan = new Scanner(System.in);
      int prizeType;
      int prizeAmnt;
      double currMoney;
      boolean guessResult = false;
      boolean gameResult = false;      // Remains false until phrase is fully completed
      Random randomNum = new Random();
      prizeType = randomNum.nextInt(100);
      Phrases phrase = new Phrases();
      
     
      
      try
      {  
         
         if(!Character.isLetter(guess.charAt(0)) )
         {
            throw new IllegalArgumentException("Input is not a letter.");
         }

         guessResult = phrase.findLetters(guess);
      }
      catch(MultipleLettersException|IllegalArgumentException e)
      {
         String message = e.getMessage() + " Enter new guess: ";
         guess = JOptionPane.showInputDialog(null, message);
      }
         
      if(prizeType > 50)
      {
         Physical physicalPrize = new Physical();
         prizeAmnt = physicalPrize.displayWinnings(player, guessResult);
            
      }
      else if (prizeType < 50)
      {
         Money moneyPrize = new Money();
         prizeAmnt = moneyPrize.displayWinnings(player, guessResult);
            
         player.setPlayerMoney(player.getPlayerMoney() + prizeAmnt);
      }
      
      if(phrase.playingPhraseComplete())
      {
         gameResult = true;
         JOptionPane.showMessageDialog(null, "Congratulations! You guessed all the letters in the phrase!");
         
         Physical physicalPrize = new Physical();
         prizeAmnt = physicalPrize.displayWinnings(player, gameResult);
      }
      else
      {
         gameResult = false;
      } 
      
      return gameResult; 
             
   }
}
