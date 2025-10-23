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
    private String username;
    private String email;
    private List<ReadingItem>readingList; //a User olvasasi bejegyzeseinek listaja
    
    public User(){
        this.readingList=new ArrayList<>();
    }

    public User(String MY_USERNAME, String email) {
        this.username = MY_USERNAME;
        this.email = email;
        this.readingList = new ArrayList<>();
    }
   

    public String getusername() {
        return username;
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
    public void listReadingItem(User user){
        
        if(user==null){
        return;
        }
        List<ReadingItem> readingList = user.getReadingList();
        
        if(readingList.isEmpty()){
            System.out.println(this.username + "the user has no recorded reading yet.");
        }
        System.out.println(this.username + "reading list: ");
        int lineNum=1;
        for(ReadingItem item : readingList){
            System.out.println(lineNum + "." + item.toString());
            lineNum++;
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
