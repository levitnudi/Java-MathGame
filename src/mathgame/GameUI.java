/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathgame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.JLabel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.Timer;

/**
 *
 * @author Levit Nudi
 */
public class GameUI extends javax.swing.JFrame {

    
//DO NOT RENAME BELOW VARIABLES    
int count_timer = 0;
int max_time = 60;//one minute
int user_score = 0;
int first_number = 0;
int second_number = 0;
int user_guess = 0;
int correct_answer = 0;
int max_number_of_questions = 10;
int number_of_answered_questions = 0;
String beep = "beep.wav";
String music = "music.mid";//feel free to change the music and sound effects
//music will start playing inside formWindowOpened() method. This is called
//when the game window is opened
String score = "score.wav";
//DO NOT RENAME ABOVE VARIABLES 
    /**
     * Creates new form GameUI
     * 
     * 
     * WARNING
     * 
     * ANY FORM OF DISHONESTY OR PLAGIARISM WILL LEAD TO DISQUALIFICATION
     * 
     * 
     * FUNDAMENTALS OF COMPUTER SCIENCE SEM1 (30 points)
     * Instructions
     * 
     * 
     * PART A (10 points)
     * 1. Let Quit menu button close the application
     * 2. disable guess button when time is up (use setEnabled(false) method on the button) and enable it
     * when game start button is clicked
     * 3. Rename ALL variable names of swing components, e.g labels, button, textFields etc
     * 
     * 
     * PART B (10 points)
     * 1. Create Another GUI using JDialog called HelpDialog similar to AboutDialog
     * 2. Give the dialog a title of 'Help' and use specifications for AboutDialog(font size etc)
     * 3. Use labels to describe how the game is played
     * 4. Use serif font for your descriptions
     * 5. Add a close button similar to the one in AboutDialog and make the click action close the dialog
     * 6. When the user clicks Tutorial under help menu, let it open HelpDialog (see how AboutDialog opens)
     * 
     * 
     * PART C (10 points)
     * 1. Package application using launch4j
     * 2. Add splash screen and use YOUR OWN icon and image
     * you can get free icons from (http://www.iconarchive.com/tag/ico-files)
     * and any image from google for your splash screen
     * 
     * 
     * ENGINEERING TOOLKIT (30 points)
     * Push your project to github (15 points)
     * detail your github project (15 points)
     * submit your github link by Friday 17th (August) 2018
     * late submissions will not be accepted
     * 
     * 
     * 
     */
    public GameUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MATH GAME");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("0");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Question");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Timer :");

        jLabel5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("00:00");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Score :");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Guess");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Start Game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Quit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Tutorial");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(82, 82, 82)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //check the timer class in the code, set repeat and start
        //if timer was running stop it else start        
        count_timer = 0;
        if(!timer.isRunning()){
        timer.setRepeats(true);
        timer.start();
        }else{
            //then restart
            timer.stop();
            timer.setRepeats(true);
            timer.start();
        }
        number_of_answered_questions = 0;//reset number of questions answered to 0 if at all above 0
        generateQuestion();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: 
        playSound(beep);
        if(!hasNoInput()){
        //check if user input matches with correct answer
        user_guess = Integer.parseInt(String.valueOf(jTextField1.getText()));
        if(user_guess == correct_answer){
            
          //increment and display score
            user_score++;
            jLabel2.setText(String.valueOf(user_score));
            playSound(score);
            
            //clear previous input
            jTextField1.setText(null);
            
            //generate next question
            generateQuestion();
           showPopup("Correct!");
        }else{
            //clear previous input
            jTextField1.setText(null);
            //move to the next question even when user gets wrong
             generateQuestion();
            showPopup("The correct answer is "+correct_answer);
        }
        }else{
            showPopup("Answer cannot be empty!");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
      playSound(beep);  
      AboutDialog aboutDialog = new AboutDialog(this, true);
      aboutDialog.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
           
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         playSound(music); 
    }//GEN-LAST:event_formWindowOpened

    //this method will generate a question with two random numbers
    //and display on the question label
    private void generateQuestion(){
      //randomly pick any number between 0 and 4 
      //based on the number picked, the question will
      //either be addition, subtraction, multiplication or division   
        
        
      
        //limit number of questions answered
      if(number_of_answered_questions < max_number_of_questions){  
        
      Random operation = new Random(); 
      
      //pick any random number between 0 and 20      
      first_number = new Random().nextInt(20);
       //pick any random number between 0 and 10 
      second_number = new Random().nextInt(10);      
          
  
      if(operation.nextInt(4)==0){
           jLabel3.setText(first_number+" + "+second_number);
             correct_answer = first_number+second_number; 
              System.out.println("Addition");
             
      }else if(operation.nextInt(4)==1){
           //if operation is 1 let's subtract
             
             jLabel3.setText(first_number+" - "+second_number);
             correct_answer = first_number-second_number;
                   System.out.println("Subtraction");             
      }else if(operation.nextInt(4)==2){
           //if operation is 2 let's multiply    
            
             jLabel3.setText(first_number+" x "+second_number);         
             correct_answer = first_number*second_number; 
                       System.out.println("Multiplication");             
      }else if(operation.nextInt(4)==3){
           //if operation is 3 let's divide      
             jLabel3.setText(first_number+" / "+second_number); 
             if(second_number!=0)
             correct_answer = first_number/second_number; 
             //if you divide a number by zero it throws arithmetic exception
             else correct_answer = first_number;
                           System.out.println("Division");
        
      }else if(operation.nextInt(4)==4){
               //if operation is 4 let's find the remainder when you divide
             jLabel3.setText("Remainder of "+first_number+" / "+second_number);                    
             correct_answer = first_number%second_number; 
                                 System.out.println("Remainder");
      }
      
      number_of_answered_questions++;
      
      }else {
          //stop timer if it was still running
        if(timer.isRunning()){  
        timer.stop();
        }
        jLabel3.setText("You Scored "+user_score+"!");
        jLabel5.setText("Time Taken "+count_timer);
      }
      
    }
    
    //this method checks whether there's any input 
    public boolean hasNoInput(){        
    return jTextField1.getText().isEmpty();
    }
    
    
    public void showPopup(String message){
        final Popup p = PopupFactory.getSharedInstance()
                .getPopup(jTextField1, new JLabel(message), jTextField1.getX(), jTextField1.getY());
    p.show();
    // create a timer to hide the popup later
    Timer t = new Timer(5000, (ActionEvent e) -> {
        p.hide();
        });
    t.setRepeats(false);
    t.start();
    }
    
        Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          if(count_timer<max_time){    
          jLabel5.setText("Time : "+count_timer);
          count_timer++;
          }else{
         jLabel5.setText("Time Up!"); 
        
        }
        }
    });  
        
        
        
         // play beep or score sounds sound
   public void playSound(String soundName) {        
       //locate the sounds under resource folder
        URL url = GameUI.class.getResource(soundName);
       if(!soundName.equals(music)){  
          // play only once if not music
       AudioClip clip = Applet.newAudioClip(url);       
       clip.play();
       
       }else{
            try {
                //repeat forever until game is closed
                // ONLY WORKS WITH MIDI FILES !
                // Obtains the default Sequencer connected to a default device.
                URL url2 = GameUI.class.getResource(soundName);
                Sequencer sequencer = MidiSystem.getSequencer();
                //set loop to play until game is closed
                sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
                
                // Opens the device, indicating that it should now acquire any
                // system resources it requires and become operational.
                sequencer.open();
                
                // create a stream from a file
                InputStream is = new BufferedInputStream(new FileInputStream(new File(url2.getPath())));
                
                // Sets the current sequence on which the sequencer operates.   
                
                // The stream must point to MIDI file data.
                sequencer.setSequence(is);
                
                // Starts playback of the MIDI data in the currently loaded sequence.
                sequencer.start();
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(GameUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(GameUI.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
   }
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameUI().setVisible(true);
        //Once the window is activated / application opens
        //let's play some background music
       
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
