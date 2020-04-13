import java.util.Scanner;
public class Balances{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int npesades, pesadanum=0, i=1, pesada = 1, suma=0;
        System.out.print("Quantes pesades vol fer? ");
            npesades = sc.nextInt();
        while(npesades>=i){
            System.out.print("Pesada "+pesada+": ");
            pesadanum = sc.nextInt();
            suma = suma+pesadanum;
            i++; pesada++;
        }
        System.out.println("El pes total es: "+suma);
    }
}