import java.util.Scanner;
public class Balances2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int npesades, pesadanum=1, i, pesada = 1, suma=0;
        do {
            System.out.print("Quantes pesades vol fer? ");
                npesades = sc.nextInt();
        } while (npesades<=0);
        for(i=1;npesades>=i;){
            System.out.print("Pesada "+pesada+": ");
            pesadanum = sc.nextInt();
            if(pesadanum>0){
                i++;pesada++;
                suma = suma+pesadanum;
            }else{
                System.out.print("Pesada "+pesada+": ");
                pesadanum = sc.nextInt();
                i++;pesada++;
            }
        }
        System.out.println("El pes total es: "+suma);
    }
}