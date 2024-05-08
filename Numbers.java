// Purpose:       Java program used to generate random numbers in range 0 - 100
// Programmer:    Araceli YM
// Created on:    5/6/2024


import java.util.Random;

public class Numbers
{
   private static int randomNum;
   
   public void setRandomNum(int num)
   {
      this.randomNum = num;
   }
   
   public int getRandomNum()
   {
      return randomNum;
   }
   
   public void generateNumber()
   {
      int min = 0, max = 100;
      Random rand = new Random();
      this.randomNum = rand.nextInt(max - min + 1) + min;
   }
   
   public boolean compareNumber(int guess)
   {
      boolean result = false;
      
      if (guess == randomNum) 
      {
         System.out.println("Congratulations, you guessed the number!");
         result = true;
      }
      else if (guess > randomNum)
      {
         System.out.println("I'm sorry, That guess was too high.");
         result = false;
      }
      else if (guess < randomNum)
      {
         System.out.println("I'm sorry, That guess was too low.");
         result = false;
      }
      
      return result;
   }
}
