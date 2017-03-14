package MarchMadness.Displays;

import MarchMadness.Main;
import MarchMadness.Tournament.*;
import MarchMadness.Tournament.Bracket.*;
import MarchMadness.Teams.Teams.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Nick on 3/12/2017.
 */
public class GraphicsBasedDisplay {

    private static Region displayRegion;
    private static BracketContainer bracket;

    public GraphicsBasedDisplay(BracketContainer bracket) {
        this.bracket = bracket;
        displayRegion = Region.EAST;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndDisplay();
            }
        });
    }

    private static void createAndDisplay() {
        //Create and set up the window
        JFrame frame = new JFrame("March Madness 2017");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display(frame.getContentPane(), new JPanel());

        //Display the window
        frame.pack();
        frame.setVisible(true);
    }

    private static void display(Container parentPane, Container pane){
        parentPane.setPreferredSize(new Dimension(700, 700));
        parentPane.setBackground(Color.LIGHT_GRAY);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        String newLine = System.getProperty("line.separator");
        JLabel l = new JLabel("     " + newLine);
        for(int i=0; i<=5; i++) {
            c.gridx=i;
            for(int j=0; j<=17; j++) {
                c.gridy=j;
                pane.add(l, c);
            }
        }

        if(!displayRegion.equals(Region.FINALS) && displayRegion != null) {
            //Add Labels
            addBracketLabels(pane, c);
            //Add bracket
            addBracket(pane, c, displayRegion);
        } else if(displayRegion.equals(Region.FINALS)) {
            //Add Labels
            addFinalsLabels(pane, c);
            //Add bracket
            addFinalsBracket(pane, c);
        } else {}

        addButtons(parentPane, pane, c);

        parentPane.add(pane);
        parentPane.revalidate();
        parentPane.repaint();
    }

    public static void addBracket(Container pane, GridBagConstraints c, Region region) {
        JLabel label;

        //Round of 64
        c.gridx = 0;
        c.gridy = 1;
        for(int i = 0; i < bracket.roundOf64.get(region).size(); i++) {
            label = new JLabel(reformatString(bracket.roundOf64.get(region).get(i).toString()));
            pane.add(label, c);
            c.gridy += 2;
        }

        //Round of 32
        c.gridx++;
        c.gridy = 2;
        for(int i = 0; i < bracket.roundOf32.get(region).size(); i++) {
            label = new JLabel(reformatString(bracket.roundOf32.get(region).get(i).toString()));
            pane.add(label, c);
            c.gridy += 4;
        }

        //Round of 16
        c.gridx++;
        c.gridy = 4;
        for(int i = 0; i < bracket.roundOf16.get(region).size(); i++) {
            label = new JLabel(reformatString(bracket.roundOf16.get(region).get(i).toString()));
            pane.add(label, c);
            c.gridy += 8;
        }

        //Round of 8
        c.gridx++;
        c.gridy = 8;
        for(int i = 0; i < bracket.roundOf8.get(region).size(); i++) {
            label = new JLabel(reformatString(bracket.roundOf8.get(region).get(i).toString()));
            pane.add(label, c);
            c.gridy += 16;
        }

        //Winner of Region
        c.gridx++;
        c.gridy = 9;
        label = new JLabel(reformatString(bracket.roundOf4.get(region).toString()));
        pane.add(label, c);
    }

    public static void addBracketLabels(Container pane, GridBagConstraints c) {
        JLabel label;

        c.gridx = 0;
        c.gridy = 0;
        label = new JLabel("First Round");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);

        c.gridx = 1;
        c.gridy = 0;
        label = new JLabel("Second Round");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);

        c.gridx = 2;
        c.gridy = 0;
        label = new JLabel("Third Round");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);

        c.gridx = 3;
        c.gridy = 0;
        label = new JLabel("Fourth Round");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);

        c.gridx = 4;
        c.gridy = 0;
        label = new JLabel("Fifth Round");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);
    }

    public static void addFinalsBracket(Container pane, GridBagConstraints c) {
        JLabel label;

        //Final Four 1
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 1;
        label = new JLabel(reformatString(bracket.roundOf4.get(Region.EAST).toString()));
        pane.add(label, c);
        c.gridy ++;
        label = new JLabel(reformatString(bracket.roundOf4.get(Region.WEST).toString()));
        pane.add(label, c);

        //Final Four 2
        c.gridx = 5;
        c.gridy = 6;
        c.gridwidth = 1;
        label = new JLabel(reformatString(bracket.roundOf4.get(Region.MIDWEST).toString()));
        pane.add(label, c);
        c.gridy ++;
        label = new JLabel(reformatString(bracket.roundOf4.get(Region.SOUTH).toString()));
        pane.add(label, c);

        //Finals
        c.gridx = 3;
        c.gridy = 6;
        c.gridwidth = 2;
        label = new JLabel(reformatString(bracket.roundOf2.toString()));
        pane.add(label, c);

        //Winner
        c.gridx = 3;
        c.gridy = 11;
        c.gridwidth = 1;
        label = new JLabel(reformatString(bracket.winner.toString()));
        pane.add(label, c);
    }

    public static void addFinalsLabels(Container pane, GridBagConstraints c) {
        JLabel label;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        label = new JLabel("Final Four");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);

        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        label = new JLabel("Finals");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);

        c.gridx = 4;
        c.gridy = 0;
        c.gridwidth = 2;
        label = new JLabel("Final Four");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);

        c.gridx = 2;
        c.gridy = 11;
        c.gridwidth = 1;
        label = new JLabel("Winner");
        label.setHorizontalAlignment(JLabel.CENTER);
        pane.add(label, c);
    }

    public static void addButtons(Container parentPane, Container pane, GridBagConstraints c) {
        JButton button;

        c.gridx = 0;
        c.gridy = 17;
        c.gridwidth = 1;
        button = new JButton(Region.EAST.toString());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRegion = Region.EAST;
                parentPane.removeAll();
                display(parentPane, new JPanel());
            }
        });
        pane.add(button, c);

        c.gridx = 1;
        c.gridy = 17;
        c.gridwidth = 1;
        button = new JButton(Region.WEST.toString());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRegion = Region.WEST;
                parentPane.removeAll();
                display(parentPane, new JPanel());
            }
        });
        pane.add(button, c);

        c.gridx = 2;
        c.gridy = 17;
        c.gridwidth = 1;
        button = new JButton(Region.MIDWEST.toString());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRegion = Region.MIDWEST;
                parentPane.removeAll();
                display(parentPane, new JPanel());
            }
        });
        pane.add(button, c);

        c.gridx = 3;
        c.gridy = 17;
        c.gridwidth = 1;
        button = new JButton(Region.SOUTH.toString());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRegion = Region.SOUTH;
                parentPane.removeAll();
                display(parentPane, new JPanel());
            }
        });
        pane.add(button, c);

        c.gridx = 4;
        c.gridy = 17;
        c.gridwidth = 1;
        button = new JButton(Region.FINALS.toString());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRegion = Region.FINALS;
                parentPane.removeAll();
                display(parentPane, new JPanel());
            }
        });
        pane.add(button, c);

        if(displayRegion.equals(Region.FINALS)) {
            c.gridx = 5;
            c.gridy = 17;
            c.gridwidth = 1;
            button = new JButton("ROLL NEW BRACKET");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Bracket b = new Bracket();
                    bracket = b.getBracket();

                    displayRegion = Region.EAST;
                    parentPane.removeAll();
                    display(parentPane, new JPanel());
                }
            });
            pane.add(button, c);
        }
    }

    private static String reformatString(String s) {
        String regex = "(?m)^";
        String result = "<html>" + s.replaceAll(regex, "") + "</html>";
        return result.replaceAll("(\r\n|\n)", "<br />");
    }
}
