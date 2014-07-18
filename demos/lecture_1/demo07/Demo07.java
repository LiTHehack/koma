// ===================================================================
// fil:    lecture_1\demo07\Demo07.java
// anm:    Demo06 + submenyer
// skapad: 2013-09-04 / janpe
// ändrad: 2014-07-18 / klaes950
// ===================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo07 extends JFrame
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

    private JMenu mnuShape = new JMenu("Shape");
    private JMenu mnuSize  = new JMenu("Size");
    private JMenu mnuColor = new JMenu("Color");

    private JMenuItem mniOpen = new JMenuItem("Open ...");
    private JMenuItem mniSave = new JMenuItem("Save ...");
    private JMenuItem mniExit = new JMenuItem("Exit");

    private JMenuItem mniCircle = new JMenuItem("Circle");
    private JMenuItem mniSquare = new JMenuItem("Square");

    private JRadioButtonMenuItem mniSmall  = new JRadioButtonMenuItem("Small");
    private JRadioButtonMenuItem mniMedium = new JRadioButtonMenuItem("Medium", true);
    private JRadioButtonMenuItem mniLarge  = new JRadioButtonMenuItem("Large");

    private JCheckBoxMenuItem mniRed   = new JCheckBoxMenuItem("Red", true);
    private JCheckBoxMenuItem mniGreen = new JCheckBoxMenuItem("Green");
    private JCheckBoxMenuItem mniBlue  = new JCheckBoxMenuItem("Blue");

    private JMenuItem mniHelp  = new JMenuItem("Help ...");
    private JMenuItem mniAbout = new JMenuItem("About ...");

    // konstruktor
    public Demo07()
    {
        FileHandler fileHandler = new FileHandler();

        mniOpen.addActionListener(fileHandler);
        mniSave.addActionListener(fileHandler);
        mniExit.addActionListener(fileHandler);

        EditHandler editHandler = new EditHandler();

        mniCircle.addActionListener(editHandler);
        mniSquare.addActionListener(editHandler);

        mniSmall.addActionListener(editHandler);
        mniMedium.addActionListener(editHandler);
        mniLarge.addActionListener(editHandler);

        mniRed.addActionListener(editHandler);
        mniGreen.addActionListener(editHandler);
        mniBlue.addActionListener(editHandler);

        HelpHandler helpHandler = new HelpHandler();

        mniHelp.addActionListener(helpHandler);
        mniAbout.addActionListener(helpHandler);

        ButtonGroup grpSize = new ButtonGroup();

        grpSize.add(mniSmall);
        grpSize.add(mniMedium);
        grpSize.add(mniLarge);

        setJMenuBar(mnb);

        mnb.add(mnuFile);
        mnb.add(mnuEdit);
        mnb.add(mnuHelp);

        mnuFile.add(mniOpen);
        mnuFile.add(mniSave);
        mnuFile.addSeparator();
        mnuFile.add(mniExit);

        mnuEdit.add(mnuShape);
        mnuEdit.add(mnuSize);
        mnuEdit.add(mnuColor);

        mnuShape.add(mniCircle);
        mnuShape.add(mniSquare);

        // mnuEdit.addSeparator();
        mnuSize.add(mniSmall);
        mnuSize.add(mniMedium);
        mnuSize.add(mniLarge);

        // mnuEdit.addSeparator();
        mnuColor.add(mniRed);
        mnuColor.add(mniGreen);
        mnuColor.add(mniBlue);

        mnuHelp.add(mniHelp);
        mnuHelp.add(mniAbout);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(drawer, BorderLayout.CENTER);

        pack();
        setTitle("Demo07");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // händelsehanterare som innerklasser
    private class FileHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == mniOpen)
            {
                JOptionPane.showMessageDialog(Demo07.this, "This feature is\n" + "only available in\n" + "ShapeDrawer Pro!");
            }
            else if (e.getSource() == mniSave)
            {
                JOptionPane.showMessageDialog(Demo07.this, "This feature is\n" + "only available in\n" + "ShapeDrawer Pro!");
            }
            else if (e.getSource() == mniExit)
            {
                System.exit(0);
            }
        }
    }

    private class EditHandler implements ActionListener
    {
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
            else if (e.getSource() == mniSmall)
            {
                size = 50;
            }
            else if (e.getSource() == mniMedium)
            {
                size = 100;
            }
            else if (e.getSource() == mniLarge)
            {
                size = 150;
            }
            else if (e.getSource() == mniRed || e.getSource() == mniGreen || e.getSource() == mniBlue)
            {
                int red   = mniRed.isSelected()   ? 255 : 0;
                int green = mniGreen.isSelected() ? 255 : 0;
                int blue  = mniBlue.isSelected()  ? 255 : 0;

                color = new Color(red, green, blue);
            }

            drawer.setShape(shape, size, color);
        }
    }

    private class HelpHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == mniHelp)
            {
                JOptionPane.showMessageDialog(Demo07.this, "This feature is\n" + "only available in\n" + "ShapeDrawer Pro!");
            }
            else if (e.getSource() == mniAbout)
            {
                JOptionPane.showMessageDialog(Demo07.this, "ShapeDrawer LE 1.1\n" + "Copyright 2013-2013\n" + "Amazing Software, Inc.");
            }
        }
    }

    // startmetoden main
    public static void main(String[] args)
    {
        Demo07 frame = new Demo07();
    }
}
