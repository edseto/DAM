import java.util.Scanner;
public class Regularitat{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int voltes, i, minuts, segons, max, min, posicio=0;
        double mitjana=0;
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
        }
        if(voltes>2){
            /*Si el pilot fa 1 o 2 voltes si eliminem els valors mínim i màxim la mitjana seria 0, un valor 
            impossible, per tant nomes eliminaré els valors si fa més de 2 voltes*/
            min = segtotals[0];
            max = segtotals[0];
            for(i=0;i<segtotals.length;i++){ //Per trobar els valors mínim i màxim
                if(min>segtotals[i]){
                    min = segtotals[i];
                }else if(max<segtotals[i]){
                    max = segtotals[i];
                }
            }
            for(i=segtotals.length-1;i>=0;i--){ //Per "eliminar" els valors mínim i màxim
                if(segtotals[i]==max||segtotals[i]==min){
                    segtotals[i]=0;
                }
            }
        }
        for(i=0;i<segtotals.length;i++){ //A partir d'aqui calcular la mitjana
            mitjana += segtotals[i];
        }
        mitjana /= segtotals.length;
        System.out.println("El pilot ha fet una mitjana de temps de: "+ mitjana+" segons");
    }
}