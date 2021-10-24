/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import assignment2.Database.DBManager;
import assignment2.GUI.Menu;
import assignment2.GUI.StartPage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aman Perhar
 */
public class Controller {
      
    public static void main(String[] args) throws SQLException {
        
       StartPage start = new StartPage();
       start.show();

       DBManager newGame = new DBManager();
       Model a = new Model();
       
       List<Question> b = new ArrayList<Question>();
       
       newGame.establishConnection();
       
       newGame.dropTableIfExists("NewGame");
       newGame.createTable();
       
       a.startGame();
       b =a.questions;         
    }           
}
        

        
    
    

