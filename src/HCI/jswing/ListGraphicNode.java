package HCI.jswing;

import features.Node;

import java.util.HashMap;

public class ListGraphicNode {
    private HashMap ListGraphicNode;

    public ListGraphicNode() {
        ListGraphicNode = new HashMap<String, GraphicNode>();
    }

    public HashMap getListGraphicNode() {
        return ListGraphicNode;
    }

    public void setListGraphicNode(HashMap listGraphicNode) {
        ListGraphicNode = listGraphicNode;
    }

    public void addGraphicNode(GraphicNode graphicNode) {
        ListGraphicNode.put(graphicNode.getNode().getName(), graphicNode);
    }

    public GraphicNode getNode(String name) {
        return (GraphicNode) ListGraphicNode.get(name);
    }
}
