/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
public class Book extends MediaItem {
   
    private static int page;
    
    public Book(){
        super("","",0,"");
    };

    public Book(String title, String author,int publicationYear, String ISBN, int page) {
        super(title,author,publicationYear,ISBN);
        this.page=page;
    }

    public int getPage() {
        return page;
    }
    
    //interfacebol overriding
    @Override
    public double calculatePrice(){
        return (double) this.page /5.0; //arszamitas pl. 5 oldal = 1 egyseg ar
    }
    
    //ket toString tulterhelese -overloading
    @Override
    public String toString() {
        return getSummaryInfo() + ",Page: " + page;
    }
    
    public String toString(boolean showPage){
        if(showPage){
           return toString(); //ha van oldalszam 
        }
        else{
            return getSummaryInfo(); //ha nincs
        }
    } 
}
