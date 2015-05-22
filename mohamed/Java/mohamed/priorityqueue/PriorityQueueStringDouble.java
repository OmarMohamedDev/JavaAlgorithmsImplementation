package mohamed.priorityqueue;

/**
 * @author Omar Mohamed
 */
public interface PriorityQueueStringDouble {

    /**
     * Add the element with a specified priority in the queue
     * @param element element that we want to add
     * @param priority priority that we want to assign to the element
     * @return false if the element is already inside the queue, true otherwise
     */
    boolean add(String element, double priority);

    /**
     * Get the first element of the queue avoiding to remove it
     * @return the string element, null otherwise if the queue is empty
     */
    String first();

    /**
     * Get the first element of the queue removing it from the queue
     * @return the string element, null otherwise if the queue is empty
     */
    String removeFirst();

    /**
     * Check if the queue is empty or not
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Remove the element from the queue, it it is present
     * @param element the element that we want to remove
     * @return true if the element is present and the method remove it, false otherwise
     */
    boolean delete(String element);

    /**
     * Set the element to a specified priority, if it is present
     * @param element the element we want to change the priority
     * @param priority the new priority value that we want to set to the element
     * @return true if the element is present and we successfully change his priority,
     * false otherwise
     */
    boolean setPriority(String element, double priority);
}
