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
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


        
public class BookTrackerApp {
    
    private static final String DATA_FILE="app_data.json";
    private static final String MY_USERNAME= "YOUR USERNAME";
    
    private ReadingTrackerSystem system;
    private User currentUser;
    private Scanner scanner;
   
    
    public static ReadingTrackerSystem loadData(String filename){
        File file=new File(filename);
        
        if (!file.exists()) {
            System.out.println("Data file not found " + filename + ". Initializing empty system.");
            return new ReadingTrackerSystem(); 
        }
        
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        
        try{
            ReadingTrackerSystem system=objectMapper.readValue(file, ReadingTrackerSystem.class);
            System.out.println("Data successfully loaded from: " + filename);
            return system;
        }
        catch(IOException e){
            System.out.println("Error loading file from: "+filename);
            return new ReadingTrackerSystem();
        }
    }
    
    private void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(DATA_FILE), this.system);
            System.out.println("Data successfully saved to: " + DATA_FILE);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving data.");
        }
    }
    
    private void initialize(){
        this.system=loadData(DATA_FILE);
        this.scanner=new Scanner(System.in);
        User appUser=system.getUserByUsername(MY_USERNAME);
        
        
        if(appUser == null){
            System.out.println("Creating a new profile: "+ MY_USERNAME);
            appUser= new User(MY_USERNAME, "my.email@tracker.com");
            system.RegistrationUser(appUser);
        }else{
            System.out.println("Welcome back, " + MY_USERNAME);
        }
        this.currentUser=appUser;
    }
    
    private void addBook(){
        System.out.println("\nADD NEW BOOK:\n");
        System.out.println("Title: ");
        String title=scanner.nextLine();
        System.out.println("Author: ");
        String author=scanner.nextLine();
        System.out.println("Book's ISBN: ");
        String ISBN=scanner.nextLine();
        System.out.println("Publication year: ");
        int publicationYear=0;
        if(scanner.hasNextInt()){
            publicationYear=scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Page count: ");
        int page=0;
        if(scanner.hasNextInt()){
            page=scanner.nextInt();
            scanner.nextLine();
        }
        
        Book newBook= new Book(title, author, publicationYear, ISBN, page);
        system.addBookItem(newBook);
        
    }
    
    public Book searchBook(){
        System.out.println("\nSEARCH BOOK BY TITLE\n");
        System.out.println("Title: ");
        String title=scanner.nextLine();
        system.searchBook(title);
        return null;
    }
    
    private void addReviewToBook(){
        Book selectedBook=searchBook();
        if(selectedBook==null){
            return;
        }
        
        System.out.println("Rating "+ selectedBook.getTitle());
        int rating=0;
        try{
            System.out.println("Enter a rating between 1-5:");
            if(rating < 1 || rating > 5){
                System.out.println("Invalid rating!");
                return;
            }
        }
        catch(NumberFormatException e){
             System.out.println("Invalid number format for rating");
            }
       System.out.println("Enter your review text: ");
       String review=scanner.nextLine();
    }
    
    private void addStatusToBook(){
        System.out.println("\nADD/UPDATE BOOK STATUS:\n");
        System.out.println("Enter the title of the book which you want to update: ");
        String title=scanner.nextLine().trim();
        
        System.out.println("\nSELECT A NEW STATUS:\n");
        System.out.println("1.READ");
        System.out.println("2.IN PROGRESS");
        System.out.println("3.WISHLIST");
        System.out.println("Choose an option between 1 and 3: ");
        
        String statusInput=scanner.nextLine();
        String statusString;
        
        switch(statusInput){
            case "1":{
                statusString="READ";
                break;
            }
            case "2":{
                statusString="IN PROGRESS";
                break;
            }
            case "3":{
                statusString="WISHLIST";
                break;
            }
            default:
                System.out.println("Invalid status option.Choose another one");
                return;
        }
    }
    
    private void CloseProgram(){
        System.out.println("\nSAVE THE DATA\n");
        saveData();
        scanner.close();
        System.exit(0);
    }
    
    private void StartMainMenu(){
        
         boolean running=true;
        while(running){
            System.out.println("\n---------------------------------");
            System.out.println("READING TRACKER - MAIN MENU");
            System.out.println("------------------------------------");
            System.out.println("0.Exit and close the program.");
            System.out.println("1.Add books to the catalog: ");
            System.out.println("2.Add review to the books: ");
            System.out.println("3.View my reading list: ");
            System.out.println("4.Search book in the catalog: ");
            System.out.println("5.Add status to the books by user: ");
            System.out.println("Choose an option: ");
            
            if(scanner.hasNextLine()){
                String input= scanner.nextLine();
                try{
                    int choice=Integer.parseInt(input);
                    switch(choice){
                    case 0:{
                        CloseProgram();
                        running=false;
                        break;
                    }
                    case 1:{
                        addBook();
                        break;
                    }
                    case 2:{
                       addReviewToBook();
                       break;
                    }
                    case 3:{
                        if(currentUser != null){
                            system.ListReadingItem(currentUser);
                        }
                        else{
                            System.out.println("User not found.");
                        }
                        break;
                    }
                    case 4:{
                        searchBook();
                        break;
                    }
                    case 5:{
                        addStatusToBook();
                        break;
                    }
                    default:{
                        System.out.println("Invalid option.Choose another one.");
                        break;
                    }
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid option!Please enter a new one.");
            }
        }
        else{
          running=false;
        }
    }
}

    public static void main(String[] args) {
        
      BookTrackerApp app=new BookTrackerApp();
      
      app.initialize();
      app.StartMainMenu();
       
    }
}
