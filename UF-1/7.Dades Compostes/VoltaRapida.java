import java.util.Scanner;
public class VoltaRapida{
    public static void main(String[] args) {
        int nvoltes, i, minuts, segons, segtotals=0, volta2=0, VoltaRapida=0, segonsRapids=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Entra el nombre de voltes que ha fet el pilot: ");
            nvoltes = sc.nextInt();
        for(i=1;i<=nvoltes;i++){
            System.out.print("Entra els minuts de la volta "+ i +": ");
                minuts = sc.nextInt();
            System.out.print("Entra els segons de la volta "+ i +": ");
                segons = sc.nextInt();
            segtotals = minuts*60+segons;//Calculo els segons totals de la volta
            //En cas que només faci una volta també haurà de dir que és la volta ràpida
            if(segtotals<volta2||VoltaRapida==0){ //Comparo si a la següent volta ha superat el temps
                VoltaRapida=i; //Guardo el número de volta en què s'ha superat
                segonsRapids = segtotals; //Guardo el temps més ràpid
            }
            volta2 = segtotals;//Guardo els valors d'aquesta volta per poder-ho comparar
        }
        System.out.println("La volta rapida ha estat la "+ VoltaRapida+ " amb un total de "+segonsRapids+" segons");
    }
}