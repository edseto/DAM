/*
    4. Nombre primer
    Fes una funció recursiva que em determini si un determinat número és o no és primer.
*/
import java.util.Scanner;
public class NombrePrimer{
    public static boolean EsPrimer(int num, int divisor){
        boolean esPrimer;

        if(num/2 < divisor && num!=1){
            esPrimer = true;
        }else{
            if(num%divisor==0 || num==1){
                esPrimer = false;
            }else{
                return EsPrimer(num, divisor+1);
            }
        }
        return esPrimer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        boolean primer;

        System.out.print("Introdueix un numero: ");
        num = sc.nextInt();

        primer = EsPrimer(num, 2);
        if(primer){
            System.out.println("El numero "+num+" es un nombre primer");
        }else{
            System.out.println("El numero "+num+" no es un nombre primer");
        }
    }
}