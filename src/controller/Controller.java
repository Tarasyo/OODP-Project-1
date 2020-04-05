package controller;

import model.Continent;
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
            add();
                break;
            case "5":
            exit();
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
        System.out.println("Please Enter Code of country it should have EXACTLY 3 letters or numbers");
        input = bufferR();
        //it should be exactly 3 numbers or letters if validation returns true call findCountryById method and look for this code
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

    //Method to fined by name that calls the findCountryByName method
    //Have validation that checks just letters because its better for DB
    //This is the name of country and symbols or numbers shouldn't use
    public void findByName(){
        ArrayList<Country> countrys;
        String input;
        System.out.println("Please Enter Name of country use JUST alphabetical letters");
        input = bufferR();
        if(validator.checkeString(input)){
        countrys = db.findCountryByName(input);
        //if array empty means that no county found by this name
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
        }else{
            System.out.println("Please use JUST alphabetical letters");
            findByName();
        }
    }

    public void add(){
        String input;

        String code = code();
        String name = name();
        Continent cont = continent();
        float area = 0;
        String headState = "";

        System.out.println("Would u like to enter surface area, pleas write 'y' for YES and 'n' for NO");
        input = bufferR();
        switch (input) {
            case "y":
                area = area();
                break;
            default:
                break;
        }

        System.out.println("Would u like to enter head of state, pleas write 'y' for YES and 'n' for NO");
        input = bufferR();
        switch (input) {
            case "y":
                headState = headState();
                break;
            default:
                break;
        }

        Country con = new Country.BuilderCountry(code, name, cont).setSutfaceArea(area).setHeadOfState(headState).build();
        boolean check = db.addCountry(con);
        if(check){
            System.out.println("Country was added");
            options();
        }else{
            System.out.println("ERROR: we couldn't add the country");
            options();
        }
    }


    //Method to ask input from user for the code off country that will be created
    public String code(){
        String input;
        Country con;
        System.out.println("Please Enter the CODE of country it should have EXACTLY 3 letters or numbers");
        input = bufferR();
        if(validator.checkCode(input)) {
            con = db.findCountryById(input);
            //Check if from findCountryById method returns something, to know if this code is used already
            if (con != null) {
                System.out.println("There is already country with code like this");
                code();
            }
        }else{
            System.out.println("Please Enter EXACTLY 3 letters or numbers");
            code();
        }
        return input;
    }
    //Method to ask name from user for add Country
    //In validation it allows just alphabetical letters, I think its will be the best practice
    public String name(){
        String input;
        System.out.println("Please Enter the NAME of country it should have JUST alphabetical letters");
        input = bufferR();
        if(validator.checkeString(input) == false){
            System.out.println("Please ENTER JUST alphabetical letters");
            name();
        }
        return input;
    }

    //Method for user to chose the continent for adding country
    public Continent continent(){
        String input;
        System.out.println("Please Chose one of the options of the Continent or pres eny other key and ASIA will be as default");
        for (int i = 0; i < menu.getEnumList().size(); i++) {
            System.out.println(String.valueOf(menu.getEnumList().get(i)));
        }
        input = bufferR();
        switch (input) {
            case "1":
                return Continent.ASIA;
            case "2":
                return Continent.EUROPE;
            case "3":
                return Continent.NORTH_AMERICA;
            case "4":
                return Continent.AFRICA;
            case "5":
                return Continent.OCEANIA;
            case "6":
                return Continent.ANTARCTICA;
            case "7":
                return Continent.SOUTH_AMERICA;
            default:
                return Continent.ASIA;
        }

    }

    //Method to take surface area from user and check if its float number
    public float area(){

        String input;
        System.out.println("Please Enter the surface area of country it should have JUST number");
        input = bufferR();
        if(validator.checkArea(input) == false){
            System.out.println("Please ENTER JUST number");
            area();
        }
        return Float.valueOf(input);
    }

    //Method to take Head of state value from user
    public String headState(){
        String input;
        System.out.println("Please Enter the head of state of country it should have JUST alphabetical letters");
        input = bufferR();
        if(validator.checkeString(input) == false){
            System.out.println("Please ENTER JUST alphabetical letters");
            headState();
        }
        return input;
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
