//Test de Scanner (Introducció de dades per teclat)
import java.util.Scanner; // Importar la classe Scanner
class DemoScanner {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    System.out.print("Enter your age: ");
        short age = sc.nextShort();
    System.out.print("Enter your weight in kg: ");
        float weight = sc.nextFloat();
    System.out.println("AGE = "+age);
    System.out.println("WEIGHT = "+weight);
  }
}