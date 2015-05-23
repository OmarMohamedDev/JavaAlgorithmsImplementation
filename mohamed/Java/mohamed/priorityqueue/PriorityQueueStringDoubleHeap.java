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
                    if(position.get(elem) == null) {
                        heap[i] = new PriorityElem(elem[i], prior[i]);
                        position.put(elem[i], i);
                    }
                }
                heapify(0);
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
        //If the queue isn't full
        if(elementsNumber < heap.length){
            //the element isn't already there
            if(position.get(element) == null) {
                PriorityElem eP = new PriorityElem(element, priority);
                heap[elementsNumber] = eP;
                moveUp(elementsNumber++);
                return true;
            }
            else return false;
        }
        else
            throw new IllegalArgumentException("Full queue");
    }

    /**
     * Get the first element of the queue avoiding to remove it
     *
     * @return the string element, null otherwise if the queue is empty
     */
    public String first() {
        if(isEmpty()) return null;

        return heap[0].elem;
    }

    /**
     * Get the first element of the queue removing it from the queue
     *
     * @return the string element, null otherwise if the queue is empty
     */
    public String removeFirst() {
        if(isEmpty()) return null;

        String element = heap[0].elem;

        PriorityElem lastEl = heap[elementsNumber - 1];
        heap[--elementsNumber] = null;

        heap[0] = lastEl;

        if(!isEmpty())
            moveDown(0);

        return element;


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
        if(position.get(element) != null){
            heap[position.get(element)] = null;
            position.remove(element);
            elementsNumber--;

            if(!isEmpty())
                moveDown(0); //Fixing the heap
            return true;
        }
        else
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
        if(isEmpty() || position.get(element) == null) return false;

        int index = position.get(element);
        heap[index].prior = priority;
        moveUp(index);
        moveDown(index);
        return true;
    }


    /**
     * Private method that move down the element in the position i in the correct place,
     * if it isn't already there
     * @param i index of the element that we want to move
     */
    private void moveDown(int i){
        if(i >= elementsNumber) throw new IllegalArgumentException("Uncorrect index");

        PriorityElem eP = heap[i]; //Element that we want to move

        while(2*i+1 < elementsNumber){ //Checking if the left child exist
            int j = 2*i+1; //Left child

            if(j+1 < elementsNumber && heap[j+1].prior < heap[j].prior) //Checking if the right child exist and is the lowest
                j++;// The lowest of the children

            if(eP.prior <= heap[j].prior) break; //We found the correct spot where we want to move the element

            heap[i] = heap[j]; //Moving up the lowest child
            position.put(heap[i].elem, i);
            i = j;
        }
        heap[i] = eP; //Copying the element in the correct position
        position.put(heap[i].elem, i);

    }

    /**
     * Private method that move up the element in the position i in the correct place,
     * if it isn't already there
     * @param i index of the element that we want to move
     */
    private void moveUp(int i){
        if(i >= elementsNumber) throw new IllegalArgumentException("Uncorrect index");

        PriorityElem eP = heap[i];

        while(i > 0 && eP.prior < heap[(i-1)/2].prior){ //If we are not in the root and the element is lowest of his parent
            heap[i] = heap[(i-1)/2];
            position.put(heap[i].elem, i); //Updating the position
            i = (i-1)/2;
        }

        heap[i] = eP;
        position.put(heap[i].elem, i); //Updating the position

    }

    /**
     * Private method that transform a portion of array in heap starting from the position i
     * @param i index of the element where want to start the heapify process
     */
    private void heapify(int i){
        //(Elements-2)/2 is the index of the last parent that is not a leaf
        for(int j = (elementsNumber-2/2); j >= 0; j--)
            moveDown(j);
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
