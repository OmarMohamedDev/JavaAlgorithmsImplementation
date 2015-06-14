package mohamed.bellmanford;

import mohamed.graphs.Graph;

import java.util.*;
import java.util.function.DoubleSupplier;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;

/**
 * @author Omar Mohamed
 */
public class MinPathBellmanFord <V, E extends DoubleSupplier>{

    /**
     * List that have to be returned with the nodes of the shortest path
     */
    List<V> path;

    /**
     * Returns the list of vertices on the shortest path between a source
     * "source" and a destination "dest". The algorithm returns the empty
     * list if the shortest path between "source" and "dest" doesn't exits
     * @param graph graph where we want to apply the dijkstra algorithm
     * @param source starting vertex of the path
     * @param dest ending vertex of the path
     * @return the list of vertices of the shortest path if exists, an empty list otherwise
     */
    public List<V> minPath(Graph<V, E> graph, V source, V dest) {

        path = new ArrayList<V>();
        int n = graph.getVertices().size();

        ArrayList<V> vertex = (ArrayList<V>)graph.getVertices();

        ((Vertex)source).previous = (Vertex)source;
        ((Vertex)source).minDistance = 0.0;
        //Adding the source in the final list
        path.add(source);

        for(int i=0;i<=n;i++){
            for(V u :vertex){
                for(Edge e : ((Vertex)u).adjacencies){
                    double weight = ((Edge)e).getAsDouble();
                    V v = (V)((Edge)e).getTarget();
                    double distanceThroughU = ((Vertex)u).minDistance + weight;
                    if(distanceThroughU<((Vertex)v).minDistance){
                        ((Vertex)v).minDistance = distanceThroughU ;
                        ((Vertex)v).previous = (Vertex)u;
                        //Adding elements in the final list
                        path.add(v);
                    }
                }
            }
        }


        return path;
    }


}
