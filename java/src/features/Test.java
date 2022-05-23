package features;

import dataImport.*;
//import HCI.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Nodes allnodes = CSVReader.extractData();        //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes
        System.out.println(allnodes.getNode("Lyon 5")); //search for a Node by name and print it
        System.out.println( allnodes.getNode("Lyon 5").neighbor(2));
        Nodes nodes = CSVReader.extractData();        //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes


        Node depart = nodes.getNode("Lyon 5");
        Node arrive = nodes.getNode("Lyon 6");

        Dijkstra test = new Dijkstra(nodes, depart, arrive);
        test.dijkstra();


        depart.compareNodes(arrive,3,"V");
    }
}
