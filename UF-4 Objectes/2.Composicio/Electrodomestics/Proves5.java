public class Proves5{
    public static void main(String[] args) {
        short red, green, blue;
        red = 2; green = 2; blue = 0;

        Electrodomestic e1 = new Electrodomestic(20, 45);
        System.out.println(e1.toString());

        System.out.println();
        try {
            e1.setConsum(20, "kW");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        e1.setColor(red, green, blue);
        System.out.println(e1.toString());

        System.out.println();
        Electrodomestic e2 = new Electrodomestic();
        System.out.println(e2.toString());

        red = 2; green = 4; blue = 0;
        System.out.println();
        e2.setPreuBase(200);
        e2.setPes(80);
        e2.setColor(red, green, blue);
        System.out.println(e2.toString());

        //Error execució
        System.out.println();
        try {
            e2.setConsum(35, "o"); //Error, unitat incorrecte
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Fer pensar a en Miquel aquesta solució
        }
        try {
            e1.setConsum(-1, "kW"); // Error, potencia incorrecte
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}