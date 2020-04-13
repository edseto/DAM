/*
    5. El circuit de motos
    El circuit de Catalunya té una llargada de 4.627 m . 
    Fes un programa que ens mostri els quilòmetres que farà 
    un pilot que dongui 10 voltes al circuit.
*/
public class Circuit{
    public static void main(String[] args) {
        int voltes;
        double distancia;
        
        voltes = 10;
        distancia = (voltes*Constants.LLARGADA_CIRCUIT);
        System.out.println("El pilot fara: " + (distancia/1000) + "km");
    }
}