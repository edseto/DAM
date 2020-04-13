import java.util.Scanner;
public class MillorPilot{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int voltes, i, minuts, segons, segtotals, posicio=0, guanya1=0, guanya2=0, empate=0;
        System.out.print("Introdueix el numero de voltes que han fet els pilots: ");
        voltes = sc.nextInt();
        int[] pilot1 = new int[voltes];
        int[] pilot2 = new int[voltes];
        for(i=1;i<=voltes;i++){
            System.out.print("Introdueix els minuts que ha trigat el pilot 1 a la volta "+i+" : ");
            minuts = sc.nextInt();
            System.out.print("Introdueix els segons que ha trigat el pilot 1 a la volta "+i+" : ");
            segons = sc.nextInt();
            segtotals = minuts*60+segons;
            pilot1[posicio] = segtotals;
            System.out.print("Introdueix els minuts que ha trigat el pilot 2 a la volta "+i+" : ");
            minuts = sc.nextInt();
            System.out.print("Introdueix els segons que ha trigat el pilot 2 a la volta "+i+" : ");
            segons = sc.nextInt();
            segtotals = minuts*60+segons;
            pilot2[posicio] = segtotals;
            posicio++;
        }
        for(i=0;i<voltes;i++){
            if(pilot1[i]<pilot2[i]){
                guanya1++;
            }else if(pilot2[i]<pilot1[i]){
                guanya2++;
            }else{
                empate++;
            }
        }
        System.out.println("El pilot 1 ha guanyat: "+guanya1+" voltes");
        System.out.println("El pilot 2 ha guanyat: "+guanya2+" voltes");
        System.out.println("Han empatat: "+empate+" voltes");
        if(guanya1>guanya2){
            System.out.println("El guanyador de la carrera es el pilot 1");
        }else if(guanya1<guanya2){
            System.out.println("El guanyador de la carrera es el pilot 2");
        }else{
            System.out.println("Els dos pilots han quedat empatats a la carrera");
        }
    }
}