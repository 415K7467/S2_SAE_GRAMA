package features;

/**
 * @author Adrien Tacher
 * @author Vincent Chavot -- Dambrun
 */
public record Edge(String type, float size, Node arriveNode) {

    /**
     * @param type       the type of the edge
     * @param size       the size of the edge
     * @param arriveNode the node where the edge arrive
     *                   constructor of the edge
     */
    public Edge {
    }

    /**
     * @return the type of the edge
     */
    public String getType() {
        return type;
    }

    /**
     * @return the size of the edge
     */
    public float getSize() {
        return size;
    }

    /**
     * @return the node where the edge arrive
     */
    public Node getArriveNode() {
        return arriveNode;
    }

    /**
     * @return the string representation of the edge
     */
    @Override
    public String toString() {
        return "Edge{" +
                "type='" + type + '\'' +
                ", size=" + size +
                ", arriveNode=" + arriveNode +
                '}';
    }
}
