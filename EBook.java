/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
public  class EBook extends ReadingMaterial {
    
   private static int fileSizeMB;

   public EBook(String title,String author, int publicationYear,String ISBN, int fileSizeMB){
       super(title,author,publicationYear,ISBN);
       EBook.fileSizeMB=fileSizeMB;
   }
   
    public int getFileSizeMB() {
        return fileSizeMB; 
    }
    
    //interfacebol a metodus, overriding
    @Override
    public double calculatePrice(){
        return (double) EBook.fileSizeMB * 0.5; //arszamitas pl. 1 MB= 0.5 egyseg ar
    }

    
    @Override
    public String toString() {
        return getSummaryInfo() + "file size: "+ fileSizeMB + "MB";
    } 
    
}
