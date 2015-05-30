package mohamed.graphs;

/**
 * @author Omar Mohamed
 */
public interface GraphSearch<V, E> {

    void search(Graph<V, E> graph, V source, SearchCallback<V,E> callback);
}
