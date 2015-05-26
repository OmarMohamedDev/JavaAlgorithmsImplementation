package mohamed.dictionary;

/**
 * @author Omar Mohamed
 */
public class AVLTree implements SortedDictionary<Integer,Integer> {

    /**
     * Root of the tree
     */
    private Node root;

    /**
     * Public constructor that set the root to null
     */
    public AVLTree(){
        this.root = null;
    }

    /**
     * Public constructor that permit to initialize the root of the tree
     * @param root
     */
    public AVLTree(Node root){
        this.root = root;
    }

    /**
     * Returns the minimun key in the sorted dictionary
     *
     * @return the minimum key
     */
    public Integer minKey() {
        return null;
    }

    /**
     * Returns the maximum key in the sorted dictionary
     *
     * @return the maximum key
     */
    public Integer maxKey() {
        return null;
    }

    /**
     * Returns the element with minimun key in the sorted dictionary
     *
     * @return the element associated with the minimum key
     */
    public Integer ElementOfMinKey() {
        return null;
    }

    /**
     * Returns the element with maximum key in the sorted dictionary
     *
     * @return the element associated with the maxixum key
     */
    public Integer ElementOfMaxKey() {
        return null;
    }

    /**
     * Check if the dictionary is empty or not
     *
     * @return true if the dictionary is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Search an element with a specified key inside the dictionary
     *
     * @param key the key of the element that we want to search
     * @return the value associated to the key, if it's present. Null otherwise
     */
    public Integer find(Integer key) {
        return root == null ? null : root.find(key);
    }

    /**
     * Associate the value of "value" to the key "key" in the dictionary
     *
     * @param key   key that we want to associate to the value
     * @param value value that we want to associate to the key
     * @return the previous value associated to the key, if any. Null otherwise
     */
    public Integer add(Integer key, Integer value) {
        if(root == null){
            root = new Node(key, value);
            return null;
        }
        else
            return root.add(key, value);
    }

    /**
     * Remove a key from the dictionary, if it's present. Do nothing otherwise
     *
     * @param key key that we want to remove
     */
    public void remove(Integer key) {
        root = remove(key, root);
    }

    /**
     * Auxiliary method that returns the node with the minimum value in the tree
     * @return the node with the minimum value int the tree
     */
    protected static Node minValue(Node node){
        while(node.left != null) node = node.left;
        return node;
    }

    /**
     * Auxiliary method used to delete the minimum value inside the tree
     * @param node current node that we are checking
     * @return root of the tree without the minimum element
     */
    protected static Node deleteMinValue(Node node){
        if(node.left == null) return node.right;
        node.left = deleteMinValue(node.left);
        return node;
    }

    /**
     * Internal method that implements the remove inside the tree
     * @param key key of the element that we want to remove
     * @param node root of the tree where we want to operate
     * @return the root of the tree without the node with key "key", if was present
     */
    protected static Node remove(int key, Node node){
        if(node == null) return null;
        int nodeKey = node.getKey();
        if(key < nodeKey) node.left = remove(key, node.left);
        else if(key > nodeKey) node.right = remove(key, node.right);
        else{
            if(node.left == null) node = node.right;
            else if(node.right == null) node = node.left;
            else{
                Node minimumNode = minValue(node.right);
                node.value = minimumNode.getValue();
                node.key = minimumNode.getKey();
                node.right = deleteMinValue(node.right);
            }
        }
        return node;
    }



    /**
     * Inner class that represent the nodes of the tree
     */
    private class Node {

        Node left;
        Node right;
        Integer value;
        Integer key;
        int height;

        Node() {
            key = null;
            value = null;
            left = right = null;
            int height = 0;
        }

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Integer getKey(){
            return key;
        }

        Integer getValue(){
            return value;
        }

        /**
         * Return the height of a node
         * @return height of the node
         */
        int height(){
            return height;
        }

        /**
         * Recursive method that search in the tree an element with key "key"
         * @param key the key of the element that we are looking for
         * @return the value of the element with key "key", if present. Null otherwise
         */
        Integer find(Integer key){
            int thisKey = getKey();
            if(key < thisKey) return left == null ? null : left.find(key);
            else if(key > thisKey) return right == null ? null : right.find(key);
            else return value;
        }

        /**
         * Associate the value of "value" to the key "key" in the dictionary
         *
         * @param key   key that we want to associate to the value
         * @param value value that we want to associate to the key
         * @return the previous value associated to the key, if any. Null otherwise
         */
        Integer add(Integer key, Integer value){
            int thisKey = getKey();
            Integer oldValue = null;

            if(key < thisKey) {
                if (left == null){
                    left = new Node(key, value);
                    return oldValue;
                }
                else
                    return left.add(key, value);
            }
            else if(key > thisKey){
                if (right == null){
                    right = new Node(key, value);
                    return oldValue;
                }
                else
                    return right.add(key, value);
            }
            else{
                oldValue = this.getValue();
                this.value = value;
                return oldValue;
            }
        }


    }
}
