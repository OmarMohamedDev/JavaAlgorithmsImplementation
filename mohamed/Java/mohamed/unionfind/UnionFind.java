package mohamed.unionfind;

/**
 * @author Omar Mohamed
 */
public class UnionFind {

    int[] parentOrMinusSize;
    int capacity;
    /**
     * The constructor create the data structure and set his capacity to n
     * @param n capacity of the data structure
     */
    UnionFind(int n){
        capacity = n;
        parentOrMinusSize = new int[capacity];
        //Initializing the array to -1
        for(int i = 0; i < capacity; i++)
            parentOrMinusSize[i] = -1;
    }

    /**
     * Return the capacity of the data structure
     * @return the capacity of the union find data structure
     */
    int getCapacity(){
        return capacity;
    }

    /**
     * Change the capacity of the union find data structure
     * @param newN new capacity
     * @throws IllegalArgumentException
     */
    void setCapacity(int newN) throws IllegalArgumentException {
        //If the new capacity is greater than the oldest one, resize the array
        if(newN > capacity) {
            int[] tempArray = new int[newN];

            for(int i=0;i<capacity;i++)
                tempArray[i] = parentOrMinusSize[i];

            parentOrMinusSize = tempArray;
        }
    }

    /**
     * Returns the representative of the set where the element e is present
     * @param e element of the set where we are searching the representative
     * @return the representative of the set that contains the element e
     */
    int find(int e){
        if(parentOrMinusSize[e] < 0) return e; //root
        else {
            parentOrMinusSize[e]= find(parentOrMinusSize[e]);
            return parentOrMinusSize[e];
        }
    }


    /**
     * Kruskal-Union
     * Unites the set that contains the element a and the
     * set that contains the element b. If a or b are part of
     * the same set, returns false and do nothing, unites the sets
     * returns true otherwise.
     *
     * @param a element of a set
     * @param b element of a set
     * @return true if a and b are part of different sets. False otherwise.
     */
    boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);
        if(root1 == root2) return false;
        if(parentOrMinusSize[root2] < parentOrMinusSize[root1]) {
            for(int i =0; i<capacity;i++){
                //Chaning the root of all the nodes
                if(parentOrMinusSize[i]==parentOrMinusSize[root2])
                    parentOrMinusSize[root2] = parentOrMinusSize[root1];
            }
            //Chaning the size of the root
            parentOrMinusSize[root1] += parentOrMinusSize[root2];
        }
        else {
            for(int i =0; i<capacity;i++){
                if(parentOrMinusSize[i]==parentOrMinusSize[root1])
                    parentOrMinusSize[root1] = parentOrMinusSize[root2];
            }
            parentOrMinusSize[root2] += parentOrMinusSize[root1];
        }
        return true;
    }

}