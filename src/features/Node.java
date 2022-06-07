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
        this.edges = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", edges=" + getType() + ',' + getName() +
                '}';
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Node> neighbor(int distance) {     // distance coresond to the nomber of edges betweens two nodes
        ArrayList<Node> neighbor = new ArrayList<>();
        for (Edge edge : this.edges) {
            Node neighbor1 = edge.getArriveNode();
            neighbor.add(neighbor1);
            if (distance > 1) {
                ArrayList<Node> neighbors = neighbor1.neighbor(distance - 1);   //put the list of neighbor of neighbor1 into neighbors
                for (Node node : neighbors) {
                    if (node != this && !neighbor.contains(node)) {  //if the neighbor is not itself and not in neighbor
                        neighbor.add(node);
                    }
                }
            }
        }
        return neighbor;
    }

    public ArrayList<String> neighborName(int distance) {     // distance correspond to the number of edges between two nodes
        ArrayList<String> neighbor = new ArrayList<>();
        for (Edge edge : this.edges) {
            Node neighbor1 = edge.getArriveNode();
            neighbor.add(neighbor1.getName());
            if (distance > 1) {
                ArrayList<String> neighbors = neighbor1.neighborName(distance - 1);   //put the list of neighbor of neighbor1 into neighbors
                for (String s : neighbors) {
                    if (!neighbor.contains(s)) {  //if the neighbor is not itself and not in neighbor
                        neighbor.add(s);
                    }
                }
            }
        }
        return neighbor;
    }

    public String compareNodes(Node node1,int distance, String type) { //if type='V' compare with neigbors city, if type='R' compare with neighbor restaurant if type='L' compare with neighbor loisir
        ArrayList<Node> neighbors1 = node1.neighbor(distance);
        ArrayList<Node> neighbors2 = this.neighbor(distance);
        int numberNeighbors1 =numberOfType(neighbors1, type);
        int numberNeighbors2 =numberOfType(neighbors2, type);
        String compare;
        String nameType = nomtype(type);


        //System.out.println(node1+":"+numberNeighbors1);
        //System.out.println(this+":"+numberNeighbors2);
        if (numberNeighbors1<numberNeighbors2){
            compare = " moins ";
        } else if (numberNeighbors1 > numberNeighbors2) {
            compare = " plus ";
        } else {
            compare = " autant ";
        }
        return node1.getName()+" a "+compare+" de " +nameType+" a "+distance+" distances que "+this.getName()+"  ; "+node1.getName()+" en a "+numberNeighbors1+" et "+this.getName()+" en a "+numberNeighbors2+" "+nameType+".";
    }

    public String nomtype(String type) {
        String nameType = null;
        if(Objects.equals(type, "V")){
            nameType="ville";
        }
        else if(Objects.equals(type, "R")){
            nameType="Restaurant";
        }
        else if(Objects.equals(type, "L")){
            nameType="Loisir";
        }
        return nameType;
    }

    public int numberOfType(ArrayList<Node> nodes, String type) {
        int number =0;
        for (Node node : nodes) {
            if (Objects.equals(node.getType(), type)) {
                number++;
            }
        }
        return number;
    }

}
