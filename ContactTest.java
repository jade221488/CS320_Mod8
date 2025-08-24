package ContactPackage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test 
    //test contact creation
    public void testValidContactCreation() {
    	
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");
        
        assertEquals("1", contact.getContactId());
        assertEquals("Jake", contact.getFirstName());
        assertEquals("Harper", contact.getLastName());
        assertEquals("6032043030", contact.getPhone());
        assertEquals("35 Mammoth St", contact.getAddress());
    }

    @Test
    //missing contact id test
    public void testInvalidContactId() {
    	
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jake", "Harper", "6032043030", "35 Mammoth St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("60340030300", "Jake", "Harper", "6032043030", "35 Mammoth St");
        });
    }

    @Test
    //first name out of bounds test
    public void testInvalidFirstName() { 
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Harper", "6032043030", "35 Mammoth St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Banananananana", "Harper", "6032043030", "35 Mammoth St");
        });
    }

    @Test
    //last name out of bounds test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Jake", null, "6032043030", "35 Mammoth St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Jake", "Banananananana", "6032043030", "35 Mammoth St");
        });
    }

    @Test
    //phone number invalid test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Jake", "Harper", null, "35 Mammoth St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Jake", "Harper", "12345", "35 Mammoth St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Jake", "Harper", "abcdefghij", "35 Mammoth St");
        });
    }

    @Test
    //address out of bounds test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Jake", "Harper", "6032043030", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Jake", "Harper", "6032043030", "43567 Mammoth Circle Snow Berry Hollow Road");
        });
    }

    @Test
    public void testSettersValidation() {
        Contact contact = new Contact("1", "Jake", "Harper", "6032043030", "35 Mammoth St");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Doe");
        assertEquals("Doe", contact.getLastName());

        contact.setPhone("9876544567");
        assertEquals("9876544567", contact.getPhone());

        contact.setAddress("12 Flower St");
        assertEquals("12 Flower St", contact.getAddress());
    }
}
