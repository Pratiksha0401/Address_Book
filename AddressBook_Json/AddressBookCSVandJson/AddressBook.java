package csvandJson.AddressBookCSVandJson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.opencsv.CSVReader;

public class AddressBook 
{
	private static Scanner s = new Scanner(System.in);
	private static File file = new File("D:\\Pratiksha\\Java_programs\\AddressBookCSVandJson\\Data\\Contact.json");
	static List<Contact> contact = new ArrayList<>();
	 
	 public static void main(String[] args) throws IOException, ParseException {
	       
	        showMainMenu();
	    }
	 
	 public static void addContact() throws IOException, ParseException {							
			System.out.println("Enter Firstname: ");
	        String firstname = s.nextLine();
	        System.out.println("Enter Lastname: ");
	        String lastname = s.nextLine();
	        System.out.println("Enter City: ");
	        String city = s.nextLine();
	        System.out.println("Enter State: ");
	        String state = s.nextLine();
	        System.out.println("Enter ZipCode: ");
	        String zip = s.nextLine();
	        System.out.println("Enter Phone number: ");
	        String phoneNumber = s.nextLine();
	        System.out.println("Enter EmailId: ");
	        String email = s.nextLine();
		
	        Contact contact1=new Contact(firstname, lastname, city, state, zip, phoneNumber, email);
	        addToFile(contact1);
	        contact.add(contact1);
	        System.out.println("Added contact: "  + contact1);
	        System.out.println();
	        showMainMenu();
	    }
	 
	 private static void readPeopleFromFile() throws IOException {
		 try {
	 	        // Create an object of filereader class with CSV file as a parameter.
	 	        FileReader filereader = new FileReader(file);
	 	  
	 	        // create csvReader object passing file reader as a parameter
	 	        CSVReader csvReader = new CSVReader(filereader);
	 	        String[] nextRecord;
	 	  
	 	        // we are going to read data line by line
	 	        while ((nextRecord = csvReader.readNext()) != null) {
	 	            for (String cell : nextRecord) {
	 	                System.out.print(cell + "\t");
	 	            }
	 	            System.out.println();
	 	        }
	 	    }
	 	    catch (Exception e) {
	 	        e.printStackTrace();
	 	    }    	 
	 	}
		
			
	 private static void addToFile(Contact contact) {
	        try(Writer writer = new BufferedWriter(new FileWriter(file, true))) {        
	        	Gson gson=new Gson();
	        	String json=gson.toJson(contact);
	        	writer.write(json+"\n");
	        	writer.close();
	        } catch(IOException e) {
	            System.out.println(e);
	        }
	    }
	 
	 private static void showMainMenu() throws IOException, ParseException {
	        System.out.println("1. Add person");
	        System.out.println("2. Read Contacts from Addressbook");
	        System.out.println("0. Close program");
	        //using switch statement to select choice
	        String choice;
	        do {
	            choice = s.nextLine();
	            switch (choice) {
	                case "1":
	                    addContact();
	                    break;
	             
	                case "2":
	                	readPeopleFromFile();
	                    showMainMenu();
	                    break;
	                case "0":
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Enter numer from 0 to 2");
	            }
	        }while(!choice.equals("0"));
	    }

}
