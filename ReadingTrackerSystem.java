/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Andi
 */
//az app kozponti osztalya amely a User s Book globalis listait kezeli

public class ReadingTrackerSystem {
    List<Book>books;
    List<User>users;

    public ReadingTrackerSystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }
    
    public void addBook(Book book){
        for(Book existingBook : books){
            if(existingBook.getISBN().equals(book.getISBN())){
                System.out.println("The book ISBN: " + book.getISBN() + "already exist in the catalog.");
                return;
            }
        }
     books.add(book);
     System.out.println("The book is added to the catalog.The book name and author: " + book.getTitle() + book.getAuthor()
     + "The book's ISBN: " + book.getISBN());
    }
    
    public void searchBook(String title){
        if(title==null && title.isEmpty()){
            System.out.println("Doesn't exist.Please give another title");
        }
        List<Book>foundBooks= new ArrayList<>();
        for(Book book : books){
            foundBooks.add(book);
        }
        if(foundBooks.isEmpty()){
            System.out.println("The book with this title:  " + title +"doesn't exist in the catalog");
        }
        else{
            System.out.println("Found the book: "+ title);
            int lineNum=1;
            for(Book book : foundBooks){
                System.out.println(lineNum + "." + foundBooks.toString());
            }
        }
    }
    
   public void RegistrationUser(User user){
       for(User existingUser : users){
           if(existingUser.getUserName().equals(user.getUserName())){
               System.out.println("The username:" + user.getUserName() + "is already used.");
           }
       }
       users.add(user);
       System.out.println("The user successfully registered." + user.getUserName());
   }

    User users(String MY_USERNAME) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
