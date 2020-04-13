import java.util.Scanner;
public class Menu{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner plat2sc = new Scanner(System.in);
        Scanner postresc = new Scanner(System.in);
        int plat1;
        char plat2, postres; 
        boolean var;
            System.out.println("MENU AMB CARA I ULLS");
            System.out.println("Entrants");
            for(i=0;i<=40;i++){
                System.out.print("*");
            }
            System.out.print("\n");
            System.out.println("1r PLAT");
            System.out.println("1- Sopa de carabassa");
            System.out.println("2- Arros de l'avia");
            System.out.println("3-  de l'hort amb complements");
            for(i=0;i<=40;i++){
                System.out.print("*");
            }
            System.out.print("\n");
            System.out.println("2n PLAT");
            System.out.println("A- Carn");
            System.out.println("B- Peix");
            System.out.println("C- Marisc");
            for(i=0;i<=40;i++){
                System.out.print("*");
            }
            System.out.print("\n");
            System.out.println("POSTRES");
            System.out.println("G- Gelat de sucre");
            System.out.println("C- Coca de sucre");
            System.out.println("I- Iogurt");
            System.out.println("\n");
            do {
                System.out.print("Introdueixi el primer plat (1-3): ");
                plat1 = sc.nextInt();
            } while ((plat1>3)||(plat1<1));
            do {
                System.out.print("Introdueixi el segon plat (A-C): ");
                plat2 = plat2sc.next().charAt(0);
            } while ((plat2!='A')&&(plat2!='B')&&(plat2!='C'));
            do {
                System.out.print("Introdueixi el postre (G, C, I): ");
                postres = postresc.next().charAt(0);
            } while ((postres!='I')&&(postres!='G')&&(postres!='C'));
            System.out.println("La seva eleccio");
            System.out.print("Primer plat: ");
            switch (plat1){
                case 1: System.out.println("Sopa de carabassa");
                break;
                case 2: System.out.println("Arros de l'avia");
                break;
                case 3: System.out.println("Amanida de l'hort amb complements");
                break;
            }
            System.out.print("Segon plat: ");
            switch (plat2){
                case 'A': System.out.println("Carn");
                break;
                case 'B': System.out.println("Peix");
                break;
                case 'C': System.out.println("Marisc");
                break;
            }
            System.out.print("Postres: ");
            switch (postres){
                case 'G': System.out.println("Gelat");
                break;
                case 'C': System.out.println("Coca de sucre");
                break;
                case 'I': System.out.println("Iogurt");
                break;
            }
    }
}