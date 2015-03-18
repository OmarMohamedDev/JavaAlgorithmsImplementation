package mohamed.esercizio1;

/**
 *
 * @author Omar Mohamed
 */
public class IntSortedArray {

    /**
     * Partially filled array that will contains the elements
     */
    protected int[] elements;

    /**
     * Number of elements that are actually inside the "elements" array
     */
    protected int size;

    /**
     * Public constructor that initialize the elements array of 16 elements
     */
    public IntSortedArray(){
        elements = new int[16];
        size = 0;
    }

    /**
     * Public constructor that initialize the elements array
     * of the capacity specified by the parameter
     * @param initialCapacity initial capacity of the array
     * @throws java.lang.IllegalArgumentException if initialCapacity is negative
     */
    public IntSortedArray(int initialCapacity){
        if(initialCapacity >= 0)
            elements = new int[initialCapacity];
        else
            throw new IllegalArgumentException("You cannot initialize the array with a negative number");

        size = 0;
    }

    /**
     * Public constructor that initialize the elements array with the length
     * of the array a plus 16 and contains all the elements of a
     * @param a array of int
     */
    public IntSortedArray(int[] a){
        elements = new int[a.length + 16];

        for(int i=0; i<a.length; i++)
            elements[i] = a[i];

        size = a.length;
    }

    /**
     * Method that returns the number of elements inside the array
     * @return the actual number of elements
     */
    public int size(){
        return size;
    }

    /**
     * Implements the iterative binary search
     * @param x the element that we want search or add, if is not present
     * @return the position of the element if is already inside the array,
     * the position where we want to insert it otherwise.
     */
    protected int binarySearch(int x){
        int inf = 0;
        int sup = size() -1;

        //If the array is empty or the element x is smaller than the first
        //one, we return -1 to put it in the first position
        if(sup == -1 || x < elements[0]) return -1;

        //If the element x is smaller than the last one, we return -(size()+1)
        //in the way to put in the last position
        if(x > elements[sup]) return -(size()+1);

        while(inf <= sup){
            int i = (inf + sup)>>>1;

            if(x < elements[i])
                sup = i-1;
            else if(x > elements[i])
                inf = i+1;
            else
                return i;
        }

        return -(inf+1);

    }

    /**
     * Method that insert the element x in elements keeping the array ordered.
     * If the array is full, we instantiate another array that will be the double
     * of the first one and than we will insert it
     * @param x the element that we want to insert
     * @return the index where we inserted the element
     */
    public int insert(int x){
        int i = 0;
        int result = binarySearch(x);
        int position;

        //If the result is smaller than 0, means that the element wasn't present in the array
        if(result < 0)
            position = -1 - result;
        else
            position = result;

        //If the array is full
        if(size() == elements.length){
            //Creating an array that is the double of the first one
            int newElements[] = new int[2 * size()];
            while (i < size()) {
                newElements[i] = elements[i];//copying all the elements in the original order
                i++;
            }
            elements = newElements;//replace the new array with the old one
        }

        for (i = size() - 1; i >= position; i--) {
            elements[i + 1] = elements[i]; //moving the elements in the way to create space for the new one
        }
        elements[position] = x;
        size++;

        return position;
    }

    /**
     * Method that permit to retrieve the element inside the array with index i
     * @param i index of the element that we want to retrieve
     * @return the element with index i
     * @throws java.lang.ArrayIndexOutOfBoundsException if i is a valid index
     */
    public int get(int i){
        if(i < size() && i >= 0)
            return elements[i];
        else
            throw new ArrayIndexOutOfBoundsException("The index provided is greater than the number of elements in the array");
    }


    /**
     * Ovveride of the Object toString() method
     * @return a string that represent the array elements
     */
    @Override
    public String toString(){
        String arrayElements = "[";

        for(int i=0; i<size(); i++) {
            arrayElements += elements[i];

            //We insert this check in the way to understand if we have to put a comma or not after the number
            if (i + 1 != size())
                arrayElements += ", ";
        }

        arrayElements += "]";

        return arrayElements;
    }


}
