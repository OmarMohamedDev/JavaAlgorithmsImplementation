package mohamed.dictionary;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* AVLTree Tester. 
* 
* @author Omar Mohamed
*/ 
public class AVLTreeTest {

    AVLTree avlTree;



    @Before
    public void setUp() throws Exception {
        avlTree = new AVLTree();
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
     * Test of remove method, of class AVLTree.
     */

    @Test
    public void testRemoveNoNodes() {

        Integer key=1;
        avlTree.remove(key);
        assertNull(avlTree.find(1));
    }

    @Test
    public void testRemoveKeyDoesntExistAndOneNode() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key=1;
        avlTree.remove(key);
        assertNull(avlTree.find(1));
    }


    @Test
    public void testRemoveKeyExistsAndOneNode() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key=5;
        Integer expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(5));
    }

    @Test
    public void testRemoveKeyExistsFirstTime() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key=5;
        Integer expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(5));

        expResult=null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(5));
    }

    @Test
    public void testRemoveKeyExistsAndHasAChild() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key = 4;
        value = 3;
        avlTree.add(key, value);

        key=5;
        Integer expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(5));
    }


    @Test
    public void testRemoveKeyExistsAndHasTwoChildren() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key = 4;
        value = 3;
        avlTree.add(key, value);

        key = 6;
        value = 2;
        avlTree.add(key, value);

        key = 5;
        Integer expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(5));
    }

    @Test
    public void testRemoveKeyExistsAndIsNotRoot() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key = 4;
        value = 3;
        avlTree.add(key, value);

        key = 6;
        value = 6;
        avlTree.add(key, value);

        key = 4;
        value = 3;
        avlTree.add(key, value);

        key = 7;
        value = 4;
        avlTree.add(key, value);

        key = 6;
        Integer expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(6));
    }

    @Test
    public void testRemoveRemoveEachNode() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key = 4;
        value = 3;
        avlTree.add(key, value);

        key = 6;
        value = 6;
        avlTree.add(key, value);

        key = 3;
        value = 4;
        avlTree.add(key, value);

        key = 7;
        value = 4;
        avlTree.add(key, value);

        key=6;
        Integer expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(6));

        key=5;
        expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(5));

        key=4;
        expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(4));

        key=7;
        expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(7));

        key=3;
        expResult= null;
        avlTree.remove(key);
        assertEquals(expResult, avlTree.find(3));

    }


    /**
     * Test of find method, of class AVLTree.
     */

    @Test
    public void testFindNoNodes() {
        avlTree = new AVLTree();

        Integer key=1;
        Integer expResult=null;
        Integer result = avlTree.find(key);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOneNode() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key=5;
        Integer expResult=1;
        Integer result = avlTree.find(key);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOneNodeFindTwice() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        //key=5;
        Integer expResult=1;
        Integer result = avlTree.find(key);
        assertEquals(expResult, result);
        result = avlTree.find(key);
        assertEquals(expResult, result);

    }

    @Test
    public void testFindFindEachOne() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        avlTree.add(key, value);

        key=4;
        value=2;
        avlTree.add(key, value);

        key=6;
        value=3;
        avlTree.add(key, value);

        key=5;
        Integer expResult=1;
        Integer result = avlTree.find(key);
        assertEquals(expResult, result);

        key=4;
        expResult=2;
        result = avlTree.find(key);
        assertEquals(expResult, result);

        key=6;
        expResult=3;
        result = avlTree.find(key);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class AVLTree.
     */
    @Test
    public void testAddFirstElem() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        Integer expResult = null;
        Integer result = avlTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTwoElementsSameKey() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        Integer expResult = null;
        Integer result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 5;
        value = 2;
        expResult=1;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddTwoElementsDifferentKey() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        Integer expResult = null;
        Integer result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 2;
        expResult=null;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddThreeElementsTwoKeysRight() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        Integer expResult = null;
        Integer result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 2;
        expResult=null;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 3;
        expResult=2;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddThreeElementsTwoKeysLeft() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        Integer expResult = null;
        Integer result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 4;
        value = 2;
        expResult=null;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 4;
        value = 3;
        expResult=2;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddThreeElementsThreeKeysLeftAndRIght() {
        Integer key = 5;
        Integer value = 1;
        avlTree = new AVLTree();
        Integer expResult = null;
        Integer result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 4;
        value = 2;
        expResult=null;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);

        key = 6;
        value = 3;
        expResult=null;
        result = avlTree.add(key, value);
        assertEquals(expResult, result);
    }



    /**
     * Test of isEmpty method, of class AVLTree.
     */
    @Test
    public void testIsEmptyTrue() {
        boolean isEmpty= avlTree.isEmpty();
        assertTrue(isEmpty);
    }
    @Test
    public void testIsEmptyOneElement() {
        Integer key = 4;
        Integer value = 2;
        avlTree.add(key, value);
        boolean isEmpty= avlTree.isEmpty();
        assertFalse(isEmpty);
    }


} 
