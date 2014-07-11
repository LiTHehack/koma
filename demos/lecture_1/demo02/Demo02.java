// ===================================================================
// fil:    ~\tnm040\java\fo2demo\demo02\Demo02.java
// anm:    animering
// skapad: 2013-09-04 / janpe
// ändrad: 2013-09-05 / janpe
// ===================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo02 extends JFrame implements ActionListener
{
    // instansvariabler

    private String shape = "Circle";
    private int    size  = 100;
    private Color  color = Color.RED;

    private ShapeDrawer drawer = new ShapeDrawer();

    private JButton btnStart = new JButton("Start");
    private JButton btnStop  = new JButton("Stop");

    private Timer timer = new Timer(100, this);

    // konstruktor

    public Demo02()
    {
        btnStart.addActionListener(this);
        btnStop.addActionListener(this);
        // timer.addActionListener(this);

        JPanel pnlEast = new JPanel();

        pnlEast.setLayout(new GridLayout(4, 1, 2, 2));
        pnlEast.add(new JLabel());
        pnlEast.add(btnStart);
        pnlEast.add(btnStop);
        pnlEast.add(new JLabel());

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(drawer, BorderLayout.CENTER);
        c.add(pnlEast, BorderLayout.EAST);

        pack();
        setTitle("Demo02");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // händelsehanterare

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnStart)
        {
            timer.start();
        }
        else if (e.getSource() == btnStop)
        {
            timer.stop();
        }
        else if (e.getSource() == timer)
        {
            size += 10;
            size %= 160;

            drawer.setShape(shape, size, color);
        }
    }

    // startmetoden main

    public static void main(String[] args)
    {
        Demo02 frame = new Demo02();
    }
}
