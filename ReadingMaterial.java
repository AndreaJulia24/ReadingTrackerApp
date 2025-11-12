/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
public class ReadingMaterial extends MediaItem {

    public ReadingMaterial(String title, String author, int publicationYear, String ISBN) {
        super(title, author, publicationYear, ISBN);
    }

    //az ar megvalositasa defaultkent, alapertelmezettkent
    @Override
    public double calculatePrice() {
        return 0.0;
    }    
}
