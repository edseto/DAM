import java.util.ArrayList;
public class Estats {
    ArrayList<Estat> estats = new ArrayList<Estat>();

    //Constructors
    public Estats(){ /*Default*/ }

    //Mètodes
    public void afegirEstat(int id, String estat) {
        estats.add(new Estat(id, estat));
    }

    public int buscarEstat(String estat){
        int index = -1, i = 0;

        while (index==-1 && i<estats.size()) {
            if(estat.equals(estats.get(i).getNom())) index = i;
            else i++;
        }

        return index;
    }
}