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
      int guess;
      int prizeType;
      int prizeAmnt;
      double currMoney;
      boolean gameResult;
      Random randomNum = new Random();
      
      System.out.println(host.getFirstName() + " " + host. getLastName() + ": " + 
                        player.getFirstName() + " " + player.getLastName() + 
                        ", " +"guess what number I picked between 0 and 100.");
                       
                       
      guess = scan.nextInt();
      
      Numbers num = new Numbers();
      prizeType = randomNum.nextInt(100);
      
      gameResult = num.compareNumber(guess);
         
      if(prizeType > 50)
      {
         Physical physicalPrize = new Physical();
         prizeAmnt = physicalPrize.displayWinnings(player, gameResult);
            
         player.setPlayerMoney(player.getPlayerMoney() + prizeAmnt);
         System.out.println(player.toString());
      }
      else if (prizeType < 50)
      {
         Money moneyPrize = new Money();
         prizeAmnt = moneyPrize.displayWinnings(player, gameResult);
            
         player.setPlayerMoney(player.getPlayerMoney() + prizeAmnt);
         System.out.println(player.toString());
      }
      
      return gameResult; 
             
   }
}
