/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.booktrackerapp;

/**
 *
 * @author Andi
 */
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

        
public class BookTrackerApp {
    
    private static final String DATA_FILE="app_data.json";
    private static final String MY_USERNAME= "YOUR USERNAME";
    
    private ReadingTrackerSystem system;
    //private User currentUser;
    private Scanner scanner;
    
    
    
    public static ReadingTrackerSystem loadData(String filename){
        File file=new File(filename);
        
        if (!file.exists()) {
            System.out.println("Data file not found " + filename + ". Initializing empty system.");
        }
        return new ReadingTrackerSystem(); 
    }
    
    private void initialize(){
        this.system=loadData(DATA_FILE);
        this.scanner=new Scanner(System.in);
        User appUser=system.users(MY_USERNAME);
        
        if(appUser == null){
            System.out.println("Creating a new profile: "+ MY_USERNAME);
            appUser= new User(MY_USERNAME, "my.email@tracker.com");
            system.RegistrationUser(appUser);
        }else{
            System.out.println("Welcome back, " + MY_USERNAME);
        }
    }

    public static void main(String[] args) {
        
        
        
    }
}
