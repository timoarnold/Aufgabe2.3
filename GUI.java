import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.File;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.Font;
import java.awt.Color;
//import javafx.scene.layout.Border;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JTextField;

import javax.imageio.*;

/**
 * Das GUI steht für Graphical User Interface und ist der Visual Experience Builder für alle Anwendungen
 * Das GUI umfasst grafische Einheiten wie Buttons, Beschriftungen, Fenster usw., über welche die Benutzer mit einer Anwendung
 * in Verbindung treten können.
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember 2022)
 */
public class GUI extends JFrame { 
    private final GUIController controller;

    public GUI(GUIController controller){
        this.controller = controller;
        initWindow();
    }

    protected void initWindow() {
        this.getContentPane().removeAll();
        this.repaint();
        
        menu();
        JLabel welcomeLabel = new JLabel("Willkommen bei AEKI!");

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
        
        welcomeLabel.setBounds(10, 50, 1000, 25);
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        welcomeLabel.setForeground(new Color(120, 90, 40));
        label_bild_startseite.setBounds(10, 10, 1000, 750);
         
        this.add(welcomeLabel);
        this.add(label_bild_startseite);

        // GUI öffnen
        // Sobald  das Fenster vollständig konstruiert ist, kann es mit setVisible im kompletten Zustand angezeigt werden.
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1600,1600);
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
        übersichtEintrag.addActionListener(e -> bestellungUebersicht());
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
     * Durch 'removeAll' und 'repaint' werden die Interfaces jeweils erneuert.
     * Durch 'setvisible' werden die Interfaces jeweils sichtbar gezeigt/ angezeigt.
     * 
     * 'Bestellung aufgeben'-Funktion: Öffnet einen Auswahldialog zum Bestellen.
     * Der Action Listener wird jeweils den Buttons hinzugefügt und erstellt dann auf Knopfdruch durch 'contentPanecontroller.onOrder' eine Bestellung.
     * Zudem wird die bestellBestaetigung upgedated.
     */
    private void bestellungAufgeben() {
        this.getContentPane().removeAll();
        this.repaint();
        JLabel welcomeLabel = new JLabel("Willkommen bei AEKI!");
        
        JLabel label_stuehle = new JLabel("Anzahl Stühle");
        JLabel label_sofas = new JLabel("Anzahl Sofas");
        JLabel label_bestellBestaetigung = new JLabel("Bestellbestätigung:");
        JLabel label_status = new JLabel("Anzahl Bestellungen:");

        JTextField textfield_stuehle = new JTextField();
        JTextField textfield_sofas = new JTextField();

        JButton senden_knopf = new JButton("Bestellen");
        JButton button_refreshstatus = new JButton("Zeige Status");
        
        senden_knopf.addActionListener((arg) -> {
                int stuehle = Integer.parseInt(textfield_stuehle.getText());
                int sofas = Integer.parseInt(textfield_sofas.getText());
                controller.onOrder(sofas, stuehle);
                String bestellBestaetigung = controller.gibBestellBestaetigung();
                label_bestellBestaetigung.setText("Bestellbestätigung: " + bestellBestaetigung);
        });
        // Action listener mit Lambda Funktion () -> {}
        button_refreshstatus.addActionListener ((arg) -> {
            String bestellNummer = controller.gibAnzahlBestellungen();
            label_status.setText("Anzahl Bestellungen: " + bestellNummer);
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

        // Alle Elemente werden durch 'this.add zum Panel hinzugefügen
        this.add(welcomeLabel);
        this.add(label_stuehle);
        this.add(label_sofas);
        this.add(label_bestellBestaetigung);
        this.add(label_status);
        this.add(textfield_stuehle);
        this.add(textfield_sofas);
        this.add(senden_knopf);
        this.add(button_refreshstatus);
        
        this.setVisible(true);
    }
    
    private void bestellungUebersicht() {
        this.getContentPane().removeAll();
        this.repaint();
        JLabel welcomeLabel = new JLabel("<html>Vielen Dank für Ihre Bestellung und willkommen zurück! Hier können Sie Ihre aktuelle Bestellung und deren Produktionsstatus einsehen.</html>");
        JLabel label_bestellUebersicht = new JLabel("");
        JButton button_bestelluebersicht = new JButton("Bestellübersicht anzeigen");
        JButton button_lageruebersicht = new JButton("Lagerübersicht anzeigen");
        JLabel label_lagerUebersicht = new JLabel("");

        button_bestelluebersicht.addActionListener ((arg) -> {
            String bestellUebersicht = controller.gibBestellInformationen();
            label_bestellUebersicht.setText("<html><br/>" + bestellUebersicht + "</html>");
        });

        button_lageruebersicht.addActionListener ((arg) -> {
            String lagerUebersicht = controller.gibLagerInformationen();
            label_lagerUebersicht.setText("<html><br/>" + lagerUebersicht + "</html>");
        });
        
        welcomeLabel.setBounds(10, 10, 1000, 25);
        button_bestelluebersicht.setBounds(10, 50, 200, 30);
        label_bestellUebersicht.setBounds(10, 60, 1000, 300);
        button_lageruebersicht.setBounds(250, 50, 200, 30);
        label_lagerUebersicht.setBounds(10, 200, 1000, 300);
        
        this.add(welcomeLabel);
        this.add(button_bestelluebersicht);
        this.add(label_bestellUebersicht);
        this.add(button_lageruebersicht);
        this.add(label_lagerUebersicht);
        
        this.setVisible(true);
    }
        
    /**
     * 'Startseite'-Funktion: Zeigt die Startseite an
     */
    private void startseiteAnzeigen() {
        this.getContentPane().removeAll();
        this.repaint();
        
        JLabel welcomeLabel = new JLabel("Willkommen bei AEKI!");
        
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
        
        welcomeLabel.setBounds(10, 50, 1000, 25);
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        welcomeLabel.setForeground(new Color(120, 90, 40));
        label_bild_startseite.setBounds(10, 10, 1000, 750);
        
        this.add(welcomeLabel);
        this.add(label_bild_startseite);
        this.setVisible(true);
    }
    
    /**
     * 'Beenden'-Funktion: Durch diese wird die Anwendung jeweils beendet
     */
    private void beenden() {
        System.exit(0);
    }
    
    /**
     * 'Exit'-Funktion: Durch diese wird die Anwendung jeweils beendet
     */
    private void exitAnzeigen() {
         System.exit(0);
    }
    
    /**
     * 'Das Team'-Funktion: Zeigt einen Überblick über das Team
     */
    private void dasteam() {        
        this.getContentPane().removeAll();
        this.repaint();
        
        JLabel teamLabel = new JLabel("Das AEKI-Team ist 365 Tage im Jahr für Sie da.");
        JLabel timoLabel = new JLabel("Timo Arnold - Produktion");
        JLabel florianneLabel = new JLabel("Florianne Walliser - Sales");
        JLabel timLabel = new JLabel("Tim Ilgenstein - IT");
        JLabel jeffLabel = new JLabel("Jeff Mulavarikkal - Lager");
        JLabel charlotteLabel = new JLabel("Charlotte Müller - Marketing");
        
        // Fügt ein Bild von Timo ein
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
        
        // Fügt ein Bild von Florianne ein
        Image florianneBild = null;
            try {
                florianneBild = ImageIO.read(new File("florianne.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_florianne = new ImageIcon(florianneBild);
            JLabel label_bild_florianne = new JLabel(bild_florianne);
        
        // Fügt ein Bild von Tim ein
        Image timBild = null;
            try {
                timBild = ImageIO.read(new File("tim.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_tim = new ImageIcon(timBild);
            JLabel label_bild_tim = new JLabel(bild_tim);
        
        // Fügt ein Bild von Jeff ein
        Image jeffBild = null;
            try {
                jeffBild = ImageIO.read(new File("jeff.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_jeff = new ImageIcon(jeffBild);
            JLabel label_bild_jeff = new JLabel(bild_jeff);
        
        // Fügt ein Bild von Charlotte ein
        Image charlotteBild = null;
            try {
                charlotteBild = ImageIO.read(new File("charlotte.png"));
            }
            catch (Exception f)
            {
                f.printStackTrace();
                System.exit(1);
            }
            ImageIcon bild_charlotte = new ImageIcon(charlotteBild);
            JLabel label_bild_charlotte = new JLabel(bild_charlotte);
        
        teamLabel.setBounds(50, 50, 1000, 25);
        timoLabel.setBounds(150, 475, 1000, 100);
        florianneLabel.setBounds(650, 475, 1000, 100);
        timLabel.setBounds(1150, 475, 1000, 100);
        jeffLabel.setBounds(405, 825, 1000, 100);
        charlotteLabel.setBounds(905, 825, 1000, 100);
        teamLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        timoLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        florianneLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        timLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        jeffLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        charlotteLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        
        label_bild_timo.setBounds(1, 200, 700, 300);
        label_bild_florianne.setBounds(500, 200, 700, 300);   
        label_bild_tim.setBounds(1000, 200, 700, 300);
        label_bild_jeff.setBounds(250, 550, 700, 300);
        label_bild_charlotte.setBounds(750, 550, 700, 300);
        
        this.add(teamLabel);
        this.add(timoLabel);
        this.add(florianneLabel);
        this.add(timLabel);
        this.add(jeffLabel);
        this.add(charlotteLabel);
        this.add(label_bild_timo);
        this.add(label_bild_florianne);
        this.add(label_bild_tim);
        this.add(label_bild_jeff);
        this.add(label_bild_charlotte);
        this.setVisible(true);
    }
    
    /**
     * 'Geschichte'-Funktion: Zeigt einen Überblick über die Geschichte von AEKI
     */
    private void geschichte() {
        this.getContentPane().removeAll();
        this.repaint();
        
        JFrame frame = new JFrame("Geschichte");
        JLabel titelgeschichteLabel = new JLabel("Hej Jonathan välkommen till aeki.");
        JLabel geschichte1Label = new JLabel("<html>Wir sind schon weit gekommen, seitdem Jonathan Gruss 1943 gegründet hat. Vom kleinen schwedischen Unternehmen, das seine Waren über einen Versandkatalog verkauft hat, ist AEKI zu einem der bekanntesten Einrichtungsmarken der Welt geworden. Heute gibt es hunderte AEKI Einrichtungshäuser rund um den Erdball und es werden noch mehr. Hier finden Sie mehr über unsere faszinierende Geschichte – von den Anfängen bis hin zu unseren heutigen Tätigkeiten.</html>");
        JLabel untertitelgeschichteLabel = new JLabel("Wohnst du noch oder lebst du schon?");
        JLabel geschichte2Label = new JLabel("<html> Unsere Faszination vom Leben zu Hause zeichnet AEKI aus. Jedes Jahr bitten wir Tausende Menschen, uns ihre Gedanken und Emotionen über den Ort mitzuteilen, an dem sie leben. Wir möchten erfahren, was ihr Leben zu Hause besser macht, damit wir Sie dabei unterstützen können. Es ist ein andauerndes Forschungsprojekt, das wichtiger denn je ist </html>");
        
        titelgeschichteLabel.setBounds(50, 25, 1000, 25);
        geschichte1Label.setBounds(50, 50, 1000, 100);
        untertitelgeschichteLabel.setBounds(50, 150, 1000, 100);
        geschichte2Label.setBounds(50, 200, 1000, 100);
        titelgeschichteLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        geschichte1Label.setFont(new Font("Serif", Font.PLAIN, 18));
        untertitelgeschichteLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        geschichte2Label.setFont(new Font("Serif", Font.PLAIN, 18));
        titelgeschichteLabel.setForeground(new Color(120, 90, 40));
        titelgeschichteLabel.setBackground(new Color(100, 20, 70));
        untertitelgeschichteLabel.setForeground(new Color(120, 90, 40));
        untertitelgeschichteLabel.setBackground(new Color(100, 20, 70));
        
        frame.add(geschichte1Label);
        frame.setSize(600,300);
        this.add(titelgeschichteLabel);
        this.add(geschichte1Label);
        this.add(untertitelgeschichteLabel);
        this.add(geschichte2Label);
        
        this.setVisible(true);
    }
    
    /**
     * 'Info'-Funktion: Zeigt Informationen zur Anwendung
     */
    private void zeigeInfo() {
        this.getContentPane().removeAll();
        this.repaint();
        
        JLabel infoLabel = new JLabel("<html>Bitte wenden Sie sich bei Fragen an unseren IT-Kontakt Tim, der unter der folgenden Nummer täglich von 8:00 - 16:00 Uhr erreichbar ist: 0824 67 76</html>");
        
        //hier noch GIF einfügen.
        // Jeff: Kannst du hier evtl helfen? Wenn nicht, machen wir einfach ein Bild draus. :)
        /*URL urlsd;
        try {
            URL urlsd = new URL("https://i.gifer.com/PJxF.gif");
            ImageIcon gif_help = new ImageIcon(urlsd);
            JLabel label_gif_help = new JLabel(gif_help);
        } 
        catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon gif_help = new ImageIcon(urlsd);
        JLabel label_gif_help = new JLabel(gif_help);*/
        
        infoLabel.setBounds(50, 25, 800, 50);
        //label_gif_help.setBounds(5, 20, 66, 66);
        infoLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        this.add(infoLabel);
        //this.add(label_gif_help);
        
        this.setVisible(true);
    }
    }
