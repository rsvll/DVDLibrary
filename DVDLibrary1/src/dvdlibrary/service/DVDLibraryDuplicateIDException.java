/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.service;

/**
 *
 * @author svlln
 */
public class DVDLibraryDuplicateIDException extends Exception {
    
    public DVDLibraryDuplicateIDException(String message){
        super(message);    
   }
    
    public DVDLibraryDuplicateIDException(String message,
                Throwable cause){
        super(message, cause);
    }
    
}
