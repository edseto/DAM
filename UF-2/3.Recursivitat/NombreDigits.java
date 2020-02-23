/*
    3. Nombre de dígits
    Fes una funció recursiva que em digui quants dígits té un nombre natural determinat. Per
    exemple, el nombre 150 té tres dígits, mentre que el nombre 83000 té 5 dígits.
*/ 

import java.util.Scanner;
public class NombreDigits{
    public static int ContarDigits(int numero){
        int contador=1;

        if(numero<10){
            return 1;
        }else{
            contador += ContarDigits(numero/10);
        }
        return contador;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, contador;

        System.out.print("Introdueix un numero: ");
        numero = sc.nextInt();
        contador = ContarDigits(numero);
        System.out.println("El numero "+ numero+ " te "+ contador+" digits");
    }
}