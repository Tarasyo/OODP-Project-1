package controller;

import model.Country;
import model.CountryDAO;
import model.MySQLCountryDAO;
import view.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Controller {

    private Menu menu;
    private CountryDAO db;

    public Controller(){

        menu = new Menu();
        db = new MySQLCountryDAO();

        options();


    }

    public void options(){
        String input;
        for (int i = 0; i < menu.getMenu().size(); i++) {
            System.out.println(String.valueOf(menu.getMenu().get(i)));
        }
        System.out.println("Please Select one of the options");
        input = bufferR();
        switch (input) {
            case "1":
            listAllCountries();
                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
            case "5":

                break;
            default:
                System.out.println("Please choice one of the options");
                options();
                break;
        }
    }


    public void listAllCountries(){
        ArrayList<Country> countrys = db.getCountries();
        for(Country c : countrys){
      System.out.println(c);

    }
    }



    //Method to read input from user
    public String  bufferR() {
        String input = "";
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            input = br.readLine();

        }catch(Exception e) { System.out.println("Error reading input");}
        return input;
    }


}
