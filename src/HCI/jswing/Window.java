package HCI.jswing;

import features.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Window {
    private static JLabel nameResult= new JLabel("");
    private static JLabel result=new JLabel("");
    private static GraphWindow.MyPanel graphPanel = new GraphWindow.MyPanel();
    private static boolean visibleDepartemental=true;
    private static boolean visibleNational=true;
    private static boolean visibleAutoroute=true;

    public static void constrwindow() throws IOException {
        JFrame window = new JFrame("JFrame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        window.add(constrpanel());
        window.setVisible(true);
    }

    private static JPanel constrpanel() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JMenuBar menu = constrmenubar();
        JPanel graphPanel = constrgraphpanel();
        JPanel buttonsPanel = constrButtonsPanel();
        JPanel constrPanel = constrResult();
        panel.add(menu,BorderLayout.NORTH);
        panel.add(graphPanel,BorderLayout.CENTER);
        panel.add(buttonsPanel,BorderLayout.EAST);
        panel.add(constrPanel,BorderLayout.SOUTH);
        return panel;
    }

    private static JMenuBar constrmenubar(){
        JMenuBar menubar = new JMenuBar();

        JMenuItem exit = exit();
        JMenu graphLoading = graphloading();
        JMenu bestPath = bestPath();

        menubar.add(graphLoading);
        menubar.add(bestPath);
        menubar.add(compare());
        menubar.add(about());
        menubar.add(exit);
        return menubar;
    }

    private static JPanel constrgraphpanel(){
        graphPanel.setBackground(Color.gray);
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

        JPanel comparePane = new JPanel();
        JMenuBar comparee = new JMenuBar();
        JMenu compare = compare();
        comparePane.add(compare);
        comparee.add(compare);
        comparePane.add(comparee);


        JPanel aboutPane = new JPanel();
        JMenuItem about = new JMenuItem("About");
        aboutPane.add(about());

        JPanel exitPane = new JPanel();
        JMenuItem exit = exit();
        exitPane.add(exit);

        buttonsPanel.add(Box.createRigidArea(space));
        buttonsPanel.add(graphLoadingPane);
        buttonsPanel.add(bestPathPane);
        buttonsPanel.add(comparePane);
        buttonsPanel.add(aboutPane);
        buttonsPanel.add(exitPane);
        return buttonsPanel;
    }

    private static JPanel constrResult(){
        JPanel result=new JPanel();
        result.setPreferredSize(new Dimension(JFrame.MAXIMIZED_BOTH,150));
        result.add(getNameResult());
        result.add(getResult());
        return result;
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
            String startNode = name("de départ");
            String arrivalNode = name("d'arrivée");
            if (startNode != null && arrivalNode != null) {
                new Dijkstra(Test.allnodes.getNode(startNode), Test.allnodes.getNode(arrivalNode));
            }
            nameResult.setText("La fonctionnalité n'est pas encore implémentée");
            result.setText("");
            nameResult.updateUI();
            result.updateUI();
        });
        bestPath.add(loadGraphWithBestPathbetweenTwoNodes);

        return bestPath;
    }

    private static JMenu compare(){
        JMenu compare = new JMenu("Compare");
        JMenuItem compareVille = new JMenuItem("Compare Ville");
        compareVille.addActionListener(e->{
            compareTo("V");
        });
        compare.add(compareVille);
        JMenuItem compareLoisir = new JMenuItem("Compare Loisir");
        compareLoisir.addActionListener(e->{
            compareTo("L");
        });
        compare.add(compareLoisir);
        JMenuItem compareRestaurant = new JMenuItem("Compare Restaurant");
        compareRestaurant.addActionListener(e->{
            compareTo("R");
        });
        compare.add(compareRestaurant);
        return compare;
    }

    private static JMenu hideEdge() {
        JMenu hide = new JMenu("Hide");
        JMenuItem hideDepartemeantal = new JMenuItem("Hide Departemental");
        hideDepartemeantal.addActionListener(e->{
            hideTo("D");
            graphPanel.updateUI();
        });
        hide.add(hideDepartemeantal);
        JMenuItem hideNational = new JMenuItem("Hide National");
        hideNational.addActionListener(e->{
            hideTo("N");
            graphPanel.updateUI();
        });
        hide.add(hideNational);
        JMenuItem hideAutoroute = new JMenuItem("Hide Autoroute");
        hideAutoroute.addActionListener(e->{
            hideTo("A");
            graphPanel.updateUI();
        });
        hide.add(hideAutoroute);
        return hide;
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

    private static JMenuItem exit(){
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(fermer->System.exit(0));
        return exit;
    }



    private static String name(String add){
        String name;
        if (add != null) {
            name = JOptionPane.showInputDialog("Entrer le nom du noeud "+add);
        }
        else {
            name = JOptionPane.showInputDialog("Entrer le nom du noeud ");
        }
        return name;
    }

    private static void neigbours(String name, int distance){
        if (name != null) {
            if (distance == 0) {
                distance = Integer.parseInt(JOptionPane.showInputDialog("Entrer la distance"));
            }
            //ArrayList<Node> list = Test.allnodes.getNode(name).neighbor(distance);
            ArrayList<String> list = Test.allnodes.getNode(name).neighborName(distance);
            nameResult.setText("Liste des noeuds voisins de "+name+" pour une distance de "+distance+" :");
            String text = "";
            if (list.size()<100)
                result.setText(list.toString());
            else if (list.size() <200) {
                result.setText(list.toString().substring(0,list.size()/2)+"\n"+list.toString().substring(list.size()/2));
            }
            else {
                result.setText(list.toString().substring(0,list.size()/3)+"\n"+list.toString().substring(list.size()/3,list.size()/2)+"\n"+list.toString().substring(list.size()/2));
            }
            nameResult.updateUI();
            result.updateUI();

            System.out.println(list);
        }
    }

    public static JLabel getNameResult() {
        return nameResult;
    }

    public static JLabel getResult() {
        return result;
    }

    private static void compareTo(String type){
        String node1 = name("1");
        String node2 = name("2");
        int distance = Integer.parseInt(JOptionPane.showInputDialog("Entrer la distance"));

        nameResult.setText("");
        result.setText(Test.allnodes.getNode(node1).compareNodes(Test.allnodes.getNode(node2),distance,type));
        nameResult.updateUI();
        result.updateUI();
    }

    private static void hideTo(String type){
        switch (type) {
            case "D":
                visibleDepartemental = !visibleDepartemental;
                break;
            case "N":
                visibleNational = !visibleNational;
                break;
            case "A":
                visibleAutoroute = !visibleAutoroute;
                break;
            default:
                break;
        }
    }

}
