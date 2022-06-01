package features;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {

    private Node startNode;
    private Node arrivalNode;
    private int distance;
    private ArrayList<Node> path;

    public Dijkstra(Node startNode, Node arrivalNode) {
        this.startNode = startNode;
        this.arrivalNode = arrivalNode;
        this.distance = Integer.MAX_VALUE;
        this.path = null;
    }

    public void searchPathDijkstra() {
        Nodes allNodes = Test.allnodes;
        Node[] currentNode = {null, startNode};
        HashMap<Node, Integer> listLastNode = new HashMap<Node, Integer>();     //listLastNode[currentNode] = distance
        //intialization
        for (Object node : allNodes.getNodes().values()) {
            listLastNode.put((Node) node, Integer.MAX_VALUE);
        }
        listLastNode.put(startNode, 0);
        Integer minDistance = listLastNode.get(1);
        //end of initialization
        while (currentNode[0] != null && arrivalNode != currentNode[0]) {
            ArrayList<Node> neighborCurrentNode = currentNode[0].neighbor(1);
            HashMap<Node,Integer> minimal = minimalNeighbor(neighborCurrentNode);
           //loosness                                                                                       //revoir le relachement
            for (Object node : minimal.keySet()) {
                if (/**/ 2 /**/ > minDistance+minimal.get(1)) {
                    listLastNode.put((Node) node, minDistance);
                }
            }
            //end of loosness
        }
        distance = minDistance;
        System.out.println("distance = " + distance+" path = " + path+"\n");

    }

    public HashMap<Node,Integer> minimalNeighbor(ArrayList<Node> neighborCurrentNode){
        Node minimalNode = null;
        int minimalDistance = Integer.MAX_VALUE;
        for (int i = 0; i < neighborCurrentNode.size(); i++) {
            if (neighborCurrentNode.get(i).getEdges().size() < minimalDistance) {
                minimalDistance = neighborCurrentNode.get(i).getEdges().size();
                minimalNode = neighborCurrentNode.get(i);
            }
        }
        HashMap<Node,Integer> theClothest = new HashMap<Node, Integer>();
        theClothest.put(minimalNode, minimalDistance);
        return theClothest ;
    }
}
/*        while (arrivalNode != currentNode[1]) {
            Node current = currentNode[1];
            for (int i = 0; i < current.getEdges().size(); i++) {
                Node neighbor = current.getEdges().get(i).getArriveNode();
                if (listLastNode.get(neighbor) == null) {
                    listLastNode.put(neighbor, (int) current.getEdges().get(i).getSize());
                } else if (listLastNode.get(neighbor) > current.getEdges().get(i).getSize()) {
                    listLastNode.put(neighbor, (int) current.getEdges().get(i).getSize());
                }
            }
            Node nextNode = null;
            int minDistance = Integer.MAX_VALUE;
            for (Node node : listLastNode.keySet()) {
                if (listLastNode.get(node) < minDistance) {
                    minDistance = listLastNode.get(node);
                    nextNode = node;
                }
            }
            currentNode[0] = currentNode[1];
            currentNode[1] = nextNode;
            listLastNode.remove(nextNode);
        }
        distance = listLastNode.get(arrivalNode);
        path = new ArrayList<Node>();
        Node current = currentNode[1];


        System.out.println("The distance between " + startNode.getName() + " and " + arrivalNode.getName() + " is " + this.distance);
        System.out.println("The path is " + this.path);

    }


    public ArrayList<Node> dijkstra() {
        /*System.out.println(this.nodeList.size());
        int i =0;
        for (Object key: nodeList.getNodes().keySet()){
            tab[i][0].add(nodeList.getNode((String) key));
            i++;
       }
        System.out.println(i);
        return null;
    }
}*/
