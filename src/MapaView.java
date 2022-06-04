import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;

public class MapaView extends JFrame implements KeyListener{
    public final int HEIGHT = 800;
    public final int WIDTH = 1000;
    public static final int CASILLAS = 20;
    public final int CASILLA_HEIGHT = HEIGHT / CASILLAS;
    public final int CASILLA_WIDTH = WIDTH / CASILLAS;
    public JButton playerButton;
    public ArrayList<JButton> botonesMapeables = new ArrayList<JButton>();
    JPanel panel;

    public MapaView() {
        this.setLayout(null);
        panel = new JPanel();
        playerButton = new JButton();
        this.addKeyListener(this);
        this.setFocusable(true);
        panel.setLayout(null);
        panel.setSize(WIDTH, HEIGHT);
        panel.setBackground(Color.darkGray);
        spawnPlayer();
        spawnMapeable();
        this.setTitle("PROYECTO");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.add(panel, 0, 0);
    }

    //SPAWN & REMOVE METHODS###########################################################
    public void spawnPlayer() {
        int xSize = WIDTH / CASILLAS;
        int ySize = HEIGHT / CASILLAS;
        playerButton.setText("" + MapaModel.player.vida);
        playerButton.setBounds(MapaModel.player.xPos * xSize, MapaModel.player.yPos * ySize, xSize, ySize);
        playerButton.setBackground(Color.BLUE);
        playerButton.setVisible(true);
        panel.add(playerButton);
        panel.repaint();
    }

    public void spawnMapeable() {
        int xSize = WIDTH / CASILLAS;
        int ySize = HEIGHT / CASILLAS;
        for(Mapeable m : MapaModel.objetosMapeables) {
            JButton mapeable = new JButton();
            mapeable.setBounds(m.xPos * xSize, m.yPos * ySize, xSize, ySize);
            mapeable.setText(m.name);
            if(m.getClass().getName() == "Aliado") { 
                mapeable.setBackground(Color.GREEN);
                mapeable.setVisible(true);
            }else {
                mapeable.setBackground(Color.RED);
                mapeable.setVisible(true);
            }
            botonesMapeables.add(mapeable);
            panel.add(mapeable);
            panel.repaint();
        }
    }

    public void removeButton(int indice) {
        if(indice != -1) {
            panel.remove(botonesMapeables.remove(indice));
            panel.repaint();
        }
    }

    //MOVE METHODS######################################################################
    public void moveMapeables() {
        for(int i = 0; i < MapaModel.objetosMapeables.size(); i++) {
            Mapeable m = MapaModel.objetosMapeables.get(i);
            botonesMapeables.get(i).setLocation(m.xPos * (WIDTH / CASILLAS), m.yPos * (HEIGHT / CASILLAS));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int indice;
        switch(e.getKeyCode()) {
            case 32:
                indice = MapaController.atacarEnemigo();
                removeButton(indice);
                System.out.println("Direction: " + MapaModel.player.direction);
                break;
            case 37: // flecha izquierda
                MapaController.movePlayer(false, -1, 0);
                playerButton.setLocation(playerButton.getX() - WIDTH / CASILLAS, playerButton.getY());
                moveMapeables();
                //MapaController.printPositions();
                refreshText();
                break;
            case 38: // flecha arriba
                MapaController.movePlayer(true, -1, 1);
                playerButton.setLocation(playerButton.getX(), playerButton.getY() - HEIGHT / CASILLAS);
                moveMapeables();
                //MapaController.printPositions();
                refreshText();
                break;
            case 39: // flecha derecha
                MapaController.movePlayer(false, 1, 2);
                playerButton.setLocation(playerButton.getX() + WIDTH / CASILLAS, playerButton.getY());
                moveMapeables();
                //MapaController.printPositions();
                refreshText();
                break;
            case 40: // flecha abajo
                MapaController.movePlayer(true, 1, 3);
                playerButton.setLocation(playerButton.getX(), playerButton.getY() + HEIGHT / CASILLAS);
                moveMapeables();
                //MapaController.printPositions();
                refreshText();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    public void refreshText() {
        playerButton.setText("" + MapaModel.player.vida);

    }
}
