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
    private Validator validator;

    public Controller(){

        menu = new Menu();
        db = new MySQLCountryDAO();
        validator = new Validator();


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
            findByCode();
                break;
            case "3":
            findByName();
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

    //Method that takes data from getCountries method and out prints the array with for-each loop
    public void listAllCountries(){
        ArrayList<Country> countrys = db.getCountries();
        for(Country c : countrys){
        System.out.println(c);
    }
        System.out.println("-----------------------------------------------------");
        options();
    }

    //Method that checks the input from user
    public void findByCode(){
        Country con;
        String input;
        System.out.println("Please Enter Code of country it should have EXACTLY 3 symbols");
        input = bufferR();
        //it should be exactly 3 symbols if validation returns true call findCountryById method and look for this code
        if(validator.checkCode(input)){
            con = db.findCountryById(input);
            //Check if from findCountryById method returns null that its will still throw an exception message and go back to menu
            if(con == null){
                System.out.println("There is no country with code like this");
                options();
            }else {
                System.out.println(con);
                System.out.println("-----------------------------------------------------");
                options();
            }
        }else{
            System.out.println("Please ENTER EXACTLY 3 symbols");
            findByCode();
        }

    }
    public void findByName(){
        ArrayList<Country> countrys = db.getCountries();
        String input;
        System.out.println("Please Enter Name of country");
        input = bufferR();
        countrys = db.findCountryByName(input);
        if(countrys.isEmpty()){
            System.out.println("There is no country with name like this");
            options();
        }else {
            for (Country c : countrys) {
                System.out.println(c);
            }
            System.out.println("-----------------------------------------------------");
            options();
        }
    }

    //method to close DB and exit from java machine
    public void  exit(){
        db.close();
        System.exit(0);
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
