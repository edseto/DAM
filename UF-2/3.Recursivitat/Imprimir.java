/*
    2. Imprimir
    Dissenya una funció recursiva per a imprimir els elements d’un array. Per exemple, si l’array
    conté els valors {1,5,7,2,3,9} , la funció ha d’imprimir:
    Fixa’t que els nombres apareixen separats per «,» excepte l’últim
*/
public class Imprimir{
    public static int Impressio(int[] valors, int index){
        
        if(index==0){
            return 0;
        }else{
            System.out.print(valors[Impressio(valors, index-1)]+", ");
        }
        return index;
    }
    public static void main(String[] args) {
        int[] valors = {1,5,7,2,3,9};
        int index = valors.length-1;

        Impressio(valors, index);
        System.out.print(valors[index]);
    }
}