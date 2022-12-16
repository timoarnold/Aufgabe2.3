import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JTextField;

/**
 * Write a description of class GUI here.
 *
 * @author Gruppe 29
 * @version 4.1 (31. Dezember)
 */
public class GUI extends JFrame
{ 
    private final GUIController controller;

    public GUI(GUIController controller){
        this.controller = controller;
        initWindow();
    }

    protected void initWindow() 
    {
        JLabel welcomeLabel = new JLabel("Willkommen bei Aeki!");
        //WIP
        
        // GUI öffnen
        // Sobald  das Fenster vollständig konstruiert ist, kann es mit setVisible im kompletten Zustand angezeigt werden.
        setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(370,250);
        this.setVisible(true);
    }
}
