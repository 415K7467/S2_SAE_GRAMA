package HCI.jswing;

import features.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Vincent Chavot -- Dambrun
 */
public class Window {
    private static final JLabel nameResult= new JLabel("");
    private static final JLabel result=new JLabel("");
    private static final GraphWindow.MyPanel graphPanel = new GraphWindow.MyPanel();
    public static boolean visibleDepartemental=true;
    public static boolean visibleNational=true;
    public static boolean visibleAutoroute=true;

    /**
     * main function to start construction of the window
     */
    public static void constrwindow(){
        JFrame window = new JFrame("MineGraph");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        window.add(constrpanel());
        window.setVisible(true);
    }

    /**
     * function to construct the panel
     * @return the panel
     */
    private static JPanel constrpanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JMenuBar menu = constrmenubar();
        JPanel graphPanel = constrgraphpanel();
        JPanel buttonsPanel = constrButtonsPanel();
        JPanel constrPanel = constrResult();
        panel.add(menu, BorderLayout.NORTH);
        panel.add(graphPanel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.EAST);
        panel.add(constrPanel, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * function to construct the menu bar
     * @return the menu bar
     */
    private static JMenuBar constrmenubar() {
        JMenuBar menubar = new JMenuBar();

        JMenuItem exit = exit();
        JMenu graphLoading = graphloading();
        JMenu bestPath = bestPath();

        menubar.add(graphLoading);
        menubar.add(bestPath);
        menubar.add(compare());
        menubar.add(hideEdge());
        menubar.add(node2distance());
        menubar.add(info());
        menubar.add(help());
        menubar.add(about());
        menubar.add(exit);
        return menubar;
    }

    /**
     * function to construct the graph panel
     * @return the graph panel
     */
    private static JPanel constrgraphpanel(){
        graphPanel.setBackground(Color.gray);
        return graphPanel;
    }

    /**
     * function to construct the buttons panel
     * @return the buttons panel
     */
    private static JPanel constrButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        Dimension space = new Dimension(400, 100);

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

        JPanel comparePane = new JPanel();
        JMenuBar comparee = new JMenuBar();
        JMenu compare = compare();
        comparee.add(compare);
        comparePane.add(comparee);

        JPanel hideEdgePane = new JPanel();
        JMenuBar hideEdgee = new JMenuBar();
        JMenu hideEdge = hideEdge();
        hideEdgee.add(hideEdge);
        hideEdgePane.add(hideEdgee);

        JPanel infoPane = new JPanel();
        infoPane.add(info());

        JPanel helpPane = new JPanel();
        helpPane.add(help());

        JPanel distance2 = new JPanel();
        distance2.add(node2distance());

        JPanel aboutPane = new JPanel();
        aboutPane.add(about());

        JPanel exitPane = new JPanel();
        exitPane.add(exit());

        buttonsPanel.add(Box.createRigidArea(space));
        buttonsPanel.add(graphLoadingPane);
        buttonsPanel.add(bestPathPane);
        buttonsPanel.add(comparePane);
        buttonsPanel.add(hideEdgePane);
        buttonsPanel.add(distance2);
        buttonsPanel.add(infoPane);
        buttonsPanel.add(helpPane);
        buttonsPanel.add(aboutPane);
        buttonsPanel.add(exitPane);
        return buttonsPanel;
    }

    /**
     * function to construct the result panel
     * @return the result panel
     */
    private static JPanel constrResult(){
        JPanel result=new JPanel();
        result.setPreferredSize(new Dimension(JFrame.MAXIMIZED_BOTH,150));
        result.add(getNameResult());
        result.add(getResult());
        return result;
    }

    /**
     * function to construct the menu item for loading a graph
     * @return the menu item
     */
    private static JMenu graphloading() {
        JMenu graphLoading = new JMenu("Voisins pour un nœud");
        JMenuItem loadFirstNeighboursForOneNode = new JMenuItem("Voir les voisins pour une distance de 1");
        loadFirstNeighboursForOneNode.addActionListener(loadFirstNeighboursForOneNodeActionListener -> {
            String nodeName = name(null);
            neigbours(nodeName, 1);
        });
        JMenuItem loadTwoNeighboursForOneNode = new JMenuItem("Voir les voisins pour une distance de 2");
        loadTwoNeighboursForOneNode.addActionListener(loadTwoNeighboursForOneNodeActionListener -> {
            String nodeName = name(null);
            neigbours(nodeName, 2);
        });
        JMenuItem loadNNeighboursForOneNode = new JMenuItem("Voir les voisins pour une distance de N");
        loadNNeighboursForOneNode.addActionListener(loadNNeighboursForOneNodeActionListener -> {
            String nodeName = name(null);
            neigbours(nodeName, 0);
        });
        graphLoading.add(loadFirstNeighboursForOneNode);
        graphLoading.add(loadTwoNeighboursForOneNode);
        graphLoading.add(loadNNeighboursForOneNode);
        return graphLoading;
    }

    /**
     * function to construct the best path menu
     * @return the menu
     */
    private static JMenu bestPath() {
        JMenu bestPath = new JMenu("Meilleur chemin");
        JMenuItem loadGraphWithBestPathbetweenTwoNodes = new JMenuItem("Voir le meilleur chemin entre deux noeuds");
        loadGraphWithBestPathbetweenTwoNodes.addActionListener(e -> {
            String startNode = name("de départ");
            String arrivalNode = name("d'arrivée");
            if (startNode != null && arrivalNode != null) {
                new Dijkstra(Main.allnodes.getNode(startNode), Main.allnodes.getNode(arrivalNode));
            }
            nameResult.setText("La fonctionnalité n'est pas encore implémentée");
            result.setText("");
            nameResult.updateUI();
            result.updateUI();
        });
        bestPath.add(loadGraphWithBestPathbetweenTwoNodes);

        return bestPath;
    }

    /**
     * function to construct the menu item for comparing two graphs
     * @return the menu item
     */
    private static JMenu compare(){
        JMenu compare = new JMenu("Comparer deux nœuds");
        JMenuItem compareVille = new JMenuItem("Compare Ville");
        compareVille.addActionListener(e-> compareTo("V"));
        compare.add(compareVille);
        JMenuItem compareLoisir = new JMenuItem("Compare Loisir");
        compareLoisir.addActionListener(e-> compareTo("L"));
        compare.add(compareLoisir);
        JMenuItem compareRestaurant = new JMenuItem("Compare Restaurant");
        compareRestaurant.addActionListener(e-> compareTo("R"));
        compare.add(compareRestaurant);
        return compare;
    }

    /**
     * function to construct the menu item for hiding edges
     * @return the menu item
     */
    private static JMenu hideEdge() {
        JMenu hide = new JMenu("Cacher/Afficher");
        JMenuItem hideDepartemeantal = new JMenuItem("Cacher/Afficher les Departementales");
        hideDepartemeantal.addActionListener(e->{
            hideTo("D");
            graphPanel.updateUI();
        });
        hide.add(hideDepartemeantal);
        JMenuItem hideNational = new JMenuItem("Cacher/Afficher les Nationales");
        hideNational.addActionListener(e->{
            hideTo("N");
            graphPanel.updateUI();
        });
        hide.add(hideNational);
        JMenuItem hideAutoroute = new JMenuItem("Cacher/Afficher les Autoroutes");
        hideAutoroute.addActionListener(e->{
            hideTo("A");
            graphPanel.updateUI();
        });
        hide.add(hideAutoroute);
        return hide;
    }

    /**
     * function to construct the menu item for information about the graph
     * @return the menu item
     */
    private static JMenuItem info() {
        JMenuItem info = new JMenuItem("Info");
        info.addActionListener(infoAction->{
            nameResult.setText("Il y a "+GraphWindow.numVilles+" Villes, "+GraphWindow.numLoisirs+" Loisirs, "+GraphWindow.numRestaurants+" Restaurants pour un total de "+ (GraphWindow.numVilles + GraphWindow.numLoisirs + GraphWindow.numRestaurants)+" noeuds   ;");
            result.setText("Il y a "+GraphWindow.numAutoroutes/2+" Autoroutes, "+GraphWindow.numNationales/2+" Nationale, "+GraphWindow.numDepartementales/2+" départemental pour un total de "+(GraphWindow.numAutoroutes/2+GraphWindow.numNationales/2+GraphWindow.numDepartementales/2)+" noeuds   ;");
            nameResult.updateUI();
            result.updateUI();
        });
        return info;
    }

    /**
     * function to construct the menu item for node 2distance information
     * @return the menu item
     */
    private static JMenuItem node2distance() {
        JMenuItem node2distance = new JMenuItem("Est ce que 2 noeuds sont à 2 distance ?");
            node2distance.addActionListener(e->{
            String node1 = name("1");
            String node2 = name("2");
            if (node1 != null && node2 != null) {
                ArrayList<String> nodes1List = Main.allnodes.getNode(node1).neighborName(2);
                if (nodes1List.contains(node2)){
                    nameResult.setText("");
                    result.setText(node1 + " et " + node2 + " sont à 2 distance ou moins");
                }
                else{
                    nameResult.setText("");
                    result.setText(node1 + " et " + node2 + " sont à plus de 2 distance");
                }
            }
        });
        return node2distance;
    }

    /**
     * function to construct the menu item help
     * @return the menu item
     */
    private static JMenuItem help() {
        JMenuItem help = new JMenuItem("Aide");
        help.addActionListener(helpAction -> {
            try {
                Desktop.getDesktop().open(new File("./ManuelDUtilisation.docx"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return help;
    }

    /**
     * function to construct the menu item about
     * @return the menu item
     */
    private static JMenuItem about() {
        JMenuItem about = new JMenuItem("A propos");
        about.addActionListener(aboutAction -> {
            try {
                Desktop.getDesktop().open(new File("./readme.md"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return about;
    }

    /**
     * function to construct the menu item for the exit
     * @return the menu item
     */
    private static JMenuItem exit() {
        JMenuItem exit = new JMenuItem("Quitter");
        exit.addActionListener(fermer -> System.exit(0));
        return exit;
    }


    /**
     * function to select a name of a node
     * @return the menu item
     */
    private static String name(String add) {
        String name;
        if (add != null) {
            name = JOptionPane.showInputDialog("Entrer le nom du noeud " + add);
        } else {
            name = JOptionPane.showInputDialog("Entrer le nom du noeud ");
        }
        return name;
    }

    /**
     * @param name the name of the node
     * @param distance the distance of the node
     * print the name neighbours of the node
     */
    private static void neigbours(String name, int distance) {
        if (name != null) {
            if (distance == 0) {
                distance = Integer.parseInt(JOptionPane.showInputDialog("Entrer la distance"));
            }
            ArrayList<String> list = Main.allnodes.getNode(name).neighborName(distance);
            nameResult.setText("Liste des noeuds voisins de " + name + " pour une distance de " + distance + " :");
            result.setText(list.toString());
            result.setText(list.toString().substring(0,list.size()/2)+"\n"+list.toString().substring(list.size()/2));
            nameResult.updateUI();
            result.updateUI();

            System.out.println(list);
        }
    }

    /**
     * get the nameResult text, nameResult is the text area where the name of result is printed
     * @return the nameResult text
     */
    public static JLabel getNameResult() {
        return nameResult;
    }

    /**
     * get the result text, result is the text area where the result is printed
     * @return the result text
     */
    public static JLabel getResult() {
        return result;
    }

    /**
     * @param type the type of the node
     * compare number of neighbours of the type between two nodes
     */
    private static void compareTo(String type){
        String node1 = name("1");
        String node2 = name("2");
        int distance = Integer.parseInt(JOptionPane.showInputDialog("Entrer la distance"));

        nameResult.setText("");
        result.setText(Main.allnodes.getNode(node1).compareNodes(Main.allnodes.getNode(node2),distance,type));
        nameResult.updateUI();
        result.updateUI();
    }

    /**
     * @param type the type of hedge
     * hide or show the hedge of the type
     */
    private static void hideTo(String type){
        switch (type) {
            case "D" -> visibleDepartemental = !visibleDepartemental;
            case "N" -> visibleNational = !visibleNational;
            case "A" -> visibleAutoroute = !visibleAutoroute;
            default -> {
            }
        }
    }

}
