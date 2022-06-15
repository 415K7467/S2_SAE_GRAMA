package HCI.jswing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import features.*;

/**
 * @author Adrien Tacher
 * @author Vincent Chavot -- Dambrun
 */
public class GraphWindow extends JFrame {
    public static int numVilles;
    public static int numLoisirs;
    public static int numRestaurants;
    public static int numDepartementales;
    public static int numNationales;
    public static int numAutoroutes;

    /**
     * constructor of the GraphWindow and open it
     */
    public GraphWindow() {
        super();
        setContentPane(new MyPanel());
        setVisible(true);
    }

    /**
     * panel with the graph
     */
    static class MyPanel extends JPanel {
        /**
         * constructor of the MyPanel
         */
        public MyPanel() {
            super();
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        /**
         * @param g the graphics
         * paint the graph on the panel
         */
        public void paintComponent(Graphics g) {
            initializationNum();
            super.paintComponent(g);

            Nodes nodes = Main.allnodes;
            ListGraphicNode listGraphicNode = new ListGraphicNode();
            int x = 10;
            int y = 50;
            boolean shiftX = false;
            boolean shiftY = false;

            Dimension dim = g.getClipBounds().getSize();
            double windowWidth = dim.width;

            for (String key : nodes.getNodes().keySet()) {
                switch ((nodes.getNode(key)).getType()) {
                    case (String) "V" -> {
                        g.setColor(new Color(255,0,0,255));//red
                        numVilles++;
                    }
                    case (String) "L" -> {
                        g.setColor(new Color(0,255,0,255));//green
                        numLoisirs++;
                    }
                    case (String) "R" -> {
                        g.setColor(new Color(0,0,255,255));//blue
                        numRestaurants++;
                    }
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
                g.drawString(key, x, y);
                listGraphicNode.addGraphicNode(new GraphicNode(nodes.getNode(key), x + 15, y + 15));
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
            for (String key : nodes.getNodes().keySet()) {
                listEdge = listGraphicNode.getNode((nodes.getNode(key)).getName()).getNode().getEdges();
                startingNode_X = listGraphicNode.getNode((nodes.getNode(key)).getName()).getX();
                startingNode_Y = listGraphicNode.getNode((nodes.getNode(key)).getName()).getY();
                for (i = 0; i < listEdge.size(); i++) {
                    Node node = listEdge.get(i).getArriveNode();
                    int arrivalNode_X = listGraphicNode.getNode(node.getName()).getX();
                    int arrivalNode_Y = listGraphicNode.getNode(node.getName()).getY();
                    switch (listEdge.get(i).getType()) {
                        case (String) "A":
                            if (Window.visibleAutoroute){
                                g.setColor(new Color(0,0,255,255));//blue
                                numAutoroutes++;
                            }
                            else {
                                g.setColor(new Color(0,0,255,0));//blue
                            }
                            break;
                        case (String) "N":
                            if (Window.visibleNational){
                                g.setColor(new Color(0,255,0,255));//green
                                numNationales++;
                            }
                            else {
                                g.setColor(new Color(0,255,0,0));//green
                            }
                            break;
                        case (String) "D":
                            if (Window.visibleDepartemental){
                                g.setColor(new Color(255,255,0,255));//yellow
                                numDepartementales++;
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

    /**
     * initialize the number of each type of node or edge
     */
    public static void initializationNum() {
        numVilles = 0;
        numLoisirs = 0;
        numRestaurants = 0;
        numDepartementales = 0;
        numNationales = 0;
        numAutoroutes = 0;
    }

}
