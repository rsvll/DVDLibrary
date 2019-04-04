/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.ui;

import java.util.Scanner;

/**
 *
 * @author svlln
 */
public class UserIOConsoleImpl implements UserIO{

    
    Scanner myScanner = new Scanner(System.in);
    protected String userInput;

   

    @Override
    public void print(String message) {                
        System.out.println(message);  
    }

    @Override
    public double readDouble(String prompt) {
        double number;
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        number = Integer.parseInt(userInput);
        return number;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        boolean valid;
        double number;
        do {
            System.out.println(prompt + " " + min + " to " + max);
            userInput = myScanner.nextLine();
            number = Integer.parseInt(userInput);
            if (number >= min && number <= max) {
                valid = true;
            } else {
                System.out.println("Sorry, pick a valid number between " + min + " and " + max);
            }
            return number;
        } while (!valid);        
    }

    @Override
    public float readFloat(String prompt) {
        float number;
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        number = Integer.parseInt(userInput);
        return number;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        boolean valid;
        float number;
        do {
            System.out.println(prompt + " " + min + " to " + max);
            userInput = myScanner.nextLine();
            number = Integer.parseInt(userInput);
            if (number >= min && number <= max) {
                valid = true;
            } else {
                System.out.println("Sorry, pick a valid number between " + min + " and " + max);
            }
            return number;
        } while (!valid);   
    }

    @Override
    public int readInt(String prompt) {
        int number;
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        number = Integer.parseInt(userInput);
        return number;

    }

    @Override
    public int readInt(String prompt, int min, int max) {
        boolean valid;
        int number;
        do {
            System.out.println(prompt + " " + min + " to " + max);
            userInput = myScanner.nextLine();
            number = Integer.parseInt(userInput);
            if (number >= min && number <= max) {
                valid = true;
            } else {
                System.out.println("Sorry, pick a valid number between " + min + " and " + max);
            }
            return number;
        } while (!valid);        
    }

    @Override
    public long readLong(String prompt) {
        long number;
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        number = Integer.parseInt(userInput);
        return number;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        boolean valid;
        long number;
        do {
            System.out.println(prompt + " " + min + " to " + max);
            userInput = myScanner.nextLine();
            number = Integer.parseInt(userInput);
            if (number >= min && number <= max) {
                valid = true;
            } else {
                System.out.println("Sorry, pick a valid number between " + min + " and " + max);
            }
            return number;
        } while (!valid);   
    }

    @Override
    public String readString(String prompt) {
        //String read;
        System.out.println(prompt);
        userInput = myScanner.nextLine();
        
        return userInput;
    }
//    

}
