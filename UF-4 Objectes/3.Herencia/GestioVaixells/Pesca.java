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
}