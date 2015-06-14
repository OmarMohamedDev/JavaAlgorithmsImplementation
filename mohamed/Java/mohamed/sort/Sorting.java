package mohamed.sort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Omar Mohamed
 */
public class Sorting {

    /**
     * Object used to generate random numbers in some method (as the quicksort)
     */
    static Random randomGenerator = new Random();

    /**
     * Private constructor
     */
    private Sorting(){
    }

    //Methods visible publicly

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
     * Method that implements the basic version of the mergesort
     * @param a array that have to be ordered
     */
    public static void msortBasic(int[] a){
        msortBasicIntern(a, 0, a.length - 1);
    }

    /**
     * Method that implements a version of the mergesort with an auxiliary array
     * and an optimized merge
     * @param a array that have to be ordered
     */
    public static void msortNoGarbage(int[] a){
        int n = a.length;
        int[] aux = new int[n];
        msortNoGarbageIntern(a, 0, n - 1, aux);
    }

    /**
     * Alternative version of the mergesort that use alternatively the original array
     * and the auxiliary one.
     * @param a array that have to be ordered
     */
    public static void msortAlt(int[] a){
        int n = a.length;
        int[] aux = new int[n];
        msortAltIntern(a, 0, n - 1, aux);
    }

    /**
     * Parallel version of the mergesort
     * @param a array that have to be ordered
     */
    public static void parallelMergesort(int[] a){
        int n = a.length-1;
        int cores = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int[] aux = new int[a.length];
        ParallelMergeSorter sorter =
                new ParallelMergeSorter(a, 0, n, aux, cores);
        pool.invoke(sorter);
    }

    /**
     * Basic version of the quicksort (extracting a pivot)
     * @param a array that have to be ordered
     */
    public static void qsortBasic(int[] a){
        int n = a.length - 1;
        qsortBasicIntern(a, 0, n);
    }

    /**
     * Parallel version of the quicksort
     * @param a array that have to be ordered
     */
    public static void parallelQuicksort(int[] a){
        int n = a.length-1;
        int cores = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ParallelQuickSorter sorter =
                new ParallelQuickSorter(a, 0, n, cores);
        pool.invoke(sorter);
    }

    /**
     * Version of the "Hoare" quicksort
     * @param a array that have to be ordered
     */
    public static void qsortHoare(int[] a){
        int n = a.length - 1;
        qsortHoareIntern(a, 0, n);
    }

    /**
     * Basic version of the heapsort
     * @param a array that have to be ordered
     */
    public static void hsort(int[] a){
        int n = a.length;
        //Heapify process starting from the last internal node (the leaves are already heaps)
        for(int j = (n-2)/2; j >= 0; j--)
            moveDown(a, j, n);
        //
        for(int i = n-1; i > 0; i--) {
            swap(a, 0, i);
            moveDown(a, 0, i);
        }

    }

    //Methods visible in the package

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
     * Method that implements the merge of an two adjacent segements in an array
     * @param a array that contains the segments
     * @param fst index that represent the left extreme of the segment
     * @param mid index that represent the middle of the segment
     * @param lst index that represent the right extreme of the segment
     */
    static void mergeBasic(int[] a, int fst, int mid, int lst) {
        int n = lst - fst + 1;
        int i,j,k;
        int[] c = new int[n];
        i = fst; j = mid+1; k = 0;
        while(i <= mid && j <= lst) {
            c[k++] = a[i]<= a[j] ? a[i++] : a[j++];
        }
        while(i <= mid) c[k++] = a[i++];
        while(j <= lst) c[k++] = a[j++];
        for(int h = 0; h < n; h++) a[fst + h] = c[h];
    }

    /**
     * Method that implements an optimized version of the merge of an two adjacent
     * segements in an array using an auxiliary array
     * @param a array that contains the segments
     * @param fst index that represent the left extreme of the segment
     * @param mid index that represent the middle of the segment
     * @param lst index that represent the right extreme of the segment
     * @param aux auxiliary array used during the merge
     */
    static void mergeNoGarbage(int[] a, int fst, int mid, int lst, int[] aux) {
        int i = fst, j = mid+1, k = fst;
        while(i <= mid && j <= lst) {
            aux[k++] = a[i]<= a[j] ? a[i++] : a[j++];
        }
        for(int h = mid, l = lst; h >= i;) a[l--] = a[h--];
        for(int r = fst; r < k; r++) a[r] = aux[r];
    }

    /**
     * Method that implements an alternative version of the merge of two adjacent
     * segements in an array using an auxiliary array and using both two avoid
     * to copy all the time one in another
     * @param a array that contains the segments
     * @param fst index that represent the left extreme of the segment
     * @param mid index that represent the middle of the segment
     * @param lst index that represent the right extreme of the segment
     * @param aux auxiliary array used during the merge
     */
    static void mergeAlt(int[] a, int fst, int mid, int lst, int[] aux) {
        int i = fst, j = mid+1, k = fst;
        while(i <= mid && j <= lst) {
            aux[k++] = a[i]<= a[j] ? a[i++] : a[j++];
        }
        while(i <= mid) aux[k++] = a[i++];
        while(j <= lst) aux[k++] = a[j++];
    }

    /**
     * Not public method that implements the basic mergesort
     * @param a array that we want to order
     * @param first index of the element that represent the left extreme of the segment that we want to order
     * @param last index of the element that represent the right extreme of the segment that we want to order
     */
    static void msortBasicIntern(int[] a, int first, int last){
        if(first >= last) return;
        int m = (first+last)>>>1;
        msortBasicIntern(a, first, m);
        msortBasicIntern(a, m+1,last);
        mergeBasic(a, first, m, last);
    }

    /**
     * Not public method that implements a version of the mergesort with an auxiliary array and an optimized mergesort
     * @param a array that we want to order
     * @param first index of the element that represent the left extreme of the segment that we want to order
     * @param last index of the element that represent the right extreme of the segment that we want to order
     * @param aux auxiliary array used to avoid to create a new one every time that we merge
     */
    static void msortNoGarbageIntern(int[] a, int first, int last, int[] aux){
        if(first >= last) return;
        int m = (first+last)>>>1;
        msortNoGarbageIntern(a, first, m, aux);
        msortNoGarbageIntern(a, m + 1, last, aux);
        mergeNoGarbage(a, first, m, last, aux);
    }

    /**
     * Not public method that implements an alternative version of the mergesort that use both the original
     * and the auxiliary array
     * @param a array that we want to order
     * @param fst index of the element that represent the left extreme of the segment that we want to order
     * @param lst index of the element that represent the right extreme of the segment that we want to order
     * @param aux auxiliary array used to avoid to create a new one every time that we merge
     */
    static void msortAltIntern(int[] a, int fst, int lst, int[] aux){
        if(fst < lst) {
            int m = (fst + lst)/2;
            msortAltIntern(aux, fst, m, a);
            msortAltIntern(aux, m + 1, lst, a);
            mergeAlt(aux, fst, m, lst, a);
        }
    }

    /**
     * Not public method that implements a basic version of the quicksort (extracting a pivot)
     * @param a array that have to be ordered
     * @param fst first element of the segment that have to be ordered
     * @param lst last element of the segment that have to be ordered
     */
    static void qsortBasicIntern(int[] a, int fst, int lst){
        if ((lst - fst + 1) > 1) {

            int iPivot = fst + randomGenerator.nextInt(lst - fst + 1);
            // moving the pivot in the head of the array
            swap(a, fst, iPivot);

            iPivot = fst;

            int j = lst;
            int i = fst + 1;
            while (i <= j) {
                if (a[i] >= a[iPivot]) {
                    swap(a, i, j);
                    j--;
                } else {
                    i++;
                }
            }
            swap(a, iPivot, j);
            iPivot = j;

            qsortBasicIntern(a, fst, iPivot - 1);
            qsortBasicIntern(a, iPivot + 1, lst);

        }
    }

    /**
     * Not public method that implements the "Hoare" version of the quicksort
     * @param a array that have to be ordered
     * @param fst first element of the segment that have to be ordered
     * @param lst last element of the segment that have to be ordered
     */
    static void qsortHoareIntern(int[] a, int fst, int lst){
        if(fst < lst) {
            int iPivot = fst + randomGenerator.nextInt(lst-fst + 1);
            int x = a[iPivot];
            int i = fst;
            int j = lst;
            do {
                while(a[i] < x) i++;
                while(a[j] > x) j--;
                if(i <= j) {
                    swap(a, i, j);
                    i++; j--;
                }
            } while(i <= j);
            qsortHoareIntern(a, fst, j);
            qsortHoareIntern(a, i, lst);
        }
    }

    /**
     * Method that implements the move down in a max-heap, used by the heapsort method
     * @param a array that we want to modify
     * @param i index of the element that we want to "move down"
     * @param length length of the segment of the array used by the heap
     */
    static void moveDown(int[] a, int i, int length){
        int elem = a[i];
        int j;

        while((j = 2*i + 1) < length) {
            if(j+1 < length && a[j+1] > a[j]) j++;
            if(elem >= a[j]) break;
            a[i] = a[j];
            i = j;
        }
        a[i] = elem;
    }

    //Inner Classes

    /**
     * Inner class used by the parallel mergesort method
     */
    static class ParallelMergeSorter extends RecursiveAction {
        int[] a, aux;
        int first, last;
        int numThreads; // number of the threads still available
        ParallelMergeSorter(int[] a, int f, int l, int[] aux, int n){
            this.a = a; this.aux = aux;
            first = f; last = l; numThreads = n;
        }
        @Override
        protected void compute() {
            if(first >= last) return;
            if(numThreads <= 1) msortNoGarbageIntern(a, first, last, aux); //Calling the sequential version of the msort
            else {
                int m = (first + last)/2;
                ParallelMergeSorter left =
                        new ParallelMergeSorter(a, first, m, aux, numThreads/2);
                ParallelMergeSorter right =
                        new ParallelMergeSorter(a, m+1, last, aux, numThreads/2);
                invokeAll(left, right);
                mergeNoGarbage(a, first, m, last, aux);
            }
        }
    }

    /**
     * Inner class used by the parallel quicksort method
     */
    static class ParallelQuickSorter extends RecursiveAction {
        int[] a;
        int first, last;
        int numThreads; // number of the threads still available
        ParallelQuickSorter(int[] a, int f, int l, int n){
            this.a = a;
            first = f; last = l; numThreads = n;
        }
        @Override
        protected void compute() {
            if ((last - first + 1) <= 1) return; //Version with the early return
            if(numThreads <= 1) qsortBasicIntern(a, first, last); //Calling the sequential version of the qsort
            else {
                   int iPivot = first + randomGenerator.nextInt(last - first + 1);
                    // moving the pivot in the head of the array
                    swap(a, first, iPivot);

                    iPivot = first;

                    int j = last;
                    int i = first + 1;
                    while (i <= j) {
                        if (a[i] >= a[iPivot]) {
                            swap(a, i, j);
                            j--;
                        } else {
                            i++;
                        }
                    }
                    swap(a, iPivot, j);
                    iPivot = j;

                    ParallelQuickSorter left =
                            new ParallelQuickSorter(a, first, iPivot - 1, numThreads/2);
                    ParallelQuickSorter right =
                            new ParallelQuickSorter(a, iPivot + 1, last, numThreads/2);
                    invokeAll(left, right);
            }

        }
    }

}
