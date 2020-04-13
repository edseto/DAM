public class Consum{
    private double potencia;
    private String unitats;
    private String lletra;

    //Getters
    public double getPotencia() { return this.potencia; }
    public String getUnitats() { return this.unitats; }
    public String getLletra() { return this.lletra; }

    //Setters
    public void setLletra(String lletra) { this.lletra = lletra; }
    public void setPotencia(double potencia) throws Exception{ //Passo directament a "kW"
        if(validar(potencia)) this.potencia = potencia;
            else throw new Exception("La potencia ha de ser superior a 0!");

        if(unitats.equals("W")){
            canviarUnitats();
        }
        this.lletra = calcularLletra(this.potencia);
    }
    public void setUnitats(String unitats) throws Exception { //Passo directament a "kW"
        // try {
            if(validar(unitats)){
                if(unitats.equals("W")){
                    canviarUnitats();
                }else{
                    this.unitats = unitats;
                }
            }else{
                throw new Exception("Les unitats introduides no son valides, les unitats valides son: kW i W");
            }
        // } catch (Exception e) {
        //     //e.printStackTrace();
        //     //System.exit(0); //Finalitzar execució del programa
        // }
    }
    
    //Constructors
    public Consum() {
        this.potencia = 75;
        this.unitats = "kW";
        this.lletra = calcularLletra(potencia);
    }

    public Consum(double potencia, String unitats){
        try {
            if(validar(unitats)) this.unitats = unitats;
                else throw new Exception("Les unitats introduides no son valides, les unitats valides son: kW i W");
            if(validar(potencia)) this.potencia = potencia;
                else throw new Exception("La potencia no pot ser inferior a 0!");
        } catch (Exception e) {
            e.printStackTrace();
            //System.exit(0); //Finalitzar execució del programa
        }
        if(unitats.equals("W")) canviarUnitats();
        this.lletra = calcularLletra(this.potencia);
    }
    
    //Mètodes
    private void canviarUnitats(){
        this.potencia /= 1000;
        this.unitats = "kW";
    }

    private boolean validar(String unitats){ //Validar unitats correcte
        if(!unitats.equals("W") && !unitats.equals("kW")){
            return false;
        }else{
            return true;
        }
    }

    private boolean validar(double potencia){ //Validar potencia superior a 0 --> Deixo el 0 per si volen "marques"
        if(potencia<0) return false;
            else return true;
    }

    private String calcularLletra(double potencia){
        if(potencia<30){
            return "A++";
        }else if(potencia<=42){
            return "A+";
        }else if(potencia<=55){
            return "A";
        }else if(potencia<=75){
            return "B";
        }else if(potencia<=90){
            return "C";
        }else if(potencia<=100){
            return "D";
        }else if(potencia<=110){ 
            return "E";
        }else if(potencia<=125){
            return "F";
        }else{
            return "G";
        }
    }
    @Override
    public String toString(){
        return "Potencia: "+this.potencia+this.unitats+" --> "+this.lletra;
    }
}