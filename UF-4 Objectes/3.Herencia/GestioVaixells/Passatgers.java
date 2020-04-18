public class Passatgers extends Vaixell implements VaixellBase{
    //Constructors
    public Passatgers() {/* Default*/ }

    public Passatgers(String matricula, double eslora, double manega){
        super(matricula, eslora, manega);
        super.setPrioritat(prioritat());
    }

    //Mètodes
    @Override
    public int prioritat(){
        return 50;
    }
}