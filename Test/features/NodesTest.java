package features;

import org.junit.*;

import java.util.HashMap;

import static org.junit.Assert.*;


public class NodesTest {
    public NodesTest(){
    }
    @BeforeClass
    public static void setUpClass() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }
    /**
     * Test of getNodes method, of class Nodes.
     */
    @Test
    public void testGetNodes() {
        System.out.println("getNodes");
        Nodes instance = new Nodes();
        HashMap<String, Node> expResult = new HashMap<>();
        HashMap<String, Node> result = instance.getNodes();
        assertEquals(expResult, result);
    }

    /**
     * Test of addNode method, of class Nodes.
     */
    @Test
    public void testAddNode() {
        System.out.println("addNode");
        Node node = new Node("V","Lyon 5");
        Nodes instance = new Nodes();
        instance.addNode(node);
        assertEquals(node, instance.getNodes().get("Lyon 5"));
    }

    /**
     * Test of toString method, of class Nodes.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Nodes instance = new Nodes();
        String expResult = "Nodes{nodes={}}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNode method, of class Nodes.
     */
    @Test
    public void testGetNode() {
        System.out.println("getNode");
        String name = "Lyon 5";
        String type = "V";
        Nodes instance = new Nodes();
        Node expResult = new Node(type,name);
        instance.addNode(expResult);
        Node result = instance.getNode(name);
        assertEquals(expResult, result);
    }

}
