import java.util.ArrayList;

public class Player{
    public int xPos;
    public int yPos;
    public int vida;
    public int direction;
    private ArrayList<Mapeable> _observadores;

    public Player(int x, int y, int vida) {
        _observadores = new ArrayList<Mapeable>();
        xPos = x;
        yPos = y;
        this.vida = vida;
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

    public void atacar() {
        Mapeable m;
        if(direction == 0) { // izquierda
            for(int i = 0; i < _observadores.size(); i++) {
                m = _observadores.get(i);
                if(m.getClass().getName() == "Enemigo") {
                    if(xPos - 1 == m.xPos & yPos == m.yPos) {
                        m.vida = 0;
                        _observadores.remove(m);
                    }
                }
            }
        }else if(direction == 1) { // arriba
            for(int i = 0; i < _observadores.size(); i++) {
                m = _observadores.get(i);
                if(m.getClass().getName() == "Enemigo") {
                    if(xPos == m.xPos & yPos - 1 == m.yPos) {
                        m.vida = 0;
                        _observadores.remove(m);
                    }
                }
            }
        }else if(direction == 2) { // derecha
            for(int i = 0; i < _observadores.size(); i++) {
                m = _observadores.get(i);
                if(m.getClass().getName() == "Enemigo") {
                    if(xPos + 1 == m.xPos & yPos == m.yPos) {
                        m.vida = 0;
                        _observadores.remove(m);
                    }
                }
            }
        }else { // abajo
            for(int i = 0; i < _observadores.size(); i++) {
                m = _observadores.get(i);
                if(m.getClass().getName() == "Enemigo") {
                    if(xPos == m.xPos & yPos + 1 == m.yPos) {
                        m.vida = 0;
                        _observadores.remove(m);
                    }
                }
            }
        }
    }
}
