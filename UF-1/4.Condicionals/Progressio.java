import java.util.Scanner;
public class Progressio{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int volta = 1;
        System.out.print("Minuts volta" + volta + ": ");
            int min1 = sc.nextInt();
        System.out.print("Segons volta" + volta + ": ");
            int seg1 = sc.nextInt();
            ++volta; //Increment del número de volta
        System.out.print("Minuts volta" + volta + ": ");
            int min2 = sc.nextInt();
        System.out.print("Segons volta" + volta + ": ");
            int seg2 = sc.nextInt();
            ++volta; //Increment del número de volta
        System.out.print("Minuts volta" + volta + ": ");
            int min3 = sc.nextInt();
        System.out.print("Segons volta" + volta + ": ");
            int seg3 = sc.nextInt();
        //Ara calcularé els segons totals de cada volta i els guardaré en variables
        int segons1 = (min1*60) + seg1;
        int segons2 = (min2*60) + seg2;
        int segons3 = (min3*60) + seg3;
        if((segons1>segons2) && (segons2>segons3)){
            System.out.println("Pilot progressa :D");
        }else{
            System.out.println("Pilot no progressa :(");
        }
    }
}