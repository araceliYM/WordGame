// Purpose:         Program used for actions regarding hosts.
// Programmer:      Araceli YM
// Created on:      5/15/2024

public class Hosts extends Person
{
   public void randomizeNum()
   {
      Numbers random = new Numbers();
      random.generateNumber();
   }
   
   public Hosts(String firstName, String lastName)
   {
      super(firstName, lastName);
   }
}