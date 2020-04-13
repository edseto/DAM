import java.util.Scanner;
public class Ordre {
    public static void main(String args[]) {
    String paraula1, paraula2;
    int var;
    Scanner sc = new Scanner(System.in);
    System.out.print("Introdueix la primera paraula: ");
        paraula1 = sc.nextLine();
    System.out.print("Introdueix la segona paraula: ");
        paraula2 = sc.nextLine();
    var = paraula1.compareTo(paraula2);
    if(var < 0){ //Si al comparar les paraules és negatiu significa que està ordenat
        System.out.println("Ordenat");
    }else{
        System.out.println("Desordenat");
    }
    }
}