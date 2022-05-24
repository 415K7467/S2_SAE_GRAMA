package HCI.jswing;

import org.omg.PortableInterceptor.DISCARDING;

import javax.swing.*;
import java.awt.*;


public class Window {
    public static void main(String[] args) {
        constrwindow();
    }

    public static void constrwindow(){
        JFrame window = new JFrame("JFrame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        window.add(constrpanel());
        window.setVisible(true);
    }

    public static JMenuBar constrmenubar(){
        JMenuBar menubar = new JMenuBar();

        JMenuItem exit = exit();
        JMenuItem clear = new JMenuItem("Clear");
        JMenu graphLoading = graphloading();
        JMenu bestPath = bestPath();
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
        return graphPanel;
    }

    public static JPanel constrButtonsPanel(){
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
        bestPathh.add(about);
        aboutPane.add(about);

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

    public static JMenuItem exit(){
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(fermer->System.exit(0));
        return exit;
    }

    public static JMenu graphloading() {
        JMenu graphLoading = new JMenu("Graph Loading");
        JMenuItem loadFirstNeighboursForOneNode = new JMenuItem("Load First Neighbours For One Node");
        JMenuItem loadTwoNeighboursForOneNode = new JMenuItem("Load Two Neighbours For One Node");
        JMenuItem loadNNeighboursForOneNode = new JMenuItem("Load N Neighbours For One Node");
        graphLoading.add(loadFirstNeighboursForOneNode);
        graphLoading.add(loadTwoNeighboursForOneNode);
        graphLoading.add(loadNNeighboursForOneNode);
        return graphLoading;
    }

    public static JMenu bestPath(){
        JMenu bestPath = new JMenu("Best Path");
        JMenuItem loadGraphWithBestPathbetweenTwoNodes = new JMenuItem("Load Graph With Best Path between Two Nodes");
        bestPath.add(loadGraphWithBestPathbetweenTwoNodes);
        return bestPath;
    }

}
