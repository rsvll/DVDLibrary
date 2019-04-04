/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.ui;

import dvdlibrary.dto.DVDdto;
import java.util.List;

/**
 *
 * @author svlln
 */
public class DVDLibraryView {
    
    UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    
    
    
    public int printMenuAndGetSelection(){
        
         io.print("Main Menu");
	            io.print("1. Add a DVD");
	            io.print("2. Remove a DVD");
	            io.print("3. Edit information from DVD");
	            io.print("4. list all DVD");
	            io.print("5. Display Info for DVD");
                    io.print("6. Search For DVD");
                    io.print("7: EXIT");
	         
                    return io.readInt("Please select from the" + " above choices.", 1, 7);

    }
    
    public DVDdto getNewDVDInfo(){
        String title = io.readString("Enter a title of a DVD.");
        String realeasedate = io.readString("Enter release date.");
        String mPAARating = io.readString("Enter the MPAA rating.");
        String directorsName = io.readString("Enter the directors name.");
        String studio = io.readString("Enter recording studio.");
        String userRatingOrNote = io.readString("Write your personal rating or note.");
                
        DVDdto currentDVD = new DVDdto(title);

        currentDVD.setRealeasedate(realeasedate);
        currentDVD.setMPAARating(mPAARating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRatingOrNote(userRatingOrNote);
        
        
        return currentDVD;
        
    }
    
    public void displaycreateDVDBanner(){
        io.print("=== Create DVD ===");        
    }
    
    public void displayCreateSuccessBanner(){
        io.readString(
                "DVD sucessfully created. Please hit enter to continue" );
    }
    
    public void displayDVDList(List<DVDdto> DVDList){
        DVDList.forEach((currentDVD) -> {
            io.print(currentDVD.getTitle() + ": "
                    + currentDVD.getRealeasedate() + ": "
                    + currentDVD.getDirectorsName()+ " "
                    + currentDVD.getMPAARating() + " "
                    + currentDVD.getStudio()+ " "
                    + currentDVD.getUserRatingOrNote()+ " ");
        });
        //=================
        io.readDouble("Please hit enter to continue");
    }
    public void displayDisplayAllBanner(){
        io.print("=== Display All DVD's ===");
        
    }
    
    public void displayDisplayDVDBanner(){
        io.print("=== Display DVD ===");
        
    }
    public String getTitleChoice(){
        return io.readString("Enter DVD movie title.");               
    }
    
    public void displayDVD(DVDdto currentDVD){
        if (currentDVD != null){
            io.print(currentDVD.getTitle() + " " 
             + currentDVD.getRealeasedate()+ " "
             + currentDVD.getStudio() + " "
             + currentDVD.getDirectorsName() + " " 
             + currentDVD.getMPAARating() + " "
             + currentDVD.getUserRatingOrNote());
            
        } else {
            io.print("No such DVD on file");
        }
        io.readString("Please enter to continue.");
    }
    
    public void displayRemoveDVDBanner(){
        io.print("=== REmove Student === ");        
    }
    public void displayRemoveSuccessBanner(){
        io.readString("DVD sucessfully removed. Please hit entert to continue.");
    }
    
    
    public int displayDVDEditOptions(){
                io.print("What do you want to change?");
        	io.print("1. Edit DVD title");
	        io.print("2. Edit release date ");
	        io.print("3. Edit MPAA rating");
	        io.print("4. Edit Directors name");
	        io.print("5. Edit Studio");
                io.print("6. Edit personal rating/comment");
                io.print("7: EXIT");
                
        return io.readInt("Please pick from above choices ", 1, 7); 
    }

    public void displayEditDVDBanner(){
        io.print("=== Edited DVD ===");
    }
    public String whichDvdToEdit() {
        return io.readString("Which Dvd would you like to edit? Search by title");
    }
    public void displayEditSuccessBanner(){
        io.readString("Successfully edited DVD. Hit enter to continue.");
    }
    
    
    
     public void displayExitBanner() {
         io.print("Good Bye!!!");
     }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    	public void displayErrorMessage(String errorMsg) {
	    io.print("=== ERROR ===");
	    io.print(errorMsg);
	}
//    
}
