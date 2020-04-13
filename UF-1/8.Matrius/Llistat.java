import java.util.Scanner;
public class Llistat{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nparaules, i, posicio=0;
        boolean trobada=false;
        String buscar;
        String[] paraules;

        System.out.print("Quantes paraules vol introduir? ");
        nparaules = sc.nextInt();
        paraules = new String[nparaules+1];
        paraules[0] = sc.nextLine();

        for(i=1;i<paraules.length;i++){
            System.out.print("Introdueix la paraula "+i+": ");
            paraules[i] = sc.nextLine();
        }
        System.out.print("Introdueix la paraula a buscar: ");
        buscar = sc.nextLine();
        i=1;
        while(i<paraules.length){
            if(buscar.equals(paraules[i])){
                posicio=i;
                trobada=true;
            }else{
                trobada=false;
            }
            i++;
        }
        if(trobada=true){
            System.out.println("Paraula introduida en la posicio: "+posicio);
        }else{
            System.out.println("Paraula inexistent");
        }
    }
}