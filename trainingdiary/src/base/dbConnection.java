package base;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Andrea on 15.03.2016.
 */


/*
*
* Database tables:
* exercise
       exerciseID          INT             NOT NULL,
       exerciseName        VARCHAR(30)     NOT NULL,
       description         VARCHAR(150)            ,

* exerciseTemplate
       templateID 		INT 			NOT NULL,
       templateName       	VARCHAR(100) 		NOT NULL,

* templateExerciseRelation
       templateID INT not null,
       exerciseID INT not null,

* user
    userID              INT             NOT NULL,
    name                VARCHAR(30)     NOT NULL,
    birthdate           DATE                    ,


* session(
       sessionID 		INT NOT NULL,
       shape                 	INT                 CHECK ( shape >=1 AND shape <= 10 ),
       note                     VARCHAR(140),
       performance          	INT                 CHECK ( shape >=1 AND shape <= 10 ),
       start                 	DATETIME            NOT NULL,
       end                  	DATETIME            NOT NULL,
       userID 			INT 		    NOT NULL


* sessionOutdoors
       temperature 		FLOAT,
       weather 			VARCHAR(140),
       sessionID  		INT 			NOT NULL,


* sessionIndoors(
       spectators 		INT ,
       airQuality        	VARCHAR(140),
       sessionID   		INT 			NOT NULL,


* exerciseSessionRelation(
       sessionID 		INT 			NOT NULL,
       exerciseID  		INT  			NOT NULL,


* exerciseGroup (
        groupID                                INT                         NOT NULL,
        groupName                              VARCHAR(45)                NOT NULL,
        parentGroupID                 	       INT                                                ,


* exerciseBelongsToGroup (
        exerciseID                        INT                                NOT NULL,
        groupID                           INT                                NOT NULL,

* exerciseReplacement (
        exercise1ID                        INT                                NOT NULL,
        exercise2ID                 	   INT                                NOT NULL,

* personalBest (
    encumbrance         INT 		NOT NULL,
    setdate             DATE            NOT NULL,
    reps                INT,
    userID              INT             NOT NULL,
    exerciseID          INT             NOT NULL,

* goal (
    userID              INT             NOT NULL,
    exerciseID          INT             NOT NULL,
    setdate             DATE            NOT NULL,
    encumbrance         INT                     ,
    reps                INT                     ,
*
* */
public class DBConnection {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql.stud.ntnu.no/torjehoa_test";

    //  Database credentials
    static final String USER = "torjehoa_test";
    static final String PASS = "drubadru";

    private Connection conn = null;


    public DBConnection() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public String getData(){
        Statement stmt = null;
        try {
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                        stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
        }


        return "";
    }

    public ArrayList<Exercise> getAllExercises(){
        Statement stmt = null;
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        try {
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select * from exercise";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id = rs.getInt("exerciseID");
                String name = rs.getString("exerciseName");
                String desc = rs.getString("description");

                exercises.add( new Exercise(id, name, desc) );
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
        }
        return exercises;
    }

    public void addExerciseToDB(String exName, String exDesc, int id){
        Statement stmt = null;
        try {
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = String.format("INSERT INTO exercise VALUES (%d, '%s', '%s')", id, exName, exDesc);
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
        }
    }

    public void addSession(int id, int shape, int performance, ArrayList<Exercise> exercises){/*
        sessionID 		INT NOT NULL,
        shape                 	INT                 CHECK ( shape >=1 AND shape <= 10 ),
                note                     VARCHAR(140),
                performance          	INT                 CHECK ( shape >=1 AND shape <= 10 ),
        start                 	DATETIME            NOT NULL,
        end                  	DATETIME            NOT NULL,
                userID*/
        Statement stmt = null;
        try {
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = String.format("INSERT INTO session VALUES (%d, %d, 'blank note', %d, '2016-01-01 11:11:11', '2016-01-01 11:11:11', 0)", id, shape, performance);
            System.out.println(sql);
            stmt.executeUpdate(sql);

            sql = String.format("INSERT INTO session VALUES (%d, %d, 'blank note', %d, '2016-01-01 11:11:11', '2016-01-01 11:11:11', 0)", id, shape, performance);
            System.out.println(sql);
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
        }

    }

    public void closeConnection() {
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

    }
/*
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = USER;
        String pass = PASS;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(DB_URL, user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from exercise");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("exerciseName") + ", " + myRs.getString("description"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }*/
}
