public class Carrega extends Vaixell implements VaixellBase{
    //Constructors
    public Carrega() {/* Default*/ }

    public Carrega(String matricula, double eslora, double manega){
        super(matricula, eslora, manega);
        super.setPrioritat(prioritat());
    }

    //Mètodes
    @Override
    public int prioritat(){
        return 20;
    }
}