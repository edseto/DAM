public class Proves2{
    public static void main(String[] args) {
        Carta c1 = new Carta("e", 6);
        Carta c2 = new Carta("e", 1);
        String[] pals = {"e","B","O","c"};
        int proves=1;
        int[] numeros = {7, 1, 8, 4};

        //Assigna jugadors - Mètode setJugador
        c1.setJugador(1);
        c2.setJugador(2);

        for (int i = 0; i < pals.length; i++) {
            c2.setPal(pals[i]);
            c2.setNumero(numeros[i]);

            System.out.println("Prova "+proves+":");
            //Mostra les dades - Mètode toString
            System.out.println("Carta 1: "+c1.toString());
            System.out.println("Carta 2: "+c2.toString());
    
            //Prova de mètode escala
            if(c1.escala(c2)){
                System.out.println("Les cartes fan escala");
            }else{
                System.out.println("Les cartes no fan escala");
            }
    
            //Prova de mètode equals
            if(c1.equals(c2)){
                System.out.println("Les cartes son iguals");
            }else{
                System.out.println("Les cartes son diferents");
            }
    
            //Prova de mètode pal
            if(c1.pal(c2)){
                System.out.println("Els pals son iguals");
            }else{
                System.out.println("Els pals son diferents");
            }
    
            //Prova de mètode escalaColor
            if(c1.escalaColor(c2)){
                System.out.println("Les cartes estan en escala color");
            }else{
                System.out.println("Les cartes no estan en escala color");
            }
    
            //Prova de mètode guanya
            if(c1.guanya(c2)){
                System.out.println("Guanya el Jugador"+ c1.getJugador() +" amb la carta "+c1.toString());
            }else{
                System.out.println("Guanya el Jugador"+ c2.getJugador() +" amb la carta "+c2.toString());
            }
            System.out.println();
            c1.setPal(pals[2]);
            proves++;
        }

        c2.setPal("o");
        c2.setNumero(6);

        System.out.println("Carta 1: "+c1.toString());
        System.out.println("Carta 2: "+c2.toString());
        
        //Prova de mètode equals -> true
        if(c1.equals(c2)){
            System.out.println("Les cartes son iguals");
        }else{
            System.out.println("Les cartes son diferents");
        }
    }
}