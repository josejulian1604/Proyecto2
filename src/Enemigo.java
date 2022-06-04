public class Enemigo extends Mapeable {
    private boolean currentMoveX;
    public Enemigo(int x, int y, String name) {
        xPos = x;
        yPos = y;
        this.name = name;
        currentMoveX = false;
        vida = 1;
    }
    
    public void move(){
        if(playerX > xPos & currentMoveX) {
            xPos++;
            currentMoveX = false;
            verifyLastMove();
        }else if(playerX < xPos & currentMoveX) {
            xPos--;
            currentMoveX = false;
            verifyLastMove();
        }
        else if(playerY > yPos & !currentMoveX) {
            yPos++;
            currentMoveX = true;
            verifyLastMove();
        }else if(playerY < yPos & !currentMoveX){
            yPos--;
            currentMoveX = true;
            verifyLastMove();
        }
    }

    private void verifyLastMove() {
        if(xPos == playerX & yPos != playerY) {
            currentMoveX = false;
        }
        if(yPos == playerY & xPos != playerX) {
            currentMoveX = true;
        }
    }

    public boolean interactuar(Player p) {
        if(xPos == playerX & yPos == playerY) {
            p.vida--;
            return true;
        }return false;
    }

    @Override
    public void actualizar(int newX, int newY) {
        playerX = newX;
        playerY = newY;
        move();
    }
}
