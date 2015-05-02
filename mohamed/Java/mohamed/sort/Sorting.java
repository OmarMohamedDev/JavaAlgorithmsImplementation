package mohamed.sort;

/**
 *
 * @author Omar Mohamed
 */
public class Sorting {

    /**
     * Private constructor
     */
    private Sorting(){
    }

    /**
     * Method that swap the value first and second inside the array a
     * @param a
     * @param first
     * @param second
     */
    static void swap(int[] a, int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    /**
     * Check if the array is sorted or not
     * @param a the array that we want to check
     * @return true if the array is sorted, false otherwise
     */
    public static boolean isSorted(int[] a){
        //Length of the array
        int n = a.length;

        //The array is less than two elements: so it is already sorted
        if(n < 2)
            return true;

        //Checking if all the elements of the array are ordered or not
        for(int i=1; i< a.length; i++)
            if(!(a[i]>=a[i-1]))
                return false;

        return true;

    }

    /**
     * Basic version of the selection sort
     * @param a array that have to be ordered
     */
    public static void ssort(int[] a){

        int n = a.length;
        for(int i = 0; i < n-1; i++){
            int iMin = i;
            for(int j = i+1; j < n; j++) {
                if (a[j] < a[iMin])
                    iMin = j;
            }
            swap(a, i, iMin);
        }
    }

    /**
     * Basic version of the insertion sort
     * @param a array that have to be ordered
     */
    public static void isort(int[] a){
        int n = a.length;

        for(int i= 1; i < n; i++){
            int x = a[i];

            int j;
            for(j= i; j > 0; j--){
                if(x >= a[j-1]) break;
                a[j] = a[j-1];
            }
            a[j] = x;
        }

    }

    /**
     * Version of the insertion sort that use the binary search
     * @param a array that have to be ordered
     */
    public static void isortBin(int[] a){

    }

    /**
     * Basic version of the mergesort
     * @param a array that have to be ordered
     */
    public static void msortBasic(int[] a){

    }

    /**
     * Method that implements a version of the mergesort with an auxiliary array
     * and an optimized merge
     * @param a array that have to be ordered
     */
    public static void msortNoGarbage(int[] a){

    }

    /**
     * Alternative version of the mergesort
     * @param a array that have to be ordered
     */
    public static void msortAlt(int[] a){

    }

    /**
     * Version of the mergesort that use also the insertion sort in some cases
     * @param a array that have to be ordered
     */
    public static void msortIsort(int[] a){

    }

    /**
     * Parallel version of the mergesort
     * @param a array that have to be ordered
     */
    public static void parallelMergesort(int[] a){

    }

    /**
     * Basic version of the quicksort (extracting a pivot)
     * @param a array that have to be ordered
     */
    public static void qsortBasic(int[] a){

    }

    /**
     * Parallel version of the quicksort
     * @param a array that have to be ordered
     */
    public static void parallelQuicksort(int[] a){

    }

    /**
     * Version of the "Hoare" quicksort
     * @param a array that have to be ordered
     */
    public static void qsortHoare(int[] a){

    }

    /**
     * Version of the "Hoare" quicksort, optimized with the insertion sort
     * and without recursion tail
     * @param a array that have to be ordered
     */
    public static  void qsortHoareIsort(int[] a){

    }

    /**
     * Basic version of the heapsort
     * @param a array that have to be ordered
     */
    public static void hsort(int[] a){

    }

}
