import org.json.JSONException;
public class Zona {
    private int id;
    private double preu;
    private Seients seients;

    // Constructors
    public Zona() {
    }

    public Zona(int id, double preu, String fitxer) throws JSONException {
        this.id = id;
        this.preu = preu;
        this.seients = new Seients(id, fitxer);
    }

    //Getters
    public int getId() { return id; }
    public double getPreu() { return preu; }
    public Seients getSeients() { return seients; }

    //Setters
    public void setId(int id) { this.id = id; }
    public void setPreu(double preu) { this.preu = preu; }
    public void setSeients(Seients seients) { this.seients = seients; }
    
    //Mètodes
    @Override
    public String toString() {
        return "Zona [id=" + id + ", preu=" + preu + ", totalseients=" + seients.seients.size() + "]";
    }
}