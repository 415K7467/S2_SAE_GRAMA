public class Arete {

    private final String type;
    private final int taille;
    private final Noeud noeudArrive;

    public Arete(String type, int taille, Noeud noeudArrive) {
        this.type = type;
        this.taille = taille;
        this.noeudArrive = noeudArrive;
    }

    public String getType() {
        return type;
    }

    public int getTaille() {
        return taille;
    }

    public Noeud getNoeudArrive() {
        return noeudArrive;
    }

    @Override
    public String toString() {
        return "Arete{" +
                "type='" + type + '\'' +
                ", taille=" + taille +
                ", noeudArrive=" + noeudArrive +
                '}';
    }
}
