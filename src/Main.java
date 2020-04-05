import db.Connector;
import model.Continent;
import model.Country;
import model.CountryDAO;
import model.MySQLCountryDAO;

import java.util.ArrayList;

public class Main {


  public static void main(String[] args) {

    CountryDAO db = new MySQLCountryDAO();


    //ArrayList<Country> countrys = db.findCountryByName("Ukraine");
    //Country cou = db.findCountryById("TER");

    //System.out.println(cou);


//    for(Country c : countrys){
//      System.out.println(c);
//    }

    //Country cou2 = new Country.BuilderCountry("  ,", "Ukraine", Continent.EUROPE).setSutfaceArea(603628).setHeadOfState("Kyiv").build();

    //boolean cou3 = db.addCountry(cou2);
    //System.out.println(cou3);

    }

}
