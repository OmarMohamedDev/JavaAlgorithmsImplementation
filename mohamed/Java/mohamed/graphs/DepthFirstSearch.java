package mohamed.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Omar Mohamed
 */
public class DepthFirstSearch implements GraphSearch<String, Double> {

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
    public void search(Graph<String, Double> graph, String source, SearchCallback<String, Double> callback) {
        graph.hasVertex(source);
        ArrayList<String> ALVertices = (ArrayList<String>)graph.getVertices();
        hMIndex = new HashMap();
        hMVisited = new HashMap();
        hMFather = new HashMap();

        for (Iterator<String> it = ALVertices.iterator(); it.hasNext();) {
            String temp = it.next();
            hMIndex.put(temp, ALVertices.indexOf((String)temp));
            hMVisited.put(temp, false);
            hMFather.put(temp, null);
        }
        callback.onVisitingVertex(source);
        for(String vertex:ALVertices){
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
    private void recursiveVisit(Graph graph, String vertex, SearchCallback<String, Double> callback){
        ArrayList<String> neighbors = (ArrayList<String>)graph.getNeighbours(vertex);
        if(neighbors == null) return;
        hMVisited.put(vertex,true);
        for(String neighbor: neighbors){
            if(!(Boolean)hMVisited.get(neighbor)){
                callback.onVisitingVertex(neighbor);
                hMFather.put(neighbor, vertex);
                recursiveVisit(graph,neighbor, callback);
            }
        }
    }
}
