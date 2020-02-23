/*
    5. Jugar
    Cal fer una funció que ens permeti seleccionar una casella introduint la seva fila i columna. Si
    en la casella no hi ha una bomba, caldrà mostrar quantes mines adjacents hi ha al voltant de la
    casella seleccionada. Cal fer una funció per a contar les mines adjacents. Quan es visualitzi el
    taulell es mostraran quantes bombes adjacents hi ha a la casella escollida. Les imatges mostren
    un exemple de funcionament.
*/
import java.util.Scanner;
public class Jugar{
    public static boolean SelectCasella(IniciTauler inici){
        Scanner sc = new Scanner(System.in);
        int fila, columna;
        boolean perdut = false;

        do {
            System.out.print("Introdueixi la fila: ");
            fila = sc.nextInt();
        } while (fila<0 || fila>inici.t.files);
        fila++;

        do {
            System.out.print("Introdueixi la columna: ");
            columna = sc.nextInt();
        } while (columna<0 || columna>inici.t.columnes);
        columna++;

        if(inici.mines[fila][columna]==Constants.MINA){
            perdut = true;
        }else{
            MinesAdjacents(fila, columna, inici);
        }
        
        return perdut;
    }
    public static void MinesAdjacents(int fila, int columna, IniciTauler inici){
        int i, j, contador=0;

        for(i=fila-1;i<=fila+1;i++){
            for(j=columna-1;j<=columna+1;j++){
                if(inici.mines[i][j]==Constants.MINA){
                    contador++;
                }
            }
        }
        contador+=48; //Passar a ASCII 48 == 0
        inici.tauler[fila][columna] = (char) contador;
    }
    public static int Guanyar(int casellesDisp, boolean perdut){

        if(!perdut){
            casellesDisp--;
        }

        return casellesDisp;
    }
    public static void main(String[] args) {
        IniciTauler inici = new IniciTauler();
        ColocarMines mines = new ColocarMines();
        boolean perdut, guanyat=false;
        int casellesDisp; //Caselles sense mines

        casellesDisp = (inici.t.files*inici.t.columnes)-mines.numMines;

        do {
            perdut = SelectCasella(inici);
            casellesDisp = Guanyar(casellesDisp, perdut);
            if(!perdut){
                VisualitzarTauler.TaulerNoMines(inici);
            }
            if(casellesDisp==0){
                guanyat = true;
            }
        } while (!perdut&&!guanyat);

        if(perdut){
            VisualitzarTauler.TaulerMines(inici);
            System.out.println("Ha explotat una mina. Has perdut!!!");
        }else{
            System.out.println("Has localitzat totes les mines");
        }
        Menu.main(null);
    }
}