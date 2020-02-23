/*
    1. El menú
    Crea una funció per a visualitzar un menú.
    Aquesta funció ha de retornar el valor que
    hagi introduït l’usuari. Per a entrar l’opció ,
    cal crear una altra funció a la qual enviarem
    quins són els valors vàlids. En la imatge es
    mostren les opcions del menú i de
    funcionament del programa.
*/
import java.util.Scanner;
public class Menu{
    public static String opcio;
    public static String ImprimirMenu(String opcio){
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("I - Inicialitzar tauler");
        System.out.println("II - Colocar mines");
        System.out.println("III - Jugar");
        System.out.println("IV - Veure tauler");
        System.out.println("V - Veure mines");
        System.out.println("VI - Sortir");
       
        System.out.print("\t\t Selecciona una opcio: ");
        opcio = sc.next();

        return opcio;
    }
    public static boolean ComprovarOpcio(String[] opcions, String opcio){
        boolean correcte = false;
        int i=0;

        while(!correcte && i<opcions.length){
            if(opcions[i].equals(opcio)){
                correcte = true;
            }
            i++;
        }
        return correcte;
    }
    public static void main(String[] args) {
        IniciTauler inici = new IniciTauler();
        String[] opcions = {"I","II","III","IV","V","VI"};
        boolean correcte;

        do {
            opcio = ImprimirMenu(opcio);
            correcte = ComprovarOpcio(opcions, opcio);
            if(!correcte){
                System.out.println("Opcio incorrecte. Les opcions valides son (I,II,III,IV,V,VI)");
            }
        } while (!correcte);
        switch (opcio){
            case "I": IniciTauler.main(null);
            break;
            case "II": ColocarMines.main(null);
            break;
            case "III": Jugar.main(null);
            break;
            case "IV": VisualitzarTauler.TaulerNoMines(inici);
            Menu.main(null);
            break;
            case "V": VisualitzarTauler.TaulerMines(inici);
            Menu.main(null);
            break;
            case "VI": System.out.println("Gracies per participar!! :D");
        }
    }
}