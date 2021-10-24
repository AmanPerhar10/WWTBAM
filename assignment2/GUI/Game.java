/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.GUI;
import assignment2.Database.DBManager;
import assignment2.Model;
import assignment2.Player;
import assignment2.Question;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aman Perhar
 */

public class Game extends javax.swing.JFrame {
    
    /**
     * Creates new form Game
     */
       static String Question;
       static String A;
       static String B;
       static String C;
       static String D;
       static String Answer;
       static String AnsLetter;
       static int i=0;
       static int questionNumber=1;
       public List<Question> b ;
       public static int jbuttoncount =5;
       static int Score[] = {0,10000,250000,100000,250000,1000000};
       static int playerScore;
       DBManager dbUpdate = new DBManager();
       String firstName;
       String lastName;
       
           
    public Game() throws SQLException {
        
       initComponents(); 

       DBManager newGame = new DBManager();
       Model a = new Model();
              
       newGame.establishConnection();
       
       newGame.dropTableIfExists("NewGame");
       newGame.createTable();
       newGame.getRandomQuestions();
 
       a.startGame();
       b= a.questions;

       process(b, i, questionNumber);
    } 
    
    //processes questions and sets button text (options) and jlabel text (question)
    public void process(List<Question> b, int i, int questionNumber){
        
       Question = b.get(i).getQuestion();
       A = b.get(i).getA();
       B = b.get(i).getB();
       C = b.get(i).getC();
       D = b.get(i).getD();
       Answer = b.get(i).getAns();
       AnsLetter = b.get(i).getAnsLetter();
               
       jLabel3.setVisible(false);
       jButton11.setVisible(false);
       jLabel2.setText("<html>"+questionNumber+") "+Question+"</html>");
       jButton1.setText("<html>"+A+"</html>");
       jButton2.setText("<html>"+B+"</html>");
       jButton3.setText("<html>"+C+"</html>");
       jButton4.setText("<html>"+D+"</html>");
       scoreColor();
    }
 
    //Method user to end game
      public void endGame(){
        i=0;
        Menu endGame = new Menu();
        endGame.show();
        
        dispose();
        }
    //Updates to score Color panel to reflect the current position/score of the player
    public void scoreColor(){

        if (i==1){
            jButton5.setBackground(Color.green.darker().darker().darker());
            playerScore =Score[i];
        }
        
        if (i==2){
            jButton6.setBackground(Color.green.darker().darker().darker());
            playerScore=Score[i];
        }
        
        if (i==3){
            jButton7.setBackground(Color.green.darker().darker().darker());
            playerScore=Score[i];
        }
        if (i==4){
            jButton8.setBackground(Color.green.darker().darker().darker());
            playerScore=Score[i];
           
        }
        if (i==5){
             jButton8.setBackground(Color.green.darker().darker().darker());
        }   
    }
    
    //Action taken after 1 million has been won, message and setting buttons to visible.
    public void wonMillion(){
        jButton9.setBackground(Color.green);
                jLabel3.setVisible(true);
                jLabel2.setVisible(false);
                jButton1.setVisible(false);
                jButton2.setVisible(false);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);
                jButton9.setVisible(false);
                jButton10.setVisible(false);
                jLabel3.setOpaque(true);
                jLabel3.setText("<html>"+"Congratulations, you've won $1,000,000"+"</html>");
                jButton11.setVisible(true);
           
    }
    
    //Action taken for wrong answer, removes unncessary buttons and labels, stores player info,
    //updates hiscores and informs player of the correct answer
    public void wrongAnswer(){
         jLabel3.setVisible(true);
            jLabel2.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            jButton3.setVisible(false);
            jButton4.setVisible(false);
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            jButton7.setVisible(false);
            jButton8.setVisible(false);
            jButton9.setVisible(false);
            jButton10.setVisible(false);
            jLabel3.setText("<html>"+"Incorrect, the answer is:\n "+AnsLetter+") "+Answer+"</html>");
            jButton11.setVisible(true);
            int score = Score[i];
            
            Player a = new Player();
            firstName = a.getFirstName();
            lastName = a.getLastName();
            
            Player game = new Player(firstName,lastName, score);
            System.out.println(firstName+" "+lastName+score);
            System.out.println(game.getFirstName()+" "+game.getLastName()+" "+game.getScore());
            
            dbUpdate.createHighScoreTable();
            dbUpdate.updateScores(game);
            
    }
    
    //Move onto next question
    public void correctAns(){
        jLabel3.setText("<html>"+"Correct, the answer is: "+AnsLetter+") "+Answer+"</html>");
        i++;
        questionNumber++;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 650));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jButton11.setBackground(new java.awt.Color(51, 0, 102));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Return to Menu");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(360, 380, 140, 22);

        jButton10.setBackground(new java.awt.Color(51, 0, 102));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Return to Menu");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(700, 560, 150, 30);

        jButton9.setBackground(new java.awt.Color(0, 51, 255));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("$1,000,000");
        jButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(680, 180, 150, 40);

        jButton8.setBackground(new java.awt.Color(0, 51, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("$250,000");
        jButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(680, 220, 150, 40);

        jButton7.setBackground(new java.awt.Color(0, 51, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("$100,000");
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(680, 260, 150, 40);

        jButton6.setBackground(new java.awt.Color(0, 51, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("$25,000");
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(680, 300, 150, 40);

        jButton5.setBackground(new java.awt.Color(0, 51, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("$10,000");
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(680, 340, 150, 40);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 460, 440, 60);

        jLabel3.setBackground(new java.awt.Color(102, 0, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 280, 860, 100);

        jButton1.setBackground(new java.awt.Color(102, 0, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("jButton1");
        jButton1.setBorder(jButton3.getBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 510, 180, 40);

        jButton2.setBackground(new java.awt.Color(102, 0, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("jButton2");
        jButton2.setBorder(jButton3.getBorder());
        jButton2.setMaximumSize(jButton1.getMaximumSize());
        jButton2.setMinimumSize(getMinimumSize());
        jButton2.setPreferredSize(jButton1.getPreferredSize());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(330, 510, 180, 40);

        jButton3.setBackground(new java.awt.Color(102, 0, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(120, 560, 180, 40);

        jButton4.setBackground(new java.awt.Color(102, 0, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("jButton4");
        jButton4.setMaximumSize(jButton1.getMaximumSize());
        jButton4.setMinimumSize(jButton1.getMinimumSize());
        jButton4.setPreferredSize(jButton1.getPreferredSize());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(330, 560, 180, 40);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assignment2/images/GameBackground.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(880, 650));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -90, 1070, 650);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -4, 1070, 660);
        getContentPane().add(jPanel2);
        jPanel2.setBounds(50, 320, 220, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              
        if (A.equals(Answer))
        {
            correctAns();
            
            if (questionNumber == 6)
            {
                wonMillion();     
            }
            else
            {
                 process(b,i,questionNumber);
            }      
        }
        
        else
        {
           wrongAnswer();
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          
        if (B.equals(Answer))
        {
            correctAns();
            
            if (questionNumber == 6)
            {
                wonMillion();
            }
            else
            {
                process(b,i,questionNumber);
            }
        }
        
        else
        {
            wrongAnswer();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        if (C.equals(Answer)){
            
            correctAns();
            
            if (questionNumber == 6){
                wonMillion();
            }
            else{
                    process(b,i,questionNumber);
                }
        }
        
        else
        {
           wrongAnswer();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (D.equals(Answer)){
            correctAns();
            
            if (questionNumber == 6){
                wonMillion();
            }
            else{
                    process(b,i,questionNumber);
                }
        }
        else
        {
            wrongAnswer();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
        //Option to exit current game during game
        int output = JOptionPane.showConfirmDialog(null, "Are you sure you wish to quit the current game?");
        
        if(output == JOptionPane.YES_OPTION){
            endGame();
        }
        else
        {
            return;
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        //Exit option after game is over
        endGame();
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Game().setVisible(true);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
