import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.border.*;

import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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
    
    /**
     * Die Methode createWindow kümmert sich um den Aufbau der grafischen Oberfläche.
     * Die Klasse hat eine Instanzvariable vom Typ JFrame, die eine Referenz auf das Fenster hält, das auf dem Bildschirm angezeigt werden möchte.
     */
    private void createWindow() {
        JFrame frame = new JFrame("Fabrik mit SpringLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * Erzeuge das User Interface samt Inhalt.
     */
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
            //String status = controller.onOrder(sofa, stuhl);
            //System.out.println(status);
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
