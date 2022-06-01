import java.util.ArrayList;

public class Player{
    public int xPos;
    public int yPos;
    public int vida;
    public int direction;
    private ArrayList<Mapeable> _observadores;

    public Player() {
        _observadores = new ArrayList<Mapeable>();
    }

    public void agregarObservador(Mapeable m) {
        _observadores.add(m);
    }

    public void eliminarObservador(Mapeable m) {
        _observadores.remove(m);
    }

    public void notificarObservadores() {
        for(Mapeable m : _observadores) {
            m.actualizar(xPos, yPos);
        }
    }
}
