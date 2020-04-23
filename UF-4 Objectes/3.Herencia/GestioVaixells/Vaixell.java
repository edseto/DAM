public class Vaixell {
    private String matricula;
    private double eslora; //Llargada
    private double manega; //Amplada

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
    protected double preuPrioritat(int prioritat){
        double preu;

        switch (prioritat) {
            case 10: preu = 100;
                break;
            case 20: preu = 175;
                break;
            case 50: preu = 450;
                break;
            default: preu = 10; //Per posar un preu per defecte
                break;
        }
        return preu;
    }
}