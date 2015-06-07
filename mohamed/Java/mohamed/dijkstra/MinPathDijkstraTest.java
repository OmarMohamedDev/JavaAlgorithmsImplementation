package mohamed.dijkstra;

import mohamed.dijkstra.MinPathDijkstra.Vertex;
import mohamed.dijkstra.MinPathDijkstra.Edge;
import mohamed.graphs.SparseGraph;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/** 
* MinPathDijkstra Tester. 
* 
* @author Omar Mohamed
*/ 
public class MinPathDijkstraTest {
    private final ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();

    @Before
    public void setupOutputStreams() {
        System.setOut(new PrintStream(outBuffer));
    }

    @After
    public void cleanUpOtputStreams() {
        System.setOut(null);
    }


    /**
     * Test for minPath method
     */
    @Test
    public void tesMinPathNoVertex() {
        SparseGraph graph = new SparseGraph();

        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

        minPathDijkstra.minPath(graph, new Vertex(""), new Vertex(""));
    }

    @Test
    public void testMinPathOneVertexNoEdges() {
        SparseGraph graph = new SparseGraph();

        String source = "A";
        graph.addVertex(source);

        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

        assertNull(minPathDijkstra.minPath(graph, new Vertex(source), null));
    }

    @Test
    public void testMinPathTwoVertecesNoEdges() {
        SparseGraph graph = new SparseGraph();
        String source = "A";

        graph.addVertex(source);
        graph.addVertex("B");

        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

        assertNull(minPathDijkstra.minPath(graph, new Vertex(source), null));
    }

    @Test
    public void testMinPathTwoVertecesOneEdge() {
        SparseGraph graph = new SparseGraph();
        String source = "A";
        String dest = "B";
        double data = 0.5;

        graph.addVertex(source);
        graph.addVertex(dest);

        graph.addEdge(source, dest, 0.5);

        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();
        List<Vertex> minPathList = new ArrayList<Vertex>();
        minPathList.add(new Vertex(source));
        minPathList.add(new Vertex(dest));

        Vertex vertex1 = new Vertex(source);
        Vertex vertex2 = new Vertex(dest);
        vertex1.adjacencies = new Edge[1];
        vertex1.adjacencies[0] = new Edge(vertex2, data);
        vertex2.adjacencies = new Edge[1];
        vertex2.adjacencies[0] = new Edge(vertex1, data);

        List<Vertex> listObtained = minPathDijkstra.minPath(graph, vertex1, vertex2);
        boolean result = false;
        int counter = 0;

        for (Vertex v1 : listObtained)
            for(Vertex v2 : minPathList)
                if(v1.name.equals(v2.name))
                    counter++;


        assertEquals(counter, listObtained.size());
    }


    @Test
    public void testMinPathOneVertexOneEdge() {
        SparseGraph graph = new SparseGraph();
        String source = "A";
        double data = 0.0;
        graph.addVertex(source);
        graph.addEdge(source, source, data);
        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

        List<Vertex> minPathList = new ArrayList<Vertex>();
        minPathList.add(new Vertex(source));

        Vertex vertex1 = new Vertex(source);
        vertex1.adjacencies = new Edge[1];
        vertex1.adjacencies[0] = new Edge(vertex1, data);

        assertNull(minPathDijkstra.minPath(graph, vertex1, null));
    }


} 
