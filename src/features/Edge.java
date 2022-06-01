package features;

public class Edge {

    private final String type;
    private final float size;
    private final Node arriveNode;

    public Edge(String type, float size, Node arriveNode) {
        this.type = type;
        this.size = size;
        this.arriveNode = arriveNode;
    }

    public String getType() {
        return type;
    }

    public float getSize() {
        return size;
    }

    public Node getArriveNode() {
        return arriveNode;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "type='" + type + '\'' +
                ", size=" + size +
                ", arriveNode=" + arriveNode +
                '}';
    }

}
