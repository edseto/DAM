public class Electrodomestic {
    private double preuBase;
    private double pes;
    private Consum consum;
    private Color color;

    //Getters
    public double getPreuBase() { return this.preuBase; }
    public double getPes() { return this.pes; }
    public Color getColor() { return this.color; } //Retorna el mètode toString
    public Consum getConsum() { return this.consum; } //Retorna el mètode toString

    //Setters
    public void setPreuBase(double preuBase) { this.preuBase = preuBase; }
    public void setPes(double pes) { this.pes = pes; }
    public void setConsum(double potencia, String unitats) throws Exception{
        consum.setPotencia(potencia);
        consum.setUnitats(unitats);
      
    }
    public void setColor(short red, short green, short blue) { 
        color.setRed(red);
        color.setGreen(green);
        color.setBlue(blue);
    }

    //Constructors
    public Electrodomestic() {
        Consum consum = new Consum();
        Color color = new Color();
        this.consum = consum;
        this.color = color;
        iniciarDefault();
    }
    public Electrodomestic(Consum consum, Color color){
        this.consum = consum;
        this.color = color;
        iniciarDefault();
    }

    public Electrodomestic(Consum consum){
        this.consum = consum;
        iniciarDefault();
    }

    public Electrodomestic(Color color){
        this.color = color;
        iniciarDefault();
    }
    public Electrodomestic(double preuBase, double pes) throws Exception{
        Consum consum = new Consum();
        Color color = new Color();
        
        if(preuBase <0) throw new Exception("El preu base no pot ser inferior a 0!"); //Deixo el 0 per "marques"
        if(pes<0) throw new Exception("El pes no pot ser inferior a 0!");

        this.consum = consum;
        this.color = color;
        this.preuBase = preuBase;
        this.pes = pes;
    }

    // public Electrodomestic(double preuBase, double pes){

    //     try {
    //         if(preuBase >= 0) this.preuBase = preuBase;
    //             else throw new Exception("El preu base no pot ser inferior a 0!");
    //         if(pes >= 0) this.pes = pes;
    //             else throw new Exception("El pes no pot ser inferior a 0!");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     Consum consum = new Consum();
    //     Color color = new Color();
    //     this.consum = consum;
    //     this.color = color;
    // }

    //Mètodes
    private void iniciarDefault(){ // Iniciar valors Default
        try {
            consum.setPotencia(75);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            consum.setUnitats("kW");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.preuBase = 100;
        this.pes = 10;
    }

    @Override
    public String toString(){
        return "Informacio Color:\n"+color.toString()+"\n"+"Informacio Consum:\n"+consum.toString()+"\n"+
        "Informacio Electrodomestic:\n"+"Preu Base: "+this.preuBase+"€\n"+"Pes: "+this.pes+"Kg\n"+preu();
    }

    public String lletra(){ return consum.getLletra(); }

    public String preu(){ return "El preu total de l'electrodomestic es: "+preuTotal()+"€"; }

    private double preuTotal(){ return this.preuBase + preuConsum() + preuPes(); }

    private double preuPes(){
        double preuPes;

        if(this.pes<20){ //Entre 0 i 19
            preuPes = 10;
        }else if(this.pes<50){ //Entre 20 i 49
            preuPes = 30;
        }else if(this.pes<80){ //Entre 50 i 79
            preuPes = 55;
        }else{ //Més de 79
            preuPes = 85;
        }
        return preuPes;
    }

    private double preuConsum(){
        double preuConsum = 0;

        switch (consum.getLletra()) {
            case "G": preuConsum = 10;
                break;
            case "F": preuConsum = 30;
                break;
            case "E": preuConsum = 40;
                break;
            case "D": preuConsum = 50;
                break;
            case "C": preuConsum = 70;
                break;
            case "B": preuConsum = 80;
                break;
            case "A":
            case "A+":
            case "A++": preuConsum = 100;
                break;
        }
        return preuConsum;
    }
}