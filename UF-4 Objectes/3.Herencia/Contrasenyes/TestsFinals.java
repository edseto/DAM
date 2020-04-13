import java.util.Scanner;

public class TestsFinals {
    static Scanner sc = new Scanner(System.in);
    static Usuaris users = new Usuaris();
    static PasswordSegur p1 = new PasswordSegur();

    public static void repartirOpcio(int opcio) {
        switch (opcio) {
            case 1:
                registrarUser();
                break;
            case 2:
                users.llistar();
                break;
            case 3:
                canviarPassword();
                break;
            case 4:
                canviarPasswordRoot();
                break;
            case 5:
                autentificar();
                break;
            case 6:
                users.precisenCanvi();
                break;
            case 7:
                canviarVigencia();
                break;
            case 8:
                passwordRandom();
                break;
        }
    }

    public static void registrarUser() {
        String nom, password;

        System.out.print("Nom d'usuari: ");
        nom = sc.next();

        System.out.print("Contrasenya: ");
        password = sc.next();

        try {
            users.registrar(nom, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void canviarPassword() {
        String nom, passwordActual, passwd1, passwd2;

        System.out.print("A quin usuari vols canviar la contrasenya? ");
        nom = sc.next();

        System.out.print("Introdueixi la seva contrasenya actual: ");
        passwordActual = sc.next();

        System.out.print("Introdueixi la nova contrasenya: ");
        passwd1 = sc.next();

        System.out.print("Introdueixi un altre cop la contrasenya: ");
        passwd2 = sc.next();

        try {
            users.canviarPassword(nom, passwordActual, passwd1, passwd2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void canviarPasswordRoot() {
        String nom, passwd1, passwd2, passwordAdmin;

        System.out.print("A quin usuari vols canviar la contrasenya? ");
        nom = sc.next();
        
        System.out.print("Introdueixi la contrasenya d'administrador: "); //Per defecte és admin (es pot canviar)
        passwordAdmin = sc.next();

        System.out.print("Introdueixi la nova contrasenya: ");
        passwd1 = sc.next();

        System.out.print("Introdueixi un altre cop la contrasenya: ");
        passwd2 = sc.next();

        try {
            users.canviarPassword(nom, passwordAdmin, passwd1, passwd2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void autentificar() {
        String nom, passwd;

        System.out.print("Introdueixi el nom d'usuari: ");
        nom = sc.next();

        System.out.print("Introdueixi la seva contrasenya: ");
        passwd = sc.next();

        try {
            users.autentificar(nom, passwd);
            System.out.println("Autentificacio correcte!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void canviarVigencia() {
        String nom;
        int diesVigencia;

        System.out.print("De quin usuari vols canviar els dies de vigencia? ");
        nom = sc.next();

        System.out.print("Estableix durant quants dies pot mantenir la mateixa contrasenya: ");
        diesVigencia = sc.nextInt();

        try {
            users.canviarVigencia(nom, diesVigencia);
            System.out.println("Vigencia canviada sense problemes!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static void passwordRandom() {
        System.out.print("De quina longitud vols la contrasenya? ");
        p1.setLongitud(sc.nextInt());
        
        try {
            System.out.println("Aqui te la seva sugerencia: "+p1.crearPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int opcio;
        boolean finalitzar = false;
        
        do {
            do {
                System.out.println("1- Registrar un usuari");
                System.out.println("2- Llistar tots els usuaris"); 
                System.out.println("3- Canviar password");
                System.out.println("4- Canviar password (root)");
                System.out.println("5- Autentificar");
                System.out.println("6- Precisen canviar password");
                System.out.println("7- Canviar dies vigencia");
                System.out.println("8- Proposam un password aleatori segur");
                System.out.println("9- Finalitzar");
                System.out.print("Escull una opcio (1-9): ");
                opcio = sc.nextInt();
            } while ((opcio<1)||(opcio>9));

            System.out.println();

            if(opcio==9) finalitzar = true;
            else repartirOpcio(opcio);

            System.out.println();
        } while (!finalitzar);
    }
}