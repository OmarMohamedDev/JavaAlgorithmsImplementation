package mohamed.bellmanford;

import mohamed.graphs.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleSupplier;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;

/**
 * @author Omar Mohamed
 */
public class MinPathBellmanFord <V, E extends DoubleSupplier>{

    /**
     * Returns the list of vertices on the minimum path between the
     * source "s" and the destination "d".
     * Returns null if a minimum path between "s" and "d" doesn't exists.
     * @author Omar Mohamed
     */
    public List<V> minPath(Graph<V,E> graph, V source, V dest) {
        if(graph == null || !graph.getVertices().contains(source) || !graph.getVertices().contains(dest)) return null;


        ((Vertex)source).minDistance = 0.;
        ArrayList<V> ALVertices = (ArrayList<V>)graph.getVertices();

        for(int i=0;i<= ALVertices.size() ; i++)
        {
            // Visit each edge exiting u
            for (Edge e : ((Vertex)ALVertices.get(i)).adjacencies)
            {
                Vertex u = (Vertex)ALVertices.get(i);
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                }
            }
        }


        List<V> path = new ArrayList<V>();
        for (Vertex vertex = (Vertex)dest; vertex != null; vertex = vertex.previous)
            path.add((V)vertex);
        Collections.reverse(path);
        return path;

    }


}
