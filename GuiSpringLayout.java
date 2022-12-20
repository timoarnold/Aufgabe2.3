import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GuiSpringLayout ist die Hauptklasse der GuiSpringLayout-Anwendung.
 * Sie erstellt die UI der Anwendung, zeigt sie an und initialisiert alle anderen Komponenten.
 * 
 * Ein Exemplar dieser Klasse muss erzeigt werden, um die Anwendung zu starten.
 * 
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */

public class GuiSpringLayout {

    private final GUIController controller;
    private JFrame window;
    
    /**
     * Konstruktor für die Klasse GuiSpringLayout.
     */
    public GuiSpringLayout(GUIController controller) {
        this.controller = controller;
        createWindow();
    }
    
    //public static void main(String[] args) {
    //    Produktions_Manager produktionsManager = new Produktions_Manager();
    //    Fabrik fabrik1 = new Fabrik(produktionsManager);
        
    //    GUIController controller = new GUIController(fabrik1);
    //    GuiSpringLayout gui = new GuiSpringLayout(controller);
    //}
    
    /**
     * Die Methode createWindow kümmert sich um den Aufbau der grafischen Oberfläche.
     * Die Klasse hat eine Instanzvariable vom Typ JFrame, die eine Referenz auf das Fenster hält, das auf dem Bildschirm angezeigt werden möchte.
     */
    private void createWindow() {
        window = new JFrame("Fabrik mit Springlayout");
        menuezeileErzeugen(window);
        
        JFrame frame = new JFrame("Fabrik mit SpringLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * Implementierung der Menü-Funktionen
     * 
     * 'Bestellung aufgeben'-Funktion: Öffnet einen Auswahldialog zum Bestellen
     */
    private void bestellungAufgeben()
    {
        // Testausgabe, bis wir das richtig implementiert haben
        System.out.println("Bestellung aufgeben");
    }
        
    /**
     * 'Beenden'-Funktion: Beendet die Anwendung.
     */
    private void beenden()
    {
        System.exit(0);
    }
    
    /**
     * 'Das Team'-Funktion: Zeigt einen Überblick über das Team
     */
    private void dasteam()
    {
        // Testausgabe, bis wir das richtig implementiert haben
        System.out.println("Erfahre mehr über das Team");
    }
    
    /**
     * 'Geschichte Team'-Funktion: Zeigt einen Überblick über die Geschichte von AEKI
     */
    private void geschichte()
    {
        // Testausgabe, bis wir das richtig implementiert haben
        System.out.println("Erfahre mehr über die Geschichte von AEKI");
    }
    
    /**
     * 'Info'-Funktion: Zeige Informationen zur Anwendung
     */
    private void zeigeInfo()
    {
        System.out.println("Bitte wenden Sie sich an unseren IT-Kontakt, Jonathan unter der folgenden Nummer: 0824 67 76");
    }
    
    /**
     * Die Menüzeile des Hauptfensters erzeugen.
     * @param fenster  das Fenster, in das die Menüzeile eingefügt werden soll
     */
    private void menuezeileErzeugen (JFrame window) {
        JMenuBar menuezeile = new JMenuBar();
        window.setJMenuBar(menuezeile);
                
        // JMenu "Bestellung" mit JMenuItems "Neue Bestellung" und "Beenden" erzeugen
        JMenu bestellungMenue = new JMenu("Neue Bestellung");
        menuezeile.add(bestellungMenue);
        
        JMenuItem aufgebenEintrag = new JMenuItem("Aufgeben");
        aufgebenEintrag.addActionListener(e -> bestellungAufgeben());
        bestellungMenue.add(aufgebenEintrag);

        JMenuItem beendenEintrag = new JMenuItem("Beenden");
        beendenEintrag.addActionListener(e -> beenden());
        bestellungMenue.add(beendenEintrag);
        
        // JMenu "Über uns" mit JMenuItems "das Team" und "Geschichte" erzeugen
        JMenu ueberunsMenue = new JMenu("Über uns");
        menuezeile.add(ueberunsMenue);
        
        JMenuItem dasteamEintrag = new JMenuItem("das Team");
        dasteamEintrag.addActionListener(e -> dasteam());
        ueberunsMenue.add(dasteamEintrag);

        JMenuItem geschichteEintrag = new JMenuItem("Geschichte");
        geschichteEintrag.addActionListener(e -> geschichte());
        ueberunsMenue.add(geschichteEintrag);
        
        //JMenu "Hilfe" mit JMenuItem "Info..." erzeugen
        JMenu hilfeMenue = new JMenu("Hilfe");
        menuezeile.add(hilfeMenue);
        
        JMenuItem infoEintrag = new JMenuItem("Info...");
        infoEintrag.addActionListener(e -> zeigeInfo());
        hilfeMenue.add(infoEintrag);
    }
    
    private void createUI(final JFrame frame){
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();

        panel.setLayout(layout);

        // Product label and textfield
        JLabel labelProdukt = new JLabel("Number of breads");
        JTextField textfieldProdukt = new JTextField();
        panel.add(labelProdukt);
        panel.add(textfieldProdukt);

        // Customer name
        JLabel labelCustomerName = new JLabel("Customer Name");
        JTextField textfieldCustomerName = new JTextField();
        panel.add(labelCustomerName);
        panel.add(textfieldCustomerName);

        // button to send order
        JButton buttonSendOrder = new JButton("Send Order");
        panel.add(buttonSendOrder);

        buttonSendOrder.addActionListener(arg0 -> {
            int produkt = Integer.parseInt(textfieldProdukt.getText());
            String name = textfieldCustomerName.getText();
            // String status = controller.onOrder(produkt, name);
        //    System.out.println(status);
        });


        layout.putConstraint(SpringLayout.WEST, labelProdukt, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labelProdukt, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, textfieldProdukt, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textfieldProdukt, 20, SpringLayout.EAST, labelProdukt);
        layout.putConstraint(SpringLayout.EAST, panel, 20, SpringLayout.EAST, textfieldProdukt);


        layout.putConstraint(SpringLayout.WEST, labelCustomerName, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labelCustomerName, 25, SpringLayout.NORTH, labelProdukt);
        layout.putConstraint(SpringLayout.EAST, labelCustomerName, 0, SpringLayout.EAST, labelProdukt);
        layout.putConstraint(SpringLayout.NORTH, textfieldCustomerName, 25, SpringLayout.NORTH, textfieldProdukt);
        layout.putConstraint(SpringLayout.WEST, textfieldCustomerName, 20, SpringLayout.EAST, labelCustomerName);
        layout.putConstraint(SpringLayout.EAST, textfieldProdukt, 0, SpringLayout.EAST, textfieldCustomerName);

        layout.putConstraint(SpringLayout.WEST, buttonSendOrder, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, buttonSendOrder, 25, SpringLayout.NORTH, labelCustomerName);


        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
