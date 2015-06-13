package mohamed.dijkstra;

import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;
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

        Vertex source = new Vertex("A");
        graph.addVertex(source);

        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

        assertNull(minPathDijkstra.minPath(graph, source, null));
    }

    @Test
    public void testMinPathTwoVertecesNoEdges() {
        SparseGraph graph = new SparseGraph();
        Vertex source = new Vertex("A");
        Vertex dest = new Vertex("B");

        graph.addVertex(source);
        graph.addVertex(dest);

        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

        assertNull(minPathDijkstra.minPath(graph, source, null));
    }

    @Test
    public void testMinPathTwoVertecesOneEdge() {
        SparseGraph graph = new SparseGraph();
        Vertex source = new Vertex("A");
        Vertex dest = new Vertex("B");

        graph.addVertex(source);
        graph.addVertex(dest);

        graph.addEdge(source, dest, new Edge(dest, 0.5));

        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();
        List<Vertex> minPathList = new ArrayList<Vertex>();
        minPathList.add(source);
        minPathList.add(dest);

        List<Vertex> listObtained = minPathDijkstra.minPath(graph, source, dest);

        int counter = 0;

        for (Vertex v1 : listObtained)
            for(Vertex v2 : minPathList)
                if(v1.compareVertices(v2))
                    counter++;

        assertEquals(counter, listObtained.size());
    }


    @Test
    public void testMinPathOneVertexOneEdge() {
        SparseGraph graph = new SparseGraph();
        Vertex source = new Vertex("A");
        graph.addVertex(source);
        graph.addEdge(source, source, new Edge(source, 0.0));
        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

        List<Vertex> minPathList = new ArrayList<Vertex>();
        minPathList.add(source);

        List<Vertex> listObtained = minPathDijkstra.minPath(graph, source, source);

        int counter = 0;

        for (Vertex v1 : listObtained)
            for(Vertex v2 : minPathList)
                if(v1.compareVertices(v2))
                    counter++;

        assertEquals(counter, listObtained.size());
    }


} 
