import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Contact {
   private String firstName;
   private String lastName;
   private String city;
   private String state;
   private String zip;
   private String phoneNumber;
   private String email;
   private List<Contact> contact;

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getfirstName() {
        return firstName;
    }
    
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    public String getlastName() {
        return lastName;
    }
    
    public void setcity(String city) {
        this.city = city;
    }
    public String getcity() {
        return city;
    }

    public void setstate(String state) {
        this.state = state;
    }
    public String getstate() {
        return state;
    }
    
    public void setzip(String zip) {
        this.zip = zip;
    }
    public String getzip() {
        return zip;
    }
    
    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getphoneNumber() {
        return phoneNumber;
    }
    
    public void setemail(String email) {
        this.email = email;
    }
    public String getemail() {
        return email;
    }

    @Override
    public String toString() {
        return '\n'+"Contact is"+'\n'+ "First Name: " + firstName +'\n'+ "Last  Name: " + lastName +'\n'+ "City : " + city +'\n'+ "State : " + state
                + "zip : " + zip +'\n'+"Phone Number : " + phoneNumber +'\n'+ "Email Id: " + email +'\n';
    }
    
    @Override
	public boolean equals(Object obj) {
    	boolean retVal = false;
		if(!(obj instanceof Contact)){
			return false;
		}
		Contact ptr= (Contact) obj;
		retVal=ptr.firstName.toString()==this.firstName;
		return retVal;
	}
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        return hash;
    }
    
}

class ContactOperations{
	
	static Scanner s=new Scanner(System.in);
	
	public static void Add_Contact(List<Contact> contact) {
				Contact c=new Contact();
				System.out.print("Add Contact  \n");
				System.out.print("Enter First Name: ");
				c.setfirstName(s.next());
				System.out.print("Enter Last Name : ");
				c.setlastName(s.next());
				System.out.print("Enter City : ");
				c.setcity(s.next());
				System.out.print("Enter State : ");
				c.setstate(s.next());
				System.out.print("Enter zip : ");
				c.setzip(s.next());
				System.out.print("Enter PhoneNumber: ");
				c.setphoneNumber(s.next());
				System.out.print("Enter Email ID : ");
				c.setemail(s.next());
				contact.add(c);
		}
		

		 public static void Display_All(List<Contact> contact){
			boolean is_Empty=contact.isEmpty();
			if(is_Empty==true)
				System.out.println("Array List is Empty");
			else
				System.out.println(contact);
		}

		public static void editContact(List<Contact> contact ) {
			System.out.println("Enter first name that you want to Edit:");
			String firstName = s.next();
			
			for (int i = 0; i < contact.size(); i++) {
				if (contact.get(i).getfirstName().equalsIgnoreCase(firstName)) {
					Contact c = contact.get(i);
					System.out.print("Enter new First Name: ");
					c.setfirstName(s.next());
					System.out.print("Enter  new Last Name : ");
					c.setlastName(s.next());
					System.out.print("Enter new City : ");
					c.setcity(s.next());
					System.out.print("Enter new State : ");
					c.setstate(s.next());
					System.out.print("Enter new zip : ");
					c.setzip(s.next());
					System.out.print("Enter new PhoneNumber: ");
					c.setphoneNumber(s.next());
					System.out.print("Enter new Email ID : ");
					c.setemail(s.next());
				contact.set(i,c);
				System.out.println("Edited Successfully!");
				}	
				else if(firstName!=(contact.get(i).getfirstName())){
					System.out.println("Not Found!");
				}
			}
		 }

		 public static void deleteContact(List<Contact> contact){
			System.out.println("Enter first name that you want to Delete:");
			String firstName = s.next();
			 for (int i = 0; i < contact.size(); i++) {
				  if (contact.get(i).getfirstName().equalsIgnoreCase(firstName)) {
					 contact.remove(i);
					 System.out.println("Deleted Successfully !");
				  	 break;
				 }  
				  else if(firstName!=(contact.get(i).getfirstName())){
						System.out.println("Not Found!");
					}
			  }  
			}
}

class Address_Book_Operations {
	
	static String f_name;
	static Scanner s=new Scanner(System.in);
	
	public static void addAddressBook(Hashtable<String, List<Contact>> addressBooks) {
		 System.out.println("Add new AddressBook");
		 String bookName = s.next();
		 addressBooks.put(bookName, new ArrayList<Contact>());
	}
	
	public static void displayAllAddressBook(Hashtable<String, List<Contact>> addressBooks) {
		boolean is_Empty=addressBooks.isEmpty();
		if(is_Empty==true)
			System.out.println("No Address Books are Present");
		else
			System.out.println(addressBooks);
	}
	
	public static void editAddressBook(Hashtable<String, List<Contact>> addressBooks) {
	    System.out.println("Enter the name of the AddressBook you want to Edit");
	    String bookName1 = s.next();
	        
	    if(addressBooks.containsKey(bookName1)) {
		    List<Contact> contact = addressBooks.get(bookName1);
		    int choice;
		    do{
		    	System.out.println("Enter your option : ");
				System.out.println("1.Add contact  ");
				System.out.println("2.Display all contact ");
				System.out.println("3.Edit Contact ");
				System.out.println("4.Delete Contact ");
		
				choice=s.nextInt();
			    switch (choice)
				{
					case 1:
						ContactOperations.Add_Contact(contact);
						break;
					case 2:			
						ContactOperations.Display_All(contact);
						break;	
					case 3:			
						ContactOperations.editContact(contact);
						break;
					case 4:
						ContactOperations.deleteContact(contact);
						break;
					default:
						System.out.println("Enter valid option");
						break;	
				 }
			    System.out.println("Do you want to continue (1.Continue or 0.Exit)");
				choice=s.nextInt();
		       }while(choice != 0);
		     }
		           else 
		        	   System.out.println("Invalid AddressBook Name!Not exist");
		    }
}

public class Address_Book {

	static Scanner s=new Scanner(System.in);
	
	public static void main(String[] args) {
		
			int option;
			Hashtable<String, List<Contact>> addressBooks = new Hashtable<String, List<Contact>>(); 
			do {
			System.out.println("Enter 1 to Add AddressBook\nEnter 2 to Edit AddressBook\nEnter 3 to see All Address Books\n"
					+"Enter 0 to Exit");
			option=s.nextInt();
			switch(option) {
			   case 1:
			 		Address_Book_Operations.addAddressBook(addressBooks);
			    	break;
			   case 2:
			    	Address_Book_Operations.editAddressBook(addressBooks); 
			        break;
			   case 3:
			    	Address_Book_Operations.displayAllAddressBook(addressBooks); 
			        break;
			   default:
				    System.exit(0);
				    break;
		    	}
			}while(option != 0); 	    
	}
		     
}
		 

	
	
	