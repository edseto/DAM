import java.util.Scanner;
public class MateixTemps{
    public static void main(String[] args) {
        int voltes, i, minuts, segons, igual=1, posicio=0, temps, maxtemps = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entra el nombre de voltes que ha fet el pilot: ");
        voltes = sc.nextInt();
        int[] segtotals = new int[voltes];
        for(i=1;i<=voltes;i++){
            System.out.print("Entra els minuts de la volta "+ i +": ");
                minuts = sc.nextInt();
            System.out.print("Entra els segons de la volta "+ i +": ");
                segons = sc.nextInt();
            segtotals[posicio] = minuts*60+segons;
            posicio++;
            if( maxtemps < minuts*60+segons ){
                maxtemps = minuts*60+segons;
            }

        }
        int[] diftemps = new int[maxtemps+1];
        for(i=0;i<segtotals.length;i++){
            temps = segtotals[i];
            if( diftemps[temps] != 0 ){
                igual++;
            } else {
                diftemps[temps] = 1;
            }
        }
        System.out.println("El pilot ha fet el mateix temps en "+ igual+" voltes");
        sc.close();
    }
}