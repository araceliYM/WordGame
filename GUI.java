// Purpose:       Java GUI used for a word guessing game.
// Programmer:    Araceli YM
// Created on:    6/14/2024

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.text.NumberFormat;

public class GUI extends JFrame implements ActionListener
{
   private JLabel currPlayer;                     
   private JLabel currHost;                
   private JLabel currPlayingPhrase;
   private JTextField winnings;      // Displays the awards and losses to players
   private JTextField playerGuess;                  
   private JButton newPlayer;
   private JButton newHost;          // Allows players to enter a new host name and phrase
   private JButton startTurn;
   private JCheckBox save;
   private JMenuBar menuBar;
   private JMenu gameMenu;
   private JMenuItem addHostMenu;
   private JMenuItem addPlayerMenu;
   private JMenu aboutMenu;
   private JMenuItem aboutLayout;
   private JTextArea messageArea;
   private JScrollPane scrollPane;
   private JPanel gamePanel;
   private boolean saveMessages = false;
   private static ArrayList<Players> playersList = new ArrayList<>();
   Hosts host;
   Players player;
   Phrases phrase = new Phrases();
   Turn newTurn = new Turn();  
   
   public GUI() {
   
      setTitle("Word Game");
      
      gamePanel = new JPanel(new GridBagLayout());
      
      GridBagConstraints layoutConst = new GridBagConstraints();
      layoutConst.anchor = GridBagConstraints.WEST;
      layoutConst.insets = new Insets(10, 10, 10, 10);
         
      // Create componenets for JPanel
      
      currPlayingPhrase = new JLabel("Phrase progress");  
      currPlayer = new JLabel("Current player");     
      currHost = new JLabel("Current host");  
      
      newPlayer = new JButton("Add new player");
      newPlayer.addActionListener(this);
       
      newHost = new JButton("New host");
      newHost.addActionListener(this);
      
      startTurn = new JButton("Start turn");
      startTurn.addActionListener(this);
      
      save = new JCheckBox("Save messages");
      save.setToolTipText("Allows you to save all messages you receive during gameplay.");
      save.addItemListener(new ItemListener() {
                           public void itemStateChanged(ItemEvent e) {
                              if (e.getStateChange() == 1) {
                                 saveMessages = true;
                              }
                              else
                              {
                                 saveMessages = false;
                              }
                           }
                           });
      
      messageArea = new JTextArea(2, 10);
      messageArea.setEditable(false);
      messageArea.setLineWrap(true);
      messageArea.setWrapStyleWord(true);
      
      scrollPane = new JScrollPane(messageArea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
      // Add components to the panel
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      gamePanel.add(currHost, layoutConst);
      
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      gamePanel.add(currPlayer, layoutConst);
      
      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      gamePanel.add(currPlayingPhrase, layoutConst);
      
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      gamePanel.add(scrollPane, layoutConst);

      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      gamePanel.add(startTurn, layoutConst);
      
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      gamePanel .add(save, layoutConst);
      
      // initializes menu and adds action listeners    
      initializeMenu();
      
      // Set the border and add panel to frame
      gamePanel.setBorder(BorderFactory.createTitledBorder(
                          BorderFactory.createEtchedBorder(), "Game Play"));
                          
      add(gamePanel);
      pack();
      setLocationRelativeTo(null);
      
   }
   
   @Override
   public void actionPerformed(ActionEvent event)
   {
      JButton sourceEvent = (JButton) event.getSource();
          
      boolean stillPlaying = true;
      boolean gameResult = false;
      
      if(sourceEvent == startTurn)
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
   
   public void initializeMenu()
   {
      menuBar = new JMenuBar();
      
      // Create game menu bar 
      gameMenu = new JMenu("Game");
      gameMenu.setMnemonic('G');    // Allows user to use Alt+G to open the menu
      
      addPlayerMenu = new JMenuItem("Add new player");
      addPlayerMenu.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        // Adds a new player to the Word Game
                        
                        String playerName = JOptionPane.showInputDialog(null, " Enter a name for the player:");
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
                  });
      
      addHostMenu = new JMenuItem("Add host");
      addHostMenu.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        // Adds a new host to the Word Game
                        String hostName = JOptionPane.showInputDialog(null, "Enter a name for the host:");
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
          
                        String phraseInput = JOptionPane.showInputDialog(null, "Enter the phrase for players to guess:");
                        host.enterPhrase(phraseInput);
                        currHost.setText(host.toString());
                     }
                  });
                  
      gameMenu.add(addHostMenu);
      gameMenu.add(addPlayerMenu);
      
      menuBar.add(gameMenu);
      
      setJMenuBar(menuBar);
      
      // Create About menu bar
      aboutMenu = new JMenu("About");
      aboutMenu.setMnemonic('A');      // Allows user to press Alt+A to open the menu
      
      aboutLayout = new JMenuItem("Layout");
      aboutLayout.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        updateMessageArea("I chose to use the GridBagLayout manager" +
                                    " due to my previous experiences with it and it allows for very" +
                                    " specific layouts.");
                                 
                     }
                  });
                  
      aboutMenu.add(aboutLayout);
      
      menuBar.add(aboutMenu);
      
      setJMenuBar(menuBar);
   }
   
   public void updateMessageArea(String message)
   {
      // FIXME: doesn't work with other classes
      if (saveMessages)
      {   
         messageArea.append(message);
      }
      else
      {
         messageArea.setText(message);
      }
   }
   
   public static void main(String[] args) {
      // Creates GUI frame and its components
      GUI wordGame = new GUI();
      
      wordGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      wordGame.setPreferredSize(new Dimension(500, 300));
      wordGame.pack();
      wordGame.setVisible(true);
   }
}