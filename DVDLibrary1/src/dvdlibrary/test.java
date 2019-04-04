/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary;

import java.util.Scanner;
/**
 *
 * @author svlln
 */
public class test {
    
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        String edit;
        String title;
        int userPick;
        String releaseDate;
        int change;
        String userChange = " ";
       
        System.out.println("choose a title.");
        title = userInput.nextLine();
        //System.out.println(title);
        
        System.out.println("What do you want to change? ");
        System.out.println("1) Title");
        System.out.println("2) date realeased");
        System.out.println("3) director");
        //edit = userInput.nextLine();
  
        userPick = userInput.nextInt(3);
//        System.out.println("pick new " + userChange);
//        title = userInput.nextLine();
        
        switch(userPick){
            case 1:
                userChange = "title";
               // System.out.println("pick new " + userChange);
                break;
            case 2:
                userChange = "release date";
              //  System.out.println("pick new " + userChange);
                break;    
                
        }
        System.out.println("pick new " + userChange);
        title = userInput.nextLine();

        
        do{
        if (userPick == 1){
            title = userInput.nextLine();
            System.out.println("New title: " + title);
        }else if (userPick == 2){
            releaseDate = userInput.nextLine();
            System.out.println("new Release date: " + releaseDate);
        } 
        else{
            System.out.println("error");
        }
        
        } while(1==3);
  
        //System.out.println("the " + title);
        
//        switch (userpick){
//            case 1:
//                userpick = "title";
//                break;
//            case 2:
//                userpick = "date realesed";
//                break;
//            default:
//                break;                       
//        }
//        if(edit.equals("title")){
//            System.out.println(" ");
//        }
  
        
        
//        if(edit.equals("title")){
//            
//        } else if (edit.equals("date realeased")){
//            
//        } else{
//            System.out.println("pick a something to edit");
//        }
//        
//     
//
    }



    
}
