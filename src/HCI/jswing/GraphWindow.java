package HCI.jswing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import features.*;

public class GraphWindow extends JFrame {
    public GraphWindow() {
        super();
        setContentPane(new MyPanel());
        setVisible(true);
    }

    static class MyPanel extends JPanel {
        public MyPanel() {
            super();
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Nodes nodes = Test.allnodes;
            ListGraphicNode listGraphicNode = new ListGraphicNode();
            int x = 10;
            int y = 50;
            boolean shiftX = false;
            boolean shiftY = false;

            Dimension dim = g.getClipBounds().getSize();
            double windowWidth = dim.width;

            for (Object key : nodes.getNodes().keySet()) {
                //System.out.println(nodes.getNode((String) key).getName());
                switch ((nodes.getNode((String) key)).getType()) {
                    case (String) "V" -> g.setColor(new Color(255,0,0,255));//red
                    case (String) "L" -> g.setColor(new Color(0,255,0,255));//green
                    case (String) "R" -> g.setColor(new Color(0,0,255,255));//blue
                    default -> g.setColor(Color.black);
                }
                if (shiftY) {
                    y += 25;
                    shiftY = false;
                } else {
                    y -= 25;
                    shiftY = true;
                }
                g.fillOval(x, y, 30, 30);
                g.drawString((String) key, x, y);
                listGraphicNode.addGraphicNode(new GraphicNode(nodes.getNode((String) key), x + 15, y + 15));
                //System.out.println((x+15) + "," + (y+15));
                x += 150;
                if (x > windowWidth - 50) {
                    y += 100;
                    if (shiftX) {
                        x = 10;
                        shiftX = false;
                    } else {
                        x = 35;
                        shiftX = true;
                    }
                }
            }

            int i;
            int startingNode_X;
            int startingNode_Y;
            ArrayList<Edge> listEdge;
            for (Object key : nodes.getNodes().keySet()) {
                listEdge = listGraphicNode.getNode((nodes.getNode((String) key)).getName()).getNode().getEdges();
                startingNode_X = listGraphicNode.getNode((nodes.getNode((String) key)).getName()).getX();
                startingNode_Y = listGraphicNode.getNode((nodes.getNode((String) key)).getName()).getY();
                for (i = 0; i < listEdge.size(); i++) {
                    Node node = listEdge.get(i).getArriveNode();
                    int arrivalNode_X = listGraphicNode.getNode(node.getName()).getX();
                    int arrivalNode_Y = listGraphicNode.getNode(node.getName()).getY();
                    switch (listEdge.get(i).getType()) {
                        case (String) "A":
                            if (Window.visibleAutoroute){
                                g.setColor(new Color(0,0,255,255));//blue
                            }
                            else {
                                g.setColor(new Color(0,0,255,0));//blue
                            }
                            break;
                        case (String) "N":
                            if (Window.visibleNational){
                                g.setColor(new Color(0,255,0,255));//green
                            }
                            else {
                                g.setColor(new Color(0,255,0,0));//green
                            }
                            break;
                        case (String) "D":
                            if (Window.visibleDepartemental){
                                g.setColor(new Color(255,255,0,255));//yellow
                            }
                            else {
                                g.setColor(new Color(255,255,0,0));//yellow
                            }
                            break;
                        default:
                            g.setColor(Color.black);
                            break;
                    }
                    g.drawLine(startingNode_X, startingNode_Y, arrivalNode_X, arrivalNode_Y);
                }
            }
        }
    }
}
