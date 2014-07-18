// ===================================================================
// fil:    lecture_1\demo03\Demo03.java
// anm:    Demo01 men meny istf knappar
// skapad: 2013-09-04 / janpe
// ändrad: 2014-07-11 / klaes950
// ===================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo03 extends JFrame implements ActionListener
{
    // instansvariabler
    private String shape = "Circle";
    private int    size  = 100;
    private Color  color = Color.RED;

    private ShapeDrawer drawer = new ShapeDrawer();

    private JMenuBar mnb = new JMenuBar();

    private JMenu mnuFile = new JMenu("File");
    private JMenu mnuEdit = new JMenu("Edit");
    private JMenu mnuHelp = new JMenu("Help");

    private JMenuItem mniCircle = new JMenuItem("Circle");
    private JMenuItem mniSquare = new JMenuItem("Square");

    // konstruktor
    public Demo03()
    {
        mniCircle.addActionListener(this);
        mniSquare.addActionListener(this);

        setJMenuBar(mnb);

        mnb.add(mnuFile);
        mnb.add(mnuHelp);
        mnb.add(mnuEdit);

        // mnuFile.add(...);

        mnuEdit.add(mniCircle);
        mnuEdit.add(mniSquare);

        // mnuHelp.add(...);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(drawer, BorderLayout.CENTER);

        pack();
        setTitle("Demo03");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // händelsehanterare
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == mniCircle)
        {
            shape = "Circle";
        }
        else if (e.getSource() == mniSquare)
        {
            shape = "Square";
        }

        drawer.setShape(shape, size, color);
    }

    // startmetoden main
    public static void main(String[] args)
    {
        Demo03 frame = new Demo03();
    }
}
