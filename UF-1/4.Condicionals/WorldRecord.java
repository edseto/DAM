import java.util.Scanner;
public class WorldRecord{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int volta = 1, segons1, segons2, segons3;
        System.out.print("Minuts volta" + volta + ": ");
            int min1 = sc.nextInt();
        System.out.print("Segons volta" + volta + ": ");
            int seg1 = sc.nextInt();
            volta = ++volta; //Increment del número de volta
        System.out.print("Minuts volta" + volta + ": ");
            int min2 = sc.nextInt();
        System.out.print("Segons volta" + volta + ": ");
            int seg2 = sc.nextInt();
            volta = ++volta; //Increment del número de volta
        System.out.print("Minuts volta" + volta + ": ");
            int min3 = sc.nextInt();
        System.out.print("Segons volta" + volta + ": ");
            int seg3 = sc.nextInt();
        //Ara calcularé els segons totals de cada volta i els guardaré en variables
        segons1 = (min1*60) + seg1;
        segons2 = (min2*60) + seg2;
        segons3 = (min3*60) + seg3;
        //En cas que tots superin el record no es mostrarà res
        if((segons1<Constants.RECORD) && (segons2<Constants.RECORD) && (segons3<Constants.RECORD)){
            System.out.println("");
        //En cas que dos d'ells superin el record no es mostrarà res
        }else if((segons1<Constants.RECORD)&&(segons2<Constants.RECORD)||(segons1<Constants.RECORD)&&(segons3<Constants.RECORD)||(segons2<Constants.RECORD)&&(segons3<Constants.RECORD)){
            System.out.println("");
        }
        else if (segons1<Constants.RECORD){
            System.out.println("Record superat a la volta 1");
            System.out.println("Ha trigat: "+segons1+"segons");
        }
        else if (segons2<Constants.RECORD){
            System.out.println("Record superat a la volta 2");
            System.out.println("Ha trigat: "+segons2+"segons");
        }
        else if (segons3<Constants.RECORD){
            System.out.println("Record superat a la volta 3");
            System.out.println("Ha trigat: "+segons3+"segons");
        }
    }
}