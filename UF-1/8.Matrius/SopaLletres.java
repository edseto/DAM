import java.util.Scanner;
import java.util.Random;
public class SopaLletres{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        boolean consonant=false, vocal=false, trobada=false, fet=false;
        int i, j, k, posicio=0, trobades=0, fila=0, columnaInici=0, columnaFi=0, index=0;
        int[][] numeros = new int[11][1];
        int[][] filaColumna = new int[11][16];
        int[] num = new int[16];
        int numero=1;
        String abecedari="ABCDEFGHIJKLMNOPQRSTUVWXYZ", buscar;
        String vocals="AEIOU", consonants="BCDGHIJKLMNPQRSTVWXYZ";
        String[] paraules = new String[500];
        char lletra='A';
        char[] paraula = new char[16];
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
        //Busqueda de les paraules
        posicio=0;
        for(i=1;i<11;i++){
            for(j=1;j<16;j++){
                index=0;
                for(k=0;k<=vocals.length();k++){
                    if(sopa[i][j] == vocals.charAt(index) && vocal==false){
                        vocal = true;
                        consonant = false;
                        // fet = true;
                        lletra = sopa[i][j];
                        paraules[posicio] = paraules[j-1]+lletra;
                        paraules[posicio] = paraules[posicio].replaceAll("null", "");
                        // posicio++;
                        break;
                    }else if(k==vocals.length() && consonant==false){
                        vocal = false;
                        consonant = true;
                        // fet = true;
                        lletra = sopa[i][j];
                        paraules[posicio] = paraules[posicio]+lletra;
                        paraules[posicio] = paraules[posicio].replaceAll("null", "");
                        // posicio++;
                        break;
                    }
                    if(index<vocals.length()-1){
                        index++;
                    }
                    // paraules[j] = paraules[j-1]+lletra;
                }
                if(paraules[posicio]!=null){
                    posicio++;
                    if(paraules[posicio].length()>1){
                        System.out.println(paraules[j-1]);
                    }else{posicio--;}
                }
            }
        }
        // System.out.print("Introdueix la paraula a buscar: ");
        // buscar = sc.next();
        // paraula = new char[buscar.length()];
        // paraula = buscar.toCharArray();
        // for(i=1;i<11;i++){
        //     for(j=1;j<16;j++){
        //         if(paraula[posicio]==sopa[i][j]){
        //             trobada=true;
        //             fila = i;
        //             columnaFi = j;
        //             posicio++;
        //             trobades++;
        //         }else{
        //             posicio=0;
        //             trobades=0;
        //             trobada=false;
        //         }
        //         if(trobades==buscar.length()){break;}
        //     }
        //     if(trobades==buscar.length()){break;}
        // }
        // if(trobada==true){
        //     columnaInici = columnaFi - (buscar.length()-1); //Per trobar a quina columna comença
        //     System.out.println("Trobada a la fila "+fila+" i a la columna "+columnaInici);
        // }else{
        //     System.out.println("No trobada");
        // }
    }
}