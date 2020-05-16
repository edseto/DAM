import java.util.ArrayList;
import org.json.*;
public class Seients {
    ArrayList<Seient> seients = new ArrayList<Seient>();

    //Constructors
    public Seients() { }

    public Seients(int zona, String fitxer) throws JSONException {
        int nSeients;
        String idSeient;
        nSeients = FuncionsJSON.numeroSeients(zona, fitxer);

        for (int i = 0; i < nSeients; i++) {
            idSeient = "Z"+zona+"-"+i; //id = Z1 - 0 (numZona - numSeient)
            seients.add(new Seient(idSeient));
        }
    }
    
    //Mètodes
    public int buscarSeient(String idSeient){
        int posicio = -1, index=0;
        boolean trobat = false;

        while (!trobat&&index<seients.size()) {
            if(seients.get(index).getId().equals(idSeient)){trobat = true; posicio = index;}
            else index++;
        }

        return posicio;
    }
}