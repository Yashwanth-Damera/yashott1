/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.OTTMS.Repository;

import com.example.OTTMS.Models.Genre;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author VenkataYashwanth Damera
 */
public interface GenreRepository extends CrudRepository<Genre, Integer>{
    
}
