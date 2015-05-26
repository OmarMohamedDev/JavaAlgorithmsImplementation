package mohamed.dictionary;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* SearchTree Tester.
* 
* @author Omar Mohamed
*/ 
public class SearchTreeTest {

    SearchTree searchTree;



    @Before
    public void setUp() throws Exception {
        searchTree = new SearchTree();
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
    *
    * Method: minKey()
    *
    */
    @Test
    public void testMinKey() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: maxKey()
    *
    */
    @Test
    public void testMaxKey() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: ElementOfMinKey()
    *
    */
    @Test
    public void testElementOfMinKey() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: ElementOfMaxKey()
    *
    */
    @Test
    public void testElementOfMaxKey() throws Exception {
    //TODO: Test goes here...
    }

    /**
     * Test of remove method, of class SearchTree.
     */

    @Test
    public void testRemoveNoNodes() {

        Integer key=1;
        searchTree.remove(key);
        assertNull(searchTree.find(1));
    }

    @Test
    public void testRemoveKeyDoesntExistAndOneNode() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key=1;
        searchTree.remove(key);
        assertNull(searchTree.find(1));
    }


    @Test
    public void testRemoveKeyExistsAndOneNode() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key=5;
        Integer expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(5));
    }

    @Test
    public void testRemoveKeyExistsFirstTime() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key=5;
        Integer expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(5));

        expResult=null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(5));
    }

    @Test
    public void testRemoveKeyExistsAndHasAChild() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key = 4;
        value = 3;
        searchTree.add(key, value);

        key=5;
        Integer expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(5));
    }


    @Test
    public void testRemoveKeyExistsAndHasTwoChildren() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key = 4;
        value = 3;
        searchTree.add(key, value);

        key = 6;
        value = 2;
        searchTree.add(key, value);

        key = 5;
        Integer expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(5));
    }

    @Test
    public void testRemoveKeyExistsAndIsNotRoot() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key = 4;
        value = 3;
        searchTree.add(key, value);

        key = 6;
        value = 6;
        searchTree.add(key, value);

        key = 4;
        value = 3;
        searchTree.add(key, value);

        key = 7;
        value = 4;
        searchTree.add(key, value);

        key = 6;
        Integer expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(6));
    }

    @Test
    public void testRemoveRemoveEachNode() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key = 4;
        value = 3;
        searchTree.add(key, value);

        key = 6;
        value = 6;
        searchTree.add(key, value);

        key = 3;
        value = 4;
        searchTree.add(key, value);

        key = 7;
        value = 4;
        searchTree.add(key, value);

        key=6;
        Integer expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(6));

        key=5;
        expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(5));

        key=4;
        expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(4));

        key=7;
        expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(7));

        key=3;
        expResult= null;
        searchTree.remove(key);
        assertEquals(expResult, searchTree.find(3));

    }


    /**
     * Test of find method, of class SearchTree.
     */

    @Test
    public void testFindNoNodes() {
        searchTree = new SearchTree();

        Integer key=1;
        Integer expResult=null;
        Integer result = searchTree.find(key);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOneNode() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key=5;
        Integer expResult=1;
        Integer result = searchTree.find(key);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOneNodeFindTwice() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        //key=5;
        Integer expResult=1;
        Integer result = searchTree.find(key);
        assertEquals(expResult, result);
        result = searchTree.find(key);
        assertEquals(expResult, result);

    }

    @Test
    public void testFindFindEachOne() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        searchTree.add(key, value);

        key=4;
        value=2;
        searchTree.add(key, value);

        key=6;
        value=3;
        searchTree.add(key, value);

        key=5;
        Integer expResult=1;
        Integer result = searchTree.find(key);
        assertEquals(expResult, result);

        key=4;
        expResult=2;
        result = searchTree.find(key);
        assertEquals(expResult, result);

        key=6;
        expResult=3;
        result = searchTree.find(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class SearchTree.
     */
    @Test
    public void testAddFirstElem() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        Integer expResult = null;
        Integer result = searchTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTwoElementsSameKey() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        Integer expResult = null;
        Integer result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 5;
        value = 2;
        expResult=1;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTwoElementsDifferentKey() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        Integer expResult = null;
        Integer result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 2;
        expResult=null;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddThreeElementsTwoKeysRight() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        Integer expResult = null;
        Integer result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 2;
        expResult=null;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 3;
        expResult=2;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddThreeElementsTwoKeysLeft() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        Integer expResult = null;
        Integer result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 4;
        value = 2;
        expResult=null;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 4;
        value = 3;
        expResult=2;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddThreeElementsThreeKeysLeftAndRIght() {
        Integer key = 5;
        Integer value = 1;
        searchTree = new SearchTree();
        Integer expResult = null;
        Integer result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 4;
        value = 2;
        expResult=null;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 3;
        expResult=null;
        result = searchTree.add(key, value);
        assertEquals(expResult, result);
    }



    /**
     * Test of isEmpty method, of class SearchTree.
     */
    @Test
    public void testIsEmptyTrue() {
        boolean isEmpty= searchTree.isEmpty();
        assertTrue(isEmpty);
    }
    @Test
    public void testIsEmptyOneElement() {
        Integer key = 4;
        Integer value = 2;
        searchTree.add(key, value);
        boolean isEmpty= searchTree.isEmpty();
        assertFalse(isEmpty);
    }


} 
