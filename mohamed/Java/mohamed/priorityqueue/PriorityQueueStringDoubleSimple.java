package mohamed.priorityqueue;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.HashMap;

/**
 * Class that implements a priority queue with arrays
 * @author Omar Mohamed
 */
public class PriorityQueueStringDoubleSimple implements PriorityQueueStringDouble{

    private int elementsNumber = 0;
    private PriorityElem[] array;
    private final HashMap<String, Integer> position = new HashMap<String, Integer>();

    /**
     * PRECONDITION: elem.length==prior.length.
     * Create an array of dimension elem.length containing the elements in elem with priority prior
     *
     * @param elem array of string containing the value of the elements
     * @param prior array of double containing the value of the priority of the elements
     */
    public PriorityQueueStringDoubleSimple(String[] elem, double[] prior) {
        if (elem != null && prior != null) {
            int elemLength = elem.length;
            int priorLength = prior.length;
            if ((elemLength > 0) && (elemLength == priorLength)) {
                elementsNumber = elemLength;
                array = new PriorityElem[elemLength];

                for (int i = 0; i < elemLength; i++) {
                    array[i] = new PriorityElem(elem[i], prior[i]);
                    position.put(elem[i], i);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Create an empty array with length n
     *
     * @param n max dimension for the heap
     */
    public PriorityQueueStringDoubleSimple(int n) {
        array = new PriorityElem[n];
        elementsNumber = 0;
    }


    /**
     * Add the element with a specified priority in the queue
     *
     * @param element  element that we want to add
     * @param priority priority that we want to assign to the element
     * @return false if the element is already inside the queue, true otherwise
     */
    public boolean add(String element, double priority) {
        //The queue contains already the element
        if(position.containsKey(element)) return false;
        if(elementsNumber < array.length){
            array[elementsNumber] = new PriorityElem(element,priority);
            position.put(element,elementsNumber++);
            return true;
        }
        else
            throw new IllegalArgumentException("The queue is full");
    }

    /**
     * Get the first element of the queue avoiding to remove it
     *
     * @return the string element, null otherwise if the queue is empty
     */
    public String first() {
        if(isEmpty()) return null;

        int indexElementMaxPriority = -1; //Inizializing with impossible index

        for(int i=0; i < array.length; i++){
            //First of all we check if the element is null
            //Secondly, we check if is the first iteration of the cycle (where we are looking for an element to compare
            //Finally, we compare it with ther other values if there are more than one
            if(array[i] != null && (indexElementMaxPriority == -1 || array[i].prior < array[indexElementMaxPriority].prior))
                indexElementMaxPriority = i;

        }

        return array[indexElementMaxPriority].elem;
    }

    /**
     * Get the first element of the queue removing it from the queue
     *
     * @return the string element, null otherwise if the queue is empty
     */
    public String removeFirst() {
        if(isEmpty()) return null;

        String elementSearched = first();

        delete(elementSearched);

        return elementSearched;
    }

    /**
     * Check if the queue is empty or not
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return elementsNumber == 0;
    }

    /**
     * Remove the element from the queue, it it is present
     *
     * @param element the element that we want to remove
     * @return true if the element is present and the method remove it, false otherwise
     */
    public boolean delete(String element) {
        if(isEmpty() || position.get(element) == null) return false;

        //After we found the element, we remove it from the array, decrease the number of elements and
        //remove the entry of the position in the hashtable
        array[position.get(element)] = null;
        elementsNumber--;
        position.remove(element);
        return true;
    }

    /**
     * Set the element to a specified priority, if it is present
     *
     * @param element  the element we want to change the priority
     * @param priority the new priority value that we want to set to the element
     * @return true if the element is present and we successfully change his priority,
     * false otherwise
     */
    public boolean setPriority(String element, double priority) {
        if(isEmpty() || position.get(element) == null) return false;

        array[position.get(element)].prior = priority;
        return true;
    }

    //Inner class that represent the element with a speficied priority
    protected class PriorityElem {

        String elem;
        double prior;

        PriorityElem(String el, double pr) {
            elem = el;
            prior = pr;
        }
    }
}
