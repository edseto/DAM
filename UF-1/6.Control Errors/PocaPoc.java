public class PocaPoc{
    public static void main(String[] args) {
        char lletra = 'A';
        int i;
        for(i=1;i<25;i++){
            try {
                Thread.sleep(500);
                System.out.print(lletra); 
            } catch (Exception ex) {
                System.out.println("Hi ha hagut un error inesperat");
            }
        }
    }
}