/*
    2. Càlcul àrea
    Resoleu el càlcul del perímetre (longitud) i 
    àrea d’una circumferència a partir del seu radi 
    utilitzant constants i variables. Per provar els tipus de les variables 
    i càsting declararem el radi enter; longitud i àrea reals de simple precisió. 
    PI serà una constant.
*/

public class CalculArea{
    public static void main(String[] args) {
        int radi;
        double longitud, area;
        radi = 24;
        longitud = Constants.PI*radi*2;
        area = Constants.PI*(radi*radi);
    System.out.println("La longitud es: " + longitud);
    System.out.println("L'area es: " + area);
    }   
}
