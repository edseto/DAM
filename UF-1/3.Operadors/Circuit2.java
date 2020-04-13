/*
    6. El circuit de motos
    Modifica el programa anterior de forma que 
    el programa demani a l’usuari el número de voltes 
    (tipus short) que ha fet i el temps que ha estat en 
    minuts (enter) i segons (enter). El programa ha de donar 
    com a resultat el total de Km que ha fet el pilot i la mitjana 
    de temps per volta. Cal guardar tots els càlcul que es facin en variable.
*/
import java.util.Scanner;
public class Circuit2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short voltes;
        int minuts, segons;
        double distancia, SegonsTotals;

        System.out.print("Quantes voltes ha fet? ");
        voltes = sc.nextShort();

        System.out.print("Quants minuts ha trigat? ");
        minuts = sc.nextInt();

        System.out.print("Quants segons ha trigat? ");
        segons = sc.nextInt();
        
        distancia = voltes*Constants.LLARGADA_CIRCUIT; //distancia total recorreguda
        SegonsTotals = (minuts*60) + segons; 
        //Minuts passats a segons i sumats als segons introduits

        System.out.println("El pilot ha fet: "+ (distancia/1000)+"km");
        System.out.println("Per volta ha trigat una mitjana de: "+ (SegonsTotals/voltes)+"segons" );
    }
}