/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

/**
 *
 * @author svlln
 */
public class DVDLibraryDaoPersistenceException extends Exception {
    
    public DVDLibraryDaoPersistenceException(String message){
        super(message);
    }
    
    public DVDLibraryDaoPersistenceException(String message, Throwable cause){
        super(message, cause);
    }
//    
}
