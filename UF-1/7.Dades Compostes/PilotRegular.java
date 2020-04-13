import java.util.Scanner;
public class PilotRegular{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, voltes, voltaRegular, posicio=0, superat=0, minuts, segons, segtotals;
        System.out.print("Introdueixi el nombre de voltes: ");
        voltes = sc.nextInt();
        int[] segonsVoltes = new int[voltes];
        for(i=1;i<=voltes;i++){
            System.out.print("Entra els minuts de la volta "+ i +": ");
                minuts = sc.nextInt();
            System.out.print("Entra els segons de la volta "+ i +": ");
                segons = sc.nextInt();
            segtotals = minuts*60+segons;
            segonsVoltes[posicio] = segtotals;
            posicio++;
        }
        System.out.print("Introdueixi la seva volta regular: ");
        voltaRegular = sc.nextInt();
        for(i=0;i<segonsVoltes.length;i++){
            if(segonsVoltes[i]==segonsVoltes[voltaRegular-1]){
            //Li resto 1 a la voltaRegular perquè a l'array les posicions comencen per 0 
                superat++;
            }
        }
        System.out.println("S'ha fet el mateix temps que la volta "+voltaRegular+", "+superat+" cops");
    }
}