// Purpose:       Java class used to perform actions regarding phrases in WordGame
// Programmer:    Araceli YM
// Created on:    5/8/2024

public class Phrases
{
   private static String gamePhrase;
   private static String playingPhrase;
   
   public void setGamePhrase(String newPhrase)
   {
      gamePhrase = newPhrase;
   }
   
   public void updatePlayingPhrase(String newPhrase)
   {
      playingPhrase = newPhrase;
   }
   
   public String getPlayingPhrase()
   {
      return playingPhrase;
   } 
   
   public void convertPhraseToGuessFormat() 
   {
      playingPhrase = gamePhrase.replaceAll("[a-zA-Z]", "_"); 
   }
   
   public boolean playingPhraseComplete()
   {
      boolean complete = false;
      
      if(playingPhrase.contains("_"))
      {
         complete = false;
      }
      else
      {
         complete = true;
      }
      
      return complete;
   }
   
   public boolean findLetters(String guess) throws MultipleLettersException, IllegalArgumentException
   {
      boolean correctGuess = false;
         
      if(guess.length() == 1)
      {
         if(!Character.isLetter(guess.charAt(0)) )
         {
            throw new IllegalArgumentException("Input is not a letter.");
         }
      
         for(int i = 0; i < gamePhrase.length(); i++)
         {
            String currChar = Character.toString(gamePhrase.charAt(i));
               
            if(guess.equalsIgnoreCase(currChar))
            {
               String newPhrase = playingPhrase.substring(0, i) + guess + playingPhrase.substring(i + 1);
               updatePlayingPhrase(newPhrase);
               correctGuess = true;
            }
         }
      }
      else
      {
         throw new MultipleLettersException();
      }  
     
      return correctGuess;    // Turn.java awards players for a correct guess
   }
}