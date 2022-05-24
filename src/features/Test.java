package features;

import HCI.jswing.Window;
import dataImport.*;
//import java.HCI.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Nodes allnodes = CSVReader.extractData();        //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes
        System.out.println(allnodes.getNode("Lyon 5")); //search for a Node by name and print it
        System.out.println( allnodes.getNode("Lyon 5").neighbor(2));
        Window.constrwindow();


        Node depart = allnodes.getNode("Lyon 5");
        Node arrive = allnodes.getNode("Lyon 6");

        Dijkstra test = new Dijkstra(allnodes, depart, arrive);
        test.dijkstra();


        depart.compareNodes(arrive,3,"V");
    }
}
