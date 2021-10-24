package assignment2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import assignment2.Database.DBManager;
import java.util.List;

/**
 *
 * @author Aman Perhar
 */
public class Model {
    
    // private DBManager DBManager;
     public List<Question> questions;
     
     DBManager a = new DBManager();

     
    public void startGame() {
        // read random questions from database
        questions = a.getRandomQuestions(); 
        }
    

}

