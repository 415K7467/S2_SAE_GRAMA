import java.util.Arrays;

public class Noeud {

    private final String type;
    private final String nom;
    private final Arete[] listeArete;

    public Noeud(String type, String nom) {
        this.type = type;
        this.nom = nom;
        this.listeArete = new Arete[10];
    }

    public String getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    public Arete[] getListeArete() {
        return listeArete;
    }

    @Override
    public String toString() {
        return "Noeud{" +
                "type='" + type + '\'' +
                ", nom='" + nom + '\'' +
                ", listeArete=" + Arrays.toString(listeArete) +
                '}';
    }

    public void ajoutArete(Arete arete){
        for (int i = 0; i < this.listeArete.length; i++){
            if (this.listeArete[i] == null){
                this.listeArete[i] = arete;
                break;
            }
        }
    }

    public Noeud[] voisin1distance(){
        Noeud[] voisin = new Noeud[10];
        int j = 0;
        for (int i = 0; i < this.listeArete.length; i++){
            if (this.listeArete[i] != null){
                voisin[j] = listeArete[i].getNoeudArrive();
            }
        }
        return voisin;
    }

    public Noeud[] voisin2distance(){
        Noeud[] voisin1 = this.voisin1distance();
        Noeud[] voisin2 = new Noeud[10];
        for (int i = 0; i < voisin1.length; i++){
            int k = 0;
            for (int j = 0; i < this.listeArete.length; i++){
                if (this.listeArete[j] != null){
                    voisin2[k] = listeArete[j].getNoeudArrive();
                }
            }
        }
        return voisin2;
    }
}
