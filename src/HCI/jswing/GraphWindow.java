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

            Dimension dim = g.getClipBounds().getSize();
            double windowWidth = dim.width;

            for (Object key: nodes.getNodes().keySet()){
                //System.out.println(nodes.getNode((String) key));
                switch ((nodes.getNode((String) key)).getType()) {
                    case (String) "V" -> g.setColor(Color.red);
                    case (String) "L" -> g.setColor(Color.green);
                    case (String) "R" -> g.setColor(Color.blue);
                    default -> g.setColor(Color.black);
                }
                g.fillOval(x, y, 30, 30);
                g.drawOval(x, y, 30,30);
                g.drawString((String) key, x, y);
                x += 150;
                if (x > windowWidth-30) {
                    x = 10;
                    y += 100;
                }
            }
        }
    }
}
