package ContactPackage;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
    private Map<String, Contact> contacts = new HashMap<>();

    //add a contact with unique ID
    public void addContact(Contact contact) {
    	
        if (contact == null) {
        	
            throw new IllegalArgumentException("Contact cannot be null...");
        }
        if (contacts.containsKey(contact.getContactId())) {
        	
            throw new IllegalArgumentException("Contact ID already exists...");
        }
        
        contacts.put(contact.getContactId(), contact);
    }

    //update first name
    public void updateFirstName(String contactId, String firstName) {
    	
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    //update last name
    public void updateLastName(String contactId, String lastName) {
    	
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    //update phone number
    public void updatePhone(String contactId, String phone) {
    	
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    //update address
    public void updateAddress(String contactId, String address) {
    	
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    //get contact or throw if not found
    private Contact getContact(String contactId) {
    	
        if (contactId == null || !contacts.containsKey(contactId)) {
        	
            throw new IllegalArgumentException("Contact ID does not exist...");
        }
        
        return contacts.get(contactId);
    }
    
    //delete a contact by ID
    public void deleteContact(String contactId) {
    	
        if (contactId == null || !contacts.containsKey(contactId)) {
        	
            throw new IllegalArgumentException("Contact ID does not exist...");
        }
        
        contacts.remove(contactId);
    }
}
