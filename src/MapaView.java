import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;

public class MapaView extends JFrame{
    public final int HEIGHT = 800;
    public final int WIDTH = 1000;
    public final int CASILLAS = 25;
    public final int CASILLA_HEIGHT = HEIGHT / CASILLAS;
    public final int CASILLA_WIDTH = WIDTH / CASILLAS;
    JPanel panel;
    JButton boton;

    public MapaView() {
        this.setLayout(null);
        panel = new JPanel();
        boton = new JButton();
        boton.setBounds(0, 0, CASILLA_WIDTH, CASILLA_HEIGHT);
        boton.setText("Boton");
        panel.setLayout(null);
        panel.setSize(WIDTH, HEIGHT);
        panel.setBackground(Color.darkGray);
        this.setTitle("PROYECTO");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        panel.add(boton);
        this.add(panel, 0, 0);
    }
}
