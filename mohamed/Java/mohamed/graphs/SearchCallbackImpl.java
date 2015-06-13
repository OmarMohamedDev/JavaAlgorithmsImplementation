package mohamed.graphs;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;

/**
 * @author Omar Mohamed
 */
public class SearchCallbackImpl implements SearchCallback<Vertex, Edge> {
    public void onVisitingVertex(Vertex vertex) {
        if(vertex!=null)
             System.out.print("["+vertex.toString()+"]");
    }

    public void onTraversingEdge(Vertex source, Vertex dest, Edge info) {
        System.out.print("["+source.toString()+"]*"+info.getAsDouble()+"*["+dest.toString()+"]");
    }
}
