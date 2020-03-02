/*
    1. Posicionament
    Una posició ve determinada per una fila i una columna. Dues posicions són iguals si tenen la mateixa i la
    mateixa columna. Crea un objecte de nom "Posicio". Implementa els seus "getters" i "setters", el
    constructor i el mètode "equals". Crea el programa per a comprovar que els diferents mètodes funcionen
    de forma correcte.
*/
public class Posicio{
    private int fila;
    private int columna;

    //Getters
    public int getFila() { return this.fila; }
    public int getColumna() { return this.columna; }

    //Setters
    public void setFila(int fila) { this.fila = fila; }
    public void setColumna(int columna) { this.columna = columna; }

    //Constructor
    public Posicio(int fila, int columna) {
        this.iniciar(fila, columna);
    }

    //Mètodes
    private void iniciar(int fila, int columna){
        this.setFila(fila);
        this.setColumna(columna);
    }
    public boolean equals(Posicio p){
        return this.getFila() == p.getFila() && this.getColumna() == p.getColumna();
    }
    public String toString(){
        return "Files: "+this.getFila()+"\nColumnes: "+this.getColumna();
    }
}