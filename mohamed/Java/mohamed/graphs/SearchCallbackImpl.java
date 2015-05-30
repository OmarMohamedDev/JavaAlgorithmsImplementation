package mohamed.graphs;

/**
 * @author Omar Mohamed
 */
public class SearchCallbackImpl implements SearchCallback<String, Double> {
    public void onVisitingVertex(String vertex) {
        System.out.print("["+vertex+"]");
    }

    public void onTraversingEdge(String source, String dest, Double info) {
        System.out.print("["+source+"]*"+info+"*["+dest+"]");
    }
}
