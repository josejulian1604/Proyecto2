import javax.swing.JButton;

public class MapeableFactory {
    
    MapeableFactory(){}

    Player createPlayer() {
        return new Player();
    }
    
    Mapeable createMapeable(int type, int x, int y) {
        switch (type) {   
            case 0:
                return new Aliado(x, y);
            
            default:
                return new Enemigo(x, y);
        }
    }

    JButton createButton() { //que reciba un numero para que cree un boton con su color respectivo
        return new JButton();
    }
}
