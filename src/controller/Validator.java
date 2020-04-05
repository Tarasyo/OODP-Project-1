package controller;

public class Validator {







    public boolean checkCode(String input){
        if(input.length() == 3){
            return true;
        }else {
            return  false;
        }
    }
}
