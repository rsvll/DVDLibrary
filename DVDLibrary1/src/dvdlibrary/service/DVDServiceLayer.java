/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.service;

import dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import dvdlibrary.dto.DVDdto;
import java.util.List;

/**
 *
 * @author svlln
 */
public interface DVDServiceLayer {
    
void addDVD(DVDdto DVD) throws    
    DVDLibraryDuplicateIDException,
    DVDLibraryDataValidationException,
    DVDLibraryDaoPersistenceException;
    
    
    List<DVDdto> getAllDVDs() throws
            DVDLibraryDaoPersistenceException;
    
    DVDdto getDVD(String title) throws
            DVDLibraryDaoPersistenceException;
    
    
    void removeDVD (String title) throws
            DVDLibraryDaoPersistenceException;
    
    DVDdto editDVD(String title,DVDdto DVD) throws
        DVDLibraryDuplicateIDException,
        DVDLibraryDataValidationException,
        DVDLibraryDaoPersistenceException;
            

            
            
    
}
