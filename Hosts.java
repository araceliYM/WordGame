// Purpose:         Program used for actions regarding hosts.
// Programmer:      Araceli YM
// Created on:      5/15/2024

import java.util.Scanner;

public class Hosts extends Person
{
   public void enterPhrase()
   {  
      Scanner scan = new Scanner(System.in);
      Phrases phraseOptions = new Phrases();
      
      System.out.println("Enter the phrase for players to guess:");
      
      String inputPhrase = scan.nextLine();
      
      phraseOptions.setGamePhrase(inputPhrase);
      phraseOptions.convertPhraseToGuessFormat();
   }
   
   public Hosts(String firstName, String lastName)
   {
      super(firstName, lastName);
   }
}