package features;

import HCI.jswing.Window;
import dataImport.*;
//import java.HCI.*;

public class Test {
    public static Nodes allnodes;        //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes

    static {
        try {
            allnodes = CSVReader.extractData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Node node1 = allnodes.getNode("Lyon 5");
        Node node2 = allnodes.getNode("Lyon 6");

        /*System.out.println(allnodes.getNode("Lyon 5")); //search for a Node by name and print it
        System.out.println( allnodes.getNode("Lyon 5").neighbor(2));
        node1.compareNodes(node2,1,"R");*/

        Window.constrwindow();


        Dijkstra test = new Dijkstra(allnodes, node1, node2);
        test.dijkstra();
    }
}
