package features;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Chavot -- Dambrun
 */
public class EdgeTest {
    public EdgeTest() {
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
     * Test of constructor method, of class Edge.
     */
    @Test
    public void testConstructor() {
        System.out.println("constructor");
        Node node = new Node("V", "Lyon 5");
        Edge instance = new Edge("D", 5, node);
        assertEquals(node, instance.getArriveNode());
    }

    /**
     * Test of getType method, of class Edge.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Edge instance = new Edge("D", 5, new Node("V", "Lyon 5"));
        String expResult = "D";
        String result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Edge.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Edge instance = new Edge("D", 5, new Node("V", "Lyon 5"));
        int expResult = 5;
        int result = (int) instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArriveNode method, of class Edge.
     */
    @Test
    public void testGetArriveNode() {
        System.out.println("getArriveNode");
        Edge instance = new Edge("D", 5, new Node("V", "Lyon 5"));
        Node expResult = new Node("V", "Lyon 5");
        Node result = instance.getArriveNode();
        assertEquals(expResult, result);
    }
}
