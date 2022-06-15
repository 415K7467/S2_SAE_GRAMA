package features;

import HCI.jswing.Window;
import dataImport.*;
//import java.HCI.*;

/**
 * @author Vincent Chavot -- Dambrun
 */
public class Main {
    public static Nodes allnodes;

    static {
        try {
            allnodes = CSVReader.extractData();     //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     * main method
     */
    public static void main(String[] args){
        Window.constrwindow();
    }
}

/*Gros bordel du main qui est pas utilisé
        Node node1 = allnodes.getNode("Lyon 5");
        Node node2 = allnodes.getNode("Lyon 6");

        System.out.println(allnodes.getNode("Lyon 5")); //search for a Node by name and print it
        System.out.println( allnodes.getNode("Lyon 5").neighbor(2));
        node1.compareNodes(node2,1,"R");
    //new Dijkstra(node1,node2).fonctionDijkstra();
    //new Dijkstra(node1, node2).searchPathDijkstra();*/