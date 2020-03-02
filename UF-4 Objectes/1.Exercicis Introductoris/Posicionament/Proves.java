public class Proves{
    public static void main(String[] args) {
        Posicio p1 = new Posicio(3,4); //P1 i P2 seran iguals
        Posicio p2 = new Posicio(3,4);

        System.out.println("Prova 1:");
        System.out.println("Posicio 1: \n"+p1.toString());
        System.out.println();

        System.out.println("Posicio 2: \n"+p2.toString());

        if(p1.equals(p2)){
            System.out.println("La posicio 1 i la posicio 2 son iguals");
        }else{
            System.out.println("La posicio 1 i la posicio 2 son diferents");
        }

        p1.setColumna(23);
        p1.setFila(30);
        
        System.out.println();
        System.out.println("Prova 2:");
        System.out.println("Posicio 1: \n"+p1.toString());
        System.out.println();

        System.out.println("Posicio 2: \n"+p2.toString());

        if(p1.equals(p2)){
            System.out.println("La posicio 1 i la posicio 2 son iguals");
        }else{
            System.out.println("La posicio 1 i la posicio 2 son diferents");
        }
    }
}