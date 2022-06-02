import java.util.Random;

public class MapaController {
    MapeableFactory factory;
    MapaModel data;

    MapaController() {
        factory = new MapeableFactory();
        data = new MapaModel();
        createPlayer();
    }
    
    public void createPlayer() {
        data.player = factory.createPlayer();
    }

    public void createMapeable(int typeMapeable) {
        int x = new Random().nextInt(); // NECESITA CAMBIOS: FORMAR EL RANDOM Y VERIFICAR QUE LA POSICION NO
        int y = new Random().nextInt(); // HAYA SIDO TOMADA

        
        data.objetosMapeables.add(factory.createMapeable(typeMapeable, x, y));
    }

    public void spawnMapeables() {
        for(int i = 0; i < data.OBJECTS; i++) {
            if(i < data.OBJECTS / 2) {
                createMapeable(0);
            }else {
                createMapeable(1);
            }
        }
    }

    public void move() {
        for(Mapeable m : data.objetosMapeables) {
            m.move();
        }
    }
    
    
}
