package dataImport;

import features.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static Nodes allNodes=new Nodes();
    public static void main(String[] args) throws Exception {
        Scanner scanner;
        scanner = scannerCSVOfTheBigin(null);
        extractNodes(scanner);
        scanner = scannerCSVOfTheBigin(scanner);
        extractEdges(scanner);
        scanner.close();
        System.out.println(allNodes.toString());
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
        //System.out.println(allNodes.toString());
    }

    public static void extractEdges(Scanner scanner) throws Exception {
        int i=1;
        try {
            while (scanner.hasNextLine()) {
                String thisNode ;
                scanner.useDelimiter(",|:");
                scanner.next();
                thisNode = scanner.next();
                System.out.println("line: " + i + "\n" + "thisNode: "+thisNode);
                scanner.useDelimiter(";;");
                ArrayList<Edge> edges = extraction(scanner.next());           //create ArrayList of edges for this node
                allNodes.searchNode(thisNode).setEdges(edges);                //add edges to the node
                System.out.println("\n\n\n");
                i++;
            }
        }
        catch (Exception e){
            System.out.println("end of file");
        }

    }

    public static ArrayList<Edge> extraction(String line) throws Exception {
        Scanner scanner = new Scanner(line);
        ArrayList<Edge> edges = new ArrayList<>();
        while (scanner.hasNext()) {
            scanner.useDelimiter(",|:|;");
            String style = scanner.next();
            System.out.print("style: "+style);
            float weight = Float.parseFloat(scanner.next());
            System.out.print(" weight: "+weight);
            scanner.next();
            scanner.next();
            Node arrivalNode = allNodes.searchNode(scanner.next());
            System.out.print(" arrivalNode: "+arrivalNode);
            Edge edge = new Edge(style,weight,arrivalNode);
            System.out.println("edge: "+edge);
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