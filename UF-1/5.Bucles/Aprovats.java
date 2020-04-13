import java.util.Scanner;
public class Aprovats{
    public static void main(String[] args) {
        int nota, aprovat = 0, suspes = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Introdueix una nota: ");
                nota = sc.nextInt();
            if(nota<5&&(nota>0)){
                suspes++;
            }else if(nota>=5&&nota<=10){
                aprovat++;
            }
        } while (nota!=-1);
        System.out.println("Han aprovat "+aprovat+" persones"); 
        System.out.println("Han de recuperar "+suspes+" persones"); 
        if(aprovat>suspes){
            System.out.println("La majoria ha aprovat");
        }else{
            System.out.println("La majoria ha suspes");
        }
    }
}
