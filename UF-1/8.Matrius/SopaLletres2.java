import java.util.Scanner;
import java.util.Random;
public class SopaLletres2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int i, j, k, posicio=0, columnaInici=0, columnaFi=0, index;
        int[][] numeros = new int[11][1];
        int[] num = new int[16];
        int numero=1;
        String abecedari="ABCDEFGHIJKLMNOPQRSTUVWXYZ", vocals="AEIOU", anterior="res", actual="res";
        // String[] paraules = new String[500];
        String paraules="a";
        char lletra;
        char[] lletres = new char[16];
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
        //Busqueda paraules
        for(i=1;i<11;i++){
            j=1;posicio=0;
            anterior = "res";actual = "res";
            for(k=0;k<paraules.length();k++){
                lletres[k] = ' ';
            }
            while(j<16){
                k=0;
                while(k<vocals.length()){
                    if(sopa[i][j] == vocals.charAt(k)){
                        actual = "vocal";
                        break;
                    }else if(k==vocals.length()-1){
                        actual = "consonant";
                        break;
                    }
                    k++;
                }

                if(!actual.equals(anterior)){
                    lletres[posicio] = sopa[i][j];
                    j++;
                    posicio++;
                    anterior = actual;
                }else if(actual.equals(anterior)){
                    paraules = String.valueOf(lletres);
                    paraules = paraules.trim();
                    if(paraules.length()>1){
                        columnaFi = j-1;
                        columnaInici = j-(paraules.length());
                        System.out.println("Fila: "+i+" Columna inicial: "+columnaInici+" Columna final: "+columnaFi+" Paraula: "+paraules);
                    }
                    for(k=0;k<paraules.length();k++){
                        lletres[k] = ' ';
                    }
                    posicio=0;anterior="res";
                }
                if(j==16){
                    paraules = String.valueOf(lletres);
                    paraules = paraules.trim();
                    if(paraules.length()>1){
                        columnaFi = j-1;
                        columnaInici = j-(paraules.length());
                        System.out.println("Fila: "+i+" Columna inicial: "+columnaInici+" Columna final: "+columnaFi+" Paraula: "+paraules);
                    }
                    for(k=0;k<paraules.length();k++){
                        lletres[k] = ' ';
                    }
                    posicio=0;anterior="res";
                }
            }
        }
    }
}