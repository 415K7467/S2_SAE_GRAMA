package features;

import dataImport.*;
//import HCI.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Nodes allnodes = CSVReader.extractData();        //put data in Nodes, a HashMap of Nodes and put Edges in ArrayLists in some Nodes
        System.out.println(allnodes.getNode("Lyon 5")); //search for a Node by name and print it
        System.out.println( allnodes.getNode("Lyon 5").neighbor(2));
        System.out.println( allnodes.getNode("Lyon 5").neighborTwoDistance());
    }
}
