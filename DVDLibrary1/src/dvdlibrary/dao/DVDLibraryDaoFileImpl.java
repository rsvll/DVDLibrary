/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import java.util.Scanner;

//import java.util.Scanner;// remove later just for my test-

import dvdlibrary.dto.DVDdto;
import dvdlibrary.ui.UserIO;
import dvdlibrary.ui.UserIOConsoleImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author svlln
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    private Map<String, DVDdto> DVDColection = new HashMap<>();
    public static final String DVD_FILE = "DVDLibrary.txt";
    public static final String DELIMITER = "::";
        
    
    @Override
    public DVDdto addDVD(String title, DVDdto DVD)
        throws DVDLibraryDaoPersistenceException{
        DVDdto newDVD = DVDColection.put(title, DVD);
        writeDVDLibrary();
        return newDVD;
    }
    
    // nothing to return just removind there for could be void 
    @Override
    public void removeDVD(String title) throws DVDLibraryDaoPersistenceException{
        DVDColection.remove(title);
        writeDVDLibrary();
    }
    
    
    @Override
    public List<DVDdto> getAllDVDs() 
        throws DVDLibraryDaoPersistenceException{
        LoadDVDLibrary();
        return new ArrayList<DVDdto>(DVDColection.values());
    }


    @Override
    public DVDdto editDVD(String title, DVDdto DVD)
        throws DVDLibraryDaoPersistenceException{
        //String replaced;
        //DVD editedDVD = DVDColection.replace(title, title, directorName);
        DVDColection.remove(title);
        DVDdto newDVD = DVDColection.put(title, DVD);
        writeDVDLibrary();
        return newDVD;
    }
    
// NEEED TO FINISH EDIT    
//    @Override
//    public DVDdto editDVD(String title) { // need to fix this - not working...
//        DVDdto newDVD = getDVD();
//        DVDdto editDVDTitle = DVDColection.replace(title, newDVD);
//        int userPick;
//        String changes;
//        Scanner userInput = new Scanner(System.in);
//         
//        userPick = userInput.nextInt();
//        return newDVD; // fix this later
//    }

    @Override
    public DVDdto getDVD(String title) 
        throws DVDLibraryDaoPersistenceException{
        LoadDVDLibrary();
        return DVDColection.get(title);
    }




//    @Override
//    public DVDdto exitDVD(String title) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public DVDdto searchDVD(String title) 
        throws DVDLibraryDaoPersistenceException{
        LoadDVDLibrary();
        return DVDColection.get(title);
    }
    
   

    
    private void LoadDVDLibrary() throws DVDLibraryDaoPersistenceException {
	    Scanner scanner;
	
            
            
	    try {
	        // Create Scanner for reading the file
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(DVD_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DVDLibraryDaoPersistenceException(
	                "-_- Could not load roster data into memory.", e);
	    }
	    // currentLine holds the most recent line read from the file
	    String currentLine;
	    // currentTokens holds each of the parts of the currentLine after it has
	    // been split on our DELIMITER
	    // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
	    // currentLine looks like this:
	    // movietitle::ReleaseDate::MPAARating::DirectorName::Studio::rating/coments
	    // then currentTokens will be a string array that looks like this:
	    //
	    // __________________________________________________________________
	    // |     |           |          |            |      |               |
	    // |Title|ReleaseDate|MPAARating|DirectorName|Studio|Raring/comments|
	    // |     |           |          |            |      |               |
	    // ------------------------------------------------------------------
	    //  [0]       [1]         [2]         [3]       [4]         [5]
	    String[] currentTokens;
	    // Go through DVD_FILE line by line, decoding each line into a 
	    // DVDdto object.
	    // Process while we have more lines in the file
	    while (scanner.hasNextLine()) {
	        // get the next line in the file
	        currentLine = scanner.nextLine();
	        // break up the line into tokens
	        currentTokens = currentLine.split(DELIMITER);
	        // Create a new DVDdto object and put it into the map of dvds
	        // NOTE FOR APPRENTICES: We are going to use the title
	        // which is currentTokens[0] as the map key for our DVDdto object.
	        // We also have to pass the title into the Student constructor
	        DVDdto currentTitle = new DVDdto(currentTokens[0]);
	        // Set the remaining vlaues on currentStudent manually
	        currentTitle.setRealeasedate(currentTokens[1]);
	        currentTitle.setMPAARating(currentTokens[2]);
	        currentTitle.setDirectorsName(currentTokens[3]);
                currentTitle.setStudio(currentTokens[4]);
                currentTitle.setUserRatingOrNote(currentTokens[5]);
	        
	        // Put currentTitle into the map using title as the key
	        DVDColection.put(currentTitle.getTitle(), currentTitle);
	    }
	    // close scanner
	    scanner.close();
	}
    
    	/**
	 * Writes all DVDs in to a DVD_FILE.  See loadDVDLibrary
	 * for file format.
	 * 
	 * @throws DVDLibraryDaoPersistenceException if an error occurs writing to the file
	 */
	private void writeDVDLibrary() throws DVDLibraryDaoPersistenceException{
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(DVD_FILE));
	    } catch (IOException e) {
	        throw new DVDLibraryDaoPersistenceException(
	                "Could not save student data.", e);
	    }
	    
	    // Write out the Student objects to the roster file.
	    // NOTE TO THE APPRENTICES: We could just grab the student map,
	    // get the Collection of Students and iterate over them but we've
	    // already created a method that gets a List of Students so
	    // we'll reuse it.
	    List<DVDdto> DVDList = this.getAllDVDs();
	    for (DVDdto currentTitle : DVDList) {
	        // write the Student object to the file
	        out.println(currentTitle.getTitle() + DELIMITER
	                + currentTitle.getRealeasedate() + DELIMITER 
	                + currentTitle.getMPAARating() + DELIMITER
	                + currentTitle.getDirectorsName() + DELIMITER
                        + currentTitle.getStudio() + DELIMITER
                        + currentTitle.getUserRatingOrNote());
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}

//




    
}
