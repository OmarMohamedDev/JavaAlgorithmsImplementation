package mohamed.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.DoubleSupplier;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;

/**
 * @author Omar Mohamed
 */
public class SparseGraph implements Graph<Vertex, Edge> {

    private final ArrayList<ArrayList> graph = new ArrayList<ArrayList>(0);
    private final HashMap<Vertex, Integer> hMIndex = new HashMap<Vertex, Integer>();
    private final HashMap<Vertex, Integer> hMDegree = new HashMap<Vertex, Integer>();

    /**
     * Add the vertex "Vertex" to the graph if the vertex is not
     * already present.
     *
     * @param vertex the vertex that we want to add
     * @return true if the vertex is successfully added, false otherwise
     */
    public boolean addVertex(Vertex vertex) {
        if(!hasVertex(vertex)){
            ArrayList<Vertex> newVertex = new ArrayList<Vertex>(1);
            newVertex.add(vertex);
            graph.add(newVertex);
            int indexOfVertex = graph.indexOf(newVertex);
            hMIndex.put(vertex, indexOfVertex);
            hMDegree.put(vertex, 0);

            return true;
        }
        return false;
    }

    /**
     * Add the edge (vertex1, vertex2) to the graph if the edge
     * is not already there.
     *
     * @param vertex1 First extremity of the edge
     * @param vertex2 Second extremity of the edge
     * @param data    data assigned to the edge
     * @return true if the edge is successfully added, false otherwise
     */
    public boolean addEdge(Vertex vertex1, Vertex vertex2, Edge data) {
        if(!hasEdge(vertex1, vertex2)){
            for (ArrayList aL : graph){
                if (((Vertex)aL.get(0)).compareVertices(vertex1)){
                    //Adding effectively the edge, updating the data in the vertices
                    ((Vertex) aL.get(0)).adjacencies.add(data);
                    ((Vertex) vertex2).adjacencies.add(data);
                    //adding vertex2 to the ArrayList containing vertex1 as first vertex
                    aL.add(vertex2);
                    //updating the degree of vertex1
                    hMDegree.put(vertex1, hMDegree.get(vertex1)+1);

                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the vertex is present or not in a graph
     *
     * @param vertex vertex that we want to look for
     * @return true if the vertex is part of the graph, false otherwise
     */
    public boolean hasVertex(Vertex vertex) {
        if(vertex==null) return false;
        for (ArrayList aL : graph){
            if (((Vertex)aL.get(0)).compareVertices(vertex)) return true;
        }
        return false;
    }

    /**
     * Check if the edge is present or not in a graph
     *
     * @param vertex1 First extremity of the edge
     * @param vertex2 Second extremity of the edge
     * @return true if the edge is part of the graph, false otherwise
     */
    public boolean hasEdge(Vertex vertex1, Vertex vertex2) {
        if(!hasVertex(vertex1)||!hasVertex(vertex2)) return false;
        else{
            Integer index = hMIndex.get(vertex1);
            Integer degree = hMDegree.get(vertex1);
            for(int i=0; i<=degree;i++){
                if(((Vertex)graph.get(index).get(i)).compareVertices(vertex2)) return true;
            }
        }
        return false;
    }

    /**
     * Check the data associated to the edge
     *
     * @param vertex1 First extremity of the edge
     * @param vertex2 Second extremity of the edge
     * @return the data associated to the edge (Vertex1, vertex2), null otherwise
     */
    public Edge getData(Vertex vertex1, Vertex vertex2) {
        if(!hasVertex(vertex1)||!hasVertex(vertex2)) return null;
        else{
            Integer index = hMIndex.get(vertex1);
            Integer degree = hMDegree.get(vertex1);
            for(int i=0; i<=degree;i++){
                if(((Vertex)graph.get(index).get(i)).compareVertices(vertex2))
                    //The index of the edge in the adjacencies arraylist will be the same
                    //of the index of the second vertex in the list related of the first vertex
                    //just because, everytime we add an edge, we insert a vertex in the main arraylist
                    //and the edge in the adiacent arraylist, so it will be ordered
                    return ((Vertex)graph.get(index).get(i)).adjacencies.get(index);
            }
        }
        return null;
    }

    /**
     * Return a list of the vertices of the graph
     *
     * @return a list of the vertices of the graph
     */
    public Collection<Vertex> getVertices() {
        ArrayList<Vertex> vertexes= new ArrayList<Vertex>(0);
        for (ArrayList edges : graph)
            vertexes.add((Vertex)((Vertex)edges.get(0)));
        return vertexes;
    }

    /**
     * Return the adjacent list of the vertex "vertex"
     *
     * @param vertex the vertex of the adjacent list that we want to obtain
     * @return the adjacent list of the vertex "vertex", null if vertex is not part of the graph
     */
    public Collection<Vertex> getNeighbours(Vertex vertex) {
        if(!hasVertex(vertex)) return null;
        else{
            ArrayList<Vertex> neighbors = new ArrayList<Vertex>(1);
            Integer index = hMIndex.get(vertex);
            Integer degree = hMDegree.get(vertex);
            if(degree<1) return null;
            for(int i=1; i<=degree;i++)
                neighbors.add((Vertex)((Vertex)graph.get(index).get(i)));
            return neighbors;
        }
    }
    

    /**
     * Class that represent a vertex
     */
    public static class Vertex implements Comparable<Vertex>
    {

        public final String name;
        public ArrayList<Edge> adjacencies;
        public double minDistance = Double.POSITIVE_INFINITY;
        public Vertex previous;

        public Vertex(String argName) {
            name = argName;
            adjacencies = new ArrayList<Edge>();
        }


        public String toString() {
            return name;
        }

        /**
         * Compares distances between vertices
         * @param other the other vertex to compare
         * @return  0 if d1 is numerically equal to d2;
         * a value less than 0 if d1 is numerically less than d2;
         * and a value greater than 0 if d1 is numerically greater than d2.
         */
        public int compareTo(Vertex other)
        {
            return Double.compare(minDistance, other.minDistance);
        }
        public boolean compareVertices(Vertex other){
            return name.equals(other.name);
        }
    }

    /**
     * Class that represent an edge
     */
    public static class Edge implements DoubleSupplier
    {
        public final Vertex target;
        public final double weight;

        public Edge(Vertex argTarget, double argWeight)
        { target = argTarget; weight = argWeight; }

        public double getAsDouble() {
            return weight;
        }

        public Vertex getTarget(){
            return target;
        }
    }

}
