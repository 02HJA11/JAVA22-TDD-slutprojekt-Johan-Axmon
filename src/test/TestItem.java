package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;

class TestItem {

	 @Test
	    @DisplayName("Item ID Should Be Lowercase")
	    void testItemIdLowercase() {
	        String testId = "TestID";
	        Item item = new Item(testId);
	        assertEquals(testId.toLowerCase(), item.getId(),
	                "Item ID should be converted to lowercase");
	    }

	    @Test
	    @DisplayName("Item toString Method Returns Correct ID")
	    void testItemToString() {
	        String testId = "TestString";
	        Item item = new Item(testId);
	        assertEquals(testId.toLowerCase(), item.toString(),
	                "Item's toString method should return the correct ID");
	    }

	    @Test
	    @DisplayName("Set ID Should Update Item ID Properly")
	    void testSetIdUpdatesId() {
	        String initialId = "InitialID";
	        String newId = "NewID";
	        Item item = new Item(initialId);
	        item.setId(newId);
	        assertEquals(newId.toLowerCase(), item.getId(),
	                "setItem should update the item ID properly");
	    }

	    @Test
	    @DisplayName("Empty ID Should Be Handled Correctly")
	    void testEmptyId() {
	        Item item = new Item("");
	        assertEquals("", item.getId(),
	                "Item with an empty ID should be handled correctly");
	    }

	    @Test
	    @DisplayName("Item ID Handling Null Value")
	    void testNullId() {
	        assertThrows(NullPointerException.class, () -> new Item(null),
	                "Constructor should throw NullPointerException for null ID");
	    }

}
