package mohamed.graphs;

import mohamed.graphs.*;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;
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
        bfs.search(graph, null, sci);

    }

    @Test
    public void testSearchOneVertexNoEdges() {
        SparseGraph graph = new SparseGraph();
        Vertex source = new Vertex("A");

        graph.addVertex(source);

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, source , sci);
        assertEquals("[A]", outBuffer.toString());
    }

    @Test
    public void testSearchTwoVertecesNoEdges() {
        SparseGraph graph = new SparseGraph();

        Vertex source = new Vertex("A");

        graph.addVertex(source);
        graph.addVertex(new Vertex("B"));


        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, source , sci);
        assertEquals("[A]", outBuffer.toString());
    }

    @Test
    public void testSearchTwoVertecesOneEdge() {
        SparseGraph graph = new SparseGraph();
        Vertex source = new Vertex("A");
        Vertex dest = new Vertex("B");

        graph.addVertex(source);
        graph.addVertex(dest);

        graph.addEdge(source,dest, new Edge(dest, 0.0));

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, source , sci);
        assertEquals("[A][B]", outBuffer.toString());
    }


    @Test
    public void testSearchOneVertexOneEdge() {
        SparseGraph graph = new SparseGraph();

        Vertex vertex = new Vertex("A");
        graph.addVertex(vertex);

        graph.addEdge(vertex,vertex, new Edge(vertex, 0.0));

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, vertex, sci);
        assertEquals("[A]", outBuffer.toString());
    }

    @Test
    public void testSearchFourEdges() {
        SparseGraph graph = new SparseGraph();

        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        graph.addVertex(vertex5);

        graph.addEdge(vertex1, vertex2, new Edge(vertex2, 0.0));
        graph.addEdge(vertex1, vertex3, new Edge(vertex3, 0.0));
        graph.addEdge(vertex1, vertex4, new Edge(vertex4, 0.0));
        graph.addEdge(vertex2, vertex5, new Edge(vertex5, 0.0));

        SearchCallbackImpl sci = new SearchCallbackImpl();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(graph, vertex1 , sci);
        assertEquals("[A][B][E][C][D]", outBuffer.toString());

    }
} 
