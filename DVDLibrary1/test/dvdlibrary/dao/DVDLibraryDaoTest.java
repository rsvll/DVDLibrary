/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVDdto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author svlln
 */
public class DVDLibraryDaoTest {
    
    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
    
    public DVDLibraryDaoTest() {
  
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    // runs before each of the test need to be put in good state
    @Before
    public void setUp() throws Exception{
        List<DVDdto> DVDList = dao.getAllDVDs();
        for(DVDdto dvd : DVDList){
            dao.removeDVD(dvd.getTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testAddGetDVD() throws Exception {
        DVDdto newdvd = new DVDdto("pokemon");
        newdvd.setDirectorsName("Rich");
        newdvd.setRealeasedate("2018");
        newdvd.setMPAARating("PG");
        newdvd.setStudio("HOME");
        newdvd.setUserRatingOrNote("Awesome movie!!");
        
        dao.addDVD(newdvd.getTitle(), newdvd);
        
        DVDdto fromDao = dao.getDVD(newdvd.getTitle());
        
        assertEquals(newdvd, fromDao);
        
    }

    /**
     * Test of getAllDVDs method, of class DVDLibraryDao.
     */
    @Test
    public void testGetAllDVDs() throws Exception {
        
        DVDdto newdvd1 = new DVDdto("pokemon");
        newdvd1.setDirectorsName("rich");
        newdvd1.setMPAARating("PG");
        newdvd1.setStudio("blah");
        newdvd1.setRealeasedate("2018");
        newdvd1.setUserRatingOrNote("fav movie");
        
        dao.addDVD(newdvd1.getTitle(), newdvd1);
        
        DVDdto newdvd2 = new DVDdto("pokemon part 2");
        newdvd1.setDirectorsName("rich");
        newdvd1.setMPAARating("PG");
        newdvd1.setStudio("blah");
        newdvd1.setRealeasedate("2018");
        newdvd1.setUserRatingOrNote("fav movie");
        
        dao.addDVD(newdvd2.getTitle(), newdvd2);
        
        assertEquals(2, dao.getAllDVDs().size());
        
    }

    /**
     * Test of getDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testGetDVD() throws Exception {
    }

    /**
     * Test of removeDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
    }

    /**
     * Test of editDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testEditDVD() throws Exception {
    }

    /**
     * Test of searchDVD method, of class DVDLibraryDao.
     */
    @Test
    public void testSearchDVD() throws Exception {
    }


}
