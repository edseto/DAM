import java.util.Scanner;
public class MatriuMath{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean matriu=false;
        int caselles, costat, i, j, k, calcul=0, resultat=0;
        int[][] taula;

        System.out.print("Entra el nombre de caselles: ");
        caselles = sc.nextInt();
        costat = (int)Math.sqrt(caselles);
        taula = new int[costat][costat];
        for(i=0;i<costat;i++){
            for(j=0;j<costat;j++){
                System.out.print("["+i+","+j+"]");
                taula[i][j] = sc.nextInt();
            }
        }
        for(i=0;i<costat;i++){
            for(j=0;j<costat;j++){
                for(k=0;k<3;k++){
                    System.out.print(" ");
                }
                System.out.print(taula[i][j]+" ");
            }
            System.out.print("\n");
        }
        for(i=0;i<costat;i++){
            for(j=0;j<costat;j++){
                calcul+=taula[i][j];
            }
            if(calcul==resultat){
                matriu=true;
            }else{
                matriu=false;
            }
            resultat=calcul;
            calcul=0;
        }
        for(i=0;i<costat;i++){
            for(j=0;j<costat;j++){
                calcul+=taula[j][i];
            }
            if(calcul==resultat){
                matriu=true;
            }else{
                matriu=false;
            }
            resultat=calcul;
            calcul=0;
        }
        if(matriu){
            System.out.println("Matriu matematica");
        }else{
            System.out.println("Matriu no matematica");
        }
    }
}