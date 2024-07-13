package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Recursion {
    private JFrame frame;
    private JTextField numberField;
    private JTextArea productArea;
    private double product;
    private int count;
    private JButton enterButton;

    public Recursion() {
        createGUI();
    }

    // GUI components
    private void createGUI() {
        // JFrame for application
        frame = new JFrame("Recursion Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for top section of frame
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        // Labels, text fields, buttons for user input
        JLabel numberLabel = new JLabel("Individually enter 5 numbers:");
        numberField = new JTextField(10);
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener());

        // Top panel
        topPanel.add(numberLabel);
        topPanel.add(numberField);
        topPanel.add(enterButton);

        // Displayed results area
        productArea = new JTextArea(10, 20); // Rows, columns
        productArea.setEditable(false);

        // Border for displayed results area
        productArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // Top, left, bottom, right
                BorderFactory.createLineBorder(Color.GRAY)
        ));

        // JFrame layout
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(productArea), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    // Action listener for "Enter" button
    private class EnterButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Get user input
            double num = Double.parseDouble(numberField.getText());
            numberField.setText(""); // Clear text field after input

            // Recursion to calculate product of numbers
            product = calculateProduct(count, num);
            count++;

            // Display intermediate results
            productArea.append(" Entry #" + count + " is: " + num + "\n");

            // Check if all numbers entered
            if (count == 5) {
                productArea.append(" The product of these numbers is: " + product);
                enterButton.setEnabled(false); // Disable "Enter" button after 5 inputs
            }
            numberField.selectAll();
            numberField.requestFocus();
        }
    }

    // Recursive method to calculate product
    private double calculateProduct(int count, double num) {
        if (count == 0) { // Base case
            return num;
        } else {
            return num * calculateProduct(count - 1, num); // Recursive case
        }
    }

    // Main
    public static void main(String[] args) {
        new Recursion();
    }
}



