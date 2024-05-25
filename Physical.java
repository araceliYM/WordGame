// Purpose:       Java program used to display the physical winnings.
// Programmer:    Araceli YM
// Created on:    5/23/2024

import java.util.Random;
import javax.swing.JOptionPane;

public class Physical implements Award
{
   private String[] prizes = {"2024 Dodge Hornet", "16ft. Canoe", "2020 Kawasaki Jet Ski",
                            "2022 Keystone Outback Travel Trailer", "Lifetime Supply of Gas", "2024 Custom Built Houseboat"};
   
   public int getRandomPrize()
   {
      int prizeIndex;
      
      int min = 0, max = 2;
      Random rand = new Random();
      prizeIndex = rand.nextInt(max - min + 1) + min;
      
      return prizeIndex;
   }
   
   public int displayWinnings(Players player, boolean gameResult)
   {
      if(gameResult)
      {
         int prize = getRandomPrize();
         System.out.println( player + ", congratulations! You won a " + prizes[prize] + "!");
      }
      else
      {
         int prize = getRandomPrize();
         System.out.println(player + ", sorry that is incorrect! " +
                           "If you had gotten it correct, you COULD HAVE WON a " + prizes[prize] + "!");
      }
      
      return 0;
   }
}