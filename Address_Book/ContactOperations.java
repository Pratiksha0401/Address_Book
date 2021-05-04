package Address_Book;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactOperations {
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
			  }  
	}
	
	 public static void countByCity(List<Contact> contact) {
   		 
		    System.out.println("Enter the name of the city:");
		    String city=s.next();
		    Long countNamesByCity= contact.stream().filter(e -> city.equals(e.getcity())).count();
		    System.out.println(city+" : "+countNamesByCity);	 
		 
  }
	 
	 public static void countByState(List<Contact> contact) {
   		 
		    System.out.println("Enter the name of the State:");
		    String state=s.next();
            Long countNamesByState=contact.stream().filter(e -> state.equals(e.getstate())).count();
		    System.out.println(state+" : "+countNamesByState); 
  }


	 public static void sortedContactByFirstName(List<Contact> contact) {
			
			List<Contact> sortedContact=contact.stream().sorted(new compareFirstName()).collect(Collectors.toList());
			System.out.println(sortedContact);
		}


		public static void sortedContactByCity(List<Contact> contact) {
			contact.stream().sorted(new compareCity()).forEach(System.out::println);
			
		}
		
		public static void sortedContactByState(List<Contact> contact) {
			contact.stream().sorted(new compareState()).forEach(System.out::println);
			
		}
		
		public static void sortedContactByZip(List<Contact> contact) {
			contact.stream().sorted(new compareZip()).forEach(System.out::println);
			
		}
}

class compareFirstName implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {	
		return o1.getfirstName().compareTo(o2.getfirstName());
	}

}
 
 class compareCity implements Comparator<Contact> {

		@Override
		public int compare(Contact o1, Contact o2) {	
			return o1.getcity().compareTo(o2.getcity());
		}

	}
 
 class compareState implements Comparator<Contact> {

		@Override
		public int compare(Contact o1, Contact o2) {	
			return o1.getstate().compareTo(o2.getstate());
		}

	}
 
 class compareZip implements Comparator<Contact> {

		@Override
		public int compare(Contact o1, Contact o2) {	
			return o1.getzip().compareTo(o2.getzip());
		}

	}
