package features;

public class listNode {
    private Node antecedentNode;
    private Node actualNode;
    private int distance;

    public Node getAntecedentNode() {
        return antecedentNode;
    }

    public void setAntecedentNode(Node antecedentNode) {
        this.antecedentNode = antecedentNode;
    }

    public Node getActualNode() {
        return actualNode;
    }

    public void setActualNode(Node actualNode) {
        this.actualNode = actualNode;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public listNode(Node antecedentNode, Node actualNode, int distance) {
        this.antecedentNode = antecedentNode;
        this.actualNode = actualNode;
        this.distance = distance;
    }
}
