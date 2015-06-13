package mohamed.dijkstra;

import mohamed.graphs.BreadthFirstSearch;
import mohamed.graphs.SearchCallbackImpl;
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

    @Test
    public void testMinPathFiveVertexFourEdges() {
        SparseGraph graph = new SparseGraph();
        MinPathDijkstra minPathDijkstra = new MinPathDijkstra();

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

        graph.addEdge(vertex1, vertex2, new Edge(vertex2, 5.0));
        graph.addEdge(vertex2, vertex3, new Edge(vertex3, 1.5));
        graph.addEdge(vertex1, vertex4, new Edge(vertex4, 2.0));
        graph.addEdge(vertex4, vertex5, new Edge(vertex5, 1.0));
        graph.addEdge(vertex2, vertex5, new Edge(vertex5, 0.5));
        graph.addEdge(vertex5, vertex3, new Edge(vertex3, 0.8));


        List<Vertex> minPathList = new ArrayList<Vertex>();
        minPathList.add(vertex1);
        minPathList.add(vertex4);
        minPathList.add(vertex5);
        minPathList.add(vertex3);

        List<Vertex> listObtained = minPathDijkstra.minPath(graph, vertex1, vertex3);

        int counter = 0;

        for (Vertex v1 : listObtained)
            for(Vertex v2 : minPathList)
                if(v1.compareVertices(v2))
                    counter++;

        assertEquals(counter, listObtained.size());

    }


} 
