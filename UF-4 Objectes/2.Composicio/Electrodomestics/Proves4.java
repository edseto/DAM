public class Proves4 {
    public static void main(String[] args) {
        Color gris = new Color(1, 1, 1);
        Color vermell = new Color(2, 1, 1);
        Color verd = new Color(2, 4, 1);
        Color blau = new Color(2, 4, 6);
        Color negre = new Color(0, 0, 0);
        Color blanc = new Color(255, 255, 255);
        Color indefinit = new Color(140, 140, 120);

        // Prova Mètode color
        System.out.println("Metode color:");
        System.out.println("gris: " + gris.color());
        System.out.println("vermell: " + vermell.color());
        System.out.println("verd: " + verd.color());
        System.out.println("blau: " + blau.color());
        System.out.println("negre: " + negre.color());
        System.out.println("blanc: " + blanc.color());
        System.out.println("indefinit: " + indefinit.color());
        System.out.println();

        // Millora Mètode toString
        System.out.println("Metode toString:");
        System.out.println(gris.toString());
        System.out.println(vermell.toString());
        System.out.println(verd.toString());
        System.out.println(blau.toString());
        System.out.println(negre.toString());
        System.out.println(blanc.toString());
        System.out.println(indefinit.toString());
        System.out.println();

        // Error execució
            // Error, preuBase incorrecte
        try {
            Electrodomestic e3 = new Electrodomestic(-1, 12);
            System.out.println(e3.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
}