/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
public class AudioBook extends MediaItem {
    
    private int durationInMinutes;

    public AudioBook( String title, String author, int publicationYear, String ISBN,int durationInMinutes) {
        super(title, author, publicationYear, ISBN);
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    

    @Override
    public double calculatePrice() {
       return (double) this.durationInMinutes * 1; //arszamitas: 1 perc= 1 egyseg ar
    }

    @Override
    public String toString() {
        return getSummaryInfo() + ",Duration: " + durationInMinutes + "minutes";
    }
}
