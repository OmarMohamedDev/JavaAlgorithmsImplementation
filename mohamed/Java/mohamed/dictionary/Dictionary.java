package mohamed.dictionary;

/**
 * Represent the ADT Dictionary
 * @author Omar Mohamed
 */
public interface Dictionary<K,V> {

    /**
     * Check if the dictionary is empty or not
     * @return true if the dictionary is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Search an element with a specified key inside the dictionary
     * @param key the key of the element that we want to search
     * @return the value associated to the key, if it's present. Null otherwise
     */
    V find(K key);

    /**
     * Associate the value of "value" to the key "key" in the dictionary
     * @param key key that we want to associate to the value
     * @param value value that we want to associate to the key
     * @return the previous value associated to the key, if any. Null otherwise
     */
    V add(K key, V value);

    /**
     * Remove a key from the dictionary, if it's present. Do nothing otherwise
     * @param key key that we want to remove
     */
    void remove(K key);
}
