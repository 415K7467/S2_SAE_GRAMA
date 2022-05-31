package features;

import java.util.ArrayList;
import java.util.Objects;

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

    public void compareNodes(Node node1,int distance, String type) { //if type='V' compare with neigbors city, if type='R' compare with neighbor restaurant if type='L' compare with neighbor loisir
        ArrayList<Node> neighbors1 = node1.neighbor(distance);
        ArrayList<Node> neighbors2 = this.neighbor(distance);
        int numberNeighbors1 =numberOfType(neighbors1, type);
        int numberNeighbors2 =numberOfType(neighbors2, type);
        String compare = "";
        String nameType = nomtype(type);


        System.out.println(node1+":"+numberNeighbors1);
        System.out.println(this+":"+numberNeighbors2);
        if (numberNeighbors1<numberNeighbors2){
            compare = " moins ";
        }
        else if (numberNeighbors1>numberNeighbors2){
            compare = " plus ";
        }
        else{
            compare = " autant ";
        }
        System.out.println(node1.getName()+" a "+compare+" de " +nameType+" a "+distance+" distances que "+this.getName());
    }

    public String nomtype(String type){
        String nameType = null;
        if(type=="V"){
            nameType="ville";
        }
        else if(type=="R"){
            nameType="Restaurant";
        }
        else if(type=="L"){
            nameType="Loisir";
        }
        return nameType;
    }

    public int numberOfType(ArrayList<Node> nodes, String type) {
        int number =0;
        for (int i=0;i< nodes.size();i++){
            if (Objects.equals(nodes.get(i).getType(), type)) {
                number++;
            }
        }
        return number;
    }

}
