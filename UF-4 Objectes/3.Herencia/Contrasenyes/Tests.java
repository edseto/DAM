// Proves de l'objecte Password
public class Tests {
    public static void main(String[] args) {
        try {
            Password p1 = new Password(4);
            String passwd1 = "hola", passwd2 = "hola";
            System.out.println(p1.getPassword());
            //Funciona
            try {
                System.out.println("La teva contrasenya es: "+p1.crearPassword());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            for (int i = 0; i < 3; i++) {
                try {
                    p1.canviarPassword(passwd1, passwd2);
                    System.out.println("Nova contrasenya: "+p1.getPassword());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //Errors d'execució
                if(i==0){
                    passwd1 = "hola"; passwd2 = "adeu";
                }else{
                    passwd1 = "try"; passwd2 = "try";
                } 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}