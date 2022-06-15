package features;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Chavot -- Dambrun
 */
public class ListeNodeTest {
    public ListeNodeTest() {
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
     * Test of constructor method, of class ListeNode.
     */
    @Test
    public void testConstructor() {
        System.out.println("constructor");
        Node actualNode = new Node("V","Lyon 5");
        listNode instance = new listNode(actualNode, 0);
        assertEquals(actualNode, instance.getActualNode());
    }

    /**
     * Test of getActualNode method, of class ListeNode.
     */
    @Test
    public void testGetActualNode() {
        System.out.println("getActualNode");
        listNode instance = new listNode(new Node("V","Lyon 5"), 0);
        Node expResult = new Node("V","Lyon 5");
        Node result = instance.getActualNode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class ListeNode.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        listNode instance = new listNode(new Node("V","Lyon 5"), 0);
        int expResult = 0;
        int result = instance.getDistance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDistance method, of class ListeNode.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        int distance = 0;
        listNode instance = new listNode(new Node("V","Lyon 5"), 0);
        instance.setDistance(distance);
        assertEquals(distance, instance.getDistance());
    }
}
