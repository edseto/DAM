import java.util.Random;
public class Sopa{
    public static void main(String[] args) {
        Random r = new Random();
        int i, j, k;
        int[][] numeros = new int[11][1];
        int[] num = new int[16];
        int numero=1;
        String abecedari="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char lletra;
        char[][] sopa = new char[11][16];
        for(j=1;j<11;j++){
            numeros[j][0] = numero++;
        } 
        numero=1;
        for(i=1;i<16;i++){
                num[i] = numero++;
        }
        for(i=1;i<11;i++){
            for(j=1;j<16;j++){
                lletra = abecedari.charAt(r.nextInt(abecedari.length()));
                sopa[i][j] = lletra;
            }
        }
        for(i=0;i<16;i++){
            if(i==0){
                for(j=0;j<7;j++){
                    System.out.print(" ");
                }
            }else{
                System.out.print(num[i]);
                if(i<10){
                    for(k=0;k<4;k++){
                        System.out.print(" ");
                    }
                }else{
                    for(k=0;k<3;k++){
                        System.out.print(" ");
                    }
                }
            }
        }
        System.out.print("\n");
        for(i=0;i<11;i++){
            if(i==0){
                System.out.print("");
            }else{
                if(i<10){
                    System.out.print(" ");
                }
                System.out.print(numeros[i][0]);
            }
            if(i>0){
                for(j=0;j<16;j++){
                    System.out.print(sopa[i][j]);
                    for(k=0;k<4;k++){
                        System.out.print(" ");
                    }
                }
            }
            if(i!=0){
                System.out.print("\n");
            }
        }
    }
}