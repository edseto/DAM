import java.util.Scanner;
public class Equilibrats{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int voltes, i, minuts, posicio=0, equilibrat=0, desequilibrat=0;
        double segons, segtotals, segonsMax=0.5, temp;
        System.out.print("Introdueix el numero de voltes que han fet els pilots: ");
        voltes = sc.nextInt();
        double[] pilot1 = new double[voltes];
        double[] pilot2 = new double[voltes];
        for(i=1;i<=voltes;i++){
            System.out.print("Introdueix els minuts que ha trigat el pilot 1 a la volta "+i+" : ");
            minuts = sc.nextInt();
            System.out.print("Introdueix els segons que ha trigat el pilot 1 a la volta "+i+" : ");
            segons = sc.nextDouble();
            segtotals = minuts*60+segons;
            pilot1[posicio] = segtotals;
            System.out.print("Introdueix els minuts que ha trigat el pilot 2 a la volta "+i+" : ");
            minuts = sc.nextInt();
            System.out.print("Introdueix els segons que ha trigat el pilot 2 a la volta "+i+" : ");
            segons = sc.nextDouble();
            segtotals = (double)minuts*60+segons;
            pilot2[posicio] = segtotals;
            posicio++;
        }
        for(i=0;i<voltes;i++){
            if(pilot1[i]<pilot2[i]){//Per evitar errors al sortir negatiu a l'hora de restar després
                temp = pilot1[i];
                pilot1[i] = pilot2[i];
                pilot2[i] = temp;
            }
            if(pilot1[i]-pilot2[i]<=segonsMax){
                equilibrat++;
            }else{
                desequilibrat++;
            }
        }
        if(equilibrat>desequilibrat){
            System.out.println("Els pilots estan equilibrats");
        }else{
            System.out.println("Els pilots estan desequilibrats");
        }
    }
}