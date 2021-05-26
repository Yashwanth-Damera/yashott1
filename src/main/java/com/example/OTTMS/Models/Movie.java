/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.OTTMS.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Venkatayashwanth Damera
 */
@Entity
public class Movie {
    
    @Id
    private int id;
    private String movie_name;
    private String year;
    private double imdb_ratings;
    
   @ManyToOne
   private OTTPlatform OTT;
   
   @ManyToOne
   private Genre genre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getImdb_ratings() {
        return imdb_ratings;
    }

    public void setImdb_ratings(double imdb_ratings) {
        this.imdb_ratings = imdb_ratings;
    }

    public OTTPlatform getOTT() {
        return OTT;
    }

    public void setOTT(OTTPlatform OTT) {
        this.OTT = OTT;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        String a="ID : "+id+"\n;"
                + "Movie Name: "+movie_name+"\n;"
                + "Released Year : "+year+"\n;"
                + "IMDB Ratings : "+imdb_ratings+"\n;"
                + "Genre : "+genre+"\n;"
                + "OTT Platform : "+OTT;
                
        return a;
    }
    
    


   
}
