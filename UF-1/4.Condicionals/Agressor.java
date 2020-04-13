import java.util.Scanner;
public class Agressor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entra el lloc de la victima: ");
            int victima = sc.nextInt();
        System.out.print("Entra el lloc de l'agressor: ");
            int agressor = sc.nextInt();
        if (agressor>victima){
/*Per evitar un possible número negatiu a l'hora de restar intercanvio 
els numeros si agressor és més gran que victima*/
            victima = victima + agressor;
            agressor = victima - agressor;
            victima = victima - agressor;
        }
            int distancia = (victima - agressor);//Calculo la distància entre els dos
        if (distancia<100){ //Si la distància és menor de 100 executa una cosa o altre
            System.out.println("Perill, allunya't!!");
        }else{
            System.out.println("Pots passejar amb tranquilitat :-D");
        }
    }
}

