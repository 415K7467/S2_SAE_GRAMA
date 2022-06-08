package features;

public class listNode {
    private final Node actualNode;
    private int distance;

    public Node getActualNode() {
        return actualNode;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public listNode(Node actualNode, int distance) {
        this.actualNode = actualNode;
        this.distance = distance;
    }
}
