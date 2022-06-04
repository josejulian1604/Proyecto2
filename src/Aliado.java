public class Aliado extends Mapeable {
    public Aliado(int x, int y, String name) {
        xPos = x;
        yPos = y;
        this.name = name;
        vida = 1;
    }
    
    public void move(){}

    @Override
    public boolean interactuar(Player p) {
        if(xPos == playerX & yPos == playerY) {
            p.vida++;
            return true;
        }return false;       
    }

    @Override
    public void actualizar(int newX, int newY) {
        playerX = newX;
        playerY = newY;
    }
}
