package mohamed.sort;

import mohamed.binarysearch.IntSortedArray;

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
     * Method that impelements a particular version of the binary search that
     * returns always the index where we want to insert the element, in the most right possible position
     * in the way to guarantee the stability of the search
     * @param x the element that we want to search
     * @return the position of the element
     */
    static int binarySearch(int x, int[] a, int ini, int end) {
        if(x < a[ini]) return ini;
        if(x >= a[end]) return end+1;
        while(ini <= end) {
            int mid = (ini + end) >>> 1;
            if(x < a[mid]) end = mid-1;
            else ini = mid+1;
        }
        return ini;
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
     * Basic version of the insertion sort using the for cycle
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
        int n = a.length;
        if(n == 0) return;
        int start = 1; // cerca il primo elemento non in ordine
        while (start < n && a[start] >= a[start-1]) start++;
        if (start == n) return; // l'array è già ordinato
        for(int i = start; i < n; i++) {
            int x = a[i];
            int iInser = binarySearch(x, a, 0, i - 1);
            for(int j = i; j > iInser; j--) {
                a[j] = a[j-1];
            }
            a[iInser] = x;
        }

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
