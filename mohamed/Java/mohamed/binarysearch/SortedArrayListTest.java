package mohamed.binarysearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortedArrayListTest {

    private SortedArrayList<Integer> sal;

    public SortedArrayListTest() {
    }

    @Before
    public void setUp() {
        sal = new SortedArrayList<Integer>();
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testEmptyConstructor(){
        sal = new SortedArrayList();
        sal.get(17);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testInitialCapacityConstructor(){
        sal = new SortedArrayList(10);
        sal.get(12);
    }

    @Test
    public void testArrayAsParameterConstructor(){
        sal = new SortedArrayList(new Integer[]{1,3,5});
        assertEquals((int)sal.get(1), 3);
    }

    @Test
    public void testBinarySearchInsertElements() {
        Integer expRes = 0;
        Integer result = sal.insert(1);
        assertEquals(expRes, result);

        expRes = 1;
        result = sal.insert(5);
        assertEquals(expRes, result);

        expRes = 1;
        result = sal.insert(3);
        assertEquals(expRes, result);

        expRes = 0;
        result = sal.insert(-2);
        assertEquals(expRes, result);

    }

    @Test
    public void testSizeEmptyArrayList() {
        Integer expResult = 0;
        Integer result = sal.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSizeNotEmptyArrayList() {
        Integer expResult = 1;
        sal.insert(5);
        Integer result = sal.size();
        assertEquals(expResult, result);

        expResult = 2;
        sal.insert(6);
        result = sal.size();
        assertEquals(expResult, result);

    }

    @Test
    public void testIndexOfEmptyArrayList(){
        assertEquals(-1, sal.indexOf(5));
    }

    @Test
    public void testIndexOfContainingElement(){
        sal.insert(1);
        sal.insert(2);
        sal.insert(5);
        assertEquals(2, sal.indexOf(5));
    }

    @Test
    public void testInsertSomeInsertions() {
        assertEquals(0, sal.insert(1));
        assertEquals(1, sal.insert(5));
        assertEquals(1, sal.insert(3));
    }


    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testGetNull() {
        sal.get(0);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testGetNonNullNotValidIndexes() {
        sal.insert(1);
        sal.insert(5);
        sal.insert(3);

        sal.get(-1);
        sal.get(3);
    }

    @Test
    public void testGetNonNullValidIndexes() {
        sal.insert(1);
        sal.insert(5);
        sal.insert(3);

        Integer expRes = 1;
        Integer result = (Integer)sal.get(0);
        assertEquals(expRes, result);

        expRes = 3;
        result = (Integer)sal.get(1);
        assertEquals(expRes, result);

        expRes = 5;
        result = (Integer)sal.get(2);
        assertEquals(expRes, result);

    }

    @Test
    public void testToStringEmptyArrayList() {
        assertEquals("[]", sal.toString());
    }

    @Test
    public void testToStringNotEmptyArrayList() {
        sal.insert(3);
        sal.insert(1);
        sal.insert(5);
        sal.insert(3);
        sal.insert(1);
        sal.insert(5);

        assertEquals("[1, 1, 3, 3, 5, 5]", sal.toString());
    }
}