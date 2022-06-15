package features;

import java.util.HashMap;

/**
 * @author Vincent Chavot -- Dambrun
 */
public class Nodes {
    private final HashMap<String, Node> nodes;

    /**
     * set the list of nodes
     */
    public Nodes() {
        this.nodes = new HashMap<>();
    }

    /**
     * @return nodes
     */
    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    /**
     * @param node the node to add
     */
    public void addNode(Node node) {
        nodes.put(node.getName(), node);
    }

    @Override
    public String toString() {
        return "Nodes{" +
                "nodes=" + nodes +
                '}';
    }

    /**
     * @param name the name of the node
     * @return the node
     */
    public Node getNode(String name) {
        return nodes.get(name);
    }

}
