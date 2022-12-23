import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.MediaTracker;
import java.awt.Image;
import java.io.File;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

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
        JLabel welcomeLabel = new JLabel("Willkommen bei AEKI!");
        this.setVisible(true);
        
        //Bild anzeigen
        Image startseiteBild = null;
            try {
                startseiteBild = ImageIO.read(new File("start.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_startseite = new ImageIcon(startseiteBild);
            JLabel label_bild_startseite = new JLabel(bild_startseite);
        
        label_bild_startseite.setBounds(15, 2000, 1000, 100);
        
        this.add(label_bild_startseite);

        
        // GUI öffnen
        // Sobald  das Fenster vollständig konstruiert ist, kann es mit setVisible im kompletten Zustand angezeigt werden.
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2500,2500);
        this.setVisible(true);
    }

    public void menu() {
        JMenuBar menueBar = new JMenuBar();
        
        // JMenu "Startseite"
        JMenu startseiteMenue = new JMenu("Startseite");
        startseiteMenue.addMenuListener(new MenuListener () {
            @Override
            public void menuSelected(MenuEvent e) {
                startseiteAnzeigen();
        }
        @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("Cancelled");
        }
        @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("Deselected");
        }
        } );
        menueBar.add(startseiteMenue);
        
        // JMenu "Bestellung" mit JMenuItems "Neue Bestellung" und "Beenden" erzeugen
        JMenu bestellungMenue = new JMenu("Neue Bestellung");
        menueBar.add(bestellungMenue);
        
        JMenuItem aufgebenEintrag = new JMenuItem("Aufgeben");
        aufgebenEintrag.addActionListener(e -> bestellungAufgeben());
        bestellungMenue.add(aufgebenEintrag);
        
        JMenuItem übersichtEintrag = new JMenuItem("Bestellübersicht");
        übersichtEintrag.addActionListener(e -> bestellungÜbersicht());
        bestellungMenue.add(übersichtEintrag);
        
        JMenuItem beendenEintrag = new JMenuItem("Beenden");
        beendenEintrag.addActionListener(e -> beenden());
        bestellungMenue.add(beendenEintrag);
        
        // JMenu "Über uns" mit JMenuItems "das Team" und "Geschichte" erzeugen
        JMenu ueberunsMenue = new JMenu("Über uns");
        menueBar.add(ueberunsMenue);
        
        JMenuItem dasteamEintrag = new JMenuItem("das Team");
        dasteamEintrag.addActionListener(e -> dasteam());
        ueberunsMenue.add(dasteamEintrag);
        
        JMenuItem geschichteEintrag = new JMenuItem("Geschichte");
        geschichteEintrag.addActionListener(e -> geschichte());
        ueberunsMenue.add(geschichteEintrag);
        
        JMenuItem eindrueckeEintrag = new JMenuItem("Eindrücke");
        eindrueckeEintrag.addActionListener(e -> eindruecke());
        ueberunsMenue.add(eindrueckeEintrag);
        
        /*JMenuItem schliessenEintrag = new JMenuItem("Schliessen");
        schliessenEintrag.addActionListener(e -> schliessen());
        ueberunsMenue.add(schliessenEintrag);
        ueberunsMenue.addSeparator();*/
        
        //JMenu "Hilfe" mit JMenuItem "Info..." erzeugen
        JMenu hilfeMenue = new JMenu("Hilfe");
        menueBar.add(hilfeMenue);
        
        JMenuItem infoEintrag = new JMenuItem("Info...");
        infoEintrag.addActionListener(e -> zeigeInfo());
        hilfeMenue.add(infoEintrag);
        
        // JMenu "Exit"
        JMenu exitMenue = new JMenu("Exit");
        exitMenue.addMenuListener(new MenuListener () {
            @Override
            public void menuSelected(MenuEvent e) {
                exitAnzeigen();
        }
        @Override
            public void menuCanceled(MenuEvent e) {
                System.out.println("Cancelled");
        }
        @Override
            public void menuDeselected(MenuEvent e) {
                System.out.println("Deselected");
        }
        } );
        menueBar.add(exitMenue);
        
        this.setJMenuBar(menueBar);
        //this.setLayout((LayoutManager)null);
        //this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
    
    /**
     * Implementierung der Menü-Funktionen
     * Durch 'removeAll' und 'repaint' werden die Interfaces jeweils erneuert 
     * 
     * 'Bestellung aufgeben'-Funktion: Öffnet einen Auswahldialog zum Bestellen
     */
    
    private void bestellungAufgeben() {
        this.getContentPane().removeAll();
        this.repaint();
        JLabel welcomeLabel = new JLabel("Willkommen bei AEKI!");
        
        JLabel label_stuehle = new JLabel("Anzahl Stühle");
        JLabel label_sofas = new JLabel("Anzahl Sofas");
        JLabel label_bestellBestaetigung = new JLabel("Bestellbestätigung:");
        JLabel label_status = new JLabel("Status:");

        JTextField textfield_stuehle = new JTextField();
        JTextField textfield_sofas = new JTextField();

        JButton senden_knopf = new JButton("Bestellen");
        JButton button_refreshstatus = new JButton("Zeige Status");
        
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

        JButton button_bestellübersicht = new JButton("Bestellübersicht anzeigen");
        
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
        button_bestellübersicht.setBounds(10, 170, 150, 30);

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
        this.add(button_bestellübersicht);
        
        this.setVisible(true);
    }
    
    private void bestellungÜbersicht() {
        this.getContentPane().removeAll();
        this.repaint();
        JLabel welcomeLabel = new JLabel("Vielen Dank für Ihre Bestellung und willkommen zurück!");
        JButton button_bestellübersicht = new JButton("Bestellübersicht anzeigen");
        
        // Positionieren
        button_bestellübersicht.setBounds(10, 170, 150, 30);

        // Elemente zum Panel hinzufügen
        this.add(button_bestellübersicht);
        
    // To Do: Action listener mit Lambda Funktion () -> {}
        button_bestellübersicht.addActionListener (arg0 -> {
            //String status = controller.gibtZustand();
            //label_status.setText(status);
        });
        this.setVisible(true);
    }
        
    /**
     * 'Startseite'-Funktion: Zeigt die Startseite an
     */
    private void startseiteAnzeigen() {
        this.getContentPane().removeAll();
        this.repaint();
        
        Image startseiteBild = null;
            try {
                startseiteBild = ImageIO.read(new File("start.png"));
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
        this.setVisible(true);
    }
    
    /**
     * 'Beenden' und 'Exit'-Funktionen: Beenden die Anwendung.
     */
    private void beenden() {
        System.exit(0);
    }
    
    private void exitAnzeigen() {
         System.exit(0);
    }
    
    /**
     * 'Das Team'-Funktion: Zeigt einen Überblick über das Team
     */
    private void dasteam() {
        // Hier Text von Timo einfügen
        System.out.println("Das Team in der Übersicht");
        
        this.getContentPane().removeAll();
        this.repaint();
        
        Image timoBild = null;
            try {
                timoBild = ImageIO.read(new File("timo.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_timo = new ImageIcon(timoBild);
            JLabel label_bild_timo = new JLabel(bild_timo);
        
        label_bild_timo.setBounds(5, 200, 1000, 100);
        
        this.add(label_bild_timo);
        this.setVisible(true);
    }
    
    /**
     * 'Eindruecke'-Funktion: Öffnet einen Dateiauswahldialog zur 
     * Auswahl einer Bilddatei und zeigt das selektierte Bild an.
     */
    private void eindruecke()
    {
        Image startseiteBild = null;
            try {
                startseiteBild = ImageIO.read(new File("start.png"));
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
    }
