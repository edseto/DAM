import java.util.Scanner;

public class PetitGran{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entra el valor 1: ");
            int petit = sc.nextInt();
        System.out.print("Entra el valor 2: ");
            int gran = sc.nextInt();
        if (petit>gran){
            petit = petit + gran; 
//Per intercanviar els números primer assignem a la variable petit la suma de petit + gran
            gran = petit - gran; 
//Després al restar petit - gran obtindrem el valor inicial de petit i li asignem a gran
            petit = petit - gran; //Fem el mateix que a l'assignació de gran
        }
        System.out.println("Valors: " + petit +", " + gran);
    }
}
   