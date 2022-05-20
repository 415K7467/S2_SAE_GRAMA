package features;

import java.util.HashMap;

public class Nodes {
    private HashMap nodes;

    public Nodes() {
        this.nodes = new HashMap<String, Node>();
    }

    public HashMap getNodes() {
        return nodes;
    }

    public void setNodes(HashMap nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.put(node.getName(), node);
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "nodes=" + nodes +
                '}';
    }

    public int size() {
        return nodes.size();
    }

    public Node getNode(String name) {
        return (Node) nodes.get(name);
    }
}
