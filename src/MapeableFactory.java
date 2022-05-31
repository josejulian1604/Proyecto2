import javax.swing.JButton;

public class MapeableFactory {
    
    MapeableFactory(){}

    Mapeable createMapeable(int type) {
        switch (type) {
            case 0:
                return new Player();
        
            case 1:
                return new Aliado();
            
            default:
                return new Enemigo();
        }
    }

    JButton createButton() { //que reciba un numero para que cree un boton con su color respectivo
        return new JButton();
    }
}
