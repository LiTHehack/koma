// ===================================================================
// fil:    demoXX\ShapeDrawer.java
// anm:    fortlöpande exempel
// skapad: 2013-09-04 / janpe
// ändrad: 2014-07-10 / klaes950
// ===================================================================

import java.awt.*;
import javax.swing.*;

public class ShapeDrawer extends JPanel
{
    // konstanter
    public static int WIDTH  = 300;
    public static int HEIGHT = 200;

    // instansvariabler
    private String shape = "Circle";
    private int    size  = 100;
    private Color  color = Color.RED;

    // konstruktor
    public ShapeDrawer()
    {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    // instansmetoder
    public void paintComponent(Graphics g)  // anropas indirekt ..
    {
        super.paintComponent(g);

        setForeground(color);

        if (shape.equals("Circle"))
        {
            g.fillOval((WIDTH - size) / 2, (HEIGHT - size) / 2, size, size);
        }
        else if (shape.equals("Square"))
        {
            g.fillRect((WIDTH - size) / 2, (HEIGHT - size) / 2, size, size);
        }
    }

    public void setShape(String theShape, int theSize, Color theColor)
    {
        shape = theShape;
        size  = theSize;
        color = theColor;

        repaint();                          // .. via repaint()
    }
}
