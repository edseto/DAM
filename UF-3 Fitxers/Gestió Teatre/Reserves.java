import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;
public class Reserves {
    ArrayList<Reserva> reserves = new ArrayList<Reserva>();

    //Constructors
    public Reserves(){ }

    //Mètodes
    public void reservar(Seient seient, Persona espectador, LocalDate data, Connection conDB) throws Exception {
        int id;
        Reserva reserva;
        
        if(reserves.size()==0) id=1; // Si és la primera reserva de la llista
        else id=ReservaDB.idUltimaReserva(conDB)+1;
        
        reserva = new Reserva(id, seient, espectador, data);
        
        ReservaDB.afegirReserva(conDB, reserva);
        reserves.add(reserva);
    }

    public void retirarReserva(Seient seient, Persona espectador, LocalDate data, Connection conDB) throws Exception{
        int index = reservaTrobada(seient, espectador, data);

        if(index==-1) throw new Exception("No s'ha trobat la vostra reserva, revisi les dades!");

        ReservaDB.anularReserva(conDB, reserves.get(index));
        reserves.remove(index);
    }

    public void retirarReserva(int id, Seient seient, Persona espectador, LocalDate data, Connection conDB) throws Exception{
        Reserva borrar = new Reserva(id, seient, espectador, data);

        if(reserves.indexOf(borrar)==-1) throw new Exception("No s'ha trobat la vostra reserva, revisi les dades!");

        ReservaDB.anularReserva(conDB, borrar);
        reserves.remove(borrar);
    }

    private int reservaTrobada(Seient seient, Persona espectador, LocalDate data){
        boolean trobat = false;
        int index = -1, i=0;

        while (!trobat&&i<reserves.size()) {
            if(reserves.get(i).getSeient().equals(seient)){
                if(reserves.get(i).getEspectador().equals(espectador)){
                    if(reserves.get(i).getData().equals(data)){
                        trobat = true;
                        index = i;
                    }
                }
            } else i++;
        }

        return index;
    }
}