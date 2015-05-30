package mohamed.graphs;

/**
 * @author Omar Mohamed
 */
public interface SearchCallback<V, E> {

    void onVisitingVertex(V vertex);
    void onTraversingEdge(V source, V dest, E info);
}
