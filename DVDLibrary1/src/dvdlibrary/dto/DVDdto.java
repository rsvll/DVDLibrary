/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dto;

import java.util.Objects;

/**
 *
 * @author svlln
 */
public class DVDdto {
    
     private String title;
     private String realeasedate;
     private String MPAARating;
     private String DirectorsName;
     private String Studio;
     private String UserRatingOrNote;

    public DVDdto(String title) {
        this.title = title;
    }
     
     

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRealeasedate() {
        return realeasedate;
    }

    public void setRealeasedate(String realeasedate) {
        this.realeasedate = realeasedate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorsName() {
        return DirectorsName;
    }

    public void setDirectorsName(String DirectorsName) {
        this.DirectorsName = DirectorsName;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public String getUserRatingOrNote() {
        return UserRatingOrNote;
    }

    public void setUserRatingOrNote(String UserRatingOrNote) {
        this.UserRatingOrNote = UserRatingOrNote;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.realeasedate);
        hash = 53 * hash + Objects.hashCode(this.MPAARating);
        hash = 53 * hash + Objects.hashCode(this.DirectorsName);
        hash = 53 * hash + Objects.hashCode(this.Studio);
        hash = 53 * hash + Objects.hashCode(this.UserRatingOrNote);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVDdto other = (DVDdto) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.realeasedate, other.realeasedate)) {
            return false;
        }
        if (!Objects.equals(this.MPAARating, other.MPAARating)) {
            return false;
        }
        if (!Objects.equals(this.DirectorsName, other.DirectorsName)) {
            return false;
        }
        if (!Objects.equals(this.Studio, other.Studio)) {
            return false;
        }
        if (!Objects.equals(this.UserRatingOrNote, other.UserRatingOrNote)) {
            return false;
        }
        return true;
    }
}
