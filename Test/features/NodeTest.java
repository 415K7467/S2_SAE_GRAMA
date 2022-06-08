package features;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NodeTest {
    Node node;
    public NodeTest() {
    }
    @BeforeClass
    public static void setUpClass() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
        node = new Node("V","Lyon 5");
    }
    @After
    public void tearDown() {
        node = null;
    }

    /**
     * Test of getType method, of class Node.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        String expResult = "V";
        String result = node.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Node.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Lyon 5";
        String result = node.getName();
        assertEquals(expResult, result);
    }


    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Node{type=V, name=Lyon 5, edges=[]}";
        String result = node.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getedges method, of class Node.
     */
    @Test
    public void testGetedges() {
        System.out.println("getedges");
        ArrayList<Edge> expResult = new ArrayList<>();
        ArrayList<Edge> result = node.getEdges();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEdge method, of class Node.
     */
    @Test
    public void testSetEdge() {
        System.out.println("setEdge");
        Edge edge = new Edge("D",5, node);
        ArrayList<Edge> expResult = new ArrayList<>();
        expResult.add(edge);
        node.setEdges(expResult);
        assertEquals(edge, node.getEdges().get(0));
    }

    /**
     * Test of neighbor method, of class Node.
     *
     */
    @Test
    public void testNeighbor() {
        System.out.println("neighbor");
        ArrayList<Node> expResult = node.neighbor(1);
        ArrayList<Node> result = node.neighbor(1);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of neighborName method, of class Node.
     * 
     */
    @Test
    public void testNeighborName() {
        System.out.println("neighborName");
        ArrayList<String> expResult = node.neighborName(1);
        ArrayList<String> result = node.neighborName(1);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareNodes method, of class Node.
     * 
     */
    @Test
    public void testCompareNodes() {
        System.out.println("compareNodes");
        Node node2 = new Node("V","Lyon 5");
        String expResult = node.compareNodes(node2, 1, "V");
        String result = node.compareNodes(node2, 1, "V");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of nomType method, of class Node.
     * 
     */
    @Test
    public void testNomType() {
        System.out.println("nomType");
        String expResult = "V";
        String result = node.getType();
        assertEquals(expResult, result);
    }
    
    /*
     * Test of numberOfType method, of class Node.
     * 
     *
    @Test

    public void testNumberOfType() {
        System.out.println("numberOfType");
        ArrayList<Node> node2 = null;
        int expResult = 1;
        int result = node.numberOfType(node2, "V");
        assertEquals(expResult, result);
    }*/

}
