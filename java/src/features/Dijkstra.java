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
    public void dijkstra() {

        ArrayList<Node>[][] tab = new ArrayList[39][1];
        int i = 0;
        for (Object key: nodeList.getNodes().keySet()){
            tab[i][0].add(nodeList.getNode((String) key));
            i++;
        }

        /*for (Object key: nodeList.getNodes().keySet()){
            if (startNode.neighbor(1).contains(nodeList.getNode((String) key))) {
                System.out.println(nodeList.getNode((String) key));
                System.out.println(nodeList.getNode((String) key).getEdges());
            }
        }*/
    }
}
