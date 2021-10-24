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

//Player object Storing first name, last name and score for hiscores and intro
public class Player {
    
private static String firstName;
private static String lastName;
private static int score;

public Player (){
    this.firstName=firstName;
    this.lastName=lastName;
}

public Player (String firstName, String lastName){
    this.firstName=firstName;
    this.lastName=lastName;
}

public Player (String firstName, String lastName, int score){
    this.firstName=firstName;
    this.lastName=lastName;
    this.score=score;
}

    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    public int getScore (){
    return score;
}
    
}
