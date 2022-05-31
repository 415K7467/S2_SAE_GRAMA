package HCI.jswing;
import javax.swing.*;
import java.awt.*;

import dataImport.*;
import features.*;

public class GraphWindow extends JFrame{
    public GraphWindow() {
        super();
        setContentPane(new MyPanel());
        setVisible(true);
    }

    static class MyPanel extends JPanel {
        public MyPanel() {
            super();
            setBorder(BorderFactory.createLineBorder(Color.black)); }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Nodes nodes = Test.allnodes;
            int x = 10;
            int y = 20;
            double windowWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();

            for (Object key: nodes.getNodes().keySet()){
                //System.out.println(nodes.getNode((String) key));
                switch( (String) (nodes.getNode((String) key)).getType() ) {
                    case (String) "V":
                        g.setColor(Color.red);
                        break;

                    case (String) "L":
                        g.setColor(Color.green);
                        break;

                    case (String) "R":
                        g.setColor(Color.blue);
                        break;
                    default:
                        g.setColor(Color.black);
                        break;
                }
                g.drawOval(x, y, 30,30);
                g.drawString((String) key, x, y);
                x += 150;
                if (x > windowWidth-149) {
                    x = 10;
                    y += 100;
                }
            }
        }
    }

}
