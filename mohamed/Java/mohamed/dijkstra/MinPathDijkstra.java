package mohamed.dijkstra;

import mohamed.graphs.Graph;

import java.util.*;
import java.util.function.DoubleSupplier;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;

/**
 *
 * @author Omar Mohamed
 */
public class MinPathDijkstra <V, E extends DoubleSupplier>{


    /**
     * Returns the list of vertices on the shortest path between a source
     * "source" and a destination "dest". The algorithm returns the empty
     * list if the shortest path between "source" and "dest" doesn't exits
     * @param graph graph where we want to apply the dijkstra algorithm
     * @param source starting vertex of the path
     * @param dest ending vertex of the path
     * @return the list of vertices of the shortest path if exists, null otherwise
     */
    public List<V> minPath(Graph<V, E> graph, V source, V dest) {
        if(graph == null || source == null || dest == null || !graph.hasVertex(source)|| !graph.hasVertex(dest)) return null;

        //Shortest path list that we have to return
        List<V> path = new ArrayList<V>();

        ((Vertex)source).minDistance = 0.0;

        PriorityQueue<V> vertexQueue = new PriorityQueue<V>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = (Vertex)vertexQueue.poll();
            //The vertex is black and the distance is definitive, adding the vertex in the final list that we have to return
            path.add((V) u);

            //Checking if u is the destination vertex. If it is, we just exit the loop and return the list
            if(u.compareVertices((Vertex)dest))
                break;

            for (Edge e : u.adjacencies)
            {
                double weight = ((Edge)e).getAsDouble();
                Vertex v = ((Edge)e).getTarget();
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add((V)v);
                }
            }
        }

        return path;

    }

}



