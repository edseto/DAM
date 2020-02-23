/*
    5. Cap i cua 
    Podem definir cap i cua com: «Paraula, frase o grup de paraules les lletres de les quals es
    repeteixen en el mateix ordre quan són llegides en la direcció inversa». Per a facilitar el codi,
    en el nostre cas només introduirem lletres, sense espais ni símbols ortogràfics. Per exemple, la
    frase «català a l’atac» l’introduirem com «catalaalatac» . Aquesta paraula es tracta d’una
    paraula cap-i-cua. Altres paraules cap i cua són: «ara», «rallar», «cinic» (sense accent) i
    «tururut».
    Fes una funció recursiva que em permeti determinar si una paraula és o no és cap-i-cua.
*/
import java.util.Scanner;
public class CapiCua{
    public static boolean Comprovacio(String paraula){
        boolean capicua = false;

        if(paraula.length()<=1){
            capicua = true;
        }else{
            if(paraula.charAt(0)==paraula.charAt(paraula.length()-1)){
                return Comprovacio(paraula.substring(1, paraula.length()-1));
                /*Aixo retorna la paraula treient la primera i la ultima lletra
                Exemple: rallar --> alla
                */
            }else{
                capicua = false;
            }
        }

        return capicua;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paraula;
        boolean capicua;

        System.out.print("Introdueix la paraula: ");
        paraula = sc.next();

        capicua = Comprovacio(paraula);
        if(capicua){
            System.out.println("La paraula es capicua");
        }else{
            System.out.println("La paraula no es capicua");
        }
    }
}