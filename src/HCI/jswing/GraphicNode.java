package HCI.jswing;

import features.Node;

/**
 * @author Adrien Tacher
 */
public class GraphicNode {

    private Node node;
    private final int x;
    private final int y;

    /**
     * @param node the node
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public GraphicNode(Node node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * @return the x coordinate of the node
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y coordinate of the node
     */
    public int getY() {
        return y;
    }

}
