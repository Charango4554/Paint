import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dessin extends JFrame {

    private int x, y;
    private boolean dessinEnCours;

    public Dessin() {
        super("Dessin");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                dessinEnCours = true;
            }
            public void mouseReleased(MouseEvent e) {
                dessinEnCours = false;
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (dessinEnCours) {
                    Graphics g = getGraphics();
                    g.setColor(Color.BLACK);
                    g.drawLine(x, y, e.getX(), e.getY());
                    x = e.getX();
                    y = e.getY();
                }
            }
        });

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dessin();
    }
}
