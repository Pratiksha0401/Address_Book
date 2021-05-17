package addressBook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class AddressBook {
	private static Scanner s = new Scanner(System.in);
	private static File file = new File("Contact.csv");
	static List<Contact> contact = new ArrayList<>();
	 
	 public static void main(String[] args) throws IOException {
	       
	        showMainMenu();
	    }
	 
	 public static void addContact() throws IOException {							
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
	 
	 private static void addToFile(Contact contact) {
	        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
	        	writer.write(contact.toString());
	        	CSVWriter csvWriter=new CSVWriter(writer);
	        	csvWriter.writeAll(contact);
	        } catch(IOException e) {
	            System.out.println(e);
	        }
	    }
	 
	 private static void readPeopleFromFile(String file) throws IOException {
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
	 private static void showMainMenu() throws IOException {
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
	                	readPeopleFromFile("D:\\Pratiksha\\Java_programs\\Day_28\\Annotation\\src\\main\\java\\addressBook\\Contact.csv");
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
