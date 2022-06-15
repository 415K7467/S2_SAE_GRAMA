package features;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Adrien Tacher
 * @author Vincent Chavot -- Dambrun
 */
public class Node {

    private final String type;
    private final String name;
    private ArrayList<Edge> edges;

    /**
     * @param type the type of the node
     * @param name the name of the node
     * constructor of the node
     */
    public Node(String type, String name) {
        this.type = type;
        this.name = name;
        this.edges = new ArrayList<>();
    }

    /**
     * @return the type of the node
     */
    public String getType() {
        return type;
    }

    /**
     * @return the name of the node
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        ArrayList<String> edgesString = new ArrayList<>();
        for (Edge edge : edges) {
            edgesString.add(edge.getType());
            edgesString.add(String.valueOf(edge.getSize()));
        }
        return "Node{" +
                "type=" + type +
                ", name=" + name  +
                ", edges=" + edgesString +
                '}';
    }

    /**
     * @return arraylist of edges of the node
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**
     * @param edges the edges to set
     */
    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    /**
     * @param distance the distance to set
     * @return arraylist of edges of the node
     */
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

    /**
     * @param distance the distance to set
     * @return arraylist of neighbors of the node
     */
    public ArrayList<String> neighborName(int distance) {     // distance correspond to the number of edges between two nodes
        ArrayList<String> neighbor = new ArrayList<>();
        for (Edge edge : this.edges) {
            Node neighbor1 = edge.getArriveNode();
            neighbor.add(neighbor1.getName());
            if (distance > 1) {
                ArrayList<String> neighbors = neighbor1.neighborName(distance - 1);   //put the list of neighbor of neighbor1 into neighbors
                for (String s : neighbors) {
                    if (!Objects.equals(s, this.getName()) && !neighbor.contains(s)) {  //if the neighbor is not itself and not in neighbor
                        neighbor.add(s);
                    }
                }
            }
        }
        return neighbor;
    }

    /**
     * @param node1 the first node to compare
     * @param distance the distance to neighbor to check
     * @param type the type of comparison
     * return String of information when you compare two nodes
     */
    public String compareNodes(Node node1,int distance, String type) { //if type='V' compare with neigbors city, if type='R' compare with neighbor restaurant if type='L' compare with neighbor loisir
        ArrayList<Node> neighbors1 = node1.neighbor(distance);
        ArrayList<Node> neighbors2 = this.neighbor(distance);
        int numberNeighbors1 =numberOfType(neighbors1, type);
        int numberNeighbors2 =numberOfType(neighbors2, type);
        String compare;
        String nameType = nomtype(type);

        if (numberNeighbors1<numberNeighbors2){
            compare = " moins ";
        } else if (numberNeighbors1 > numberNeighbors2) {
            compare = " plus ";
        } else {
            compare = " autant ";
        }
        return node1.getName()+" a "+compare+" de " +nameType+" a "+distance+" distances que "+this.getName()+"  ; "+node1.getName()+" en a "+numberNeighbors1+" et "+this.getName()+" en a "+numberNeighbors2+" "+nameType+".";
    }

    /**
     * @param type the type of comparison
     * @return String with type
     */
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

    /**
     * @param nodes the nodes to compare
     * @param type the type of comparison
     * @return the number for the comparison
     */
    public int numberOfType(ArrayList<Node> nodes, String type) {
        int number =0;
        for (Node node : nodes) {
            if (Objects.equals(node.getType(), type)) {
                number++;
            }
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

}
