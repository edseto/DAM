import java.util.ArrayList;
public class Vaixells {
    ArrayList<VaixellBase> vaixells = new ArrayList<VaixellBase>();

    //Constructors
    public Vaixells(){  }

    //Mètodes
    //Llistar tots els vaixells
    public void llistar(){
        for (VaixellBase vaixell : vaixells) 
            System.out.println(vaixell.getMatricula()+" -> "+vaixell.getEslora()+"x"+vaixell.getManega()); 
    }

    //Preu
    public double preu(Embarcadors gestio){
        return vaixells.get(vaixells.size()-1).solicitarPreu(gestio);
    }

    //Atracar
    public boolean atracar(String embarcador, Embarcadors gestio) throws Exception{
        if(!vaixells.get(vaixells.size()-1).atracar(embarcador, gestio)) throw new Exception("Error al atracar");
        return true;
    }
}