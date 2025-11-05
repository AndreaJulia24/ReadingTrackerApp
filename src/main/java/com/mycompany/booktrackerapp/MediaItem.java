/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
public abstract class MediaItem implements Publication{
    private String title;
    private String author;
    private int publicationYear;
    private String ISBN; //egyedi azonosito

    public MediaItem(String title, String author, int publicationYear, String ISBN) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getISBN() {
        return ISBN;
    }
    
    
    //absztrakt metodus- a leszarmazottak majd definialjak a calculatePrice-t
    @Override
    public abstract double calculatePrice();

    @Override
    public String getSummaryInfo(){
        return this.title + "by" +this.author + "( " + this.publicationYear + ")";
    }
}
