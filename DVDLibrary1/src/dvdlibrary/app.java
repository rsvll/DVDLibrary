/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary;

import dvdlibrary.controller.DVDLibraryController;
import dvdlibrary.dao.DVDLibraryAuditDao;
import dvdlibrary.dao.DVDLibraryAuditDaoFileImpl;
import dvdlibrary.dao.DVDLibraryDao;
import dvdlibrary.dao.DVDLibraryDaoPersistenceException;
import dvdlibrary.dao.DVDLibraryDaoFileImpl;
import dvdlibrary.service.DVDLibraryServiceLayerImpl;
import dvdlibrary.service.DVDServiceLayer;
import dvdlibrary.ui.DVDLibraryView;
import dvdlibrary.ui.UserIO;
import dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author svlln
 */
public class app {
    public static void main(String[] args) throws DVDLibraryDaoPersistenceException {
        
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryAuditDao  myAuditDao = new DVDLibraryAuditDaoFileImpl();
        DVDServiceLayer myService = new DVDLibraryServiceLayerImpl(myDao, myAuditDao);
        DVDLibraryController controller = new DVDLibraryController(myView, myService);
       controller.run();

    }
    
}
