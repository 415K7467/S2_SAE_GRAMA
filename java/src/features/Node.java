package features;

import java.util.ArrayList;

public class Node {

    private final String type;
    private final String name;
    private ArrayList<Edge> edges;

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
                ", edges=" + getType()+','+getName()+
                '}';
    }

    public String allToString(){
        return "Node{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", edges=" + edges +
                '}';
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void addEdge(Edge edge){
        this.edges.add(edge);
    }

    public ArrayList<Node> neighbor(int distance) {     // distance coresond to the nomber of edges betweens two nodes
        ArrayList<Node> neighbor = new ArrayList<Node>();
        for (int i = 0; i < this.edges.size(); i++){
            Node neighbor1 = this.edges.get(i).getArriveNode();
            neighbor.add(neighbor1);
            if(distance >1){
                ArrayList neighbors = neighbor1.neighbor(distance-1);   //put the list of neighbor of neighbor1 into neighbors
                for (int k = 0; k < neighbors.size(); k++){
                    if(neighbors.get(k)!=this && !neighbor.contains(neighbors.get(k))) {  //if the neighbor is not itself and not in neighbor
                        neighbor.add((Node) neighbors.get(k));
                    }
                }
            }
        }
        return neighbor;
    }
}
