package dataImport;

import features.Edge;
import features.Node;
import features.Nodes;

import java.io.*;
import java.util.Scanner;

public class CSVReader {
    public static Nodes allNodes=new Nodes();
    public static void main(String[] args) throws Exception {
        Scanner scanner;
        scanner = scannerCSVOfTheBigin(null);
        extractNodes(scanner);
        scanner = scannerCSVOfTheBigin(scanner);
        //extractEdges(scanner);
        scanner.close();
    }

    public static void extractNodes(Scanner scanner) throws Exception {
       scanner.useDelimiter(":");
       while (scanner.hasNext()) {
           Scanner scannerNode = new Scanner(scanner.next());
           scannerNode.useDelimiter(",");
           Node node = new Node(scannerNode.next(), scannerNode.next());
           allNodes.addNode(node);
           scanner.nextLine();
       }
        System.out.println(allNodes.toString());
    }
/*
    public static void extractEdges(Scanner scanner) throws Exception {
        int index = 0;
        scanner.useDelimiter(":|,|;");
        while (scanner.hasNext()) {
            scanner.next();
            scanner.next();
            while (scanner.hasNext()) {
                String edgeType = scanner.next();
                float edgeWeight =Float.parseFloat(scanner.next());
                //.substring(0, scanner.next().length() - 1)
                scanner.next();
                scanner.next();
                scanner.next();
                Node edgearrive = allNodes.searchNode(scanner.next());
                Edge tmpEdge=new Edge(edgeType, edgeWeight, edgearrive);
                allNodes.get(index).addEdge(tmpEdge);
            }
            scanner.nextLine();
            index++;
        }
        System.out.println(allNodes.toString());
    }
/*/
    public static Scanner scannerCSVOfTheBigin(Scanner scanner) throws Exception {
        if (scanner!=null) {
        scanner.close();
        }
        scanner = new Scanner(new File("src/dataImport/CSV.csv"));
        return scanner;
    }

}