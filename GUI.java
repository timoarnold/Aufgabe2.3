import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.MediaTracker;
import java.awt.Image;
import java.io.File;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JTextField;

import java.io.*;
import javax.imageio.*;

/**
 * Das GUI steht für Graphical User Interface und ist der Visual Experience Builder für alle Anwendungen
 * Das GUI umfasst grafische Einheiten wie Buttons, Beschriftungen, Fenster usw., über welche die Benutzer mit einer Anwendung
 * in Verbindung treten können.
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */
public class GUI extends JFrame
{ 
    private final GUIController controller;

    public GUI(GUIController controller){
        this.controller = controller;
        initWindow();
    }

    protected void initWindow() {
        menu();
        //setContentPane(new BackGroundPane("hier Dateipfad für Bild einfügen"));
        JLabel welcomeLabel = new JLabel("Willkommen bei AEKI!");
        
        JLabel label_stuehle = new JLabel("Anzahl Stühle");
        JLabel label_sofas = new JLabel("Anzahl Sofas");
        JLabel label_bestellBestaetigung = new JLabel("Bestellbestätigung:");
        JLabel label_status = new JLabel("Status:");

        JTextField textfield_stuehle = new JTextField();
        JTextField textfield_sofas = new JTextField();

        JButton senden_knopf = new JButton("Bestellen");
        JButton button_refreshstatus = new JButton("Zeige Status");
        
        //Bild anzeigen
        Image startseiteBild = null;
            try {
                startseiteBild = ImageIO.read(new File("startseite.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_startseite = new ImageIcon(startseiteBild);
            JLabel label_bild_startseite = new JLabel(bild_startseite);
        
        label_bild_startseite.setBounds(15, 200, 1000, 100);
        
        this.add(label_bild_startseite);
        
        // Action listener zu button hinzufügen, der dann auf Kopfdruck durch contentPanecontroller.onOrder eine Bestellung erstellt
        // Zudem wird die bestellBestaetigung upgedated
        senden_knopf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int stuehle = Integer.parseInt(textfield_stuehle.getText());
                int sofas = Integer.parseInt(textfield_sofas.getText());
                controller.onOrder(stuehle, sofas);
                //label_bestellBestaetigung.setText(status);
            }
        });
        
        // Action listener mit Lambda Funktion () -> {}
        button_refreshstatus.addActionListener (arg0 -> {
            //String status = controller.gibtZustand();
            //label_status.setText(status);
        });

        // Positionieren
        label_stuehle.setBounds(10, 50, 1000, 25);
        textfield_stuehle.setBounds(180, 50, 100, 25);
        label_sofas.setBounds(10,80, 100, 25);
        textfield_sofas.setBounds(180,80,100,25);
        welcomeLabel.setBounds(10, 10, 1000, 25);
        label_bestellBestaetigung.setBounds(10,110, 1000, 25);
        label_status.setBounds(10,140, 400, 25);
        senden_knopf.setBounds(10,170,150,30);
        button_refreshstatus.setBounds(190,170,150,30);

        // Alle Elemente zum panel hinzufügen --> wird zur Superklasse hinzugefügt
        this.add(welcomeLabel);
        this.add(label_stuehle);
        this.add(label_sofas);
        this.add(label_bestellBestaetigung);
        this.add(label_status);
        this.add(textfield_stuehle);
        this.add(textfield_sofas);
        this.add(senden_knopf);
        this.add(button_refreshstatus);
        
        // GUI öffnen
        // Sobald  das Fenster vollständig konstruiert ist, kann es mit setVisible im kompletten Zustand angezeigt werden.
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
    }

    public void menu() {
        JMenuBar menueBar = new JMenuBar();
        
        // JMenu "Bestellung" mit JMenuItems "Neue Bestellung" und "Beenden" erzeugen
        JMenu bestellungMenue = new JMenu("Neue Bestellung");
        menueBar.add(bestellungMenue);
        
        JMenuItem aufgebenEintrag = new JMenuItem("Aufgeben");
        aufgebenEintrag.addActionListener(e -> bestellungAufgeben());
        bestellungMenue.add(aufgebenEintrag);
        
        //noch einfügen: Auftragsstatus prüfen, Produktübersicht (Stuhl, Sofa), spezielle Ansicht mit Produktionsmanager. Lager
        
        JMenuItem beendenEintrag = new JMenuItem("Beenden");
        beendenEintrag.addActionListener(e -> beenden());
        bestellungMenue.add(beendenEintrag);
        
        // JMenu "Über uns" mit JMenuItems "das Team" und "Geschichte" erzeugen
        JMenu ueberunsMenue = new JMenu("Über uns");
        menueBar.add(ueberunsMenue);
        
        JMenuItem dasteamEintrag = new JMenuItem("das Team");
        dasteamEintrag.addActionListener(e -> dasteam());
        ueberunsMenue.add(dasteamEintrag);

        JMenuItem eindrueckeEintrag = new JMenuItem("Eindrücke");
        eindrueckeEintrag.addActionListener(e -> eindruecke());
        ueberunsMenue.add(eindrueckeEintrag);
        
        /*JMenuItem schliessenEintrag = new JMenuItem("Schliessen");
        schliessenEintrag.addActionListener(e -> schliessen());
        ueberunsMenue.add(schliessenEintrag);
        ueberunsMenue.addSeparator();*/
        
        JMenuItem geschichteEintrag = new JMenuItem("Geschichte");
        geschichteEintrag.addActionListener(e -> geschichte());
        ueberunsMenue.add(geschichteEintrag);
        
        //JMenu "Hilfe" mit JMenuItem "Info..." erzeugen
        JMenu hilfeMenue = new JMenu("Hilfe");
        menueBar.add(hilfeMenue);
        
        JMenuItem infoEintrag = new JMenuItem("Info...");
        infoEintrag.addActionListener(e -> zeigeInfo());
        hilfeMenue.add(infoEintrag);
        
        this.setJMenuBar(menueBar);
        //this.setLayout((LayoutManager)null);
        //this.setDefaultCloseOperation(3);
        this.setVisible(true);
        
        
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
     * 'Eindruecke'-Funktion: Öffnet einen Dateiauswahldialog zur 
     * Auswahl einer Bilddatei und zeigt das selektierte Bild an.
     */
    private void eindruecke()
    {
        Image startseiteBild = null;
            try {
                startseiteBild = ImageIO.read(new File("startseite.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_startseite = new ImageIcon(startseiteBild);
            JLabel label_bild_startseite = new JLabel(bild_startseite);
        
        label_bild_startseite.setBounds(15, 200, 1000, 100);
        
        this.add(label_bild_startseite);

        // bildflaeche.setzeBild(aktuellesBild);
        //setzeKnoepfeAktiviert(true);
        //dateinameAnzeigen(selektierteDatei.getPath());
        //statusAnzeigen("Datei geladen.");
        //window.pack();
    }
    
    
    /**
     * 'Schliessen'-Funktion: Schliesst das aktuelle Bild.
     */
    /*private void schliessen()
     {
         aktuellesBild = null;
         bildflaeche.loeschen();
        dateinameAnzeigen(null);
        setzeKnoepfeAktiviert(false);
    }*/
    
    /**
     * 'Geschichte'-Funktion: Zeigt einen Überblick über die Geschichte von AEKI
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
        System.out.println("Bitte wenden Sie sich an unseren IT-Kontakt, Jonathan, unter der folgenden Nummer: 0824 67 76");
    }