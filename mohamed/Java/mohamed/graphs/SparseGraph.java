package mohamed.graphs;

import mohamed.binarysearch.IntSortedArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author Omar Mohamed
 */
public class SparseGraph implements Graph<String, Double> {

    private final ArrayList<ArrayList> graph = new ArrayList<ArrayList>(0);
    private final HashMap<String, Integer> hMIndex = new HashMap<String, Integer>();
    private final HashMap<String, Integer> hMDegree = new HashMap<String, Integer>();

    /**
     * Add the vertex "Vertex" to the graph if the vertex is not
     * already present.
     *
     * @param vertex the vertex that we want to add
     * @return true if the vertex is successfully added, false otherwise
     */
    public boolean addVertex(String vertex) {
        if(!hasVertex(vertex)){
            ArrayList<Node> newVertex = new ArrayList<Node>(1);
            newVertex.add(new Node(vertex, null));
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
    public boolean addEdge(String vertex1, String vertex2, Double data) {
        if(!hasEdge(vertex1, vertex2)){
            for (ArrayList aL : graph){
                if (((Node)aL.get(0)).getVertex().equals(vertex1)){
                    //adding vertex2 to the ArrayList containing vertex1 as first vertex
                    aL.add(new Node(vertex2,data));
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
    public boolean hasVertex(String vertex) {
        if(vertex==null) return false;
        for (ArrayList aL : graph){
            if (((Node)aL.get(0)).getVertex().equals(vertex)) return true;
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
    public boolean hasEdge(String vertex1, String vertex2) {
        if(!hasVertex(vertex1)||!hasVertex(vertex2)) return false;
        else{
            Integer index = hMIndex.get(vertex1);
            Integer degree = hMDegree.get(vertex1);
            for(int i=0; i<=degree;i++){
                if(((Node)graph.get(index).get(i)).getVertex().equals(vertex2)) return true;
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
    public Double getData(String vertex1, String vertex2) {
        if(!hasVertex(vertex1)||!hasVertex(vertex2)) return null;
        else{
            Integer index = hMIndex.get(vertex1);
            Integer degree = hMDegree.get(vertex1);
            for(int i=0; i<=degree;i++){
                if(((Node)graph.get(index).get(i)).getVertex().equals(vertex2))
                    return ((Node)graph.get(index).get(i)).getEdgeData();
            }
        }
        return null;
    }

    /**
     * Return a list of the vertices of the graph
     *
     * @return a list of the vertices of the graph
     */
    public Collection<String> getVertices() {
        ArrayList<String> vertexes= new ArrayList<String>(0);
        for (ArrayList edges : graph)
            vertexes.add((String)((Node)edges.get(0)).getVertex());
        return vertexes;
    }

    /**
     * Return the adjacent list of the vertex "vertex"
     *
     * @param vertex the vertex of the adjacent list that we want to obtain
     * @return the adjacent list of the vertex "vertex", null if vertex is not part of the graph
     */
    public Collection<String> getNeighbours(String vertex) {
        if(!hasVertex(vertex)) return null;
        else{
            ArrayList<String> neighbors = new ArrayList<String>(1);
            Integer index = hMIndex.get(vertex);
            Integer degree = hMDegree.get(vertex);
            if(degree<1) return null;
            for(int i=1; i<=degree;i++)
                neighbors.add((String)((Node)graph.get(index).get(i)).getVertex());
            return neighbors;
        }
    }

    /**
     * Inner class used to represent a vertex and the data of a edge, if necessary
     */
    private class Node{
        String vertex;
        Double edgeData;

        Node(String vertex, Double edgeData){
            this.vertex = vertex;
            this.edgeData = edgeData;
        }

        public String getVertex() {
            return vertex;
        }

        public void setVertex(String vertex) {
            this.vertex = vertex;
        }

        public Double getEdgeData() {
            return edgeData;
        }

        public void setEdgeData(Double edgeData) {
            this.edgeData = edgeData;
        }
    }

}
