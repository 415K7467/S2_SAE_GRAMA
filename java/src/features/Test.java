package features;

import java.util.ArrayList;

import dataImport.*;
//import HCI.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Nodes nodes = CSVReader.extractData();        //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes


        Node depart = new all.get("lyon 5");
        Dijkstra dijkstra = new Dijkstra(nodes, );
    }
}
