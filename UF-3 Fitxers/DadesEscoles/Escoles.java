import java.util.ArrayList;

public class Escoles {
    ArrayList<Escola> escoles = new ArrayList<Escola>();

    // Constructors
    public Escoles() { /* Default */ }
    
    //Mètodes
    public void afegirEscola(int id, int profes, String st_leaid){
        escoles.add(new Escola(id, profes, st_leaid));
    }
}