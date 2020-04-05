import db.Connector;
import model.Country;
import model.CountryDAO;
import model.MySQLCountryDAO;

import java.util.ArrayList;

public class Main {


  public static void main(String[] args) {

    CountryDAO db = new MySQLCountryDAO();


    ArrayList<Country> countrys = db.findCountryByName("Brazil");


    for(Country c : countrys){
      System.out.println(c);
    }


    }


}
