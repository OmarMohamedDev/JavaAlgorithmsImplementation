package mohamed.priorityqueue;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* PriorityQueueStringDoubleHeap Tester. 
* 
* @author Omar Mohamed
*/ 
public class PriorityQueueStringDoubleHeapTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Test of isEmpty method, of class PriorityQueueStringDoubleHeap.
     */
    @Test
    public void testisEmptyNullParameters() {
        try {
            PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(null, null);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    @Test
    public void testisEmptyNotEmpty() {
        String[] elem = {"first"};
        double[] prior = {0.0};

        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertFalse(h.isEmpty());
    }

    /**
     * Test of Add method, of class PriorityQueueStringDoubleHeap.
     */
    @Test
    public void testAddOneElementOneSpot() {
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(1);
        String elem = "first";
        double prior = 0.0;
        try {
            h.add(elem, prior);
            assertTrue(true);
        } catch (IllegalArgumentException e) {
            assertTrue(false);
        }

    }

    @Test
    public void testAddTwoElementsOneSpot() {
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(1);
        String elem = "second";
        double prior = 1.0;

        try {
            h.add(elem, prior);
            elem = "first";
            prior = 0.0;
            h.add(elem, prior);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    @Test
    public void testAddTwoElementsTwoSpots() {
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(2);
        String elem = "second";
        double prior = 1.0;

        try {
            h.add(elem, prior);
            elem = "first";
            prior = 0.0;
            h.add(elem, prior);
            assertEquals("first", h.first());
        } catch (IllegalArgumentException e) {
            assertTrue(false);
        }
    }

    /**
     * Test of first method, of class PriorityQueueStringDoubleHeap.
     */
    @Test
    public void testFirstOneElement() {
        String[] elem = {"first"};
        double[] prior = {0.0};
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertEquals("first", h.first());
    }

    @Test
    public void testFirstTwoElements() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertEquals("first", h.first());
    }

    /**
     * Test of removeFirst method, of class PriorityQueueStringDoubleHeap.
     */
    @Test
    public void testRemoveFirstTwoElementsOneTime() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertEquals("first", h.removeFirst());
    }

    @Test
    public void testRemoveFirstTwoElementsTwice() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertEquals("first", h.removeFirst());
        assertEquals("second", h.removeFirst());
    }

    @Test
    public void testRemoveFirstTwoElementsThreeTimes() {
        String[] elem = {"second", "first"};
        double[] prior = {1.0, 0.0};
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertEquals("first", h.removeFirst());
        assertEquals("second", h.removeFirst());
        try {
            h.removeFirst();
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }

    @Test
    public void testRemoveFirstThreeElementsThreeTimes() {
        String[] elem = {"second", "third", "first"};
        double[] prior = {1.0, 1.5, 0.0};
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertEquals("first", h.removeFirst());
        assertEquals("second", h.removeFirst());
        assertEquals("third", h.removeFirst());
    }

    /**
     * Test of setPriority method, of class PriorityQueueStringDoubleHeap.
     */
    @Test
    public void testSetPriority() {
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(3);
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
        PriorityQueueStringDoubleHeap h = new PriorityQueueStringDoubleHeap(elem, prior);
        assertEquals("first", h.first());
        h.setPriority("third", 0);
        assertEquals("third", h.first());

    }

    /**
     * Test of delete method, of class PriorityQueueStringDoubleHeap.
     */
    @Test
    public void testDeleteEmptyQueue() {


    }

    @Test
    public void testDeleteNotEmptyQueue() {


    }


} 
