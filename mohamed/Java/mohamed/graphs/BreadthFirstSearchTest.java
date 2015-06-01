package mohamed.graphs;

import mohamed.graphs.BreadthFirstSearch;
import mohamed.graphs.Graph;
import mohamed.graphs.SearchCallbackImpl;
import mohamed.graphs.SparseGraph;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/** 
* BreadthFirstSearch Tester. 
* 
* @author Omar Mohamed
*/ 
public class BreadthFirstSearchTest {

    private final ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();

    public BreadthFirstSearchTest() {
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
     * Test of search method, of class BreadthFirstSearch.
     */
    @Test
    public void testSearchNoVertex() {
        SparseGraph graph = new SparseGraph();

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, null , sci);
    }

    @Test
    public void testSearchOneVertexNoEdges() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");

        String source = "A";

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, source , sci);
        assertEquals("[A]", outBuffer.toString());
    }

    @Test
    public void testSearchTwoVertecesNoEdges() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        String source = "A";

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, source , sci);
        assertEquals("[A][B]", outBuffer.toString());
    }

    @Test
    public void testSearchTwoVertecesOneEdge() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");
        graph.addVertex("B");

        graph.addEdge("A", "B", 0.0);

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, "A" , sci);
        assertEquals("[A][B]", outBuffer.toString());
    }


    @Test
    public void testSearchOneVertexOneEdge() {
        SparseGraph graph = new SparseGraph();
        graph.addVertex("A");
        graph.addEdge("A", "A", 0.0);
        SearchCallbackImpl sci = new SearchCallbackImpl();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, "A" , sci);
        assertEquals("[A]", outBuffer.toString());
    }



    @Test
    public void testSearchFourEdges() {
        SparseGraph graph = new SparseGraph();
        String source = "A";
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 0.0);
        graph.addEdge("A", "C", 0.0);
        graph.addEdge("A", "D", 0.0);
        graph.addEdge("B", "E", 0.0);



        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, source , sci);
        assertEquals("[A][B][C][D][E]", outBuffer.toString());

    }

    /**
     * Test of onVisitingVertex method, of class BreadthFirstSearch.
     */
    // @Test
    public void testAnalyseOneCall() {
        SearchCallbackImpl sci = new SearchCallbackImpl();
        sci.onVisitingVertex("A");

        assertEquals("[A]", outBuffer.toString());
    }

    public void testAnalyseMoreCalls() {
        SearchCallbackImpl sci = new SearchCallbackImpl();
        sci.onVisitingVertex("A");
        sci.onVisitingVertex("B");
        sci.onVisitingVertex("C");

        assertEquals("[A][B][C]", outBuffer.toString());
    }

} 