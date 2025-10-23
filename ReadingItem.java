/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
import java.time.LocalDate;

public class ReadingItem {
    Book book;
    int rating;
    String review;
    LocalDate startDate;
    LocalDate endDate;
    Status status;
    
    public enum Status{
        READ,
        IN_PROGRESS,
        WISHLIST
    }
    
    public ReadingItem(){};

    public ReadingItem(Book book, int rating, String review, LocalDate startDate, LocalDate endDate, Status status) {
        this.book = book;
        this.rating = rating;
        this.review =review;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setRating(int rating) {
        if(rating>=1 && rating<=5){
            this.rating=rating;
        }
        else{
            System.out.println("Does not exist.The rating is only between 1 and 5.");
        }
    }

    public void setStatus(Status newStatus) {
       if (this.status == newStatus) return;

        if (newStatus == Status.IN_PROGRESS && this.status != Status.IN_PROGRESS) {
            this.startDate = LocalDate.now();
            this.endDate = null;
        } else if (newStatus == Status.READ && this.status != Status.READ) {
            if (this.startDate == null) {
                this.startDate = LocalDate.now();
            }
            this.endDate = LocalDate.now();
        } else if (newStatus == Status.WISHLIST) {
            this.startDate = null;
            this.endDate = null;
        }
        this.status = newStatus;
    }
    
   
    public void setReview(String review) {
        this.review =review;
    }
    
    
    public long getReadingTime(){
        
        if(this.status==Status.READ && this.startDate!=null && this.endDate!=null){
            long startDay=this.startDate.toEpochDay();
            long endDay=this.endDate.toEpochDay();
            
          return (endDay - startDay) + 1;
        }
        return 0;
    }
}