import java.util.Scanner;
import java.util.Random;
public class SopaResolta{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        boolean trobada=false;
        int i, j, k, posicio=0, trobades=0, fila=0, columna =0;
        int[][] numeros = new int[11][1];
        int[] num = new int[16];
        int numero=1;
        String abecedari="ABCDEFGHIJKLMNOPQRSTUVWXYZ", buscar;
        char lletra;
        char[] paraula;
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
        System.out.print("Introdueix la paraula a buscar: ");
        buscar = sc.next();
        paraula = new char[buscar.length()];
        paraula = buscar.toCharArray();
        for(i=1;i<11;i++){
            for(j=1;j<16;j++){
                if(paraula[posicio]==sopa[i][j]){
                    trobada=true;
                    fila = i;
                    columna = j;
                    posicio++;
                    trobades++;
                }else{
                    posicio=0;
                    trobades=0;
                    trobada=false;
                }
                if(trobades==buscar.length()){break;}
            }
            if(trobades==buscar.length()){break;}
        }
        if(trobada==true){
            columna -= (buscar.length()-1); //Per trobar a quina columna comença
            System.out.println("Trobada a la fila "+fila+" i a la columna "+columna);
        }else{
            System.out.println("No trobada");
        }

    }
}