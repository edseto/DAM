import java.util.Scanner;
public class Alcohol {
    public static void main(String args[]) {
    String consum, conduccio;
    int edat;
    boolean consumsi, conducciosi;
    Scanner sc = new Scanner(System.in);
    System.out.print("Desitja una beguda alcoholica (Si / No): ");
        consum = sc.nextLine();
        consumsi = consum.equals("Si");
    if(consumsi == true){
        System.out.print("Quina edat tens? ");
        edat = sc.nextInt();
        if(edat>=18){
            Scanner conduir = new Scanner(System.in);
            System.out.print("Voste vol conduir (Si / No)? ");
            conduccio = conduir.nextLine();
            conducciosi = conduccio.equals("Si");
            if(conducciosi == true){
                System.out.println("Ho sento, si condueix no begui!");
            }else if(conducciosi == false){
                System.out.println("Aqui te la seva beguda!");
            }
        }else{
            System.out.println("Ho sento, les begudes alcoholiques no estan permeses a menors!");
        }
    }
    }
}