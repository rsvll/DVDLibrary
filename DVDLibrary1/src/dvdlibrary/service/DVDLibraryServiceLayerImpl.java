/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.service;

import dvdlibrary.dao.DVDLibraryAuditDao;
import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import dvdlibrary.dto.DVDdto;
import java.util.List;

/**
 *
 * @author svlln
 */
public class DVDLibraryServiceLayerImpl implements DVDServiceLayer{
    
    DVDLibraryDao dao;
    DVDLibraryAuditDao auditDao;
    
    public DVDLibraryServiceLayerImpl(DVDLibraryDao dao, DVDLibraryAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }
   
    
    @Override
    public void addDVD(DVDdto DVD) throws  
    DVDLibraryDuplicateIDException,
    DVDLibraryDataValidationException,
    DVDLibraryDaoPersistenceException {
        
        if(dao.getDVD(DVD.getTitle()) != null){
            throw new DVDLibraryDuplicateIDException(
                    "ERROR: could not create student. Student ID "
                    + DVD.getTitle()
                    + " already exists");        
        }
        validateDVDData(DVD);
        
        dao.addDVD(DVD.getTitle(), DVD);
        
        
        auditDao.writeAuditEntry("DVD " + DVD.getTitle() + " created" );
            
    }

    @Override
    public List<DVDdto> getAllDVDs() throws DVDLibraryDaoPersistenceException {
        return dao.getAllDVDs();
    }

    @Override
    public DVDdto getDVD(String title) throws DVDLibraryDaoPersistenceException {
        return dao.getDVD(title);
    }

    
    // service layer calling dao there is nothing to return since theres nothing to return
    @Override
    public void removeDVD(String title) throws DVDLibraryDaoPersistenceException {
        //return dao.removeDVD(title);
        dao.removeDVD(title);
    }

    @Override
    public DVDdto editDVD(String title, DVDdto DVD) throws DVDLibraryDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    private void validateDVDData(DVDdto DVD) throws
            DVDLibraryDataValidationException {
        if(DVD.getTitle() == null
                || DVD.getTitle().trim().length() == 0
                || DVD.getDirectorsName() == null
                || DVD.getDirectorsName().trim().length() == 0
                || DVD.getRealeasedate() == null
                || DVD.getRealeasedate().trim().length() == 0
                ){
        throw new DVDLibraryDataValidationException(
                "ERROR: All fields [Title, Directors name, Release date] are required.");    
        };
    }
    
    
}
