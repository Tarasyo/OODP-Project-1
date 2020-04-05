package view;

import java.util.ArrayList;

public class Menu {
    /*
     * Just simple menu with options that are stored in Array LIst
     * The class with methods are taken from My work on DoubleLinkedList and little bit changed
     *https://github.com/Tarasyo/DoubleLinkedList_CA/blob/master/src/main/java/View/View.java
     * */

        private ArrayList menu;

        public Menu() {

            System.out.println("-------------Menu---------------");

            menu = new ArrayList<>();

            menu.add("1. List all countries");
            menu.add("2. Find a country by code");
            menu.add("3. Find a country by name");
            menu.add("4. Save a new country");
            menu.add("5. Exit");
        }
        public ArrayList getMenu() {
            return menu;
        }
}
