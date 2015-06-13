package mohamed.graphs;

import mohamed.graphs.SparseGraph;
import mohamed.graphs.SparseGraph.Vertex;
import mohamed.graphs.SparseGraph.Edge;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/** 
* SparseGraph Tester. 
* 
* @author Omar Mohamed
*/ 
public class SparseGraphTest {

    SparseGraph instance;

    public SparseGraphTest() {
    }


    @Before
    public void setUp() {
        instance = new SparseGraph();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addVertex method, of class SparseGraph.
     */
    @Test
    public void testAddVertex() {
        Vertex vertex = new Vertex("A");
        boolean expResult = true;
        boolean result = instance.addVertex(vertex);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddVertexAddTwice() {
        Vertex vertex = new Vertex("A");
        boolean expResult = false;
        instance.addVertex(vertex);
        boolean result = instance.addVertex(vertex);
        assertEquals(expResult, result);

    }

    /**
     * Test of addEdge method, of class SparseGraph.
     */
    @Test
    public void testAddEdge() {
        Vertex vertex1 =  new Vertex("A");
        Vertex vertex2 = new Vertex("B");

        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        assertTrue(instance.addEdge(vertex1, vertex2, new Edge(vertex2, 0.0)));
    }

    /**
     * Test of hasVertex method, of class SparseGraph.
     */
    @Test
    public void testHasVertexHasNoVertex() {
        Vertex vertex = new Vertex("A");
        boolean expResult = false;
        boolean result = instance.hasVertex(vertex);
        assertEquals(expResult, result);
    }

    @Test
    public void testHasVertexHasAddedVertex() {
        Vertex vertex = new Vertex("A");
        boolean expResult = true;
        instance.addVertex( new Vertex("A"));
        boolean result = instance.hasVertex(vertex);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasEdge method, of class SparseGraph.
     */

    @Test
    public void testHasEdgeNoVertexes() {

        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");

        boolean result = instance.hasEdge(vertex1, vertex2);
        assertFalse(result);

    }

    @Test
    public void testHasEdgeExistingVertexesNoEdges() {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        boolean expResult = false;
        boolean result = instance.hasEdge(vertex1, vertex2);
        assertEquals(expResult, result);
    }

    @Test
    public void testHasEdgeExistingEdge() {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        boolean expResult=true;
        instance.addEdge(vertex1,vertex2, new Edge(vertex2, 0.0));

        boolean result = instance.hasEdge(vertex1,vertex2);
        assertEquals(expResult, result);

    }


    @Test
    public void testHasEdgeExistingEdgeBothDirection() {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        boolean expResult=true;
        instance.addEdge(vertex1,vertex2,new Edge(vertex1, 0.0));
        instance.addEdge(vertex2,vertex1, new Edge(vertex2, 0.0));

        boolean result = instance.hasEdge(vertex1,vertex2);
        assertEquals(expResult, result);

        result = instance.hasEdge(vertex2,vertex1);
        assertEquals(expResult, result);

    }

    /**
     * Test of getVertices method, of class SparseGraph.
     */
    @Test
    public void testVerticesNoVertexes() {
        ArrayList<Vertex> expResult = new ArrayList<Vertex>(0);
        ArrayList<Vertex> result = (ArrayList<Vertex>)instance.getVertices();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerticesOneVertex() {
        Vertex vertex1 =  new Vertex("A");
        ArrayList<Vertex> expResult = new ArrayList<Vertex>(0);
        expResult.add(vertex1);
        instance.addVertex(vertex1);
        ArrayList<Vertex> result = (ArrayList<Vertex>)instance.getVertices();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerticesMoreVertexes() {
        Vertex vertex1 =  new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        ArrayList<Vertex> expResult = new ArrayList<Vertex>(0);
        expResult.add(vertex1);
        expResult.add(vertex2);
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);
        ArrayList<Vertex> result = (ArrayList<Vertex>)instance.getVertices();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerticesOneEdge() {
        Vertex vertex1 =  new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        ArrayList<Vertex> expResult = new ArrayList<Vertex>(0);
        expResult.add(vertex1);
        expResult.add(vertex2);
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);
        instance.addEdge(vertex1,vertex2, new Edge(vertex2, 0.0));
        ArrayList<Vertex> result = (ArrayList<Vertex>)instance.getVertices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNeighbours method, of class SparseGraph.
     */

    @Test
    public void testNeighborsNoVertexes() {
        ArrayList<Vertex> result = (ArrayList<Vertex>)instance.getNeighbours( new Vertex("A"));
        assertNull(result);
    }

    @Test
    public void testNeighborsNoNeighbors() {
        Vertex vertex1 =  new Vertex("A");
        Vertex vertex2 = new Vertex("B");

        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        ArrayList<Vertex> expResult = null;
        ArrayList<Vertex> result =(ArrayList<Vertex>)instance.getNeighbours(vertex1);
        assertEquals(expResult, result);

    }

    @Test
    public void testNeighborsANeighbor() {
        Vertex vertex1 =  new Vertex("A");
        Vertex vertex2 = new Vertex("B");

        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        instance.addEdge(vertex1,vertex2, new Edge(vertex2, 0.0));
        instance.addEdge(vertex2,vertex1, new Edge(vertex1, 0.0));

        ArrayList<Vertex> expResult = new ArrayList<Vertex>(0);
        expResult.add(vertex2);
        ArrayList<Vertex> result =(ArrayList<Vertex>)instance.getNeighbours(vertex1);
        assertEquals(expResult, result);

    }

    @Test
    public void testNeighborsMoreNeighbores() {
        Vertex vertex1 =  new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");


        instance.addVertex(vertex1);
        instance.addVertex(vertex2);
        instance.addVertex(vertex3);


        instance.addEdge(vertex1,vertex2, new Edge(vertex2, 0.0));
        instance.addEdge(vertex1,vertex3, new Edge(vertex3, 0.0));

        ArrayList<Vertex> expResult = new ArrayList<Vertex>(0);
        expResult.add(vertex2);
        expResult.add(vertex3);
        ArrayList<Vertex> result = (ArrayList<Vertex>)instance.getNeighbours(vertex1);
        assertEquals(expResult, result);

    }


} 
