import java.time.LocalDate;
public class Embarcador {
    private String nom;
    private LocalDate dataEmbarcament;
    private double eslora; //Llargada
    private double manega; //Amplada
    private VaixellBase vaixell;

    //Constructors
    public Embarcador() { /*Default*/ }

    public Embarcador(String nom, int eslora, int manega){
        setNom(nom);
        setEslora(eslora);
        setManega(manega);
        setVaixell(null);
    }

    //Getters
    public String getNom() { return this.nom; }
    public LocalDate getDataEmbarcament() { return this.dataEmbarcament; }
    public double getEslora() { return this.eslora; }
    public double getManega() { return this.manega; }
    public VaixellBase getVaixell() { return this.vaixell; }

    //Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setDataEmbarcament(LocalDate dataEmbarcament) { this.dataEmbarcament = dataEmbarcament; }
    public void setEslora(double eslora) { this.eslora = eslora; }
    public void setManega(double manega) { this.manega = manega; }
    public void setVaixell(VaixellBase vaixell) { 
        this.vaixell = vaixell;
        if(this.vaixell!=null) setDataEmbarcament(LocalDate.now()); 
    }

    //Mètodes
    public void alliberar(){
        setVaixell(null);
    }

    @Override
    public String toString(){
        return vaixell.getMatricula()+" -> "+ vaixell.getEslora()+" x "+ vaixell.getManega()+" - "+
        this.getNom()+" Data embarc: "+this.getDataEmbarcament();
    }
}