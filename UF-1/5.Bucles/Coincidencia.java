import java.util.Random;
public class Coincidencia{
    public static void main(String[] args) {
        int num1, num2, i=0;
        Random r = new Random();
        do {
            num1 = r.nextInt(10);
            num2 = r.nextInt(10);
            System.out.print("["+num1+"-"+num2+"], ");
            i++;
        } while (num1!=num2);
        System.out.println("\b\b ");
        System.out.println("Objectiu assolit despres de "+i);
    }
}