/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.OTTMS.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author VenkataYashwanth Damera
 */
@Entity
public class Genre {
    @Id
    private int genre_id;
    private String genre_name;

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }


    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    @Override
    public String toString() {
        return  genre_name ;
    }    
    
}
