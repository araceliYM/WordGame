// Purpose:         Program used for actions regarding hosts.
// Programmer:      Araceli YM
// Created on:      5/15/2024

import java.util.Scanner;

public class Hosts extends Person
{
   public void enterPhrase(String inputPhrase)
   { 
      Scanner scan = new Scanner(System.in);
      Phrases phraseOptions = new Phrases();
      
      phraseOptions.setGamePhrase(inputPhrase);
      phraseOptions.convertPhraseToGuessFormat();
   }
   
   public Hosts(String firstName, String lastName)
   {
      super(firstName, lastName);
   }
   
   public Hosts(String firstName)
   {
      super(firstName);
   }
   
   @Override
   public String toString()
   {
      return(super.getFirstName() + " " + super.getLastName());
   }
}