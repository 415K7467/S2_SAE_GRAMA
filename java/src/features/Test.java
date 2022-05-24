package features;

import dataImport.*;
//import HCI.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Nodes nodes = CSVReader.extractData();        //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes


        Node depart = nodes.getNode("Lyon 5");
        Node arrive = nodes.getNode("Lyon 6");

        Dijkstra test = new Dijkstra(nodes, depart, arrive);
        test.dijkstra();


        depart.compareNodes(arrive,3,"V");
    }
}
