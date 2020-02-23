/*
    4. Fes una funció per a canviar d’unitats una determinada mesura de longitud. Les unitats que
    podem utilitzar tant d’origen com de destí són: mil·límetres (mm), centímetres (cm), metres
    (m) i quilòmetres (km). La funció cal que retorni el valor transformat a les noves unitats. Per
    exemple, si s’introdueix 1 km com a valor i es vol convertir a metres, la funció haurà de
    retornar el valor 1000.
*/
import java.util.Scanner;
public class Transformacio{
    public static double KmToM(double numero){
        int metres = 1000; //Hauria de ser una Constant però em fa pal :D

        numero*=metres;

        return numero;
    }
    public static double MToCm(double numero){
        int centimetres = 100; //Hauria de ser una Constant però em fa pal :D

        numero*=centimetres;

        return numero;
    }
    public static double CmToMm(double numero){
        int milimetres = 10; //Hauria de ser una Constant però em fa pal :D

        numero*=milimetres;

        return numero;
    }
    public static double Conversio(double numero, String unitats, String passar){
        int metres = 1000, centimetres = 100, milimetres = 10; //Hauria de ser una Constant però em fa pal :D

        if(unitats.equals("km")){
            switch (passar) {
                case "m": numero = KmToM(numero);
                        break;
                case "cm": numero = KmToM(numero);
                        numero = MToCm(numero);
                        break;
                case "mm":numero = KmToM(numero);
                        numero = MToCm(numero);
                        numero = CmToMm(numero);
                        break;
            }
        }else if(unitats.equals("m")){
            switch (passar) {
                case "km": numero/=metres;
                        break;
                case "cm": numero = MToCm(numero);
                        break;
                case "mm":numero = MToCm(numero);
                        numero = CmToMm(numero);
                        break;
            }
        }else if(unitats.equals("cm")){
            switch (passar) {
                case "km": numero/=(metres*centimetres); //1000*100 es equivalent a 100000cm -> 1km
                        break;
                case "m": numero/=centimetres;
                        break;
                case "mm":numero = CmToMm(numero);
                        break;
            }
        }else{
            switch (passar) {
                case "km": numero/=(milimetres*centimetres*metres); //Igual que anterior pero per arribar a km
                        break;
                case "m": numero/=(milimetres*centimetres); //100*10 es equivalent a 1000mm -> 1m
                        break;
                case "cm":numero/=milimetres;
                        break;
            }
        }
        return numero;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double numero;
        String unitats, passar;

        System.out.print("Entra el valor (ex. 1 km): ");
        numero = sc.nextDouble();
        unitats = sc.next();
        System.out.print("Entra les unitats a les quals vols passar (km, m, cm, mm): ");
        passar = sc.next();

        numero = Conversio(numero, unitats, passar);
        System.out.println(numero+" "+passar);
    }
}