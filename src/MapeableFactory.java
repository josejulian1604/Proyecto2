import javax.swing.JButton;
import java.util.ArrayList;

public class MapeableFactory {
    
    MapeableFactory(){}

    Player createPlayer(int x, int y) {
        return new Player(x, y);
    }
    
    Mapeable createMapeable(int type, int x, int y, String name) {
        switch (type) {   
            case 0:
                return new Aliado(x, y, name);
            
            default:
                return new Enemigo(x, y, name);
        }
    }

    ArrayList<Mapeable> createArrayList() {
        return new ArrayList<Mapeable>();
    }
    JButton createButton() { //que reciba un numero para que cree un boton con su color respectivo
        return new JButton();
    }
}
