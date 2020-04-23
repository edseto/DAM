import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
public class Embarcadors {
    ArrayList <Embarcador> gestio = new ArrayList<Embarcador>();
    private int posicio;

    //Constructor
    public Embarcadors() {
        inicialitzar();
    }

    //Mètodes
    private void inicialitzar(){
        int[] nEmbarcadors = {80, 50, 70};
        int[] eslores = {200, 300, 400};
        int[] manega = {100, 100, 150};
        int i;

        for (i = 0; i < nEmbarcadors.length; i++) {
            crearEmbarcador(nEmbarcadors[i], eslores[i], manega[i]);
        }
    }

    private void crearEmbarcador(int nEmbarcadors, int eslora, int manega){
        String nom, lletres, abecedari="abcdefghijklmnopqrstuvwxyz";
        int i, index = 0, posicio = 0;

        for (i = 0; i < nEmbarcadors; i++) {
            lletres = ""; nom="-"+eslora+"x"+manega;
            if(posicio==abecedari.length()){
                index++; posicio = 0;
            } 
            lletres = lletres + abecedari.charAt(index);

            if(lletres.charAt(0)==abecedari.charAt(posicio)) posicio++;

            lletres = lletres + abecedari.charAt(posicio);
            nom = lletres + nom;

            gestio.add(new Embarcador(nom, eslora, manega));
            posicio++;
        }
    }

    //Llistar tots els embarcadors
    public void llistar(){
        for (Embarcador embarcador : gestio) System.out.println(embarcador.getNom());
    }

    //Llistar tots els embarcadors disponibles
    public void llistarBuits(){
        for (Embarcador embarcador : gestio) {
            if(embarcador.getVaixell()==null) System.out.println(embarcador.getNom());
        }
    }

    //Llistar tots els embarcadors plens
    public void llistarPlens(){
        for (Embarcador embarcador : gestio) {
            if(embarcador.getVaixell()!=null) System.out.println(embarcador);
        }
    }

    //Atracar vaixell
    public boolean atracarVaixell(String embarcador, VaixellBase vaixell) throws Exception {
        if(!embarcadorExisteix(embarcador)) throw new Exception("L'embarcador no existeix!");
        if(!embarcadorLliure(gestio.get(posicio))) throw new Exception("L'embarcador ja esta ocupat");
        if(!midesBones(vaixell, gestio.get(posicio))) throw new Exception("El vaixell no entra en aquest embarcador");

        gestio.get(posicio).setVaixell(vaixell);
        return true;
    }

    //Comprovar que existeix l'embarcador
    private boolean embarcadorExisteix(String embarcador){
        boolean trobat = false;
        posicio = 0;

        while (!trobat&&posicio<gestio.size()) {
            if(gestio.get(posicio).getNom().equals(embarcador)) trobat=true;
            else posicio++;
        }

        return trobat;
    }

    //Embarcador lliure?
    private boolean embarcadorLliure(Embarcador embarcador){
        if(embarcador.getVaixell()==null) return true;
        return false;
    }

    //Cabrà el vaixell? (No se m'acudia cap nom que quedés bé :D)
    private boolean midesBones(VaixellBase vaixell, Embarcador embarcador) throws Exception{
        if(moltAmple(vaixell, embarcador)) throw new Exception("El vaixell es massa llarg per aquest embarcador!");
        if(moltLlarg(vaixell, embarcador)) throw new Exception("El vaixell es massa ample per aquest embarcador!");
        
        return true;
    }

    private boolean moltAmple(VaixellBase vaixell, Embarcador embarcador){
        return vaixell.getEslora()>embarcador.getEslora();
    }

    private boolean moltLlarg(VaixellBase vaixell, Embarcador embarcador){
        return vaixell.getManega()>embarcador.getManega();
    }

    //Solicitar Embarcador
    public String solicitarEmbarcador(VaixellBase vaixell) throws Exception{
        boolean trobat = false;
        posicio = 0;

        while (!trobat&&posicio<gestio.size()) {
            if(!moltAmple(vaixell, gestio.get(posicio))&&!moltLlarg(vaixell, gestio.get(posicio))){
                if(embarcadorLliure(gestio.get(posicio))) trobat = true;
            }else{
                posicio++;
            }
        }

        if(!trobat) throw new Exception("Ho sento, no hi ha cap embarcador disponible que vagi be amb el teu vaixell :(");
        return gestio.get(posicio).getNom();
    }

    public int diesEmbarcat(VaixellBase vaixell){
        boolean trobat = false;
        posicio = 0;

        while (!trobat&&posicio<gestio.size()) {
            if(gestio.get(posicio).getVaixell().equals(vaixell)) trobat=true;
            else posicio++;
        }

        return (int)ChronoUnit.DAYS.between(LocalDate.now(), gestio.get(posicio).getDataEmbarcament());
    }

    public String alliberar(String embarcador) throws Exception {
        String matricula;
        double preu;

        if(!embarcadorExisteix(embarcador)) throw new Exception("L'embarcador no existeix");

        matricula = gestio.get(posicio).getVaixell().getMatricula();
        preu = gestio.get(posicio).getVaixell().solicitarPreu(this);

        return "El vaixell amb matricula "+matricula + " ha salpat, el preu a abonar es de: "+preu+"€";
    }
}