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
public class OTTPlatform {
    @Id
    private int OTTId;
    private String OTTName;
    private double price;

    public int getOTTId() {
        return OTTId;
    }

    public void setOTTId(int OTTId) {
        this.OTTId = OTTId;
    }

    public String getOTTName() {
        return OTTName;
    }

    public void setOTTName(String OTTName) {
        this.OTTName = OTTName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return OTTName ;
    }
    
    

}
