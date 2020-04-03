package db;

import java.sql.*;


    /*
    Taras Boreyko 2017284

    This is the database connector which I decided to do like enum singleton
    */

public enum Conector {
    instance;



    private String server = "jdbc:mysql://apontejaj.com:3306/world";
    private String user = "cctstudent";
    private String pass = "Pass1234!";
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private Conector() {

        try{

            // Get a connection to the database
            conn = DriverManager.getConnection(server, user, pass) ;

            // Get a statement from the connection
            stmt = conn.createStatement() ;

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

    public boolean insertQuery(String query){
        try{
            stmt.executeQuery(query);
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ResultSet selectQuery(String query){
        try {
            rs = stmt.executeQuery(query);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public static Conector getInstance(){
        return instance;
    }


    //Close database method
    public void closeDB(){
        try {
            rs.close();
            stmt.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
