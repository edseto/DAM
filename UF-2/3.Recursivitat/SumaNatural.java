/*
    1. Suma natural
    Fes una funció recursiva per a calcular la suma entre el número 1 i un determinat número N.
    Per exemple, si N=6, la suma dels 6 primers nombres naturals és 21.
*/
import java.util.Scanner;
public class SumaNatural{
    public static int Suma(int num){
        int res;

        if(num==1){
            return 1;
        }else{
            res = num + Suma(num-1);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, resultat;

        System.out.print("Introdueix un numero: ");
        num = sc.nextInt();
        resultat = Suma(num);
        System.out.println("La suma del numero 1 fins "+num+" es: "+resultat);
    }
}