import java.util.Scanner;
public class SumaDigits{
    public static int Suma(int numero){
        
        if(numero==0){
            return 0;
        }else{
            return Suma(numero/10) + numero%10;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.print("Introdueixi un numero: ");
        numero = sc.nextInt();
        numero = Suma(numero);
        System.out.println("La suma dels seus digits es: "+numero);
    }
}