import java.util.Scanner;

public class Menu {
    static Embarcadors gestio = new Embarcadors();
    static Scanner sc = new Scanner(System.in);
    static Vaixells gestioVaixells = new Vaixells();

    public static int menuInicial() {
        int opcio;

        do {
            System.out.println("1- Arribada d’un nou vaixell");
            System.out.println("2- Salpar");
            System.out.println("3- Finalitzar");
            System.out.print("Escull una opcio (1-3): ");
            opcio = sc.nextInt();
        } while (opcio < 1 || opcio > 3);
        return opcio;
    }

    public static void arribada() {
        int opcio;
        boolean finish = false;

        introduirDades();
        do {
            do {
                System.out.println("1- Atracar en un embarcador");
                System.out.println("2- Solicitar un embarcador");
                System.out.println("3- Solicitar preu");
                System.out.println("4- Llistar embarcadors lliures");
                System.out.println("5- Llistar embarcadors plens");
                System.out.println("6- Tornar al menú principal");
                System.out.print("Escull una opcio (1-6): ");
                opcio = sc.nextInt();
            } while (opcio < 1 || opcio > 6);
    
            switch (opcio) {
                case 1:
                    atracar();
                    break;
                case 2:
                    solicitarEmbarcador();
                    break;
                case 3:
                    System.out.println("Cost total: " + gestioVaixells.preu(gestio)+"€");
                    break;
                case 4:
                    gestio.llistarBuits();
                    break;
                case 5:
                    gestio.llistarPlens();
                    break;
                default: 
                    finish = true;
                    break;
            }
        } while (!finish);
    }

    public static void introduirDades(){
        int tipus;
        double eslora, manega;
        String matricula;

        System.out.print("Entra matricula: ");
        matricula = sc.next();
        System.out.print("Entra eslora (m): ");
        eslora = sc.nextDouble();
        System.out.print("Entra manega (m): ");
        manega = sc.nextDouble();

        do {
            System.out.println("Introdueixi el tipus de Vaixell");
            System.out.println("1- Carrega");
            System.out.println("2- Passatgers");
            System.out.println("3- Pesca");
            System.out.print("Escull una opcio (1-3): ");
            tipus = sc.nextInt();
        } while (tipus < 1 || tipus > 3);

        switch (tipus) {
            case 1:
                gestioVaixells.vaixells.add(new Carrega(matricula, eslora, manega));
                break;
            case 2:
                gestioVaixells.vaixells.add(new Passatgers(matricula, eslora, manega));
                break;
            case 3:
                gestioVaixells.vaixells.add(new Pesca(matricula, eslora, manega));
                break;
        }
    }

    public static void atracar() {
        String embarcador;

        System.out.print("Introdueixi el codi de l'embarcador: ");
        embarcador = sc.next();

        try {
            if(gestioVaixells.atracar(embarcador, gestio)) 
                System.out.println("Vaixell "+ 
                    gestioVaixells.vaixells.get(gestioVaixells.vaixells.size()-1).getMatricula()+" ancorat amb èxit!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void solicitarEmbarcador() {
        try {
            System.out.println("Codi embarcador: "+
                gestio.solicitarEmbarcador(gestioVaixells.vaixells.get(gestioVaixells.vaixells.size() - 1)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void salpar() {
        String embarcador;
        double preu;

        System.out.print("Introdueixi el codi de l'embarcador a alliberar: ");
        embarcador = sc.next();
        
        
        try {
            preu = gestioVaixells.preu(gestio, embarcador);
            System.out.println("Ha salpat el vaixell amb matricula: "+gestio.alliberar(embarcador, gestioVaixells));
            System.out.println("El preu del servei es: "+preu+"€");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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