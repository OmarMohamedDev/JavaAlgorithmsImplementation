package mohamed.dijkstra;

import mohamed.graphs.Graph;
import mohamed.priorityqueue.PriorityQueueStringDoubleSimple;

import java.util.*;
import java.util.function.DoubleSupplier;

/**
 * @author Omar Mohamed
 */
public class MinPathDijkstra <V, E extends DoubleSupplier>{

    private HashMap hMIndex;
    private HashMap hMVisited;
    private HashMap hMFather;
    private PriorityQueueStringDoubleSimple priorityQueue;

    /**
     * Returns the list of vertices on the minimum path between a source
     * "source" and a destination "dest". The algorithm returns the empty
     * list if a minimum path between "source" and "dest" doesn't exits
     * @param graph graph where we want to apply the dijkstra algorithm
     * @param source starting vertex of the path
     * @param dest ending vertex of the path
     * @return the list of vertices of the minimum path if exists, null otherwise
     */
    public List<V> minPath(Graph<V, E> graph, V source, V dest) {

        //TO MODIFY
        graph.hasVertex(source);
        //Retrieving all the vertices values
        String[] vertices = (String[]) graph.getVertices().toArray();
        //Creating and initializing an array of double to the positive infinite
        Double[] distances = new Double[vertices.length];
        for(int i=0; i<distances.length;i++)
            distances[i] = Double.POSITIVE_INFINITY;

        priorityQueue = new PriorityQueueStringDoubleSimple(vertices, distances);
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
            if(!(Boolean)hMVisited.get(vertex)) recursiveMinPath(graph, vertex, dest);
        //

    }

    /**
     * Auxiliary method, implement effectively the dijkstra algorithm
     *
     * @param graph graph where we want to apply the dijkstra algorithm
     * @param source starting vertex of the path
     * @param dest ending vertex of the path
     */
    private void recursiveMinPath(Graph<V, E> graph, V source, V dest){

        priorityQueue.add(source);
        hMVisited.put(source, true);
        callback.onVisitingVertex(source);
        while(!priorityQueue.isEmpty()){
            String node = (String)priorityQueue.removeFirst();
            hMVisited.put(node,true);//end of the visit
            ArrayList<String> neighbors = (ArrayList<String>)graph.getNeighbours(node);
            if(neighbors!=null)
                for (String neighbor : neighbors) {
                    if(!(Boolean)hMVisited.get(neighbor)){
                        hMVisited.put(neighbor,true);
                        hMFather.put(neighbor, node);
                        callback.onVisitingVertex(neighbor);
                        priorityQueue.add(neighbor);
                    }
                }
        }
    }

    /**
     * Inner class used to represent a vertex and the data of a edge, if necessary
     */
    private class Node implements DoubleSupplier{
        String vertex;
        Double edgeData;

        Node(String vertex, Double edgeData){
            this.vertex = vertex;
            this.edgeData = edgeData;
        }

        public String getVertex() {
            return vertex;
        }

        /**
         * @return the data assigned to the edge
         */
        public double getAsDouble() {
            return edgeData;
        }
    }
}



