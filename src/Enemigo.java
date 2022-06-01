public class Enemigo extends Mapeable {
    private int goToX;
    private int goToY;

    public Enemigo(int x, int y) {
        xPos = x;
        yPos = y;
    }
    
    public void move(){}

    @Override
    public void actualizar(int newX, int newY) {
        goToX = newX;
        goToY = newY;
    }
}
