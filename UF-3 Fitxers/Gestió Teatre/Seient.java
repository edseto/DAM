public class Seient {
    private String id;
    private Reserves reserves;

    //Constructors
    public Seient() { }

    public Seient(String id) {
        this.id = id;
        this.reserves = new Reserves();
    }

    //Getters
    public String getId() { return id; }
    public Reserves getReserves() { return reserves; }

    //Setters
    public void setId(String id) { this.id = id; }

    //Mètodes
    @Override
    public String toString() {
        return "Seient [id= " + id + "]";
    }
}