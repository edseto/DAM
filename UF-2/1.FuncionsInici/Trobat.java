/*
    1.Fes una funció que em retorni si un determinat element existeix en un vector de números enters.
*/
import java.util.Scanner;
public class Trobat{
    public static boolean buscarValor(int element){
        boolean existeix=true;
        int i=0;
        int[] valors = {3, 6, 7, 10, 42};
        do {
            if(element==valors[i]){
                existeix=true;
            }else{
                existeix=false;
            }
            i++;
        } while (!existeix&&i<valors.length);
        return existeix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int element;
        boolean existeix;

        System.out.print("Introdueix el valor a buscar: ");
        element = sc.nextInt();
        existeix = buscarValor(element);
        if(!existeix){
            System.out.println("El valor introduit no existeix a l'array");
        }else{
            System.out.println("El valor introduit si existeix a l'array");
        }
    }
}