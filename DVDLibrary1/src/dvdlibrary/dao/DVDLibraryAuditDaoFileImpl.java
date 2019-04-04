/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author svlln
 */
public class DVDLibraryAuditDaoFileImpl implements DVDLibraryAuditDao{

    public static final String AUDIT_FILE = "audit.txt";
    
    public void writeAuditEntry(String entry) throws DVDLibraryDaoPersistenceException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        }catch(IOException e){
            throw new DVDLibraryDaoPersistenceException("Could not persist audit information.", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    
}
