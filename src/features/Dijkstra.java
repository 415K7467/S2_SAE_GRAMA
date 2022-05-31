package features;

import java.util.ArrayList;

public class Dijkstra {

    private Node startNode;
    private Node arrivalNode;

    public Dijkstra(Node startNode, Node arrivalNode) {
        this.startNode = startNode;
        this.arrivalNode = arrivalNode;
    }


    public Node getStartNode() {
        return startNode;
    }

    public Node getArrivalNode() {
        return arrivalNode;
    }

    //Dijkstra's algorithm
    public ArrayList<Node> dijkstra() {
        /*System.out.println(this.nodeList.size());
        int i =0;
        for (Object key: nodeList.getNodes().keySet()){
            tab[i][0].add(nodeList.getNode((String) key));
            i++;
       }
        System.out.println(i);*/
        return null;
    }
}
