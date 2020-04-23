public class Passatgers extends Vaixell implements VaixellBase{
    //Constructors
    public Passatgers() {/* Default*/ }

    public Passatgers(String matricula, double eslora, double manega){
        super(matricula, eslora, manega);
    }

    //Mètodes
    @Override
    public int prioritat(){
        return 50;
    }

    @Override
    public double solicitarPreu(Embarcadors gestio){
        double preu, preuBase;
        int dies;

        preuBase = preuPrioritat(prioritat());
        dies = gestio.diesEmbarcat(this);
        preu = preuBase + dies * ((preuBase/100 * getEslora()) + (preuBase/100 * getManega()));
        
        return preu;
    }

    @Override
    public boolean atracar(String embarcador, Embarcadors gestio) throws Exception{
        if(!gestio.atracarVaixell(embarcador, this)) throw new Exception("Error al atracar");
        return true;
    }
}