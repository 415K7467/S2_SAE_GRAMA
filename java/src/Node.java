import java.util.ArrayList;
import java.util.Arrays;

public class Node {

    private final String type;
    private final String name;
    private final ArrayList<Edge> edges;

    public Node(String type, String name) {
        this.type = type;
        this.name = name;
        this.edges = new ArrayList<Edge>();
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Edge> getEd() {
        return edges;
    }

    @Override
    public String toString() {
        return "Node{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", edges=" + edges +
                '}';
    }

    public void addEdge(Edge edge){
        this.edges.add(edge);
    }

    public ArrayList<Node> neighborOneDistance(Node origin) {
        ArrayList<Node> neighbor = new ArrayList<Node>();
        for (int i = 0; i < this.edges.size(); i++){
            if (this.edges.get(i) != null && this.edges.get(i).getArriveNode() != origin){
                neighbor.add(this.edges.get(i).getArriveNode());
            }
        }
        return neighbor;
    }

    public ArrayList<Node> neighborTwoDistance() {
        ArrayList<Node> neighbor = new ArrayList<Node>();
        for (int i = 0; i < this.edges.size(); i++){
            if (this.edges.get(i) != null){
                neighbor.add(this.edges.get(i).getArriveNode());
                neighbor.addAll(this.edges.get(i).getArriveNode().neighborOneDistance(this));
            }
        }
        return neighbor;
    }

    /*
    public ArrayList<Node> neighborNDistance(Node origin,int n) {
        ArrayList<Node> neighbor = new ArrayList<Node>();
        for (int i = 0; i < this.edges.size(); i++){
            if (this.edges.get(i) != null){
                neighbor.add(this.edges.get(i).getArriveNode());
                if (this.edges.get(i) != null && this.edges.get(i).getArriveNode() != origin){
                neighbor.addAll(this.edges.get(i).getArriveNode().neighborNDistance(this,n-1));
                }
            }
        }
        return neighbor;
    }
    */
}
