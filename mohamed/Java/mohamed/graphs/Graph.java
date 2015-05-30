package mohamed.graphs;

import java.util.Collection;

/**
 * @author Omar Mohamed.
 */
public interface Graph<V,E> {

    /**
     * Add the vertex "Vertex" to the graph if the vertex is not
     * already present.
     * @param vertex the vertex that we want to add
     * @return true if the vertex is successfully added, false otherwise
     */
    boolean addVertex(V vertex);

    /**
     * Add the edge (vertex1, vertex2) to the graph if the edge
     * is not already there.
     * @param vertex1 First extremity of the edge
     * @param vertex2 Second extremity of the edge
     * @param data data assigned to the edge
     * @return true if the edge is successfully added, false otherwise
     */
    boolean addEdge(V vertex1, V vertex2, E data);

    /**
     * Check if the vertex is present or not in a graph
     * @param vertex vertex that we want to look for
     * @return true if the vertex is part of the graph, false otherwise
     */
    boolean hasVertex(V vertex);

    /**
     * Check if the edge is present or not in a graph
     * @param vertex1 First extremity of the edge
     * @param vertex2 Second extremity of the edge
     * @return true if the edge is part of the graph, false otherwise
     */
    boolean hasEdge(V vertex1, V vertex2);

    /**
     * Check the data associated to the edge
     * @param vertex1 First extremity of the edge
     * @param vertex2 Second extremity of the edge
     * @return the data associated to the edge (Vertex1, vertex2)
     */
    E getData(V vertex1, V vertex2);

    /**
     * Return a list of the vertices of the graph
     * @return a list of the vertices of the graph
     */
    Collection<V> getVertices();

    /**
     * Return the adjacent list of the vertex "vertex"
     * @param vertex the vertex of the adjacent list that we want to obtain
     * @return the adjacent list of the vertex "vertex"
     */
    Collection<V> getNeighbours (V vertex);

}
