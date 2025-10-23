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
    /*
  public ReadingItem getOrCreateReadingItem(User user, Book book){
        for(ReadingItem item : user.getReadingList()){
            if(item.getBook().getISBN().equals(book.getISBN())){
                return item;
            }
        }
    ReadingItem newItem=new ReadingItem(book,0," ",null,null,ReadingItem.Status.WISHLIST);
    user.addReadingItem(newItem);
    return newItem;
  } */
    
    public User getUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            return null;
        }
        for (User user : users) {
            if (user.getusername()!= null && user.getusername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public void addBookItem(Book book){
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
        if(title==null || title.isEmpty()){
            System.out.println("Doesn't exist.Please give another title");
            return;
        }
       String searchTitleLower = title.toLowerCase();
        
        List<Book>foundBooks= new ArrayList<>();
        
       for(Book book : books){
        if(book.getTitle() != null && book.getTitle().toLowerCase().contains(searchTitleLower)){
            foundBooks.add(book);
        }
       }
       if(foundBooks.isEmpty()){
           System.out.println("The book with this title: "+ title +" doesn't exist in the catalog.");
       }
        else{
            System.out.println("Found the book: "+ title  + "':");
            int lineNum=1;
            for(Book book : foundBooks){
                System.out.println(lineNum + "." + book.toString());
            }
        }
    }
    /*
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title.trim())) {
                return book;
            }
        }
        return null;
    } */
    
   public void RegistrationUser(User user){
       for(User existingUser : users){
           if(existingUser.getusername().equals(user.getusername())){
               System.out.println("The username:" + user.getusername() + "is already used.");
               return;
           }
       }
       users.add(user);
       System.out.println("The user successfully registered." + user.getusername());
   }
   
   public void ListReadingItem(User user){
       if(user==null){
           return;
       }
       List<ReadingItem>readingList=user.getReadingList();
       
       System.out.println(user.getusername()+ "'s reading list is " + readingList.size());
       
       if(readingList.isEmpty()){
           System.out.println("The reading list is currently empty.");
       }
       else{
           int lineNum=1;
           for(ReadingItem item: readingList){
               System.out.println(lineNum + "." +item.toString());
                }  
            }
        }
   }

