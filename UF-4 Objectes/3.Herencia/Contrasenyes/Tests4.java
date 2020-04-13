import java.time.LocalDate;
import java.time.Month;

// Proves de l'objecte Usuari
public class Tests4 {
    public static void main(String[] args) {
        LocalDate dataRegistre = LocalDate.of(2020, Month.MARCH, 1);
        try {
            PasswordSegur p1 = new PasswordSegur(4, 10, "P4ssw0r!");
            Usuari usu1 = new Usuari("Edgar", p1); 
            Usuari usu2 = new Usuari("Miquel", dataRegistre, p1);

            System.out.println(usu1.toString());
            System.out.println(usu2.toString());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println();
        //Proves dels diferents constructors
        Usuari usu1 = new Usuari("Edgar", "!3Duc#"); // Aixi també provo el mètode registrar
        Usuari usu2 = new Usuari("Miquel", dataRegistre, "M1que!");
        Usuari usu3 = new Usuari("Usuari3");
        Usuari usu4 = new Usuari("User4", dataRegistre);
        
        System.out.println(usu1.toString());
        System.out.println(usu2.toString());
        System.out.println(usu3.toString());
        System.out.println(usu4.toString());

        System.out.println();
        if (usu1.autentificar("Edgar", "!3Duc#")) System.out.println("Autentificació correcte!");
        else System.out.println("Autentificació erronia");

        if (usu1.autentificar("Edgar", "hola")) System.out.println("Autentificació correcte!");
        else System.out.println("Autentificació erronia");
        
        usu2.password.setLongitudMaxima(30);
        try {
            if (usu2.canviarPassword("Patat4!", "Patat4!")) System.out.println("Canvi de contrasenya correcte!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Errors execució
            //Contrasenya utilitzada abans
        try {
            if (usu2.canviarPassword("Patat4!", "Patat4!")) System.out.println("Canvi de contrasenya correcte!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

            //Supera el màxim de longitud
        usu2.password.setLongitudMaxima(5);
        try {
            if (usu2.canviarPassword("PasswordLl4rga!", "PasswordLl4rga!")) System.out.println("Canvi de contrasenya correcte!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
} 