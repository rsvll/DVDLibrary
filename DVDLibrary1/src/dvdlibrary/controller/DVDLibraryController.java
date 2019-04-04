/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controller;


import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import dvdlibrary.dao.DVDLibraryDaoFileImpl;
import dvdlibrary.dto.DVDdto;
import dvdlibrary.service.DVDLibraryDataValidationException;
import dvdlibrary.service.DVDLibraryDuplicateIDException;
import dvdlibrary.service.DVDServiceLayer;
import dvdlibrary.ui.DVDLibraryView;
//import dvdlibrary.ui.UserIO;
import dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author svlln
 */
public class DVDLibraryController {
    
        DVDLibraryView view;
        DVDServiceLayer service;
                
        //private UserIO io = new UserIOConsoleImpl();// to be removed

    public DVDLibraryController(DVDLibraryView view, DVDServiceLayer service) {
        this.service = service;
        this.view = view;
    }
        
        
        
        public void run() throws DVDLibraryDaoPersistenceException {
	        boolean keepGoing = true;
	        int menuSelection = 0;
                try{
	        while (keepGoing) {
                    

                    
                    menuSelection = getMenuSelection();
	           
	            switch (menuSelection) {
	                case 1:
	                    createDVD();
	                    break;
	                case 2:
	                    removeTitle();
	                    break;
	                case 3:
	                    editTitle();
	                    break;
	                case 4:
	                    listDVDs();
	                    break;
	                case 5:                            
                            viewDVD();
                            break;
                            case 6:
                            viewDVD();
	                    break;
                            case 7:
                            keepGoing = false;
                            break;
                            default:
	                    unknownCommand();
	            }

	        }
	        exitMessage();
                } catch (DVDLibraryDaoPersistenceException e){
                    view.displayErrorMessage(e.getMessage());
                }
	    }

    private int getMenuSelection() {
         return view.printMenuAndGetSelection();
    }
    
   private void createDVD() throws DVDLibraryDaoPersistenceException {
       view.displaycreateDVDBanner();
       boolean hasErrors = false;
       do{
            DVDdto newDVD = view.getNewDVDInfo();
            try{
                service.addDVD(newDVD);
                view.displayCreateSuccessBanner();
            }catch(DVDLibraryDuplicateIDException | DVDLibraryDataValidationException e){
                hasErrors = false;
                view.displayErrorMessage(e.getMessage());
            }
       }while(hasErrors); 
   }
   
   private void listDVDs() throws DVDLibraryDaoPersistenceException {
       view.displayDisplayAllBanner();
       List<DVDdto> DVDList = service.getAllDVDs();
       view.displayDVDList(DVDList);
   }
   
   private void viewDVD() throws DVDLibraryDaoPersistenceException {
       view.displayDisplayDVDBanner();
       String title = view.getTitleChoice();
       DVDdto currentDVD = service.getDVD(title);
       view.displayDVD(currentDVD);

    //    view.displayDVD(view.getTitleChoice());
       
       
   }
    
   private void removeTitle() throws DVDLibraryDaoPersistenceException {
         view.displayRemoveDVDBanner();
//       String title = view.getTitleChoice();
//       dao.removeDVD(title);
//       view.displayRemoveSuccessBanner();
        service.removeDVD(view.getTitleChoice());
        view.displayRemoveSuccessBanner();

       
   }
   
  private void editTitle() throws DVDLibraryDaoPersistenceException{
      view.displayEditDVDBanner();
      String specificDVD = view.whichDvdToEdit();
      service.removeDVD(specificDVD);
      DVDdto myDVDColection = view.getNewDVDInfo();
            try {
                service.editDVD(myDVDColection.getTitle(), myDVDColection);
            } catch (DVDLibraryDuplicateIDException ex) {
                Logger.getLogger(DVDLibraryController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DVDLibraryDataValidationException ex) {
                Logger.getLogger(DVDLibraryController.class.getName()).log(Level.SEVERE, null, ex);
            }
      //dao.addDVD(myDVDColection.getTitle(), myDVDColection);
      view.displayEditSuccessBanner();
  }         
//
  
//   private void editTitle(){
//       view.displayEditDVDBanner();
//       String title = view.getTitleChoice();
//       boolean keepGoing = true;
//       int menuSelection2 = 0;
//       
//    //DVD object variable    
//    while (keepGoing) {
//                    
//      menuSelection2 = getEditOptions();    
//// if (map.containsKey(key) && Objects.equals(map.get(key), value)) {
////     map.put(key, newValue);
////     return true;
//// } else
////     return false;    
////          
////     private String title;
////     private String realeasedate;
////     private String MPAARating;
////     private String DirectorsName;
////     private String Studio;
////     private String UserRatingOrNote;
//     
//	           
//	            switch (menuSelection2) {
//	                case 1:
//	                   // io.print("lets edit that dvd title");
//	                    break;
//	                case 2:
//	                    //String realesedate = 
//	                    break;
//	                case 3:
//	                    //e EDIT MPAA RATING
//	                    break;
//	                case 4:
//	                    // EDIT DIRECTORS NAME
//	                    break;
//	                case 5:                            
//                            // EDIT STUDIO
//                            break;
//                            case 6:
//                            // EDIT PERSONAL RATING/ COMENT 
//	                    break;
//                            case 7:
//                            keepGoing = false;
//                            break;
//                            	              
//                            
//	                default:
//	                    unknownCommand();
//	            }
//
//	        }
//	     exitMessage();
//	    }
   
       private int getEditOptions() {
         return view.displayDVDEditOptions();
    }

        private void unknownCommand() {
             view.displayUnknownCommandBanner();
        }

        private void exitMessage() {
            view.displayExitBanner();
        }       
   
   
} 

