package mohamed.graphs;

import mohamed.graphs.*;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/** 
* DepthFirstSearch Tester. 
* 
* @author Omar Mohamed
*/ 
public class DepthFirstSearchTest {

    private final ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();

    public DepthFirstSearchTest() {
    }

    @Before
    public void setupOutputStreams() {
        System.setOut(new PrintStream(outBuffer));
    }

    @After
    public void cleanUpOtputStreams() {
        System.setOut(null);
    }

    /**
     * Test of search method, of class DepthFirstSearch.
     */
    @Test
    public void testSearchNoVertex() {
        SparseGraph graph = new SparseGraph();
        SearchCallbackImpl sci = new SearchCallbackImpl();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.search((Graph)graph, null , sci);

    }

    @Test
    public void testSearchOneVertexNoEdges() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");

        String source = "A";

        SearchCallbackImpl sci = new SearchCallbackImpl();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.search((Graph)graph, source , sci);
        assertEquals("[A]", outBuffer.toString());
    }

    @Test
    public void testSearchTwoVertecesNoEdges() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        String source = "A";

        SearchCallbackImpl sci = new SearchCallbackImpl();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.search((Graph)graph, source , sci);
        assertEquals("[A]", outBuffer.toString());
    }

    @Test
    public void testSearchTwoVertecesOneEdge() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        graph.addEdge("A", "B", 0.0);

        SearchCallbackImpl sci = new SearchCallbackImpl();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.search((Graph)graph, "A" , sci);
        assertEquals("[A][B]", outBuffer.toString());
    }


    @Test
    public void testSearchOneVertexOneEdge() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");

        graph.addEdge("A", "A", 0.0);

        SearchCallbackImpl sci = new SearchCallbackImpl();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.search((Graph)graph, "A" , sci);
        assertEquals("[A]", outBuffer.toString());
    }

    @Test
    public void testSearchFourEdges() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 0.0);
        graph.addEdge("A", "C", 0.0);
        graph.addEdge("A", "D", 0.0);
        graph.addEdge("B", "E", 0.0);

        String source = "A";

        SearchCallbackImpl sci = new SearchCallbackImpl();

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.search((Graph)graph, source , sci);
        assertEquals("[A][B][E][C][D]", outBuffer.toString());

    }
} 
