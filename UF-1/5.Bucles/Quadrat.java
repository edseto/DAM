import java.util.Scanner;
public class Quadrat{
    public static void main(String[] args) {
        int num, i, j;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueixi la mida del costat del quadrat [3-20]: ");
            num = sc.nextInt();
        if(num>=3 && num<=20){
            for(i=1;i<=num;i++){
                for(j=1;j<=num;j++){
                    System.out.print("*"); 
                }
                System.out.print("\n");
            }
        }
    }
}