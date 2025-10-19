/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.booktrackerapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andi
 */
public class User {
    private String UserName;
    private String email;
    private List<ReadingItem>readingList; //a User olvasasi bejegyzeseinek listaja
    
    public User(){
        this.readingList=new ArrayList<>();
    }

    public User(String UserName, String email, List<ReadingItem> readingList) {
        this.UserName = UserName;
        this.email = email;
        this.readingList = new ArrayList<>();
    }

    User(String MY_USERNAME, String myemailtrackerhu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return email;
    }

    public List<ReadingItem> getReadingList() {
        return readingList;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    //hozzaad egy uj olvasasi bejegyzest a user listajahoz
    public void addReadingItem(ReadingItem item){
        this.readingList.add(item);
    }
    
    //listazza az olvasi bejegyzeseit a Usernek
    public void listReadingItem(){
        if(readingList.isEmpty()){
            System.out.println(this.UserName + "the user has no recorded reading yet.");
        }
        System.out.println(this.UserName + "reading list: ");
        int lineNum=1;
        for(ReadingItem item : readingList){
            System.out.println(lineNum + "." + item.toString());
        }
    }
    
    public void CalcTotalReadPages(){
        int totalPage=0;
        for(ReadingItem item : readingList){
            if(item.status==ReadingItem.Status.READ){
                totalPage += item.book.getPage();
            }
        }
    }
}
