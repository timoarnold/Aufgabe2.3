import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.MediaTracker;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JTextField;

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
        
        // Action listener zu button hinzufügen, der dann auf Kopfdruck durch contentPanecontroller.onOrder eine Bestellung erstellt
        // Zudem wird die bestellBestaetigung upgedated
        senden_knopf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int stuehle = Integer.parseInt(textfield_stuehle.getText());
                int sofas = Integer.parseInt(textfield_sofas.getText());
                String status = controller.onOrder(stuehle, sofas);
                label_bestellBestaetigung.setText(status);
            }
        });
        
        // Action listener mit Lambda Funktion () -> {}
        button_refreshstatus.addActionListener (arg0 -> {
            String status = controller.gibtZustand();
            label_status.setText(status);
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
    
    /**
     * Die folgende Klasse wird gebraucht, um ein Bild einzufügen.
     */
    // class BackGroundPane extends JPanel {
    //    Image img = null;

    //    BackGroundPane(String imagefile)
    //    {
    //        if (imagefile != null) {
    //            MediaTracker mt = new MediaTracker(this);
    //            img = Toolkit.getDefaultToolkit().getImage(imagefile);
    //            mt.addImage(img, 0);
    //            try {
    //                mt.waitForAll();
    //            } catch (InterruptedException e) {
    //                e.printStackTrace();
               }
    //       }
     //   }

    //    protected void paintComponent(Graphics g)
    //    {
     //       super.paintComponent(g);
     //       g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
     //   }
   // }
//}
