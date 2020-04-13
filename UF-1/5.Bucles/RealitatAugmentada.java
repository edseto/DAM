import java.util.Scanner;
public class RealitatAugmentada{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, i, j, z, altura;
        char lletra;
        System.out.print("Quina grandaria desitja la lletra [6-12]: ");
            num = sc.nextInt();
        System.out.print("Entra una lletra: ");
            lletra = sc.next().charAt(0);
        altura = num/2;
        if((num>=6 && num<=12)&&(lletra=='S')){
            for(z=1;z<=3;z++){
                for(i=1;i<=num;i++){
                    System.out.print('*');
                }
                System.out.print("\n");
                if(z==1){
                    for(j=1;j<=altura;j++){
                        System.out.println('*');
                    }
                }else if(z==2){
                    for(i=1;i<=altura;i++){
                        for(j=1;j<num;j++){
                            System.out.print(" ");
                        }
                        System.out.println("*");
                    }
                }
            }
        }
    }
}