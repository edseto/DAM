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
    public boolean atracarVaixell(String embarcador, Vaixell vaixell) throws Exception {
        if(!embarcadorExisteix(embarcador)) throw new Exception("L'embarcador no existeix!");
        if(embarcadorOcupat(gestio.get(posicio))) throw new Exception("L'embarcador ja esta ocupat");

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

    //Embarcador ocupat?
    private boolean embarcadorOcupat(Embarcador embarcador){
        if(embarcador.getVaixell()!=null) return true;
        return false;
    }
}