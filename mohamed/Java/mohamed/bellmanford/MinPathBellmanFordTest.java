package mohamed.bellmanford;

import mohamed.bellmanford.MinPathBellmanFord.Vertex;
import mohamed.bellmanford.MinPathBellmanFord.Edge;
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
* MinPathBellmanFord Tester. 
* 
* @author Omar Mohamed
*/ 
public class MinPathBellmanFordTest {
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
     * Tests for minPath method
     */
    @Test
    public void tesMinPathNoVertex() {
        SparseGraph graph = new SparseGraph();

        MinPathBellmanFord minPathBellmanFord= new MinPathBellmanFord();

        minPathBellmanFord.minPath(graph, new Vertex(""), new Vertex(""));
    }

    @Test
    public void testMinPathOneVertexNoEdges() {
        SparseGraph graph = new SparseGraph();

        String source = "A";
        graph.addVertex(source);

        MinPathBellmanFord minPathBellmanFord= new MinPathBellmanFord();

        assertNull(minPathBellmanFord.minPath(graph, new Vertex(source), null));
    }

    @Test
    public void testMinPathTwoVertecesNoEdges() {
        SparseGraph graph = new SparseGraph();
        String source = "A";

        graph.addVertex(source);
        graph.addVertex("B");

        MinPathBellmanFord minPathBellmanFord= new MinPathBellmanFord();

        assertNull(minPathBellmanFord.minPath(graph, new Vertex(source), null));
    }

    @Test
    public void testMinPathTwoVertecesOneEdge() {
        SparseGraph graph = new SparseGraph();
        String source = "A";
        String dest = "B";

        graph.addVertex(source);
        graph.addVertex(dest);

        graph.addEdge(source, dest, 0.0);

        MinPathBellmanFord minPathBellmanFord= new MinPathBellmanFord();
        List<MinPathBellmanFord.Vertex> minPathList = new ArrayList<MinPathBellmanFord.Vertex>();
        minPathList.add(new Vertex(source));
        minPathList.add(new Vertex(dest));

        assertEquals(minPathBellmanFord.minPath(graph, new Vertex(source), new Vertex(dest)), minPathList);
    }


    @Test
    public void testMinPathOneVertexOneEdge() {
        SparseGraph graph = new SparseGraph();
        String source = "A";
        graph.addVertex(source);
        graph.addEdge(source, source, 0.0);
        MinPathBellmanFord minPathBellmanFord= new MinPathBellmanFord();

        List<MinPathBellmanFord.Vertex> minPathList = new ArrayList<MinPathBellmanFord.Vertex>();
        minPathList.add(new Vertex(source));;

        assertEquals(minPathBellmanFord.minPath(graph, new Vertex(source), new Vertex(source)), minPathList);
    }



    @Test
    public void testMinPathFourEdges() {
        SparseGraph graph = new SparseGraph();
        String source = "A";
        String dest = "E";
        graph.addVertex(source);
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex(dest);

        graph.addEdge("A", "B", 1.0);
        graph.addEdge("A", "C", 1.5);
        graph.addEdge("A", "D", 2.0);
        graph.addEdge("B", "E", 0.5);



        MinPathBellmanFord minPathBellmanFord= new MinPathBellmanFord();

        List<MinPathBellmanFord.Vertex> minPathList = new ArrayList<MinPathBellmanFord.Vertex>();
        minPathList.add(new Vertex(source));
        minPathList.add(new Vertex("B"));
        minPathList.add(new Vertex(dest));

        assertEquals(minPathBellmanFord.minPath(graph, new Vertex(source), new Vertex(dest)), minPathList);
    }


} 
