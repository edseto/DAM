public class Vaixell {
    String matricula;
    double eslora; //Llargada
    double manega; //Amplada

    //Constructors
    public Vaixell() { /*Default*/ }

    public Vaixell(String matricula, double eslora, double manega){
        setMatricula(matricula);
        setEslora(eslora);
        setManega(manega);
    }        

    //Getters
    public String getMatricula() { return this.matricula; }
    public double getEslora() { return this.eslora; }
    public double getManega() { return this.manega; }

    //Setters
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setEslora(double eslora) { this.eslora = eslora; }
    public void setManega(double manega) { this.manega = manega; }

    //Mètodes
    public boolean atracar(String embarcador, Embarcadors gestio) throws Exception{


        return true;
    }
}