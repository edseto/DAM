// Proves de l'objecte Usuaris
public class Tests3 {
    public static void main(String[] args) {
        UsuariSegur usu1, usu2;
        Usuaris llista = new Usuaris();

        //Funciona
        try {
            usu1 = new UsuariSegur("Edgar", "!3Duc#");
            llista.registrar(usu1);
            llista.registrar("Miquel", "M1que!");
            System.out.println("Llistar:");
            llista.llistar();

            System.out.println();
            System.out.println("Prova default password:");
            usu2 = new UsuariSegur("Hola");
            System.out.println(usu2.toString());

            System.out.println();
            llista.baixa("Edgar");
            System.out.println("Llistar:");
            llista.llistar();
            
            System.out.println();
            llista.precisenCanvi(); //Aqui no sortirà res perquè l'ultim canvi es avui i vigència és 0
            llista.canviarVigencia("Miquel", -1); //Poso -1 per dir que caducava ahir
            System.out.println("Prova vigencia:");
            llista.precisenCanvi();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        //Errors execució
            // Error l'usuari no està donat d'alta a l'ArrayList
        try {
            llista.baixa("Hola");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        System.out.println();

            // Error usuari existent
        try {
            llista.registrar("Miquel", "D3v3lOp3r!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        System.out.println();

            // Error usuari inexistent
        try {
            llista.canviarPassword("NoExisteixo", "contrasenya", "hola", "hola");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        System.out.println();

            // Error contrasenya incorrecte (No provo autentificar perquè és pràcticament el mateix que canviar password)
        try {
            usu1 = new UsuariSegur("Edgar", "!3Duc#");
            llista.registrar(usu1);
            llista.canviarPassword("Edgar", "contrasenya", "hola", "hola");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 

    }
}