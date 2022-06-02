import java.util.ArrayList;

public class Player{
    public int xPos;
    public int yPos;
    public int vida;
    public int direction;
    private ArrayList<Mapeable> _observadores;

    public Player(int x, int y) {
        _observadores = new ArrayList<Mapeable>();
        xPos = x;
        yPos = y;
        vida = 10;
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
