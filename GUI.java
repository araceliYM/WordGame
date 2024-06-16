// Purpose:       Java GUI used for a word guessing game.
// Programmer:    Araceli YM
// Created on:    6/14/2024

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener
{
   private JLabel currPlayer;                     
   private JLabel currHost;                
   private JLabel currPlayingPhrase;
   private JTextField winnings;       // Displays the awards and losses to players
   private JTextField playerGuess;                  
   private JButton newPlayer;
   private JButton newHost;      // Allows players to enter a new host name and phrase
   private JButton startTurn;
   private static ArrayList<Players> playersList = new ArrayList<>();
   Hosts host;
   Players player;
   Phrases phrase = new Phrases();
   Turn newTurn = new Turn();  
   GUI() {
   
      // Add GUI components to the frame
      this.setLayout(new FlowLayout(FlowLayout.LEFT));
     
      currPlayer = new JLabel("Current player");   // FIXME: display ALL players
      this.add(currPlayer);
      
      currHost = new JLabel("Current host");
      this.add(currHost);
      
      currPlayingPhrase = new JLabel("Phrase progress");
      this.add(currPlayingPhrase);    
      
      newPlayer = new JButton("Add new player");
      newPlayer.addActionListener(this);
      this.add(newPlayer);
      
      newHost = new JButton("New host");
      newHost.addActionListener(this);
      this.add(newHost);
      
      startTurn = new JButton("Start turn");
      startTurn.addActionListener(this);
      this.add(startTurn);
   }
   
   @Override
   public void actionPerformed(ActionEvent event)
   {
      JButton sourceEvent = (JButton) event.getSource();
      boolean stillPlaying = true;
      boolean gameResult = false;
      
      if(sourceEvent == newPlayer)
      {
         String playerName = JOptionPane.showInputDialog(this, "Enter a name for the player:");
         String[] names = playerName.split("\\s+'");
         
         if(names.length >= 2) 
         {     
            // Used to determine if player has last name
            String firstName = names[0];
            String lastName = names[1];
            player = new Players(firstName, lastName);
         }
         else
         {
            player = new Players(playerName);
         }
         
         playersList.add(player);
         
         if(currPlayer.getText() != "Current player")
         {
            currPlayer.setText(currPlayer.getText() + player.toString() + System.lineSeparator());
         }
         else 
         {
            currPlayer.setText(player.toString());
         }
      }
      else if(sourceEvent == newHost)
      {
         String hostName = JOptionPane.showInputDialog(this, "Enter a name for the host:");
         String[] names = hostName.split("\\s+'");
         
         if(names.length >= 2) 
         {     
            // Used to determine if host has last name
            String firstName = names[0];
            String lastName = names[1];
            host = new Hosts(firstName, lastName);
         }
         else
         {
            host = new Hosts(hostName);
         }
          
         String phraseInput = JOptionPane.showInputDialog(this, "Enter the phrase for players to guess:");
         host.enterPhrase(phraseInput);
         currHost.setText(host.toString());
      }
      else if(sourceEvent == startTurn)
      {
         while(stillPlaying)
         {
            while(!gameResult)
            {
               for(int i = 0; i < playersList.size(); ++i)
               {
                  currPlayingPhrase.setText(phrase.getPlayingPhrase());
                  currPlayer.setText(playersList.get(i).toString()); 
                  
                  String playerGuessing = playersList.get(i).getFirstName() + playersList.get(i).getFirstName() + "Enter your guess:"  ;
                  String guess = JOptionPane.showInputDialog(this, playerGuessing);
                        
                  gameResult = newTurn.takeTurn(playersList.get(i), host, guess);
               
                  if(gameResult == true)
                  {
                     break;      // Ends game once a user guesses correctly
                  }
               }
            }
            
            currPlayingPhrase.setText(phrase.getPlayingPhrase());
                   
            int answer = JOptionPane.showConfirmDialog(this, "Do you want to continue playing?");
            
            if(answer == JOptionPane.YES_OPTION)
            {
               stillPlaying = true;
               gameResult = false; // Reset the guess to allow players to play again
               String newPhrase = JOptionPane.showInputDialog(this, "Enter a new phrase:");
               host.enterPhrase(newPhrase);
            }
            else
            {
               JOptionPane.showMessageDialog(this, "Thanks for playing!");
               stillPlaying = false;
            }
         }
      }
   }
   
   public static void main(String[] args) {
      // Creates GUI frame and its components
      GUI wordGame = new GUI();
   
      wordGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      wordGame.setPreferredSize(new Dimension(300, 300));
      wordGame.pack();
      wordGame.setVisible(true);
   }
}