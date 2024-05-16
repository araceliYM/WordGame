// Purpose:         Program used for activities for each player's turn.
// Programmer:      Araceli YM
// Created on:      5/15/2024

import java.util.Scanner;

public class Turn
{
   final double WIN_AMNT = 100.00;
   final double LOSE_AMNT = 80.00;
      
   public boolean takeTurn(Players player, Hosts host)
   {
      Scanner scan = new Scanner(System.in);
      int guess;
      double playerMoney;
      boolean resultOfGuess;
      
      System.out.println(host.getFirstName() + " " + host. getLastName() + ": " + 
                        player.getFirstName() + " " + player.getLastName() + 
                        ", " +"guess what number I picked between 0 and 100.");
                       
                       
      guess = scan.nextInt();
      
      Numbers num = new Numbers(); 
      
      if(num.compareNumber(guess))
      {
         playerMoney = player.getPlayerMoney();          // Get user's current amount of money
         player.setPlayerMoney(playerMoney + WIN_AMNT);
         System.out.println("Congrats! You win! " + WIN_AMNT + " added to your funds.");
         System.out.println(player.toString());
         
         resultOfGuess = true;
      }
      else
      {
         playerMoney = player.getPlayerMoney();
         player.setPlayerMoney(playerMoney - LOSE_AMNT);
         System.out.println("Better luck next time. " + LOSE_AMNT + " removed from your funds.");
         System.out.println(player.toString());
         
         resultOfGuess = false;  
      }
      
      return resultOfGuess;        
   }
 
}
