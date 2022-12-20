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
    
    public static void main(String[] args) {
        Produktions_Manager produktionsManager = new Produktions_Manager();
        Fabrik fabrik = new Fabrik(produktionsManager);
        
        GUIController controller = new GUIController(fabrik);
        GuiSpringLayout gui = new GuiSpringLayout(controller);
    }
    
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
        // hier müssen wir den Link zum GUI erstellen, damit wir dann Produkte bestellen können (durch die Menüleiste)
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
        // Hier Text von Timo einfügen
        System.out.println("Das Team in der Übersicht");
    }
    
    /**
     * 'Geschichte Team'-Funktion: Zeigt einen Überblick über die Geschichte von AEKI
     */
    private void geschichte()
    {
        // Hier Text von Timo Einfügen
        System.out.println("Die Geschichte von AEKI");
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

        // Stühle und Textfeld
        JLabel labelStuhl = new JLabel("Anzahl Stühle");
        JTextField textfieldStuhl = new JTextField();
        panel.add(labelStuhl);
        panel.add(textfieldStuhl);

        // Sofas und Textfeld
        JLabel labelSofa = new JLabel("Anzahl Sofas");
        JTextField textfieldSofa = new JTextField();
        panel.add(labelSofa);
        panel.add(textfieldSofa);
        
        // Knopf SendenKnopf
        JButton buttonSendenKnopf = new JButton("Sende Bestellung");
        panel.add(buttonSendenKnopf);

        buttonSendenKnopf.addActionListener(arg0 -> {
            int stuhl = Integer.parseInt(textfieldStuhl.getText());
            int sofa = Integer.parseInt(textfieldSofa.getText());
            String status = controller.onOrder(sofa, stuhl);
            System.out.println(status);
        });


        layout.putConstraint(SpringLayout.WEST, labelStuhl, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labelStuhl, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, textfieldStuhl, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textfieldStuhl, 20, SpringLayout.EAST, labelStuhl);
        layout.putConstraint(SpringLayout.EAST, panel, 20, SpringLayout.EAST, textfieldStuhl);

        layout.putConstraint(SpringLayout.WEST, labelSofa, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, labelSofa, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, textfieldSofa, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, textfieldSofa, 20, SpringLayout.EAST, labelSofa);
        layout.putConstraint(SpringLayout.EAST, panel, 20, SpringLayout.EAST, textfieldSofa);

        layout.putConstraint(SpringLayout.WEST, buttonSendenKnopf, 10, SpringLayout.WEST, panel);


        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}
