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
        Node[] tab = paris.neighbor1distance();
        for (int i = 0; i<tab.length; i++){
            System.out.println(tab[i]);
        }
        System.out.println("/////////////////////////////////////////");
        Node[] tab2 = paris.neighbor2distance();
        for (int i = 0; i<tab2.length; i++){
            System.out.println(tab2[i]);
        }
    }
}
