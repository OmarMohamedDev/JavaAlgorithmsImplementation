package mohamed.sort;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Omar Mohamed
 */
public class SortingTest {

    //Arrays used for the tests
    int[] lengthZeroArray;
    int[] lengthOneArray;
    int[] sortedArray;
    int[] reverseSortedArray;
    int[] unsortedArray;
    int[] randomArray;
    int[] sortedRandomArray;


    @Before
    public void setUp() {
        lengthZeroArray = new int[0];

        int[] a = {5};
        lengthOneArray = a;

        int[] b = {-5, 1, 3, 10, 5};
        sortedArray = b;

        int[] c = {5, 10, 3, 1, -5};
        reverseSortedArray = c;

        int[] d = {5, -5, 3, 1, 10};
        unsortedArray = d;

        int[] f;
        Random r = new Random();
        int randomSize = r.nextInt(10000);
        f = new int[randomSize];
        for (int j = 0; j < randomSize; j++) {
            f[j] = r.nextInt(1000000);
        }
        int[] f2 = f;
        Arrays.sort(f2);
        randomArray = f;
        sortedRandomArray = f2;
    }


    /**
     * Test of the selection sort method of the Sorting class
     */
    @Test
    public void testSSortArrayLengthZeroArray() {
        Sorting.ssort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testSSortLengthOneArray() {
        Sorting.ssort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testSSortSortedArray() {
        Sorting.ssort(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testSSortReverseSortedArray() {
        Sorting.ssort(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testSSortUnsortedArray() {
        Sorting.ssort(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testSSortRandomArray() {
        Sorting.ssort(randomArray);
        assertTrue(Sorting.isSorted(randomArray));

    }

    /**
     * Test of the insertion sort method of the Sorting class
     */
    @Test
    public void testISortArrayLengthZeroArray() {
        Sorting.isort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testISortLengthOneArray() {
        Sorting.isort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testISortSortedArray() {
        Sorting.isort(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testISortReverseSortedArray() {
        Sorting.isort(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testISortUnsortedArray() {
        Sorting.isort(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testISortRandomArray() {
        Sorting.isort(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of a particular version of the insertion sort that use the binary search method of the Sorting class
     */
    @Test
    public void testISortBinArrayLengthZeroArray() {
        Sorting.isortBin(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testISortBinLengthOneArray() {
        Sorting.isortBin(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testISortBinSortedArray() {
        Sorting.isortBin(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testISortBinReverseSortedArray() {
        Sorting.isortBin(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testISortBinUnsortedArray() {
        Sorting.isortBin(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testISortBinRandomArray() {
        Sorting.isortBin(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

}
