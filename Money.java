// Purpose:       Java program used to display the monetary winnings.
// Programmer:    Araceli YM
// Created on:    5/23/2024

import javax.swing.JOptionPane;

public class Money implements Award
{
   final double WIN_AMNT = 100.00;
   final double LOSE_AMNT = 80.00;
   
   public int displayWinnings(Players player, boolean gameResult)
   {
      int returnAmnt;
      
      if(gameResult)
      {
         System.out.println(player + ", that is correct! You won " + WIN_AMNT);
         returnAmnt = (int)Math.round(WIN_AMNT);
      }
      else
      {
         System.out.println(player + ", sorry, that is incorrect! You lost " + LOSE_AMNT);
         returnAmnt = (int)Math.round(-LOSE_AMNT);
      }
      
      return returnAmnt;
   }
}