// Purpose:         Program used for activities for each player's turn.
// Programmer:      Araceli YM
// Created on:      5/15/2024

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

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
      boolean gameResult = false;
      Random randomNum = new Random();
      
      System.out.println(host.getFirstName() + " " + host. getLastName() + ": " + 
                        player.getFirstName() + " " + player.getLastName() + 
                        ", " +"guess a letter in the phrase.");
                      
      Phrases gamePhrase = new Phrases();
      prizeType = randomNum.nextInt(100);
      
      try
      {
         guess = scan.next();
         guessResult = gamePhrase.findLetter(guess);
      }
      catch(InputMismatchException e)
      {
         System.out.println("Input must be a letter!");
      }
      catch(MultipleLettersException e)
      {
         e.getMessage();
      }
      
         
      if(prizeType > 50)
      {
         Physical physicalPrize = new Physical();
         prizeAmnt = physicalPrize.displayWinnings(player, guessResult);
            
         player.setPlayerMoney(player.getPlayerMoney() + prizeAmnt);
         System.out.println(player.toString());
      }
      else if (prizeType < 50)
      {
         Money moneyPrize = new Money();
         prizeAmnt = moneyPrize.displayWinnings(player, guessResult);
            
         player.setPlayerMoney(player.getPlayerMoney() + prizeAmnt);
         System.out.println(player.toString());
      }
     
      return gameResult; 
             
   }
}
