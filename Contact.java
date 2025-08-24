package ContactPackage;

public class Contact {
	
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
    	
        //validate contact Id
        if (contactId == null || contactId.length() > 10) {
        	
            throw new IllegalArgumentException("Contact ID cannot be null or longer than ten characters");
        }
        
        this.contactId = contactId;

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    //accessors
    public String getContactId() {
    	
        return contactId;
    }

    public String getFirstName() {
    	
        return firstName;
    }
    
    public String getLastName() {
    	
        return lastName;
    }

    public String getPhone() {
    	
        return phone;
    }
    
    public String getAddress() {
    	
        return address;
    }


    //mutators
    public void setFirstName(String firstName) {
    	
        if (firstName == null || firstName.length() > 10) {
        	
            throw new IllegalArgumentException("First name cannot be null or longer than ten characters");
        }
        
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
    	
        if (lastName == null || lastName.length() > 10) {
        	
            throw new IllegalArgumentException("Last name cannot be null or longer than ten characters");
        }
        
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
    	
        if (phone == null || !phone.matches("\\d{10}")) {
        	
            throw new IllegalArgumentException("Phone number must be exactly ten digits");
        }
        
        this.phone = phone;
    }

    public void setAddress(String address) {
    	
        if (address == null || address.length() > 30) {
        	
            throw new IllegalArgumentException("Address cannot be null or longer than 30 characters");
        }
        
        this.address = address;
    }
}
