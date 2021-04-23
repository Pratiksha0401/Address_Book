class Book 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}


class Contact {
   private String firstName;
   private String lastName;
   private String city;
   private String state;
   private int zip;
   private int phoneNumber;
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
    
    public void setzip(int zip) {
        this.zip = zip;
    }
    public int getzip() {
        return zip;
    }
    
    public void setphoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getphoneNumber() {
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