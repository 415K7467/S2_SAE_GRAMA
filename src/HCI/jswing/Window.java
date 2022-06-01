package HCI.jswing;

import features.Dijkstra;
import features.Node;
import features.Nodes;
import features.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Window {

    public static void constrwindow() throws IOException {
        JFrame window = new JFrame("JFrame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        window.add(constrpanel());
        window.setVisible(true);
    }

    private static JMenuBar constrmenubar(){
        JMenuBar menubar = new JMenuBar();

        JMenuItem exit = exit();
        JMenuItem clear = new JMenuItem("Clear");
        JMenu graphLoading = graphloading();
        JMenu bestPath = bestPath();

        menubar.add(exit);
        menubar.add(clear);
        menubar.add(graphLoading);
        menubar.add(bestPath);
        menubar.add(about());
        return menubar;
    }

    private static JMenuItem about() {
        JMenuItem about = new  JMenuItem("About");
        about.addActionListener(aboutAction->{
            try {
                Desktop.getDesktop().open(new File("./CahierDesCharges.docx"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return about;
    }

    private static JPanel constrpanel() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JMenuBar menu = constrmenubar();
        JPanel graphPanel = constrgraphpanel();
        JPanel buttonsPanel = constrButtonsPanel();
        panel.add(menu,BorderLayout.NORTH);
        panel.add(graphPanel,BorderLayout.CENTER);
        panel.add(buttonsPanel,BorderLayout.EAST);
        return panel;
    }

    private static JPanel constrgraphpanel(){
        GraphWindow.MyPanel graphPanel = new GraphWindow.MyPanel();
        return graphPanel;
    }

    private static JPanel constrButtonsPanel() throws IOException {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.Y_AXIS));
        Dimension space = new Dimension(400,100);

        JPanel graphLoadingPane = new JPanel();
        JMenuBar graphLoadingg = new JMenuBar();
        JMenu graphLoading = graphloading();
        graphLoadingg.add(graphLoading);
        graphLoadingPane.add(graphLoadingg);

        JPanel bestPathPane = new JPanel();
        JMenuBar bestPathh = new JMenuBar();
        JMenu bestPath = bestPath();
        bestPathh.add(bestPath);
        bestPathPane.add(bestPathh);

        JPanel aboutPane = new JPanel();
        JMenuItem about = new JMenuItem("About");
        bestPathh.add(about());
        aboutPane.add(about());

        JPanel exitPane = new JPanel();
        JMenuItem exit = exit();
        exitPane.add(exit);

        JPanel clearPane = new JPanel();
        JMenuItem clear = new JMenuItem("Clear");
        clearPane.add(clear);


        buttonsPanel.add(Box.createRigidArea(space));
        buttonsPanel.add(graphLoadingPane);
        buttonsPanel.add(bestPathPane);
        buttonsPanel.add(aboutPane);
        buttonsPanel.add(clearPane);
        buttonsPanel.add(exitPane);
        return buttonsPanel;
    }

    private static JMenuItem exit(){
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(fermer->System.exit(0));
        return exit;
    }

    private static JMenu graphloading() {
        JMenu graphLoading = new JMenu("Graph Loading");
        JMenuItem loadFirstNeighboursForOneNode = new JMenuItem("Load First Neighbours For One Node");
        loadFirstNeighboursForOneNode.addActionListener(loadFirstNeighboursForOneNodeActionListener -> {
            String nodeName = name(null);
            neigbours(nodeName,1);
        });
        JMenuItem loadTwoNeighboursForOneNode = new JMenuItem("Load Two Neighbours For One Node");
        loadTwoNeighboursForOneNode.addActionListener(loadTwoNeighboursForOneNodeActionListener -> {
            String nodeName = name(null);
            neigbours(nodeName,2);
        });
        JMenuItem loadNNeighboursForOneNode = new JMenuItem("Load N Neighbours For One Node");
        loadNNeighboursForOneNode.addActionListener(loadNNeighboursForOneNodeActionListener -> {
            String nodeName = name(null);
            neigbours(nodeName,0);
        });
        graphLoading.add(loadFirstNeighboursForOneNode);
        graphLoading.add(loadTwoNeighboursForOneNode);
        graphLoading.add(loadNNeighboursForOneNode);
        return graphLoading;
    }

    private static JMenu bestPath(){
        JMenu bestPath = new JMenu("Best Path");
        JMenuItem loadGraphWithBestPathbetweenTwoNodes = new JMenuItem("Load Graph With Best Path between Two Nodes");
        loadGraphWithBestPathbetweenTwoNodes.addActionListener(e->{
            String startNode = JOptionPane.showInputDialog(name("de départ"));
            String arrivalNode = JOptionPane.showInputDialog(name("d'arrivée"));
            if (startNode != null && arrivalNode != null) {
                new Dijkstra(Test.allnodes.getNode(startNode), Test.allnodes.getNode(arrivalNode));
            }
        });
        bestPath.add(loadGraphWithBestPathbetweenTwoNodes);
        return bestPath;
    }

    private static String name(String add){
        String name = JOptionPane.showInputDialog("Entrer le nom du noeud");
        if (add != null) {
            name = name + add;
        }
        return name;
    }

    private static void neigbours(String name, int distance){
        if (name != null) {
            if (distance == 0) {
                distance = Integer.parseInt(JOptionPane.showInputDialog("Entrer la distance"));
            }
            ArrayList<Node> list = Test.allnodes.getNode(name).neighbor(distance);
            System.out.println(list);
        }
    }

}
