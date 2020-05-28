public class Estat {
    private int id;
    private String nom;
    private Nivells nivells;

    // Constructors
    public Estat() { /* Default */ }

    public Estat(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.nivells = new Nivells();
    }

    //Getters
    public int getId() { return this.id; }
    public String getNom() { return this.nom; }
    public Nivells getNivells() { return nivells; }
    public void setNivells(Nivells nivells) { this.nivells = nivells; }
    
    //Setters
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String toString() {
        return "Estat [id=" + id + ", nom=" + nom + "]";
    }


}