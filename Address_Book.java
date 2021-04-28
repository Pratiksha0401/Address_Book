import java.util.*;
import java.util.regex.*;

class Contact {
   private  String firstName;
   private  String lastName;
   private  String city;
   private  String state;
   private  String zip;
   private  String phoneNumber;
   private  String email;

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
    
    Pattern p;
	Matcher m;
	

	public boolean isValidFirstName(){
		String regex1="^[A-Z]{1}[a-z]+";
		p = Pattern.compile(regex1);
		 m= p.matcher(getfirstName());
		return m.matches();
	}
	
	public boolean isValidLastName() {
        String regex="^[A-Z]{1}[A-Z a-z]{2,}$";
        Pattern Q=Pattern.compile(regex);
        Matcher n=Q.matcher(getlastName());
        return n.matches();
    }
	
	public boolean isValidCity() {
        String regex="^[A-Z]{1}[A-Z a-z]{2,}$";
        Pattern Q=Pattern.compile(regex);
        Matcher n=Q.matcher(getcity());
        return n.matches();
    }
	
	public boolean isValidState() {
        String regex="^[A-Z]{1}[A-Z a-z]{2,}$";
        Pattern Q=Pattern.compile(regex);
        Matcher n=Q.matcher(getstate());
        return n.matches();
    }
	
	public boolean isValidZIP() {
        String regex="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
        Pattern Q=Pattern.compile(regex);
        Matcher n=Q.matcher(getzip());
        return n.matches();
    }
	
	public boolean isValidPhoneNumber() {
        String regex="^[1-9]{2}\\s{0,1}[1-9]{1}[0-9]{9}$";
        Pattern Q=Pattern.compile(regex);
        Matcher n=Q.matcher(getphoneNumber());
        return n.matches();
    }
	
	public boolean isValidEmailId() {
        String regex="^[A-Z a-z 0-9]+([._+-][0-9 a-z A-Z]+)*@[0-9 a-z A-Z]+.[a-z A-Z]{2,3}([.][a-z A-Z]{2})*$";
        Pattern Q=Pattern.compile(regex);
        Matcher n=Q.matcher(getemail());
        return n.matches();
    }
}


public class Address_Book {
	static String f_name;
	static ArrayList<Contact> list=new ArrayList<Contact>();
	static Scanner s=new Scanner(System.in);
	
	//Add Contact
	public void Add_Contact(Contact c) {
		
	   Scanner s=new Scanner(System.in);
	   System.out.print("Add Contact  \n");
	   while(true){
		      System.out.println("Enter First Name");
		      c.setfirstName(s.nextLine());
		      if((c.isValidFirstName())==true)
		        break;
		      else
		        System.out.println("Invalid...1st letter must be Capital");
			  }
	   while(true) {
		   	System.out.print("Enter Last Name : ");
		   	c.setlastName(s.nextLine());
		   	if((c.isValidLastName())==true)
		        break;
		      else
		        System.out.println("Invalid...1st letter must be Capital");
			  }
	   while(true) {
		   	System.out.print("Enter City : ");
		   	c.setcity(s.nextLine());
		   	if((c.isValidCity())==true)
		        break;
		      else
		        System.out.println("Invalid...1st letter must be Capital");
			  }
	   while(true) {
		   	System.out.print("Enter State : ");
		   	c.setstate(s.nextLine());
		   	if((c.isValidState())==true)
		        break;
		      else
		        System.out.println("Invalid...1st letter must be Capital");
			  }
	   while(true) {
		   	System.out.print("Enter zip : ");
		   	c.setzip(s.nextLine());
		   	if((c.isValidZIP())==true)
		        break;
		      else
		        System.out.println("Invalid...must be 6 digits");
			  }
	   while(true) {
		   	System.out.print("Enter PhoneNumber: ");
		   	c.setphoneNumber(s.nextLine());
		   	if((c.isValidPhoneNumber())==true)
		        break;
		      else
		        System.out.println("Invalid...must be 2 digit country code followed by 10 digit number");
			  }
	   while(true) {
		   	System.out.print("Enter Email ID : ");
		   	c.setemail(s.nextLine());
		   	if((c.isValidEmailId())==true)
		        break;
		      else
		        System.out.println("Invalid...enter valid email Id");
			  }
		list.add(c);
	 }
	
	//Display All Contact
	 public void Display_All(){
		boolean is_Empty=list.isEmpty();
		if(is_Empty==true)
			System.out.println("Array List is Empty");
		else
			System.out.println(list);
	}

	public void editContact( String f_name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getfirstName().equalsIgnoreCase(f_name)) {
				Contact contact=list.get(i);
				
				while(true){
				      System.out.println("Enter New First Name");
				      contact.setfirstName(s.next());
				      if((contact.isValidFirstName())==true)
				        break;
				      else
				        System.out.println("Invalid...1st letter must be Capital");
					  }
			   while(true) {
				   	System.out.print("Enter New Last Name : ");
				   	contact.setlastName(s.next());
				   	if((contact.isValidLastName())==true)
				        break;
				      else
				        System.out.println("Invalid...1st letter must be Capital");
					  }
			   while(true) {
				   	System.out.print("Enter New City : ");
				   	contact.setcity(s.next());
				   	if((contact.isValidCity())==true)
				        break;
				      else
				        System.out.println("Invalid...1st letter must be Capital");
					  }
			   while(true) {
				   	System.out.print("Enter New State : ");
				   	contact.setstate(s.next());
				   	if((contact.isValidState())==true)
				        break;
				      else
				        System.out.println("Invalid...1st letter must be Capital");
					  }
			   while(true) {
				   	System.out.print("Enter New zip : ");
				   	contact.setzip(s.next());
				   	if((contact.isValidZIP())==true)
				        break;
				      else
				        System.out.println("Invalid...must be 6 digits");
					  }
			   while(true) {
				   	System.out.print("Enter New PhoneNumber: ");
				   	contact.setphoneNumber(s.next());
				   	if((contact.isValidPhoneNumber())==true)
				        break;
				      else
				        System.out.println("Invalid...must be 2 digit country code followed by 10 digit number");
					  }
			   while(true) {
				   	System.out.print("Enter New Email ID : ");
				   	contact.setemail(s.next());
				   	if((contact.isValidEmailId())==true)
				        break;
				      else
				        System.out.println("Invalid...enter valid email Id");
					  }
				
			 list.set(i,contact);
			 System.out.println(list);
			 }
			else
			System.out.println("Not Found");
			}
	 }

	 public void deleteContact(Contact c,String f_name){
		for(int i = 0; i < list.size(); i++){
		c = (Contact)list.get(i);
			if(f_name.equals(c.getfirstName())){
				list.remove(i);
				}
			}
		}

 public static void main(String[] args) {
	
	Address_Book book=new Address_Book();
	Contact c;
	
	int option;
	do
	{
		System.out.println("Enter your option : ");
		System.out.println("1.Add contact  ");
		System.out.println("2.Display all contact ");
		System.out.println("3.Edit Contact ");
		System.out.println("3.Delete Contact ");
		
		option=s.nextInt();
		c=new Contact();
		Scanner sc=new Scanner(System.in);

		switch (option)
		{
		case 1:
			book.Add_Contact(c);
			break;
		case 2:
			book.Display_All();
			break;
		case 3:
			System.out.println("Enter first name that you want to edit:");
			f_name=sc.nextLine();
			book.editContact(f_name);
			break;
		case 4:
			System.out.println("Enter first name that you want to edit:");
			f_name=sc.nextLine();
			book.deleteContact(c,f_name);
			break;
		default:
			System.out.println("Enter valid option");
			break;
		}
		System.out.println("Do you want to continue (1.Continue or 0.Exit)");
		option=s.nextInt();
	}
	while (option!=0);
 }
}