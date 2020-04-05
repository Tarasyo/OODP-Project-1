package view;

import java.util.ArrayList;

public class Menu {
    /*
     * Just simple menu with options that are stored in Array LIst
     * The class with methods are taken from My work on DoubleLinkedList and little bit changed
     *https://github.com/Tarasyo/DoubleLinkedList_CA/blob/master/src/main/java/View/View.java
     * */

        private ArrayList menu;
        private ArrayList enumList;

        public Menu() {

            System.out.println("-------------Menu---------------");

            menu = new ArrayList<>();

            menu.add("1. List all countries");
            menu.add("2. Find a country by code");
            menu.add("3. Find a country by name");
            menu.add("4. Save a new country");
            menu.add("5. Exit");

            enumListMenu();
        }
        public ArrayList getMenu() {
            return menu;
        }

        //This method to list all options for user to chose for country
        //will be used in continent method in Controller class
        public void enumListMenu(){

            enumList = new ArrayList<>();

            enumList.add("1. Asia");
            enumList.add("2. Europe");
            enumList.add("3. North America");
            enumList.add("4. Africa");
            enumList.add("5. Oceania");
            enumList.add("6. Antarctica");
            enumList.add("7. South America");


        }

    public ArrayList getEnumList() {
        return enumList;
    }


}




