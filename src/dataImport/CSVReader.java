package dataImport;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import features.*;

public class CSVReader {
    public static Nodes allNodes=new Nodes();

    public static Nodes extractData() throws Exception {
        Scanner scanner;
        scanner = scannerCSVOfTheBigin(null);
        extractNodes(scanner);
        scanner = scannerCSVOfTheBigin(scanner);
        extractEdges(scanner);
        scanner.close();
        System.out.println(allNodes);
        return allNodes;
    }

    public static void extractNodes(Scanner scanner) {
        scanner.useDelimiter(":");
        while (scanner.hasNext()) {
            Scanner scannerNode = new Scanner(scanner.next());
            scannerNode.useDelimiter(",");
            Node node = new Node(scannerNode.next(), scannerNode.next());
            allNodes.addNode(node);
            scanner.nextLine();
        }
    }

    public static void extractEdges(Scanner scanner) {
        try {
            while (scanner.hasNextLine()) {
                String thisNode ;
                scanner.useDelimiter("[,:]");
                scanner.next();
                thisNode = scanner.next();
                scanner.useDelimiter(";;");
                ArrayList<Edge> edges = extraction(scanner.next());             //create ArrayList of edges for this node
                allNodes.getNode(thisNode).setEdges(edges);                     //add edges to the node
            }
        }
        catch (Exception e){
            System.out.println("end of file");
        }

    }

    public static ArrayList<Edge> extraction(String line) {
        Scanner scanner = new Scanner(line);
        ArrayList<Edge> edges = new ArrayList<>();
        while (scanner.hasNext()) {
            scanner.useDelimiter("[,:;]");
            String style = scanner.next();
            float weight = Float.parseFloat(scanner.next());
            scanner.next();
            scanner.next();
            Node arrivalNode = allNodes.getNode(scanner.next());
            Edge edge = new Edge(style,weight,arrivalNode);
            edges.add(edge);
        }
        return edges;
    }

    public static Scanner scannerCSVOfTheBigin(Scanner scanner) throws Exception {
        if (scanner!=null) {
            scanner.close();
        }
        return new Scanner(new File("src/dataImport/CSV.csv"));
    }
}
