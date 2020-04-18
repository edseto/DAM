public class Vaixell {
    private String matricula;
    private double eslora; //Llargada
    private double manega; //Amplada
    private int prioritat;

    //Constructors
    public Vaixell() { /*Default*/ }

    public Vaixell(String matricula, double eslora, double manega){
        setMatricula(matricula);
        setEslora(eslora);
        setManega(manega);
        setPrioritat(0);
    }        

    //Getters
    public String getMatricula() { return this.matricula; }
    public double getEslora() { return this.eslora; }
    public double getManega() { return this.manega; }
    public int getPrioritat() { return this.prioritat; }
    
    //Setters
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setEslora(double eslora) { this.eslora = eslora; }
    public void setManega(double manega) { this.manega = manega; }
    public void setPrioritat(int prioritat) { this.prioritat = prioritat; }

    //Mètodes
    public boolean atracar(String embarcador, Embarcadors gestio) throws Exception{
        if(!gestio.atracarVaixell(embarcador, this)) throw new Exception("Error al atracar");
        return true;
    }

    public double solicitarPreu(Embarcadors gestio){
        double preu;
        int dies;

        dies = gestio.diesEmbarcat(this);
        preu = getPrioritat() + dies * ((getPrioritat()/100 * getEslora()) + (getPrioritat()/100 * getManega()));
        
        return preu;
    }
}