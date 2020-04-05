package controller;

public class Validator {






    //validation for code of country
    public boolean checkCode(String input){
        if(input.matches("[a-zA-Z0-9]+") && input.length() == 3){
            return true;
        }else {
            return  false;
        }
    }

    //Validation Just for string
    public boolean checkeString(String input){
        if(input.matches("[a-zA-Z]+")){
            return true;
        }else {
            return  false;
        }
    }

    //Validation for float number
    public boolean checkArea(String input){
        if (input.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            return true;
        }else{
            return  false;
        }
    }
}
