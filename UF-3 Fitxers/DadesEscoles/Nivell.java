public class Nivell {
    private String nivell;
    private Escoles schools;
    
    //Constructors
    public Nivell() { /* Default */}

    public Nivell(String nivell) {
        this.nivell = nivell;
        this.schools = new Escoles();
    }
    
    //Getters
    public String getNivell() { return nivell; }
    public Escoles getSchools() { return schools; }

    //Setters
    public void setNivell(String nivell) { this.nivell = nivell; }
    public void setSchools(Escoles schools) { this.schools = schools; }

    //Mètodes
    public int calcularProfes(){
        int dedicacio=0;
        
        for (int i = 0; i < schools.escoles.size(); i++) {
            dedicacio += schools.escoles.get(i).getProfes();
        }

        return dedicacio;
    }

}