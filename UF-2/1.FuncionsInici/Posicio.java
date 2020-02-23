/* 
    2.Fes una funció que em retorni l’índex de la posició d’un element en un vector de números
    enters. Si l’element no existeix, retornarà el valor -1
*/
import java.util.Scanner;
public class Posicio{
    public static int buscarValor(int element){
        boolean existeix=true;
        int i=0, index;
        int[] valors = {3, 6, 7, 10, 42};
        do {
            if(element==valors[i]){
                index=i;
                existeix=true;
            }else{
                index=-1;
                existeix=false;
            }
            i++;
        } while (!existeix&&i<valors.length);
        return index;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int element, index;

        System.out.print("Introdueix el valor a buscar: ");
        element = sc.nextInt();
        index = buscarValor(element);
        System.out.println(index);
    }
}