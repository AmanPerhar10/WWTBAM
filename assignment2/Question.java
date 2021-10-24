/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Aman Perhar
 */
public class Question {
      
    private int QID;
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private String ans;
    private String ansLetter;

    public Question(int QID, String question, String a, String b, String c, 
            String d, String ans, String ansLetter) {
        this.QID = QID;
        this.question = question;
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.ans=ans;
        this.ansLetter=ansLetter;
    }

    public int getQID() {
        return this.QID;
    }

    public String getQuestion() {
        return this.question;
    }
    
    public String getA() {
        return this.a;
    }
    
     public String getB() {
        return this.b;
    }
    
    public String getC() {
        return this.c;
    }
      
    public String getD() {
        return this.d;
    }
        
    public String getAns() {
        return this.ans;
    }
    
    public String getAnsLetter() {
        return this.ansLetter;
    }        
}
