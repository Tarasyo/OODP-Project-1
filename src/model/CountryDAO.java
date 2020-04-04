package model;

import java.util.ArrayList;

public interface CountryDAO {

    public ArrayList<Country> getCountries();
    public Country findCountryById(int id);
    public Country findCountryByName(String name);
    public boolean addCountry(Country country);

}
