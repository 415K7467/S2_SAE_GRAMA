public class Test {
    public static void main(String[] args) {

        Noeud lyon = new Noeud("ville", "lyon");
        Noeud paris = new Noeud("ville", "paris");
        Noeud marseille = new Noeud("ville", "marseille");

        Arete ParisLyon = new Arete("autoroute", 30, lyon);
        Arete LyonParis = new Arete("autoroute", 30, paris);
        Arete LyonMarseille = new Arete("autoroute", 30, marseille);
        Arete MarseilleLyon = new Arete("autoroute", 30, lyon);
        Arete MarseilleParis = new Arete("autoroute", 30, paris);
        Arete ParisMarseille = new Arete("autoroute", 30, marseille);

        paris.ajoutArete(ParisLyon);
        lyon.ajoutArete(LyonMarseille);
        Noeud[] tab = paris.voisin1distance();
        for (int i = 0; i<tab.length; i++){
            System.out.println(tab[i]);
        }
        System.out.println("/////////////////////////////////////////");
        Noeud[] tab2 = paris.voisin2distance();
        for (int i = 0; i<tab2.length; i++){
            System.out.println(tab2[i]);
        }
    }
}
