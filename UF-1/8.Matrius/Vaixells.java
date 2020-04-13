import java.util.Scanner;
public class Vaixells{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean adjacent=false, columnExist=false;
        int i, j, k, fila, ncolumna=0;
        String abecedari=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros=" 12345678910";
        char columna;
        char[][] tauler = new char[11][12];

        for(i=1;i<11;i++){
            if(i==10){
                tauler[i][0] = '1';
            }else{
                tauler[i][0] = numeros.charAt(i);
            }
        }
        tauler[10][1]='0';
        for(i=0;i<11;i++){
            tauler[0][i] = abecedari.charAt(i);
        }
        for(i=1;i<11;i++){
            for(j=11;j>0;j--){
                if(j==1 && i==10){
                }else{
                    tauler[i][j] = 'O';
                }
            }
        }
        System.out.println("**Benvingut al joc dels Vaixells**");
        System.out.println("Has d'introduir 8 vaixells en total");
        System.out.println("No poden ser adjacents (no es poden tocar)");
        System.out.print("\n");

        for(i=0;i<11;i++){
            System.out.print(tauler[0][i]+"  ");
        }
        System.out.print("\n");
        for(i=1;i<11;i++){
            for(j=0;j<12;j++){
                if(i<10&&j==11){}else{
                    System.out.print(tauler[i][j]);
                }
                if(i==10&&j==0){
                }else if(i==10&&j==1){
                    System.out.print(" ");
                }else{
                    System.out.print("  ");
                }
            }
            if(i==1||i<10){
                System.out.print("\n");
            }
        }
        System.out.print("\n");
        i=1;
        do {
            adjacent=false;
            System.out.println("Posicio Vaixell "+i);
            do {
                System.out.print("Fila (1-10): ");
                fila = sc.nextInt();
            } while (fila>10 && fila<0);
            do {
                System.out.print("Columna (A-J): ");
                columna = sc.next().charAt(0);
                for(j=1;j<11;j++){
                    if(columna==tauler[0][j]){
                        columnExist = true;
                        ncolumna = j;
                        break;
                    }else{
                        columnExist = false;
                    }
                }
            } while (!columnExist);
            if(fila==10){ncolumna+=1;}
            if(fila==1){
                for(j=fila;j<=fila+1;j++){
                    if(adjacent==true){break;}
                    for(k=ncolumna-1;k<ncolumna+2;k++){
                        if(tauler[j][k]=='X'){
                            adjacent = true;
                            System.out.println("Posicio: ["+fila+" , "+columna+"] no valida");
                            break;
                        }else{adjacent = false;}
                    }
                }
            }else if(fila==10){
                if(ncolumna==11){ncolumna-=1;}
                for(j=fila-1;j<fila+1;j++){
                    if(adjacent==true){break;}
                    for(k=ncolumna-1;k<=ncolumna+1;k++){
                        if(tauler[j][k]=='X'){
                            adjacent = true;
                            System.out.println("Posicio: ["+fila+" , "+columna+"] no valida");
                            break;
                        }else{adjacent = false;}
                    }
                }
            }else{
                for(j=fila-1;j<=fila+1;j++){
                    if(adjacent==true){break;}
                    for(k=ncolumna-1;k<ncolumna+2;k++){
                        if(tauler[j][k]=='X'){
                            adjacent = true;
                            System.out.println("Posicio: ["+fila+" , "+columna+"] no valida");
                            break;
                        }else{adjacent = false;}
                    }
                }
            }
            if(adjacent==false){
                tauler[fila][ncolumna] = 'X';
                i++;
            }
            System.out.print("\n");
        } while (i<=8);
        
        System.out.println("**Colocacio dels vaixells**");
        for(i=0;i<11;i++){
            System.out.print(tauler[0][i]+"  ");
        }
        System.out.print("\n");
        for(i=1;i<11;i++){
            for(j=0;j<12;j++){
                if(i<10&&j==11){}else{
                    System.out.print(tauler[i][j]);
                }
                if(i==10&&j==0){
                }else if(i==10&&j==1){
                    System.out.print(" ");
                }else{
                    System.out.print("  ");
                }
            }
            if(i==1||i<10){
                System.out.print("\n");
            }
        }
    }
}