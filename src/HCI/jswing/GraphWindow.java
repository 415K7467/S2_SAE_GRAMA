package HCI.jswing;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
            ListGraphicNode listGraphicNode = new ListGraphicNode();
            int x = 10;
            int y = 20;

            Dimension dim = g.getClipBounds().getSize();
            double windowWidth = dim.width;

            for (Object key: nodes.getNodes().keySet()){
                //System.out.println(nodes.getNode((String) key).getName());
                switch ((nodes.getNode((String) key)).getType()) {
                    case (String) "V" -> g.setColor(Color.red);
                    case (String) "L" -> g.setColor(Color.green);
                    case (String) "R" -> g.setColor(Color.blue);
                    default -> g.setColor(Color.black);
                }
                g.fillOval(x, y, 30, 30);
                g.drawOval(x, y, 30,30);
                g.drawString((String) key, x, y);
                listGraphicNode.addGraphicNode(new GraphicNode(nodes.getNode((String) key), x+15, y+15));
                x += 150;
                if (x > windowWidth-30) {
                    x = 10;
                    y += 100;
                }
            }
            g.setColor(Color.black);

            int i;
            int startingNode_X;
            int startingNode_Y;
            ArrayList<Edge> listEdge;
            for (Object key: nodes.getNodes().keySet()){
                listEdge = listGraphicNode.getNode((nodes.getNode((String) key)).getName()).getNode().getEdges();
                startingNode_X = listGraphicNode.getNode((nodes.getNode((String) key)).getName()).getX();
                startingNode_Y = listGraphicNode.getNode((nodes.getNode((String) key)).getName()).getY();
                for (i = 0; i < listEdge.size(); i++) {
                    Node node = listEdge.get(i).getArriveNode();
                    int arrivalNode_X = listGraphicNode.getNode(node.getName()).getX();
                    int arrivalNode_Y = listGraphicNode.getNode(node.getName()).getY();
                    switch (listEdge.get(i).getType()) {
                        case (String) "A" -> g.setColor(Color.blue);
                        case (String) "N" -> g.setColor(Color.green);
                        case (String) "D" -> g.setColor(Color.yellow);
                        default -> g.setColor(Color.black);
                    }
                    g.drawLine(startingNode_X, startingNode_Y, arrivalNode_X, arrivalNode_Y);
                }
            }
        }
    }
}
