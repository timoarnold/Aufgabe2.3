import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.MediaTracker;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JTextField;

/**
 * Write a description of class GUI here.
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
        
        senden_knopf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) { //addActionListener --> was passiert wenn der Button gedrückt wird
                int stuehle = Integer.parseInt(textfield_stuehle.getText()); //Textfelder werden ausgelesen (ist eine Anzahl --> Integer)
                int sofas = Integer.parseInt(textfield_sofas.getText()); //Text der vom Kunden eingefügt wurde, kann geholt werden
               // String status = controller.onOrder(breads, name); //methode wird aufgerufen, Bestellung wird über den Controller bestellt
               // label_bestellBestaetigung.setText(status); //neuer text definieren
            }
        });
        
        // button_refreshstatus.addActionListener (arg0 -> { //addActionListener --> was passiert wenn der Button gedrückt wird
        // String status = controller.onStatus();
        // label_bakerystatus.setText(status);
        //});

        // Positionieren
        label_stuehle.setBounds(10, 50, 1000, 25);
        textfield_stuehle.setBounds(180, 50, 100, 25);
        label_sofas.setBounds(10,80, 100, 25);
        textfield_sofas.setBounds(180,80,100,25);
        welcomeLabel.setBounds(10, 10, 1000, 25);
        label_bestellBestaetigung.setBounds(10,110, 1000, 25);
        //label_bakerystatus.setBounds(10,140, 400, 25);
        senden_knopf.setBounds(10,170,150,30);
        button_refreshstatus.setBounds(190,170,150,30);

        // Alle Elemente zum panel hinzufügen --> wird zur Superklasse hinzugefügt
        this.add(welcomeLabel);
        this.add(label_stuehle);
        this.add(label_sofas);
        this.add(label_bestellBestaetigung);
        //this.add(label_bakerystatus);
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
