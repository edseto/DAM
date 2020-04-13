/*
    4. El camp d’hockey
    Modifica el programa anterior per tal que mostri la següent informació.
    Llargada: 36.5 m
    Ample: 27.5 m
    Area: 36.5 m x 27.5 m = 1003.75 m2
*/
public class AreaHockey2{
    public static void main(String[] args) {
        System.out.println("La llargada es: " + Constants.LLARGADA_HOCKEY + "m");
        System.out.println("L'amplada es: " + Constants.AMPLADA_HOCKEY + "m");
        System.out.println("L'area del camp d'hockey es: " + Constants.LLARGADA_HOCKEY + "m" + " x " + 
        Constants.AMPLADA_HOCKEY + "m = " + (Constants.LLARGADA_HOCKEY*Constants.AMPLADA_HOCKEY) + "m2");
    }
}