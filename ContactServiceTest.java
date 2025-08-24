package ContactPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setup() {
    	
        service = new ContactService();
    }

    @Test
    //add same contact ID test
    public void testAddContact() {
    	
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");
        service.addContact(contact);
        
        Contact duplicate = new Contact("1", "Maria", "Sanders", "6034007788", "12 Hanover St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    //delete non-existent contact test
    public void testDeleteContact() {
    	
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");
        service.addContact(contact);
        service.deleteContact("1");
        
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1"));
    }

    @Test
    //update non-existent contact test
    public void testUpdateFirstName() {
    	
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");
        service.addContact(contact);
        service.updateFirstName("1", "Jane");
        assertEquals("Jane", contact.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("2", "Someone"));
    }

    @Test
    //update last name test
    public void testUpdateLastName() {
    	
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");
        service.addContact(contact);
        service.updateLastName("1", "Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    //update phone number test
    public void testUpdatePhone() {
    	
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");
        service.addContact(contact);
        service.updatePhone("1", "0987654321");
        assertEquals("0987654321", contact.getPhone());
        
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123"));
    }

    @Test
    //update address test
    public void testUpdateAddress() {
    	
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");
        service.addContact(contact);
        service.updateAddress("1", "456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }
}