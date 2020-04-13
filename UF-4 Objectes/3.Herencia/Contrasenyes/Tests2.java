import java.time.LocalDate;
import java.time.Month;

//Proves de l'objecte PasswordSegur
public class Tests2{
    public static void main(String[] args) {
        try {
            LocalDate ultimCanvi = LocalDate.of(2020, Month.MARCH, 1);
            PasswordSegur p1 = new PasswordSegur(6, 10);
            String passwd1 = "!3dCu7_", passwd2 = "!3dCu7_";

            System.out.println(p1.getPassword());

            p1.setDiesVigencia(5);
            p1.setUltimCanvi(ultimCanvi);

            //Caducada
            if(p1.precisaCanvi()) System.out.println("S'ha de canviar la contrasenya");
            else System.out.println("Encara no ha caducat");
            
            //No caducada
            p1.setDiesVigencia(30);
            if(p1.precisaCanvi()) System.out.println("S'ha de canviar la contrasenya");
            else System.out.println("Encara no ha caducat");
        
            //Funciona
            try {
                System.out.println("La teva contrasenya es: "+p1.crearPassword());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            for (int i = 0; i < 5; i++) {
                try {
                    p1.canviarPassword(passwd1, passwd2);
                    System.out.println("Nova contrasenya: "+p1.getPassword());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //Errors d'execució
                switch (i) {
                    case 0: passwd1 = "C3PO_1"; passwd2 = "R2D2!2"; //No és segura (falta minus)
                    break;
                    case 1: passwd1 = "!a3AB"; passwd2 = "!a3AB"; //No té la longitud minima
                    break;
                    case 2: passwd1 = "C!3_o4"; passwd2 = "C!3_o4"; //Té menys de 3 chars diferents
                    break;
                    default: passwd1 = "0O~lasdf1Re"; passwd2 = "0O~lasdf1Re"; //Supera la longitud màxima
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}