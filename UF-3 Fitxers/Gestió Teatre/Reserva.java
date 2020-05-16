import java.time.LocalDate;
public class Reserva {
    private int id;
    private Seient seient;
    private Persona espectador;
    private LocalDate data;

    //Constructors
    public Reserva() { }

    public Reserva(int id, Seient seient, Persona espectador, LocalDate data) {
        this.id = id;
        this.seient = seient;
        this.espectador = espectador;
        this.data = data;
    }
    
    //Getters
    public int getId() { return id; }
    public Seient getSeient() { return seient; }
    public Persona getEspectador() { return espectador; }
    public LocalDate getData() { return data; }

    //Setters
    public void setId(int id) { this.id = id; }
    public void setSeient(Seient seient) { this.seient = seient; }
    public void setEspectador(Persona espectador) { this.espectador = espectador; }
    public void setData(LocalDate data) { this.data = data; }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", data=" + data + ", espectador=" + espectador + ", seient=" + seient + "]";
    }
}