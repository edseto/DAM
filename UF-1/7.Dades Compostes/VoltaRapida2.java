import java.util.Scanner;
public class VoltaRapida2{
    public static void main(String[] args) {
        int nvoltes, i, minuts, segons, segtotals=0, VoltaRapida=0, segonsRapids=0, posicio=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entra el nombre de voltes que ha fet el pilot: ");
        nvoltes = sc.nextInt();
        int[] var = new int[nvoltes];
        for(i=1;i<=nvoltes;i++){
            System.out.print("Entra els minuts de la volta "+ i +": ");
                minuts = sc.nextInt();
            System.out.print("Entra els segons de la volta "+ i +": ");
                segons = sc.nextInt();
            segtotals = minuts*60+segons;
            var[posicio] = segtotals;
            if(posicio==0||var[posicio]<var[posicio-1]){
                VoltaRapida=i; 
                segonsRapids = segtotals;
            }
            posicio++;
        }
        System.out.println("La volta rapida ha estat la "+ VoltaRapida+ " amb un total de "+segonsRapids+" segons");
    }
}