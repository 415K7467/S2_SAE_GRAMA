package HCI.jswing;

import features.Node;

public class GraphicNode {

    private Node node;
    private int x;
    private int y;

    public GraphicNode(Node node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
