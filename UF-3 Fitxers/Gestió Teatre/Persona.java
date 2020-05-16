public class Persona {
    private String dni;
    private String nom;
    
    //Constructors
    public Persona() { }

    public Persona(String dni, String nom) {
        this.dni = dni;
        this.nom = nom;
    }

    //Getters
    public String getDni() { return dni; }
    public String getNom() { return nom; }

    //Setters
    public void setDni(String dni) { this.dni = dni; }
    public void setNom(String nom) { this.nom = nom; }

    
    //Mètodes
    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nom=" + nom + "]";
    }
    
}