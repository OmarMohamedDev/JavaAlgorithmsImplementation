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

    /**
     * Test of the method that implements the basic version of the mergesort of the Sorting class
     */
    @Test
    public void testMsortBasicArrayLengthZeroArray() {
        Sorting.msortBasic(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testMsortBasicLengthOneArray() {
        Sorting.msortBasic(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testMsortBasicSortedArray() {
        Sorting.msortBasic(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testMsortBasicReverseSortedArray() {
        Sorting.msortBasic(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testMsortBasicUnsortedArray() {
        Sorting.msortBasic(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testMsortBasicRandomArray() {
        Sorting.msortBasic(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of the method that implements the "No Garbage" version of the mergesort of the Sorting class
     */
    @Test
    public void testMsortNoGarbageArrayLengthZeroArray() {
        Sorting.msortNoGarbage(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testMsortNoGarbageLengthOneArray() {
        Sorting.msortNoGarbage(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testMsortNoGarbageSortedArray() {
        Sorting.msortNoGarbage(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testMsortNoGarbageReverseSortedArray() {
        Sorting.msortNoGarbage(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testMsortNoGarbageUnsortedArray() {
        Sorting.msortNoGarbage(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testMsortNoGarbageRandomArray() {
        Sorting.msortNoGarbage(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of the method that implements an alternative version of the mergesort of the Sorting class
     */
    @Test
    public void testMsortAltArrayLengthZeroArray() {
        Sorting.msortAlt(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testMsortAltLengthOneArray() {
        Sorting.msortAlt(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testMsortAltSortedArray() {
        Sorting.msortAlt(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testMsortAltReverseSortedArray() {
        Sorting.msortAlt(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testMsortAltUnsortedArray() {
        Sorting.msortAlt(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testMsortAltRandomArray() {
        Sorting.msortAlt(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of the method that implements the parallel version of the mergesort of the Sorting class
     */
    @Test
    public void testParallelMergesortArrayLengthZeroArray() {
        Sorting.parallelMergesort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testParallelMergesortLengthOneArray() {
        Sorting.parallelMergesort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testParallelMergesortSortedArray() {
        Sorting.parallelMergesort(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testParallelMergesortReverseSortedArray() {
        Sorting.parallelMergesort(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testParallelMergesortUnsortedArray() {
        Sorting.parallelMergesort(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testParallelMergesortRandomArray() {
        Sorting.parallelMergesort(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of the method that implements the basic version of the quicksort of the Sorting class
     */
    @Test
    public void testQsortBasicArrayLengthZeroArray() {
        Sorting.qsortBasic(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testQsortBasicLengthOneArray() {
        Sorting.qsortBasic(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testQsortBasicSortedArray() {
        Sorting.qsortBasic(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testQsortBasicReverseSortedArray() {
        Sorting.qsortBasic(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testQsortBasicUnsortedArray() {
        Sorting.qsortBasic(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testQsortBasicRandomArray() {
        Sorting.qsortBasic(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of the method that implements the "Hoare" version of the quicksort of the Sorting class
     */
    @Test
    public void testQsortHoareArrayLengthZeroArray() {
        Sorting.qsortHoare(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testQsortHoareLengthOneArray() {
        Sorting.qsortHoare(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testQsortHoareSortedArray() {
        Sorting.qsortHoare(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testQsortHoareReverseSortedArray() {
        Sorting.qsortHoare(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testQsortHoareUnsortedArray() {
        Sorting.qsortHoare(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testQsortHoareRandomArray() {
        Sorting.qsortHoare(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of the method that implements the parallel version of the quicksort of the Sorting class
     */
    @Test
    public void testParallelQuicksortArrayLengthZeroArray() {
        Sorting.parallelQuicksort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testParallelQuicksortLengthOneArray() {
        Sorting.parallelMergesort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testParallelQuicksortSortedArray() {
        Sorting.parallelQuicksort(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testParallelQuicksortReverseSortedArray() {
        Sorting.parallelQuicksort(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testParallelQuicksortUnsortedArray() {
        Sorting.parallelMergesort(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testParallelQuicksortRandomArray() {
        Sorting.parallelQuicksort(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }

    /**
     * Test of the method that implements the basic version of the heapsort of the Sorting class
     */
    @Test
    public void testHeapsortArrayLengthZeroArray() {
        Sorting.hsort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthZeroArray));
    }

    @Test
    public void testHeapsortLengthOneArray() {
        Sorting.hsort(lengthZeroArray);
        assertTrue(Sorting.isSorted(lengthOneArray));
    }

    @Test
    public void testHeapsortSortedArray() {
        Sorting.hsort(sortedArray);
        assertTrue(Sorting.isSorted(sortedArray));
    }

    @Test
    public void testHeapsortReverseSortedArray() {
        Sorting.hsort(reverseSortedArray);
        assertTrue(Sorting.isSorted(reverseSortedArray));

    }

    @Test
    public void testHeapsortUnsortedArray() {
        Sorting.hsort(unsortedArray);
        assertTrue(Sorting.isSorted(unsortedArray));

    }

    @Test
    public void testHeapsortRandomArray() {
        Sorting.hsort(randomArray);
        assertTrue(Sorting.isSorted(randomArray));
    }


}
