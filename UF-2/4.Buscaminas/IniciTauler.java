/*
    2. Inicialitzar tauler
    Fes una funció que demani el nombre de files i de columnes que ha de tenir el tauler. No es pot
    utilitzar cap vector per a introduir les dades ni emmagatzemar les dades. La mida màxima del
    tauler serà de 20 x 20. La mida mínima del tauler serà de 3 x 3.
    Cal definir la funció com a
    private static void entrarDimensio(...)
    on cal substituir els "..." pels paràmetres que cal enviar a la funció.
    Introduïdes les files i les columnes que ha de tenir el tauler, crea una altra funció que
    inicialitzi totes les posicions del tauler.
*/
import java.util.Scanner;
public class IniciTauler{
    public static char[][] tauler;
    public static char[][] mines; //Aquesta matriu serà per colocar les mines
    public static Dimensions t = new Dimensions();

    private static void EntrarDimensio(Dimensions t){
        Scanner sc = new Scanner(System.in); 

        do {
            System.out.print("Introdueix el numero de files (3-20): ");
            t.files = sc.nextInt();
        } while (t.files<Constants.MIDA_MIN||t.files>Constants.MIDA_MAX);
        
        do {
            System.out.print("Introdueix el numero de columnes (3-20): ");
            t.columnes = sc.nextInt();
        } while (t.columnes<Constants.MIDA_MIN||t.columnes>Constants.MIDA_MAX);
    }
    public static void IniciarTauler(Dimensions t, char[][] tauler, char[][] mines){
        int i, j;

        for(i=1;i<=t.files;i++){
            for(j=1;j<=t.columnes;j++){
                tauler[i][j] = '-';
                mines[i][j] = '-';
            }
        }
    }
    public static void main(String[] args){

        EntrarDimensio(t);
        tauler = new char[t.files+2][t.columnes+2]; //Aixi a Jugar puc recorrer millor les caselles
        mines = new char[t.files+2][t.columnes+2]; //Aixi a Jugar puc recorrer millor les caselles
        IniciarTauler(t, tauler, mines);
        Menu.main(null);
    }
}