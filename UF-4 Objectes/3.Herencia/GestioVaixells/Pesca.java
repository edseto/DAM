public class Pesca extends Vaixell implements VaixellBase{
    //Constructors
    public Pesca() {/* Default*/ }

    public Pesca(String matricula, double eslora, double manega){
        super(matricula, eslora, manega);
    }

    //Mètodes
    @Override
    public int prioritat(){
        return 10;
    }

    @Override
    public double solicitarPreu(Embarcadors gestio){
        double preu;
        int dies;

        dies = gestio.diesEmbarcat(this);
        preu = prioritat() + dies * ((prioritat()/100 * getEslora()) + (prioritat()/100 * getManega()));
        
        return preu;
    }

    @Override
    public boolean atracar(String embarcador, Embarcadors gestio) throws Exception{
        if(!gestio.atracarVaixell(embarcador, this)) throw new Exception("Error al atracar");
        return true;
    }
}