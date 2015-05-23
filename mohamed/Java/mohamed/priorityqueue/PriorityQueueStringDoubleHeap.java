package mohamed.priorityqueue;

import java.util.HashMap;

/**
 * Class that implements priority queue with heap
 * @author Omar Mohamed
 */
public class PriorityQueueStringDoubleHeap implements PriorityQueueStringDouble{

    private int elementsNumber = 0;
    private PriorityElem[] heap;
    private final HashMap<String, Integer> position = new HashMap<String, Integer>();

    /**
     * PRECONDITION: elem.length==prior.length.
     * Create an heap of dimension elem.length containing the elements in elem with priority prior
     *
     * @param elem array of string containing the value of the elements
     * @param prior array of double containing the value of the priority of the elements
     */
    public PriorityQueueStringDoubleHeap(String[] elem, double[] prior) {
        if (elem != null && prior != null) {
            int elemLength = elem.length;
            int priorLength = prior.length;
            if ((elemLength > 0) && (elemLength == priorLength)) {
                elementsNumber = elemLength;
                heap = new PriorityElem[elemLength];

                for (int i = 0; i < elemLength; i++) {
                    heap[i] = new PriorityElem(elem[i], prior[i]);
                    position.put(elem[i], i);
                }
               // heapify(0); AGGIUNGERE METODI AUSILIARI!!!!
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Create an empty heap with length n
     *
     * @param n max dimension for the heap
     */
    public PriorityQueueStringDoubleHeap(int n) {
        heap = new PriorityElem[n];
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
        return false;
    }

    /**
     * Get the first element of the queue avoiding to remove it
     *
     * @return the string element, null otherwise if the queue is empty
     */
    public String first() {
        return null;
    }

    /**
     * Get the first element of the queue removing it from the queue
     *
     * @return the string element, null otherwise if the queue is empty
     */
    public String removeFirst() {
        return null;
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
        return false;
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
        return false;
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
