package mohamed.graphs;

import mohamed.graphs.SparseGraph;
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
        String vertex = "A";
        boolean expResult = true;
        boolean result = instance.addVertex(vertex);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddVertexAddTwice() {
        String vertex = "A";
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
        instance.addVertex("A");
        instance.addVertex("B");
        String vertex1 = "A";
        String vertex2 = "B";
        boolean expResult = true;
        boolean result=instance.addEdge(vertex1, vertex2, 0.0);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasVertex method, of class SparseGraph.
     */
    @Test
    public void testHasVertexHasNoVertex() {
        String vertex = "A";
        boolean expResult = false;
        boolean result = instance.hasVertex(vertex);
        assertEquals(expResult, result);
    }

    @Test
    public void testHasVertexHasAddedVertex() {
        String vertex = "A";
        boolean expResult = true;
        instance.addVertex("A");
        boolean result = instance.hasVertex(vertex);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasEdge method, of class SparseGraph.
     */

    @Test
    public void testHasEdgeNoVertexes() {

        String vertex1 = "A";
        String vertex2 = "B";

        boolean result = instance.hasEdge(vertex1, vertex2);
        assertFalse(result);

    }

    @Test
    public void testHasEdgeExistingVertexesNoEdges() {
        instance.addVertex("A");
        instance.addVertex("B");
        String vertex1 = "A";
        String vertex2 = "B";

        boolean expResult = false;
        boolean result = instance.hasEdge(vertex1, vertex2);
        assertEquals(expResult, result);
    }

    @Test
    public void testHasEdgeExistingEdge() {
        String vertex1 = "A";
        String vertex2 = "B";
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        boolean expResult=true;
        instance.addEdge(vertex1,vertex2, 0.0);

        boolean result = instance.hasEdge(vertex1,vertex2);
        assertEquals(expResult, result);

    }


    @Test
    public void testHasEdgeExistingEdgeBothDirection() {
        String vertex1 = "A";
        String vertex2 = "B";
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        boolean expResult=true;
        instance.addEdge(vertex1,vertex2, 0.0);
        instance.addEdge(vertex2,vertex1, 0.0);

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
        ArrayList<String> expResult = new ArrayList<String>(0);
        ArrayList<String> result = (ArrayList<String>)instance.getVertices();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerticesOneVertex() {
        String vertex1 = "A";
        ArrayList<String> expResult = new ArrayList<String>(0);
        expResult.add(vertex1);
        instance.addVertex(vertex1);
        ArrayList<String> result = (ArrayList<String>)instance.getVertices();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerticesMoreVertexes() {
        String vertex1 = "A";
        String vertex2 = "B";
        ArrayList<String> expResult = new ArrayList<String>(0);
        expResult.add(vertex1);
        expResult.add(vertex2);
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);
        ArrayList<String> result = (ArrayList<String>)instance.getVertices();
        assertEquals(expResult, result);
    }

    @Test
    public void testVerticesOneEdge() {
        String vertex1 = "A";
        String vertex2 = "B";
        ArrayList<String> expResult = new ArrayList<String>(0);
        expResult.add(vertex1);
        expResult.add(vertex2);
        instance.addVertex(vertex1);
        instance.addVertex(vertex2);
        instance.addEdge(vertex1,vertex2, 0.0);
        ArrayList<String> result = (ArrayList<String>)instance.getVertices();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNeighbours method, of class SparseGraph.
     */

    @Test
    public void testNeighborsNoVertexes() {
        ArrayList<String> result = (ArrayList<String>)instance.getNeighbours("A");
        assertNull(result);
    }

    @Test
    public void testNeighborsNoNeighbors() {
        String vertex1 = "A";
        String vertex2 = "B";

        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        ArrayList<String> expResult = null;
        ArrayList<String> result =(ArrayList<String>)instance.getNeighbours(vertex1);
        assertEquals(expResult, result);

    }

    @Test
    public void testNeighborsANeighbor() {
        String vertex1 = "A";
        String vertex2 = "B";

        instance.addVertex(vertex1);
        instance.addVertex(vertex2);

        instance.addEdge(vertex1,vertex2, 0.0);
        instance.addEdge(vertex2,vertex1, 0.0);

        ArrayList<String> expResult = new ArrayList<String>(0);
        expResult.add(vertex2);
        ArrayList<String> result =(ArrayList<String>)instance.getNeighbours(vertex1);
        assertEquals(expResult, result);

    }

    @Test
    public void testNeighborsMoreNeighbores() {
        String vertex1 = "A";
        String vertex2 = "B";
        String vertex3 = "C";


        instance.addVertex(vertex1);
        instance.addVertex(vertex2);
        instance.addVertex(vertex3);


        instance.addEdge(vertex1,vertex2, 0.0);
        instance.addEdge(vertex1,vertex3, 0.0);

        ArrayList<String> expResult = new ArrayList<String>(0);
        expResult.add(vertex2);
        expResult.add(vertex3);
        ArrayList<String> result = (ArrayList<String>)instance.getNeighbours(vertex1);
        assertEquals(expResult, result);

    }


} 
