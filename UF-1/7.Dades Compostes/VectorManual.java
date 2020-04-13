import java.util.Scanner;
public class VectorManual{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hora, mitjanit=24;
        double graus;
        double[] temperatura=new double[24];
        for(hora=0;hora<mitjanit;hora++){
            System.out.print("Entri la temperatura a l'hora "+hora+": ");
            graus = sc.nextDouble();
            temperatura[hora] = graus;
        }
        for(hora=0;hora<mitjanit;hora++){
            System.out.println("Temperatura hora "+hora+": "+temperatura[hora]);
        }
        sc.close();
    }
}