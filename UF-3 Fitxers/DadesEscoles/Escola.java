public class Escola {
    private int id;
    private int profes; //Dedicació profes
    private String st_leaid; //Agrupació per Estat (ex. AL-101)
    
    //Constructors
    public Escola() { /*Default*/ }
    
    public Escola(int id, int profes, String st_leaid) {
        this.id = id;
        this.profes = profes;
        this.st_leaid = st_leaid;
    }

    //Getters
    public int getId() { return id; }
    public int getProfes() { return profes; }
    public String getSt_leaid() { return st_leaid; }

    //Setters
    public void setId(int id) { this.id = id; }
    public void setProfes(int profes) { this.profes = profes; }
    public void setSt_leaid(String st_leaid) { this.st_leaid = st_leaid; }
}