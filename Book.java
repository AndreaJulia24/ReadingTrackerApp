/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private String ISBN; //egyedi azonosito
    private int page;
    
    public Book(){};

    public Book(String title, String author, String ISBN, int page) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.page = page;
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

    public int getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", ISBN=" + ISBN + ", page=" + page + '}';
    }
     
}
