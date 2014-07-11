// ===================================================================
// fil:    ~\tnm040\java\fo2demo\demo05\Demo05.java
// anm:    Demo03 + popup-meny
// skapad: 2013-09-04 / janpe
// ändrad: 2014-07-11 / klaes950
// ===================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo05 extends JFrame implements ActionListener
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

    private JPopupMenu pmnEdit = new JPopupMenu("Edit");

    private JMenuItem pmiCircle = new JMenuItem("Circle");
    private JMenuItem pmiSquare = new JMenuItem("Square");

    // konstruktor
    public Demo05()
    {
        mniCircle.addActionListener(this);
        mniSquare.addActionListener(this);

        pmiCircle.addActionListener(this);
        pmiSquare.addActionListener(this);

        drawer.addMouseListener(new PopupHandler());

        setJMenuBar(mnb);

        mnb.add(mnuFile);
        mnb.add(mnuEdit);
        mnb.add(mnuHelp);

        // mnuFile.add(...);

        mnuEdit.add(mniCircle);
        mnuEdit.add(mniSquare);

        // mnuHelp.add(...);

        pmnEdit.add(pmiCircle);
        pmnEdit.add(pmiSquare);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(drawer, BorderLayout.CENTER);

        pack();
        setTitle("Demo05");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // händelsehanterare
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == mniCircle || e.getSource() == pmiCircle)
        {
            shape = "Circle";
        }
        else if (e.getSource() == mniSquare || e.getSource() == pmiSquare)
        {
            shape = "Square";
        }

        drawer.setShape(shape, size, color);
    }

    // innerklass för muslyssnare mha adapterklass
    private class PopupHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            if (e.isMetaDown()) // Höget musknapp nedtryckt?
            {
                pmnEdit.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    // startmetoden main
    public static void main(String[] args)
    {
        Demo05 frame = new Demo05();
    }
}
