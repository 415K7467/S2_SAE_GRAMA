package features;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {
    private final Node startNode;
    private final Node arrivalNode;
    private int pathdistance;
    private ArrayList<Node> path;
    private Nodes allNodes = Test.allnodes;
    private HashMap<String, listNode> allNodesD = new HashMap<String, listNode>();
    private Node currentNode;
    ArrayList<Node> neighbors;

    public Dijkstra(Node startNode, Node arrivalNode) {
        this.startNode = startNode;
        this.arrivalNode = arrivalNode;
        this.pathdistance = Integer.MAX_VALUE;
        this.path = null;
    }

    private void initializationOfAllNodesD() {
        for (Object node : allNodes.getNodes().values()) {
            Node node1 = (Node) node;
            listNode listNode = new listNode(null, node1, Integer.MAX_VALUE);
            allNodesD.put(node1.getName(), listNode);
        }
    }

    private void addDistance(Node minimalNodes) {
        int distance = allNodesD.get(minimalNodes).getDistance();
        currentNode = minimalNodes;
    }

    public void fonctionDijkstra() {
        String minimalNodeTmp;
        initializationOfAllNodesD();

        allNodesD.get(startNode).setDistance(0);
        currentNode = startNode;
        while (!currentNode.equals(arrivalNode)) {
            neighborsDijsktra(currentNode);
            minimalNodeTmp = minimalNode();
            currentNode = allNodesD.get(minimalNodeTmp).getActualNode();
        }
    }

    private String minimalNode() {
        Node node1 = null;
        for (Object node : allNodes.getNodes().values()) {
            if (node1 == null || allNodesD.get(node).getDistance() < allNodesD.get(node1).getDistance()) {
                node1 = (Node) node;
            }
        }
        return node1.getName();
    }

    private void deleteNodes(Node node) {
        allNodesD.remove(node);
    }

    private void neighborsDijsktra(Node node) {
        for (int i = 0; i < node.getEdges().size(); i++) {
            Node neighbor1 = node.getEdges().get(i).getArriveNode();
            if ((allNodesD.get(neighbor1).getDistance() > allNodesD.get(node).getDistance() + (int) (node.getEdges().get(i).getSize()))) {
                deleteNodes(neighbor1);
                allNodesD.put(neighbor1.getName(), new listNode(node, neighbor1, allNodesD.get(node).getDistance() + (int) (node.getEdges().get(i).getSize())));
                ;
            }
        }
        System.out.println("pour le trajet de " + this.startNode.getName() + " a " + this.arrivalNode.getName() + " est d'une longueur de: " + this.pathdistance);
        System.out.println("le chemin est : " + this.path);
    }

}

    /*

    public void searchPathDijkstra() {
        Nodes allNodes = Test.allnodes;
        HashMap<Node, Integer> listLastNode = new HashMap<Node, Integer>();     //listLastNode[currentNode] = distance
        //intialization
        for (Object node : allNodes.getNodes().values()) {
            listLastNode.put((Node) node, Integer.MAX_VALUE);
        }
        listLastNode.put(startNode, 0);
        Node currentNode = startNode;
        Integer minDistance = listLastNode.get(1);
        //end of initialization
         while (arrivalNode != currentNode) {
            ArrayList<Node> neighborCurrentNode = currentNode.neighbor(1);
            HashMap<Node,Integer> minimal = minimalNeighbor(neighborCurrentNode,distance);
            //loosness                                                                                       //revoir le relachement
            for (Object node : minimal.keySet()) {
                if ( 2  > minDistance+minimal.get(1)) {
                    listLastNode.put((Node) node, minDistance);
                }
            }
            //end of loosness
             distance = minDistance;
             System.out.println("distance = " + distance+" path = " + path+"\n");
         }
    }

    public HashMap<Node,Integer> minimalNeighbor(ArrayList<Node> neighborCurrentNode,distance){
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
}*/
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
