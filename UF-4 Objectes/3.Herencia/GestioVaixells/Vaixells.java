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

    public double preu(Embarcadors gestio, String embarcador) throws Exception{
        VaixellBase vaixell;
        int posicio;

        vaixell = vaixell(gestio, embarcador);
        posicio = vaixells.indexOf(vaixell);

        if(posicio==-1) throw new Exception("No hi ha cap vaixell atracat en aquest embarcador!");

        return vaixells.get(posicio).solicitarPreu(gestio);
    }

    private VaixellBase vaixell(Embarcadors embarcadors, String embarcador){
        boolean trobat = false;
        int i = 0;

        while (!trobat&&i<embarcadors.gestio.size()-1) {
            if(embarcadors.gestio.get(i).getNom().equals(embarcador)) trobat = true;
            else i++;
        }

        return embarcadors.gestio.get(i).getVaixell();
    }

    //Atracar
    public boolean atracar(String embarcador, Embarcadors gestio) throws Exception{
        if(vaixellAtracat(gestio)) throw new Exception("El vaixell ja ha estat atracat anteriorment");
        if(!vaixells.get(vaixells.size()-1).atracar(embarcador, gestio)) throw new Exception("Error a l'atracar");
        return true;
    }

    //Comprovar si el vaixell ja ha estat atracat
    private boolean vaixellAtracat(Embarcadors embarcadors){
        boolean trobat = false;
        int i = 0;

        while (!trobat && i<embarcadors.gestio.size()) {
            if(embarcadors.gestio.get(i).getVaixell()!=null){
                if(embarcadors.gestio.get(i).getVaixell().equals(vaixells.get(vaixells.size()-1))) trobat = true;
                else i++;
            }else i++;
        }

        return trobat;
    }

    //Borrar vaixell
    public void adeuVaixell(String matricula){
        vaixells.remove(posicioVaixell(matricula));
    }

    //Buscar Vaixell
    private int posicioVaixell(String matricula){
        boolean trobat = false;
        int i = 0;

        while(!trobat&&i<vaixells.size()){
            if(vaixells.get(i).getMatricula().equals(matricula)) trobat = true;
            else i++;
        }

        return i;
    }
}