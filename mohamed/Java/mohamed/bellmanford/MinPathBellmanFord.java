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

    ArrayList<V> path;
    int n;

    public List<V> minPath(Graph<V, E> graph, V source, V dest) {

        path = new ArrayList<V>();
        n = graph.getVertices().size();

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
