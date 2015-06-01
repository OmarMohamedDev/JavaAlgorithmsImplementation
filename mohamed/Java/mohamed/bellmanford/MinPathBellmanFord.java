package mohamed.bellmanford;

import mohamed.graphs.Graph;

import java.util.List;
import java.util.function.DoubleSupplier;

/**
 * Returns the list of vertices on the minimum path between the
 * source "s" and the destination "d".
 * Returns null if a minimum path between "s" and "d" doesn't exists.
 * @author Omar Mohamed
 */
public class MinPathBellmanFord <V, E extends DoubleSupplier>{
    public List<V> minPath(Graph<V,E> graph, V source, V dest) {

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
