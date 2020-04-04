package model;

import db.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLCountryDAO implements CountryDAO {

    Connector db = Connector.getInstance();
    String id;



    @Override
    public ArrayList<Country> getCountries() {
        ArrayList<Country> countries = new ArrayList<Country>();

        String query = "SELECT * FROM country";

        ResultSet rs = db.select(query);

        try {
            while( rs.next() ) {




            }


            db.closeDB();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return countries;
    }

    @Override
    public Country findCountryById(int id) {
        return null;
    }

    @Override
    public Country findCountryByName(String name) {
        return null;
    }

    @Override
    public boolean addCountry(Country country) {
        return false;
    }
}
