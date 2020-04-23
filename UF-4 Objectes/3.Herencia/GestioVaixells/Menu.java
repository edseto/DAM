import java.util.Scanner;
public class Menu {
    static Embarcadors gestio = new Embarcadors();
    static Scanner sc = new Scanner(System.in);
    static Vaixells gestioVaixells = new Vaixells();

    public static int menuInicial(){
        int opcio;

        do {
            System.out.println("1- Arribada d’un nou vaixell");
            System.out.println("2- Salpar");
            System.out.println("3- Finalitzar");
            System.out.print("Escull una opcio (1-3): ");
            opcio = sc.nextInt();
        } while (opcio<1||opcio>3);
        return opcio;
    }
    public static void arribada(){
        int opcio, tipus;
        double eslora, manega;
        String matricula;

        System.out.print("Entra matricula: ");
        matricula = sc.next();
        System.out.println("Entra eslora (m): ");
        eslora = sc.nextDouble();
        System.out.println("Entra manega (m): ");
        manega = sc.nextDouble();

        do {
            System.out.println("Introdueixi el tipus de Vaixell");
            System.out.println("1- Carrega");
            System.out.println("2- Passatgers");
            System.out.println("3- Pesca");
            System.out.print("Escull una opcio (1-3): ");
            tipus = sc.nextInt();
        } while (tipus<1||tipus>3);

        switch (tipus) {
            case 1: gestioVaixells.vaixells.add(new Carrega(matricula, eslora, manega));
                break;
            case 2: gestioVaixells.vaixells.add(new Passatgers(matricula, eslora, manega));
                break;
            case 3: gestioVaixells.vaixells.add(new Pesca(matricula, eslora, manega));
                break;
        }

        do {
            System.out.println("1- Atracar en un embarcador");
            System.out.println("2- Solicitar un embarcador");
            System.out.println("3- Solicitar preu");
            System.out.println("4- Llistar embarcadors");
            System.out.println("5- Llistar embarcadors plens");
            System.out.println("6- Tornar al menú principal");
            System.out.print("Escull una opcio (1-6): ");
            opcio = sc.nextInt();
        } while (opcio<1||opcio>6);

        switch (opcio) {
            case 1:
                break;
            case 2:
                break;
            case 3: System.out.println("Cost total: "+ gestioVaixells.preu(gestio));
                break;
            case 4: gestio.llistarBuits();
                break;
            case 5: gestio.llistarPlens();
                break;
        }
    }
    public static void salpar(){

    }
    public static void main(String[] args) {
        int opcio;
        boolean finish = false;

        do {
            opcio = menuInicial();
            switch (opcio) {
                case 1: arribada();
                    break;
                case 2: salpar();
                    break;
                case 3: finish = true;
                    break;
            }
        } while (!finish);
    }
}