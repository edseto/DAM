import java.time.LocalDate;
public class Embarcador {
    private String nom;
    LocalDate dataEmbarcament;
    double eslora; //Llargada
    double manega; //Amplada
    //VaixellBase vaixell;

    //Constructors
    public Embarcador() { /*Default*/ }

    public Embarcador(String nom, double eslora, double manega){
        setNom(nom);
        setEslora(eslora);
        setManega(manega);
    }

    //Getters
    public String getNom() { return this.nom; }
    public LocalDate getDataEmbarcament() { return this.dataEmbarcament; }
    public double getEslora() { return this.eslora; }
    public double getManega() { return this.manega; }

    //Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setDataEmbarcament(LocalDate dataEmbarcament) { this.dataEmbarcament = dataEmbarcament; }
    public void setEslora(double eslora) { this.eslora = eslora; }
    public void setManega(double manega) { this.manega = manega; }

}