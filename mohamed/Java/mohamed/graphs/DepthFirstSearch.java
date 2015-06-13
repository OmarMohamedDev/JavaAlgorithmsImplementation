package mohamed.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;

/**
 * @author Omar Mohamed
 */
public class DepthFirstSearch implements GraphSearch<Vertex, Edge> {

    private HashMap hMIndex;
    private HashMap hMVisited;
    private HashMap hMFather;

    /**
     * Depth-first visit of graph starting from the vertex passed as source
     *
     * @param graph graph where we want to use the search
     * @param source starting vertex of the visit
     * @param callback  object that analyse vertices and edges during the visit
     */
    public void search(Graph<Vertex, Edge> graph, Vertex source, SearchCallback<Vertex, Edge> callback) {
        graph.hasVertex(source);
        ArrayList<Vertex> ALVertices = (ArrayList<Vertex>)graph.getVertices();
        hMIndex = new HashMap();
        hMVisited = new HashMap();
        hMFather = new HashMap();

        for (Iterator<Vertex> it = ALVertices.iterator(); it.hasNext();) {
            Vertex temp = it.next();
            hMIndex.put(temp, ALVertices.indexOf((Vertex)temp));
            hMVisited.put(temp, false);
            hMFather.put(temp, null);
        }
        callback.onVisitingVertex(source);
        for(Vertex vertex:ALVertices){
            if(!(Boolean)hMVisited.get(vertex))
                recursiveVisit( graph,  vertex, callback);
        }
    }

    /**
     * Auxiliary method, make recursively the visit of the vertices adjacent to "vertex",
     * implementing effectively the depth-first visit
     *
     * @param graph graph where we want to use the search
     * @param vertex starting vertex of the visit
     * @param callback  object that analyse vertices and edges during the visit
     */
    private void recursiveVisit(Graph graph, Vertex vertex, SearchCallback<Vertex, Edge> callback){
        ArrayList<Vertex> neighbors = (ArrayList<Vertex>)graph.getNeighbours(vertex);
        if(neighbors == null) return;
        hMVisited.put(vertex,true);
        for(Vertex neighbor: neighbors){
            if(!(Boolean)hMVisited.get(neighbor)){
                callback.onVisitingVertex(neighbor);
                hMFather.put(neighbor, vertex);
                recursiveVisit(graph,neighbor, callback);
            }
        }
    }
}
