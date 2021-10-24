package assignment2.Database;

import assignment2.Player;
import assignment2.Question;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aman Perhar
 */
public class DBManager {

    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private static final String URL = "jdbc:derby:WWTBAM;create=true";  //derby.jar

    Connection conn;
    private Statement statement = null;
    List randomQuestions = new ArrayList();

    public DBManager() {
        establishConnection();
    }


    public Connection getConnection() {
        return this.conn;
    }

    //Establish connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + "   CONNECTED....");

            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Close connection
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Result set query
    public ResultSet myQuery(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void myUpdate(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  
    //Generates 5 questions - not used
    public List<Question> getQuestions() {
        
        List<Question> questions = new ArrayList<>();
        try {
            Statement statement = this.conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM NewGame {LIMIT 5}");
            while (rs.next()) {
                int QID = rs.getInt("QID"); 
                String question = rs.getString("question");
                String a = rs.getString("a");
                String b = rs.getString("b");
                String c = rs.getString("c");
                String d = rs.getString("d");
                String ans = rs.getString("ans");
                String ansLetter = rs.getString("ansLetter");

                Question q = new Question(QID, question, a, b, c, d, ans, ansLetter);
                questions.add(q);
               // System.out.println(QID+" "+ question + " "+ a + " "+ b + " "+ c +" "+d +" "+ ans+ " " +ansLetter);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questions;
    }
    
    
        //Create table to store 20 questions, options and answers for those questions.
        public void createTable() throws SQLException{
        
        try{
            Statement statement = this.getConnection().createStatement();
        String TableName = "NewGame";
        
        String sqlCreate  = "create table " + TableName + "(QID int NOT NULL,"
                + "question varchar (100),"+ "a varchar (80)," + "b varchar (80),"
                + "c varchar  (80)," + "d varchar  (80)," + "ans varchar (80)," 
                + "ansLetter varchar(1))";
        statement.executeUpdate(sqlCreate);
        
        String sqlInsert = "INSERT INTO " + TableName + " values("
        +"1, 'In what year did Sir Edmund Hillary climb to the summit of Everest?', '1953', '1967', '1933', '2006', '1953', 'A' ),"
        +"("
        +"2, 'What is the capital of New Zealand?', 'Auckland', 'Wellington', 'Sydney', 'Canberra', 'Wellington','B'),"
        +"("
        +"3, 'What year did New Zealand win the World Test Championship?', '2021', '2022', '1992', '2002', '2021', 'A'),"
        +"("
        +"4, 'Which football club did Lionel Messi move to in 2021?', 'Bayern Munich', 'Real Madrid', 'Barcelona', 'PSG', 'PSG','D'),"
        +"("
        +"5, 'Which team won the 2020 Copa America?', 'Brazil', 'Italy', 'Argentina', 'Uruguay', 'Argentina', 'C'),"
        +"("
        +"6, 'What is the name of the virus that sent the world in to lock down?', 'Helena', 'Corona', 'Influenza', 'Chicken Pox', 'Corona', 'B'),"
        +"("
        +"7, 'In what year was US President Biden inaugurated?', '2011', '2020', '2009', '2022', '2020', 'B'),"
        +"("
        +"8, 'Who are the current Football World Champions?', 'New Zealand', 'France', 'England', 'Argentina', 'France', 'B'),"
        +"("
        +"9, 'What is the New Zealand Rugby Team also known as?', 'Black Socks', 'All Blacks', 'All Whites', 'Springboks', 'All Blacks', 'B'),"
        +"("
        +"10, 'Which of the following is not a known name for a rugby team?', 'Reds', 'Wallabies', 'Springboks', 'Mets', 'Mets', 'D'),"
        +"("
        +"11, 'What is the name of the island located south of the South Island of New Zealand?', 'Andrew', 'Hobbit', 'Stewart', 'Stew', 'Stewart', 'C'),"
        +"("
        +"12, 'What is the capital of Australia?', 'Sydney', 'Brisbane', 'Canberra', 'Christchurch', 'Canberra', 'C'),"
        +"("
        +"13, 'Which country is not a part of the Asian continent?', 'China', 'India', 'Japan', 'Canada', 'Canada', 'D'),"
        +"("
        +"14, 'Kanye West released an album called what in the year 2021?', 'Donda', 'Yeezus', 'Ronda', 'Jesus is King', 'Donda', 'A'),"
        +"("
        +"15, 'In what year were the Taliban overthrown by American forces in Afghanistan?', '2001', '2005', '1991', '2021', '2001', 'A'),"
        +"("
        +"16, 'Who is the current Australian Prime Minister?', 'Jacinda Adern', 'Scott Morrison', 'Donald Trump', 'Julia Gillard', 'Scott Morrison', 'B'),"
        +"("
        +"17, 'Which movie is the highest grossing film of all time?', 'Avengers: Endgame', 'Titanic', 'Avatar', 'Star Wars: Episode VII The Force Awakens', 'Avatar', 'C'),"
        +"("
        +"18, 'Where are the 2024 Summer Olympics being held?', 'Tokyo', 'Melbourne', 'Paris', 'Barcelona', 'Paris', 'C'),"
        +"("
        +"19, 'What is the name of the best selling album of all time?', 'Bat Out of Hell', 'The Bodyguard', 'Back in Black', 'Thriller', 'Thriller', 'D'),"
        +"("
        +"20, 'The following novels \"A Game of Thrones\" and \"A Song of Ice and Fire\" were written by?', 'J. K. Rowling', 'Roald Dahl', 'Stephen King', 'George R. R. Martin', 'George R. R. Martin', 'D')";
        statement.executeUpdate(sqlInsert);
        
            System.out.println("Table created.");
        
        } catch (SQLException ex)
            {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
 
    //Selects 5 questions from New Game table. Not used.
    public void getQuery() {
        ResultSet rs = null;

        try {
            System.out.println("\nGetting query....\n");
            Statement statement = this.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select * from NewGame";

            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                int QID = rs.getInt("QID"); 
                String question = rs.getString("question");
                String a = rs.getString("a");
                String b = rs.getString("b");
                String c = rs.getString("c");
                String d = rs.getString("d");
                String ans = rs.getString("ans");
                String ansLetter = rs.getString("ansLetter");
                System.out.println(QID + ": " + question+"\n"+"A) "+a+" B) "+b+" C) "+c+" D) " +d+"\nAnswer:\n"+ansLetter+") "+ans+"\n");
                
                
                
                //randomQuestions.add(question,a,b,c,d,ans,ansLetter);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Generates 5 random 
    public List<Question> getRandomQuestions() {
        ResultSet rs = null;
        List<Question> game = new ArrayList<Question>();

        try {
            System.out.println("\nGetting query....\n");
            Statement statement = this.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            String sqlQuery = "select DISTINCT * from NewGame ORDER BY RANDOM() {LIMIT 5}";
            rs = statement.executeQuery(sqlQuery);
            rs.beforeFirst();
            while (rs.next()) {
                int QID = rs.getInt("QID"); 
                String question = rs.getString("question");
                String a = rs.getString("a");
                String b = rs.getString("b");
                String c = rs.getString("c");
                String d = rs.getString("d");
                String ans = rs.getString("ans");
                String ansLetter = rs.getString("ansLetter");
                //System.out.println(QID + ": " + question+"\n"+"A) "+a+" B) "+b+" C) "+c+" D) " +d+"\nAnswer:\n"+ansLetter+") "+ans+"\n");
                
                Question data = new Question(QID, question, a, b, c, d, ans, ansLetter);
                game.add(data);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return game;
    }
    

    //Used to drop tables if already exists to avoid creashes and erorrs
      public void dropTableIfExists(String name) {
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, null, types);
            Statement statement = this.conn.createStatement();
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
               
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
      
      
      //Creates hiscore table
      public void createHighScoreTable() {
        
        dropTableIfExists("Hiscores");
       
        try {
            this.statement = conn.createStatement();           
            this.statement.addBatch("CREATE TABLE Hiscores (firstname VARCHAR(20),lastname VARCHAR(20), score int)");
            this.statement.executeBatch();
            System.out.println("Hiscores table created");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      
      //Uset to get Hiscores
      public List<Player> getHiscore() {
        List<Player> Hiscores = new ArrayList<Player>();

        try {
            
            Statement statement = this.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            
            String sqlQuery = "SELECT firstname, lastname, score FROM Hiscores";
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int score = rs.getInt("score");

                Player update = new Player(firstname,lastname, score);
                Hiscores.add(update);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Hiscores;
    }
      
      
      //Used to update hiscores after a game is complete
        public void updateScores(Player hiscores) {
        try {
            this.statement = conn.createStatement();
            
            String firstname = hiscores.getFirstName();
            String lastname = hiscores.getLastName();
            int score = hiscores.getScore();

            this.statement.execute("insert into Hiscores values "
            + "('" + firstname + "','" + lastname + "'," + score + ")");  

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

