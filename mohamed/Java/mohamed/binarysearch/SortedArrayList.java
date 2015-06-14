package mohamed.binarysearch;

import java.util.ArrayList;

/**
 *
 * @author Omar Mohamed
 */
public class SortedArrayList<E extends Comparable<E>> {

    /**
     * Partially filled arraylist that will contains the elements
     */
    ArrayList<E> elements;

    /**
     * Public constructor that initialize the elements arraylist of 16 elements
     */
    public SortedArrayList(){
        elements = new ArrayList<E>(16);
    }

    /**
     * Public constructor that initialize the elements arraylist
     * of the capacity specified by the parameter
     * @param initialCapacity initial capacity of the arraylist
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public SortedArrayList(int initialCapacity){
        if(initialCapacity >= 0)
            elements = new ArrayList<E>(initialCapacity);
        else
            throw new IllegalArgumentException("You cannot initialize the arraylist with a negative number");
    }

    /**
     * Public constructor that initialize the elements arraylist with the length
     * of the arraylist a plus 16 and contains all the elements of a
     * @param a arraylist of int
     */
    public SortedArrayList(E[] a){
        elements = new ArrayList<E>(a.length + 16);

        for(int i=0; i<a.length; i++)
            elements.add(a[i]);
    }

    //Public methods

    /**
     * Method that returns the number of elements inside the arraylist
     * @return the actual number of elements
     */
    public int size(){
        return elements.size();
    }


    /**
     * Method that use the binary search to return the index of an element or -1 if the element is not present
     * @param x the element that we want to search inside the arraylist
     * @return the index of the element passed as parameter, -1 otherwise
     */
    public int indexOf(E x){
        int result = binarySearch(x);
        return result >=0 ? result : -1;
    }

    /**
     * Method that insert the element x in elements keeping the arraylist ordered.
     * @param x the element that we want to insert
     * @return the index where we inserted the element
     */
    public int insert(E x){
        int i = 0;
        int result = binarySearch(x);
        //If the result is smaller than 0, means that the element wasn't present in the arraylist, is present otherwise
        int position = result < 0 ? -1 -result : result;

        for (i = size() - 1; i >= position; i--) {
            elements.add(i+1, elements.get(i));
            elements.remove(i); //moving the elements in the way to create space for the new one
        }

        elements.add(position,x);

        return position;
    }

    /**
     * Method that permit to retrieve the element inside the arraylist with index i
     * @param i index of the element that we want to retrieve
     * @return the element with index i
     * @throws ArrayIndexOutOfBoundsException if i is a valid index
     */
    public E get(int i){
        if(i < size() && i >= 0)
            return elements.get(i);
        else
            throw new ArrayIndexOutOfBoundsException("The index provided is greater than the number of elements in the arraylist");
    }


    /**
     * Override of the Object toString() method
     * @return a string that represent the arraylist elements
     */
    @Override
    public String toString(){
        String arrayListElements = "[";

        for(int i=0; i<size(); i++) {
            arrayListElements += elements.get(i);

            //We insert this check in the way to understand if we have to put a comma or not after the number
            if (i + 1 != size())
                arrayListElements += ", ";
        }

        arrayListElements += "]";

        return arrayListElements;
    }

    //Protected Methods

    /**
     * Implements the iterative binary search
     * @param x the element that we want search or add, if is not present
     * @return the position of the element if is already inside the arraylist,
     * the position where we want to insert it otherwise.
     */
    int binarySearch(E x){
        int inf = 0;
        int sup = size() -1;

        //If the arraylist is empty or the element x is smaller than the first
        //one, we return -1 to put it in the first position
        if(sup == -1 || x.compareTo(elements.get(0)) == -1) return -1;

        //If the element x is smaller than the last one, we return -(size()+1)
        //in the way to put in the last position
        if(x.compareTo(elements.get(sup)) == 1) return -(size()+1);

        while(inf <= sup){
            int i = (inf + sup)>>>1;

            if(x.compareTo(elements.get(i)) == -1)
                sup = i-1;
            else if(x.compareTo(elements.get(i)) == 1)
                inf = i+1;
            else
                return i;
        }

        return -(inf+1);

    }



}
