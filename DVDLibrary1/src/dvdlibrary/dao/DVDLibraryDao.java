/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVDdto;
import java.util.List;
//import java.util.Set;

/**
 *
 * @author svlln
 */
public interface DVDLibraryDao {
    
    DVDdto addDVD(String title, DVDdto DVD)
        throws DVDLibraryDaoPersistenceException;
    List<DVDdto> getAllDVDs()
        throws DVDLibraryDaoPersistenceException;
    DVDdto getDVD(String title)
        throws DVDLibraryDaoPersistenceException;
    void removeDVD(String title)
        throws DVDLibraryDaoPersistenceException;
    DVDdto editDVD(String title, DVDdto DVD)
        throws DVDLibraryDaoPersistenceException;
    DVDdto searchDVD(String title)
            throws DVDLibraryDaoPersistenceException;
//    
    
}
