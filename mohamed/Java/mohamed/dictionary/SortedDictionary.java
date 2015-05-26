package mohamed.dictionary;

/**
 * @author Omar Mohamed
 */
public interface SortedDictionary<K extends Comparable<? super K>, V> extends Dictionary<K,V>{

    /**
     * Returns the minimun key in the sorted dictionary
     * @return the minimum key
     */
    K minKey();

    /**
     * Returns the maximum key in the sorted dictionary
     * @return the maximum key
     */
    K maxKey();

    /**
     * Returns the element with minimun key in the sorted dictionary
     * @return the element associated with the minimum key
     */
    V elementOfMinKey();

    /**
     * Returns the element with maximum key in the sorted dictionary
     * @return the element associated with the maxixum key
     */
    V elementOfMaxKey();
}
