package mohamed.priorityqueue;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* PriorityQueueStringDoubleSimple Tester. 
* 
* @author Omar Mohamed
*/ 
public class PriorityQueueStringDoubleSimpleTest { 

    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    }
    
    /**
     * Test of isEmpty method, of class PriorityQueueStringDoubleSimple.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testisEmptyNullParameters() {
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(null, null);
    }
    
    @Test
    public void testisEmptyNotEmpty() {
        String[] elem = {"first"};
        double[] prior = {0.0};
    
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertFalse(h.isEmpty());
    }
    
    /**
     * Test of Add method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testAddOneElementOneSpot() {
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(1);
        String elem = "first";
        double prior = 0.0;
        h.add(elem, prior);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddTwoElementsOneSpot() {
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(1);
        String elem = "second";
        double prior = 1.0;
        h.add(elem, prior);
        elem = "first";
        prior = 0.0;
        h.add(elem, prior);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddTwoElementsTwoSpots() {
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(2);
        String elem = "second";
        double prior = 1.0;
        h.add(elem, prior);
        elem = "first";
        prior = 0.0;
        h.add(elem, prior);
        assertEquals("first", h.first());
    }
    
    /**
     * Test of first method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testFirstOneElement() {
        String[] elem = {"first"};
        double[] prior = {0.0};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertEquals("first", h.first());
    }
    
    @Test
    public void testFirstTwoElements() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertEquals("first", h.first());
    }
    
    /**
     * Test of removeFirst method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testRemoveFirstTwoElementsOneTime() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertEquals("first", h.removeFirst());
    }
    
    @Test
    public void testRemoveFirstTwoElementsTwice() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertEquals("first", h.removeFirst());
        assertEquals("second", h.removeFirst());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFirstTwoElementsThreeTimes() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertEquals("first", h.removeFirst());
        assertEquals("second", h.removeFirst());
        h.removeFirst();
    }
    
    @Test
    public void testRemoveFirstThreeElementsThreeTimes() {
        String[] elem = {"second", "third", "first"};
        double[] prior = {1.0, 1.5, 0.0};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertEquals("first", h.removeFirst());
        assertEquals("second", h.removeFirst());
        assertEquals("third", h.removeFirst());
    }
    
    /**
     * Test of setPriority method, of class PriorityQueueStringDoubleSimple.
     */
    @Test
    public void testSetPriority() {
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(3);
        h.add("third", 3);
        h.add("second", 2);
        h.add("first", 1);
        assertEquals("first", h.first());
        h.setPriority("third", 0);
        assertEquals("third", h.first());
    
    }
    
    @Test
    public void testSetPriorityOtherConstructor() {
        String[] elem = {"second", "third", "first"};
        double[] prior = {2, 3, 1};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertEquals("first", h.first());
        h.setPriority("third", 0);
        assertEquals("third", h.first());
    
    }

    /**
     * Test of delete method, of class PriorityQueueStringDoubleSimple.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteEmptyQueue() {
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(1);
        h.delete("first");
    }

    @Test
    public void testDeleteNotEmptyQueue() {
        String[] elem = {"second", "third", "first"};
        double[] prior = {2, 3, 1};
        PriorityQueueStringDoubleSimple h = new PriorityQueueStringDoubleSimple(elem, prior);
        assertTrue(h.delete("third"));
    }

} 
