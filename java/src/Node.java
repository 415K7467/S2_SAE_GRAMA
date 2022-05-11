import java.util.Arrays;

public class Node {

    private final String type;
    private final String name;
    private final Edge[] edges;

    public Node(String type, String name) {
        this.type = type;
        this.name = name;
        this.edges = new Edge[10];
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Edge[] getEd() {
        return edges;
    }

    @Override
    public String toString() {
        return "Node{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", edges=" + Arrays.toString(edges) +
                '}';
    }

    public void addEdge(Edge edge){
        for (int i = 0; i < this.edges.length; i++){
            if (this.edges[i] == null){
                this.edges[i] = edge;
                break;
            }
        }
    }

    public Node[] neighbor1distance(){
        Node[] neighbor = new Node[10];
        int j = 0;
        for (int i = 0; i < this.edges.length; i++){
            if (this.edges[i] != null){
                neighbor[j] = edges[i].getArriveNode();
            }
        }
        return neighbor;
    }

    public Node[] neighbor2distance(){
        Node[] neighbor1 = this.neighbor1distance();
        Node[] neighbor2 = new Node[10];
        for (int i = 0; i < neighbor1.length; i++){
            int k = 0;
            for (int j = 0; i < this.edges.length; i++){
                if (this.edges[j] != null){
                    neighbor2[k] = edges[j].getArriveNode();
                }
            }
        }
        return neighbor2;
    }
}
