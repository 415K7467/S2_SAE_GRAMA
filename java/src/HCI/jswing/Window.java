package HCI.jswing;

import javax.swing.*;
import java.awt.*;


public class Window {
    private static double windowWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static double windowHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    public static void main(String[] args) {
        constrwindow();
    }

    public static void constrwindow(){
        JFrame window = new JFrame("JFrame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize((int)windowWidth,(int)windowHeight);

        window.add(constrpanel());
        window.setVisible(true);
    }

    public static JMenuBar constrmenubar(){
        JMenuBar menubar = new JMenuBar();
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(fermer->System.exit(0));

        JMenuItem clear = new JMenuItem("Clear");

        JMenu graphLoading = new JMenu("Graph Loading");
        JMenuItem loadFirstNeighboursForOneNode = new JMenuItem("Load First Neighbours For One Node");
        JMenuItem loadTwoNeighboursForOneNode = new JMenuItem("Load Two Neighbours For One Node");
        JMenuItem loadNNeighboursForOneNode = new JMenuItem("Load N Neighbours For One Node");
        graphLoading.add(loadFirstNeighboursForOneNode);
        graphLoading.add(loadTwoNeighboursForOneNode);
        graphLoading.add(loadNNeighboursForOneNode);

        JMenu bestPath = new JMenu("Best Path");
        JMenuItem loadGraphWithBestPathbetweenTwoNodes = new JMenuItem("Load Graph With Best Path between Two Nodes");
        bestPath.add(loadGraphWithBestPathbetweenTwoNodes);

        JMenuItem about = new JMenuItem("About");

        menubar.add(exit);
        menubar.add(clear);
        menubar.add(graphLoading);
        menubar.add(bestPath);
        menubar.add(about);
        return menubar;
    }

    public static JPanel constrpanel(){
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

    public static JPanel constrgraphpanel(){
        JPanel graphPanel = new JPanel();
        graphPanel.setBackground(Color.red);
        return graphPanel;
    }

    public static JPanel constrButtonsPanel(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.green);
        return buttonsPanel;
    }
}
