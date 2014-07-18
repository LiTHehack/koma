// ===================================================================
// fil:    lecture_1\demo01\Demo01.java
// anm:    grafik
// skapad: 2013-09-04 / janpe
// ändrad: 2013-09-05 / klaes950
// ===================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo01 extends JFrame implements ActionListener
{
    // instansvariabler
    private String shape = "Circle";
    private int    size  = 100;
    private Color  color = Color.RED;

    private ShapeDrawer drawer = new ShapeDrawer();

    private JButton btnCircle = new JButton("Circle");
    private JButton btnSquare = new JButton("Square");

    // konstruktor
    public Demo01()
    {
        btnCircle.addActionListener(this);
        btnSquare.addActionListener(this);

        JPanel pnlEast = new JPanel();

        pnlEast.setLayout(new GridLayout(4, 1, 2, 2));
        pnlEast.add(new JLabel());
        pnlEast.add(btnCircle);
        pnlEast.add(btnSquare);
        pnlEast.add(new JLabel());

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(drawer, BorderLayout.CENTER);
        c.add(pnlEast, BorderLayout.EAST);

        pack();
        setTitle("Demo01");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // händelsehanterare
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnCircle)
        {
            shape = "Circle";
        }
        else if (e.getSource() == btnSquare)
        {
            shape = "Square";
        }

        drawer.setShape(shape, size, color);
    }

    // startmetoden main
    public static void main(String[] args)
    {
        Demo01 frame = new Demo01();
    }
}
