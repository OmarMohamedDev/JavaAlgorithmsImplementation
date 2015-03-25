package mohamed.binarysearch;

import org.junit.*;

import static org.junit.Assert.*;

public class IntSortedArrayTest {

    private IntSortedArray isr;

    public IntSortedArrayTest() {
    }

    @Before
    public void setUp() {
        isr = new IntSortedArray();
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testEmptyConstructor(){
        isr = new IntSortedArray();
        isr.get(17);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testInitialCapacityConstructor(){
        isr = new IntSortedArray(10);
        isr.get(12);
    }

    @Test
    public void testArrayAsParameterConstructor(){
        isr = new IntSortedArray(new int[]{1,3,5});
        assertEquals(isr.get(1), 3);
    }

    @Test
    public void testBinarySearchInsertElements() {
        int expRes = 0;
        int result = isr.insert(1);
        assertEquals(expRes, result);

        expRes = 1;
        result = isr.insert(5);
        assertEquals(expRes, result);

        expRes = 1;
        result = isr.insert(3);
        assertEquals(expRes, result);

        expRes = 0;
        result = isr.insert(-2);
        assertEquals(expRes, result);

    }

    @Test
    public void testReallocate(){
        isr.reallocate();
        int result = isr.elements.length;
        int expResult = 32;
        assertEquals(result, expResult);
    }

    @Test
    public void testSizeEmptyArray() {
        int expResult = 0;
        int result = isr.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSizeNotEmptyArray() {
        int expResult = 1;
        isr.insert(5);
        int result = isr.size();
        assertEquals(expResult, result);

        expResult = 2;
        isr.insert(6);
        result = isr.size();
        assertEquals(expResult, result);

    }

    @Test
    public void testInsertSomeInsertions() {
        assertEquals(0, isr.insert(1));
        assertEquals(1, isr.insert(5));
        assertEquals(1, isr.insert(3));
    }


    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testGetNull() {
        isr.get(0);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testGetNonNullNotValidIndexes() {
        isr.insert(1);
        isr.insert(5);
        isr.insert(3);

        isr.get(-1);
        isr.get(3);
    }

    @Test
    public void testGetNonNullValidIndexes() {
        isr.insert(1);
        isr.insert(5);
        isr.insert(3);

        int expRes = 1;
        int result = isr.get(0);
        assertEquals(expRes, result);

        expRes = 3;
        result = isr.get(1);
        assertEquals(expRes, result);

        expRes = 5;
        result = isr.get(2);
        assertEquals(expRes, result);

    }

    @Test
    public void testToStringEmptyArray() {
        assertEquals("[]", isr.toString());
    }

    @Test
    public void testToStringNotEmptyArray() {
        isr.insert(3);
        isr.insert(1);
        isr.insert(5);
        isr.insert(3);
        isr.insert(1);
        isr.insert(5);

        assertEquals("[1, 1, 3, 3, 5, 5]", isr.toString());
    }
}