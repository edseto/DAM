public class Proves6 {
    public static void main(String[] args) {
        Consum c1 = new Consum();
        Consum c2 = new Consum(2200, "W");

        System.out.println("Consum:");
        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println("Electrodomestic:");
        Electrodomestic e5 = new Electrodomestic(c1);
        System.out.println(e5.getConsum());

        // Error execució
        System.out.println();
        try {
            Electrodomestic e4 = new Electrodomestic(12, -1);
            System.out.println(e4.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}