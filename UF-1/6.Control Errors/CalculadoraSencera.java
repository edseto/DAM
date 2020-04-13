import java.util.Scanner;
public class CalculadoraSencera{
    public static void main(String[] args) {
        int dividend, divisor, error = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introdueixi el dividend: ");
                dividend = sc.nextInt();
            System.out.print("Introdueixi el divisor: ");
                divisor = sc.nextInt();
            try {
                System.out.println("Quocient: "+ (dividend/divisor));
                System.out.println("Reste: "+ (dividend%divisor));
            } catch (Exception ex) {
                System.out.println("No es pot dividir per 0");
                error++;
            }
        } while (error == 0);
    }
}