// Purpose:         Program used for actions regarding hosts.
// Programmer:      Araceli YM
// Created on:      5/15/2024

import java.util.Scanner;

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
      
      enterNewPhrase();
   }
   
   public void enterNewPhrase()
   {
      Scanner scnr = new Scanner(System.in);
      
      System.out.println("Enter the phrase for players to guess:");
      String inputPhrase = scnr.nextLine();
      Phrases newPhrase = new Phrases();
      newPhrase.setPhrase(inputPhrase);
   }
}