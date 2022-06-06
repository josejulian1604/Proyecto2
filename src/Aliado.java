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

    // verifica si el jugador esta a 2 casillas o menos de distancia
    public boolean closePlayer() {
        if((yPos + 1 == playerY || yPos + 2 == playerY) & xPos == playerX) return true; // CASILLAS ABAJO
        else if((yPos - 1 == playerY || yPos - 2 == playerY) & xPos == playerX) return true; // CASILLAS ARRIBA
        else if(yPos == playerY & (xPos + 1 == playerX || xPos + 2 == playerX)) return true; // CASILLAS DERECHA
        else if(yPos == playerY & (xPos - 1 == playerX || xPos - 2 == playerX)) return true; // CASILLAS IZQUIERDA
        return false;
    }
}
