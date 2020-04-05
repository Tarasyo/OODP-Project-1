package model;

import db.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

        /*
            This class implements countryDAO interface,
            in this class will be operation between DB and controller
        */

public class MySQLCountryDAO implements CountryDAO {

    //declaring variables in which will be initialise data from DB
    Connector db = Connector.getInstance();
    String id;
    String name;
    Continent continent;
    float surfaceArea;
    String headOfState;
    Country cn;



    //This method will select all tuples from table and pass to the Array List of Country objects and returns it
    @Override
    public ArrayList<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<Country>();

        //the query WONT pass the tuples with empty continent attribute for more info check README file
        String query = "SELECT * FROM country WHERE NOT continent = '';";

        ResultSet rs = db.select(query);

            //While loop which will initialise variables with representative attribute from table
        try {
            while( rs.next()) {
                this.id = rs.getString(1);
                this.name = rs.getString(2);
                //in case with ENUM was used valueOf method to parse string which was changed to uppercase
                //and replace space to "_" that it can be used as ENUM
                this.continent = Continent.valueOf(rs.getString(3).toUpperCase().replace(" ", "_"));
                this.surfaceArea = rs.getFloat(4);
                this.headOfState = rs.getString(5);


                //Declaring new BuilderCountry inner class use constructor to pass all values
                Country.BuilderCountry builder =
                        new Country.BuilderCountry(id, name, continent).setSutfaceArea(surfaceArea).setHeadOfState(headOfState);
                //and add new country object to the array
                countries.add(builder.build());
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return countries;
    }

    //this method looks for the tuple that have code same sa wos passed to the class
    //return will be just one country object as the code of country is original attribute
    //and code dont have duplicates
    @Override
    public Country findCountryById(String code) {

        //the query WONT pass the tuples with empty continent attribute for more info check README file
        String query = "SELECT * FROM country WHERE code = '"+code+"' AND NOT continent = '';";

        ResultSet rs = db.select(query);

        //initialise variables with representative attribute from table
        try {
                rs.next();
                this.id = rs.getString(1);
                this.name = rs.getString(2);
                //in case with ENUM was used valueOf method to parse string which was changed to uppercase
                //and replace space to "_" that it can be used as ENUM
                this.continent = Continent.valueOf(rs.getString(3).toUpperCase().replace(" ", "_"));
                this.surfaceArea = rs.getFloat(4);
                this.headOfState = rs.getString(5);


                //Declaring new BuilderCountry inner class use constructor to pass all values
                Country.BuilderCountry builder =
                        new Country.BuilderCountry(id, name, continent).setSutfaceArea(surfaceArea).setHeadOfState(headOfState);

                        this.cn = builder.build();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return cn;
    }

    //This method will select all countries with the name that will be pass as a string
    //The structure an operations are the same like getCoutrys class just with different query
    @Override
    public ArrayList<Country> findCountryByName(String name) {
        ArrayList<Country> countries = new ArrayList<Country>();

        //the query WONT pass the tuples with empty continent attribute for more info check README file
        String query = "SELECT * FROM country WHERE name = '"+name+"' AND NOT continent = '';";

        ResultSet rs = db.select(query);

        //While loop which will initialise variables with representative attribute from table
        try {
            while( rs.next()) {
                this.id = rs.getString(1);
                this.name = rs.getString(2);
                //in case with ENUM was used valueOf method to parse string which was changed to uppercase
                //and replace space to "_" that it can be used as ENUM
                this.continent = Continent.valueOf(rs.getString(3).toUpperCase().replace(" ", "_"));
                this.surfaceArea = rs.getFloat(4);
                this.headOfState = rs.getString(5);


                //Declaring new BuilderCountry inner class use constructor to pass all values
                Country.BuilderCountry builder =
                        new Country.BuilderCountry(id, name, continent).setSutfaceArea(surfaceArea).setHeadOfState(headOfState);
                //and add new country object to the array
                countries.add(builder.build());
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return countries;
    }

    //This method add new country to the DB returns true or false depending if the insert was successful 
    @Override
    public boolean addCountry(Country country) {

        //All variables are initialised from country object that passed to the method by getters
        this.id = country.getId();
        this.name = country.getName();
        this.continent = country.getContinent();
        this.surfaceArea = country.getSurfaceArea();
        this.headOfState = country.getHeadOfState();

        //Query for insert statement and with value
        String query = "INSERT INTO country (code, name, continent, surfaceArea, headOfState) " +
                "VALUES ('" + id + "', '" + name + "', '" + continent + "', '" + surfaceArea + "', '" + headOfState + "');";
        System.out.println(query);
        return db.insert(query);


    }
}
