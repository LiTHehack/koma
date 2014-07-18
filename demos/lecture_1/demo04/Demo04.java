// ===================================================================
// fil:    lecture_1\demo04\Demo04.java
// anm:    Demo03 + kortkommandon
// skapad: 2013-09-04 / janpe
// ändrad: 2014-07-11 / klaes950
// ===================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo04 extends JFrame implements ActionListener
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
    public Demo04()
    {
        mniCircle.addActionListener(this);
        mniSquare.addActionListener(this);

        mniCircle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        mniSquare.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));

        setJMenuBar(mnb);

        mnb.add(mnuFile);
        mnb.add(mnuEdit);
        mnb.add(mnuHelp);

        // mnuFile.add(...);

        mnuEdit.add(mniCircle);
        mnuEdit.add(mniSquare);

        // mnuHelp.add(...);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(drawer, BorderLayout.CENTER);

        pack();
        setTitle("Demo04");
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
        else // e.getSource() == mniSquare
        {
            shape = "Square";
        }

        drawer.setShape(shape, size, color);
    }

    // startmetoden main
    public static void main(String[] args)
    {
        Demo04 frame = new Demo04();
    }
}
