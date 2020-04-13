import java.util.Scanner;

class Exercici1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.print("Introdueix un nombre: ");
        numero = sc.nextInt();
        if(numero % 2 == 0){
           System.out.println("Es parell");
        }
        else{
            System.out.println("Es imparell");
        }
    }
}