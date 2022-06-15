package HCI.jswing;

import java.util.HashMap;

/**
 * @author Adrien Tacher
 */
public class ListGraphicNode {
    private final HashMap<String, GraphicNode> ListGraphicNode;

    /**
     * set the list of graphic node
     */
    public ListGraphicNode() {
        ListGraphicNode = new HashMap<>();
    }

    /**
     * @param graphicNode the graphic node
     * add a graphic node to the list
     */
    public void addGraphicNode(GraphicNode graphicNode) {
        ListGraphicNode.put(graphicNode.getNode().getName(), graphicNode);
    }

    /**
     * @param name the name of the graphic node
     * return the graphic node
     */
    public GraphicNode getNode(String name) {
        return ListGraphicNode.get(name);
    }
}
