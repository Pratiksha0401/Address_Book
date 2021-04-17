
import java.util.*;

class Contact {
   private String firstName;
   private String lastName;
   private String city;
   private String state;
   private String zip;
   private String phoneNumber;
   private String email;

    
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
        return '\n'+"Contact add is"+'\n'+ "First Name: " + firstName +'\n'+ "Last  Name: " + lastName +'\n'+ "City : " + city +'\n'+ "State : " + state
                + "zip : " + zip +'\n'+"Phone Number : " + phoneNumber +'\n'+ "Email Id: " + email ;
    }

public void Add_Contact(int Person_Number) {

  ArrayList<Contact> list=new ArrayList<Contact>();
   Contact P1=new Contact();

   Scanner s=new Scanner(System.in);
   System.out.print("Enter First Name: ");
    P1.setfirstName(s.nextLine());
   System.out.print("Enter Last Name : ");
    P1.setlastName(s.nextLine());
   System.out.print("Enter City : ");
    P1.setcity(s.nextLine());
   System.out.print("Enter State : ");
    P1.setstate(s.nextLine());
   System.out.print("Enter zip : ");
    P1.setzip(s.nextLine());
   System.out.print("Enter PhoneNumber: ");
    P1.setphoneNumber(s.nextLine());
   System.out.print("Enter Email ID : ");
    P1.setemail(s.nextLine());

   list.add (P1);
   System.out.println(list);
 }
}

public class Address_Book {
 public static void main(String[] args) {
    System.out.println("Give the information for First Contact");
    Contact A1 =new Contact();
    A1.Add_Contact(1);
 }
}