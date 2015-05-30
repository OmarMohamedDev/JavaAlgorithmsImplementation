package mohamed.unionfind;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import static org.junit.Assert.*;

/** 
* UnionFind Tester. 
* 
* @author Omar Mohamed
*/ 
public class UnionFindTest {

    UnionFind unionFind;

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }
    /**
    *
    * Method: getCapacity()
    *
    */
    @Test
    public void testGetCapacityEmptyStructure(){
        unionFind = new UnionFind(0);
        assertEquals(0,unionFind.getCapacity());
    }

    @Test
    public void testGetCapacityOneElement(){
        unionFind = new UnionFind(1);
        assertEquals(1, unionFind.getCapacity());
    }

    @Test
    public void testGetCapacityManyElements(){
        unionFind = new UnionFind(10);
        assertEquals(10, unionFind.getCapacity());
    }

    /**
    *
    * Method: setCapacity(int newN)
    *
    */
    @Test
    public void testSetCapacityEmptyStructure(){
        unionFind = new UnionFind(0);
        unionFind.setCapacity(10);
        assertEquals(10, unionFind.getCapacity());
    }

    @Test
    public void testSetCapacityNotEmptyStructure(){
        unionFind = new UnionFind(10);
        unionFind.setCapacity(25);
        assertEquals(25, unionFind.getCapacity());
    }

    /**
    *
    * Method: find(int e)
    *
    */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testFindEmptyStructure(){
        unionFind = new UnionFind(0);
        unionFind.find(10);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testFindElementNotPresent(){
        unionFind = new UnionFind(10);
        unionFind.find(15);
    }

    @Test
    public void testFindElementPresentAndRepresentativeOfHisSet(){
        unionFind = new UnionFind(10);
        assertEquals(5, unionFind.find(5));
    }

    @Test
    public void testFindElementPresentAndNotRepresentativeOfHisSet(){
        unionFind = new UnionFind(10);
        unionFind.union(5,3);
        unionFind.union(6,3);
        unionFind.union(1,3);
        assertEquals(1, unionFind.find(5));
    }
    
    /**
    *
    * Method: union(int a, int b)
    *
    */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testUnionEmptyStructure(){
        unionFind = new UnionFind(0);
        unionFind.union(5,3);
    }

    @Test
    public void testUnionElementsOfTheSameSet(){
        unionFind = new UnionFind(10);
        unionFind.union(0,1);
        assertFalse(unionFind.union(0, 1));
    }

    @Test
    public void testUnionElementsOfDifferentSets(){
        unionFind = new UnionFind(10);
        unionFind.union(0,1);
        unionFind.union(5,6);
        assertTrue(unionFind.union(5,0));
    }


} 
