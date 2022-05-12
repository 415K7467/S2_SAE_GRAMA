package features;

import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {

        Node lyon = new Node("ville", "lyon");
        Node paris = new Node("ville", "paris");
        Node marseille = new Node("ville", "marseille");

        Edge ParisLyon = new Edge("autoroute", 30, lyon);
        Edge LyonParis = new Edge("autoroute", 30, paris);
        Edge LyonMarseille = new Edge("autoroute", 30, marseille);
        Edge MarseilleLyon = new Edge("autoroute", 30, lyon);
        Edge MarseilleParis = new Edge("autoroute", 30, paris);
        Edge ParisMarseille = new Edge("autoroute", 30, marseille);

        paris.addEdge(ParisLyon);
        lyon.addEdge(LyonMarseille);
        lyon.addEdge(LyonParis);
        ArrayList<Node> tab = paris.neighborOneDistance(paris);

        for (int i = 0; i<tab.size(); i++){
            System.out.println(tab.get(i).getName());
        }/*
        System.out.println("/////////////////////////////////////////");
        Node[] tab2 = paris.neighborTwoDistance();
        for (int i = 0; i<tab2.length; i++){
            System.out.println(tab2[i]);
        }*/
    }
}
