import java.util.Scanner;
public class WorldRecord2{
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
        int recordI = 80; //Record Inicial
        int record = 80;
        int copsSuperat = 0;
         //Creo una variable per guardar els cops que s'ha superat, més endavant es veu perquè
        int recordPrimer = 0; 
        //Creo una variable per poder calcular si la 2n volta supera o no
               
        if(segons1<record){
            record=segons1;
            recordPrimer=segons1; 
        }
        if((segons2<recordI)&&(segons2<recordPrimer)){
            record=segons2;
        }
        if(((segons3<record)&&(segons3<segons2))||(segons3<segons1)){
            record=segons3;
        }
        if((segons1<=recordI)||(segons2<=record)||(segons3<=record)){
            copsSuperat++;
        }
        if(((segons1<recordI)&&(segons2<=record))||((segons1<recordI)&&(segons3<=record))||((segons2<recordI)&&(segons3<=record))){
            copsSuperat++;
        }
        if((segons1<recordI) && (segons2<recordPrimer) && (segons3 <=record)){
            copsSuperat++;
        }
        switch(copsSuperat){ 
        //Depèn del número que hi hagi a la variable creada abans farà una cosa o una altra
            case 1: System.out.println("Ha superat el record 1 cop");
            break;
            case 2: System.out.println("Ha superat el record 2 cops");
            break;
            case 3: System.out.println("Ha superat el record 3 cops");
            break;
        }
    }
}