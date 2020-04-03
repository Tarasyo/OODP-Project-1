package db;

import java.sql.*;

public class Conector {


    private String db = "jdbc:mysql://apontejaj.com:3306/world";
    private String un = "cctstudent";
    private String pw = "Pass1234!";

    public Conector() {

        try{

            // Get a connection to the database
            Connection conn = DriverManager.getConnection( db, un, pw ) ;

            // Get a statement from the connection
            Statement stmt = conn.createStatement() ;

            // Execute the query
            ResultSet rs = stmt.executeQuery( "SELECT * FROM country" ) ;

            // Loop through the result set
            while( rs.next() )
                System.out.println( rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
                        + "\t" + rs.getString(4) + "\t" + rs.getString(5)) ;

            // Close the result set, statement and the connection
            rs.close() ;
            stmt.close() ;
            conn.close() ;
        }
        catch( SQLException se ){
            System.out.println( "SQL Exception:" ) ;

            // Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
        }
        catch( Exception e ){
            System.out.println( e ) ;
        }
    }
}
