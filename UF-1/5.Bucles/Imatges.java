import java.util.Scanner;
public class Imatges{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String figura;
        int triangle, i, j, z;
        System.out.print("Quina figura vols (Quadrat o Triangle)? ");
            figura = sc.nextLine();
        if(figura.equals("Triangle")){
            System.out.print("Quin triangle vols(1-4)? ");
                triangle = sc.nextInt();
            switch(triangle){
                case 1:System.out.println("TRIANGLE 1:");
                for(i=1;i<=10;i++){
                    for(j=1;j<=i;j++){
                        System.out.print("*"); 
                    }
                    System.out.print("\n");
                }
                break;
                case 2:System.out.println("TRIANGLE 2:");
                for(i=1;i<=10;i++){
                    for(j=10;j>=i;j--){
                        System.out.print("*"); 
                    }
                    System.out.print("\n");
                }
                break;
                case 3:System.out.println("TRIANGLE 3:");
                for(i=10;i>=1;i--){
                    for(j=10;j>i;j--){
                        System.out.print(" "); 
                    }
                    for(z=1;z<=j;z++){
                        System.out.print("*"); 
                    }
                    System.out.print("\n");
                }
                break;
                case 4:System.out.println("TRIANGLE 4:");
                for(i=10;i>=1;i--){
                    for(j=1;j<i;j++){
                        System.out.print(" "); 
                    }
                    for(z=10;z>=j;z--){
                        System.out.print("*"); 
                    }
                    System.out.print("\n");
                }
                break;
            }
        }
        if(figura.equals("Quadrat")){
            System.out.println("QUADRAT BUIT");
            for (i=0;i<=10;i++){
                System.out.print("*");
            }
            System.out.print("\n");
            for(j=0;j<=10;j++){
                System.out.println("*\t  *");
            }
            for(z=0;z<=10;z++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}