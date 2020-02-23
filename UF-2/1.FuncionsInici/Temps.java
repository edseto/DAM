/*
    3.Fes una funció que a partir d’una hora , minut i segons, em retorni quants segons queden per
    acabar el dia.
*/
import java.util.Scanner;
public class Temps{
    public static int FinalDia(int hora, int min, int seg){
        int restant, mitjanit=86400;
        seg+=hora*60*60;
        seg+=min*60;
        restant = mitjanit-seg;
        return restant;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hora, minuts, segons, segRestant;
        sc.useDelimiter(":|\\s+"); //Així pugui introduir la hora en format hh:mm:ss

        System.out.print("Escriu la hora en (hh:mm:ss): ");
        hora = sc.nextInt();
        minuts = sc.nextInt();
        segons = sc.nextInt();
        segRestant = FinalDia(hora, minuts, segons);
        System.out.println(segRestant);
    }
}