package HCI.jswing;

import java.util.HashMap;

public class ListGraphicNode {
    private final HashMap<String, GraphicNode> ListGraphicNode;

    public ListGraphicNode() {
        ListGraphicNode = new HashMap<>();
    }


    public void addGraphicNode(GraphicNode graphicNode) {
        ListGraphicNode.put(graphicNode.getNode().getName(), graphicNode);
    }

    public GraphicNode getNode(String name) {
        return ListGraphicNode.get(name);
    }
}
