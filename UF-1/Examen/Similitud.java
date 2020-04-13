public class Similitud{
    public static void main(String[] args) {
        int[] v1={1,3,2};
        int[] v2={2,4,3};
        int indexV1=0, indexV2;
        boolean trobat, similars=true;
/*
Per tal de minimitzar el nombre de comparacions tinc el boolean trobat
El que fa és que si no troba x número (significa que no són similars) 
El boolean similars el poso a false i surt del bucle
*/
        while(similars&&indexV1<v1.length){
            indexV2=0;trobat=false;
            while(!trobat&&indexV2<v2.length){
                if(v1[indexV1]==v2[indexV2]){
                    trobat=true;
                }else{
                    indexV2++;
                }
            }
            if(!trobat){
                similars=false;
            }
            indexV1++;
        }
        if(!similars){
            System.out.print("Elements vector 1: ");
            for(indexV1=0;indexV1<v1.length;indexV1++){
                System.out.print(v1[indexV1]+" ");
            }
            System.out.println();
            System.out.print("Elements vector 2: ");
            for(indexV2=0;indexV2<v2.length;indexV2++){
                System.out.print(v2[indexV2]+" ");
            }
            System.out.println();
            System.out.println("Els dos vectors no son similars");
        }else{
            System.out.print("Elements vector 1: ");
            for(indexV1=0;indexV1<v1.length;indexV1++){
                System.out.print(v1[indexV1]+" ");
            }
            System.out.println();
            System.out.print("Elements vector 2: ");
            for(indexV2=0;indexV2<v2.length;indexV2++){
                System.out.print(v2[indexV2]+" ");
            }
            System.out.println();
            System.out.println("Els dos vectors son similars");
        }
    }
}