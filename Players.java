// Purpose:         Program used for actions regarding players.
// Programmer:      Araceli YM
// Created on:      5/15/2024

public class Players extends Person 
{
   private double currMoney;
   
   public void setPlayerMoney(double userMoney) 
   {
      currMoney = userMoney;
   }
   
   public double getPlayerMoney()
   {
      return currMoney;
   }
   
   public Players(String firstName, String lastName)
   {
      super(firstName, lastName);
      currMoney = 1000.00;
   }
   
   public Players(String firstName)
   {
      super(firstName);
      currMoney = 1000.00;
   }
   
   @Override
   public String toString()
   {
      return(super.getFirstName() + " " + super.getLastName() +
             ": $" + currMoney);
   }
}