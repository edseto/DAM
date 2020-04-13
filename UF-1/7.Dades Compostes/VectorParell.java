import java.util.Scanner;
public class VectorParell{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, j, posicio=0;        
        System.out.print("Introdueixi el nombre maxim: ");
        numero = sc.nextInt();
        int[] parell= new int[numero/2+1];
        for(j=0;j<=numero;j+=2){
            System.out.println(j);
            parell[posicio]=j;
            posicio++;
        }
        sc.close();
    }
}