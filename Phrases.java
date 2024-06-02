// Purpose:       Java program used for actions regarding phrases in WordGame.
// Programmer:    Araceli YM
// Created on:    5/29/2024

public class Phrases
{
   private static String gamePhrase;
   private static String playingPhrase;
   
   public void setPhrase(String phrase)
   {
      gamePhrase = phrase;
   }
   
   public void updatePlayingPhrase(String newPhrase)
   {
      playingPhrase = newPhrase;
   } 
   public void convertToGuessFormat() 
   {
      gamePhrase.toUpperCase();
      playingPhrase = gamePhrase.replaceAll("[a-zA-Z]", "_"); 
   }
   
   public boolean playingPhraseComplete()
   {
      if(!playingPhrase.contains("_"))
      {
         return false;     // Playing phrase still has some blank spaces to guess.
      }
      else
      {
         return true;      // Playing phrase is completed.
      }
   }
   
   public boolean findLetter(String input) throws MultipleLettersException
   {
      boolean result = false;
      
      gamePhrase = gamePhrase.toUpperCase();
      
      if(input.length() == 1)
      {
         System.out.println("The phrase to guess is: " + playingPhrase);   
         
         for(int i = 0; i < gamePhrase.length(); i++)
         {
            String currChar = Character.toString(gamePhrase.charAt(i));
            
            if(input.equalsIgnoreCase(currChar))
            {
               String newPhrase = playingPhrase.replace(playingPhrase.charAt(i), input.charAt(0));
               updatePlayingPhrase(newPhrase);
               result = true;
            }
            
            if(playingPhraseComplete())
            {
               System.out.println("You guessed the phrase!");
               result = true;
               break;
            }
         }
      }
      else 
      {
         throw new MultipleLettersException();
      }
      
      return result;
   }
}