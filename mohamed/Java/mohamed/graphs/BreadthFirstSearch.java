package mohamed.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Omar Mohamed
 */
public class BreadthFirstSearch implements GraphSearch<String,Double> {

    private HashMap hMIndex;
    private HashMap hMVisited;
    private HashMap hMFather;
    private LinkedList q;


    /**
     * Breadth-first visit of graph starting from the vertex passed as source
     *
     * @param graph graph where we want to use the search
     * @param source starting vertex of the visit
     * @param callback  object that analyse vertices and edges during the visit
     */
    public void search(Graph<String, Double> graph, String source, SearchCallback<String, Double> callback) {
        graph.hasVertex(source);
        q = new LinkedList();
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
        hMFather.put(source, source);

        for(String vertex: ALVertices)
            if(!(Boolean)hMVisited.get(vertex)) recursiveSearch(graph, vertex, callback);
    }

    /**
     * Auxiliary method, make recursively the visit of the vertices adjacent to "vertex",
     * implementing effectively the breadth-first visit
     *
     * @param graph graph where we want to use the search
     * @param source starting vertex of the visit
     * @param callback  object that analyse vertices and edges during the visit
     */
    private void recursiveSearch(Graph<String, Double> graph, String source, SearchCallback<String, Double> callback){

        q.add(source);
        hMVisited.put(source, true);
        callback.onVisitingVertex(source);
        while(!q.isEmpty()){
            String node = (String)q.removeFirst();
            hMVisited.put(node,true);//fine visita di node.
            ArrayList<String> neighbors = (ArrayList<String>)graph.getNeighbours(node);
            if(neighbors!=null)
                for (String neighbor : neighbors) {
                    if(!(Boolean)hMVisited.get(neighbor)){
                        hMVisited.put(neighbor,true);
                        hMFather.put(neighbor, node);
                        callback.onVisitingVertex(neighbor);
                        q.add(neighbor);
                    }
                }
        }
    }
}
