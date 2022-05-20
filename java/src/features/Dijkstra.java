package features;

import java.util.ArrayList;

public class Dijkstra {

    private Nodes nodeList;
    private Node startNode;
    private Node arrivalNode;

    public Dijkstra(Nodes nodeList, Node startNode, Node arrivalNode) {
        this.nodeList = nodeList;
        this.startNode = startNode;
        this.arrivalNode = arrivalNode;
    }

    public Nodes getNodeList() {
        return nodeList;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getArrivalNode() {
        return arrivalNode;
    }

    //Dijkstra's algorithm
    private ArrayList<Node> dijkstra() {
        return null;
    }
}
