import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Beschrieb noch einfügen
 */

public class GuiSpringLayout {

    private final GUIController controller;
    
    /**
     * Konstruktor für die Klasse GuiSpringLayout.
     */
    public GuiSpringLayout(GUIController controller) {
        this.controller = controller;
        createWindow();
    }
    
    public static void main(String[] args) {
    //to do
    }

    /**
     * Die Methode createWindow kümmert sich um den Aufbau der grafischen Oberfläche.
     * Die Klasse hat eine Instanzvariable vom Typ JFrame, die eine Referenz auf das Fenster hält, das auf dem Bildschirm angezeigt werden möchten.
     */
    private void createWindow() {
        JFrame frame = new JFrame("Fabrik mit SpringLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
            String status = controller.onOrder(produkt, name);
            System.out.println(status);
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
