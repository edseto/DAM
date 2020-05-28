import java.util.ArrayList;
public class Nivells {
    ArrayList<Nivell> nivells = new ArrayList<Nivell>();

    //Constructors
    public Nivells(){
        nivells.add(new Nivell("Middle"));
        nivells.add(new Nivell("High"));
        nivells.add(new Nivell("Elementary"));
    }

    public int buscarLevel(String nivell){
        int index = -1, i = 0;

        while (index==-1 && i < nivells.size()) {
            if(nivell.equals(nivells.get(i).getNivell())) index = i;
            else i++;
        }

        return index;
    }
}