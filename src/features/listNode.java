package features;

/**
 * @author Vincent Chavot -- Dambrun
 */
public class listNode {
    private final Node actualNode;
    private int distance;

    /**
     * @return the actualNode
     */
    public Node getActualNode() {
        return actualNode;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @param actualNode the actualNode
     * @param distance the distance
     * constructor of the listNode
     */
    public listNode(Node actualNode, int distance) {
        this.actualNode = actualNode;
        this.distance = distance;
    }
}
