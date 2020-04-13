import java.time.LocalDate;
import java.time.Month;

//Proves de l'objecte UsuariSegur
public class Tests5 {
    public static void main(String[] args) {
        LocalDate dataRegistre = LocalDate.of(2020, Month.MARCH, 1);
        try {
            PasswordSegur p1 = new PasswordSegur(4, 10, "P4ssw0r!");
            UsuariSegur usu1 = new UsuariSegur("Edgar", p1);
            UsuariSegur usu2 = new UsuariSegur("Miquel", dataRegistre, p1);

            System.out.println(usu1.toString());
            System.out.println(usu2.toString());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println();
        // Proves dels diferents constructors
        UsuariSegur usu1 = new UsuariSegur("Edgar", "!3Duc#");
        UsuariSegur usu2 = new UsuariSegur("Miquel", dataRegistre, "M1que!");
        UsuariSegur usu3 = new UsuariSegur("Usuari3");
        UsuariSegur usu4 = new UsuariSegur("User4", dataRegistre);

        System.out.println(usu1.toString());
        System.out.println(usu2.toString());
        System.out.println(usu3.toString());
        System.out.println(usu4.toString());
        System.out.println();
        
        //Errors execució
            //Password no segura
        try {
            usu1.canviarPassword("Hola", "Hola");
            System.out.println("Contrasenya canviada correctament!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

            //Password utilitzada (primer la canvio varis cops per veure que mira historial)
        usu1.password.setLongitudMaxima(50);
        try {
            usu1.canviarPassword("Patat4!", "Patat4!");
            System.out.println("Contrasenya canviada correctament!");

            usu1.canviarPassword("Pr0gr4m4d0R!", "Pr0gr4m4d0R!");
            System.out.println("Contrasenya canviada correctament!");

            usu1.canviarPassword("NOseQu3P0sar!", "NOseQu3P0sar!");
            System.out.println("Contrasenya canviada correctament!");

            usu1.canviarPassword("H0laM1que!", "H0laM1que!");
            System.out.println("Contrasenya canviada correctament!");

            usu1.canviarPassword("Pr0gr4m4d0R!", "Pr0gr4m4d0R!"); //Aquesta és la password utilitzada
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}