package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import test.mockedObjects.MockBuffer;
import test.mockedObjects.MockConsumer;
import test.mockedObjects.MockItem;
import test.mockedObjects.MockProducer;

class TestBuffer {

	@Test
    @DisplayName("Buffer Should Not Be Empty After Enqueue")
    void confirmBufferNonEmptyAfterEnqueue() {
        MockBuffer testBuffer = new MockBuffer();
        MockProducer testProducer = new MockProducer(testBuffer);
        MockConsumer testConsumer = new MockConsumer(testBuffer);
        MockItem testItem = new MockItem("companion");
        testProducer.additem(testItem);
        assertEquals(testItem, testConsumer.removeItem());
    }
    
    @Test
    @DisplayName("Buffer Should Be Empty After Dequeue Operation")
    void assertBufferEmptyAfterDequeue() {
        MockBuffer testBuffer = new MockBuffer();
        MockProducer testProducer = new MockProducer(testBuffer);
        MockConsumer testConsumer = new MockConsumer(testBuffer);
        MockItem testItem = new MockItem("companion");
        testProducer.additem(testItem);
        testConsumer.removeItem();
        assertTrue(testBuffer.isCurrentlyEmpty());
    }
    
    @Test
    @DisplayName("Output Verification Upon Item Enqueue")
    void checkOutputWhenItemEnqueued() {
        ByteArrayOutputStream outputCapture = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputCapture));
        
        MockBuffer testBuffer = new MockBuffer();
        MockProducer testProducer = new MockProducer(testBuffer);
        testProducer.additem(new MockItem("gladiator"));
        
        assertTrue(outputCapture.toString().contains("[gladiator]"));
        System.setOut(originalOut);
    }
    
    @Test
    @DisplayName("Enqueue Operation Return Value Confirmation")
    void validateEnqueueReturnValue() {
        MockBuffer testBuffer = new MockBuffer();
        MockProducer testProducer = new MockProducer(testBuffer);
        MockItem testItem = new MockItem("companion");
        assertTrue(testProducer.additem(testItem));
    }

    
    
    @Test
    @DisplayName("isEmpty Should Report True With No Items")
    void isEmptyShouldBeTrueWhenBufferIsEmpty() {
        MockBuffer testBuffer = new MockBuffer();
        assertTrue(testBuffer.isCurrentlyEmpty(), "Buffer should report empty when no items are present");
    }
    
    @Test
    @DisplayName("isEmpty Should Report False When Items Exist")
    void isEmptyShouldBeFalseWhenItemsPresent() {
        MockBuffer testBuffer = new MockBuffer();
        testBuffer.add(new Item("test"));  // Assuming an appropriate constructor in Item class
        assertFalse(testBuffer.isCurrentlyEmpty(), "Buffer should report non-empty after item addition");
    }
}
