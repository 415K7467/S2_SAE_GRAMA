package features;

import java.util.HashMap;

public class Nodes {
    private final HashMap<String, Node> nodes;

    public Nodes() {
        this.nodes = new HashMap<>();
    }

    public HashMap<String, Node> getNodes() {
        return nodes;
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

    public Node getNode(String name) {
        return nodes.get(name);
    }

}
