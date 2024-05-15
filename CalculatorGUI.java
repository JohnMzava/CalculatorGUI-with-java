import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField num1Field, num2Field, resultField;
    private JButton btnAdd, btnSubtract, btnMultiply, btnDivide;

    public CalculatorGUI() {
        super("Calculator");
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Text fields for numbers and result
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        // Buttons for operations
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivide = new JButton("/");

        // Add components to the frame
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Number 1: "), c);
        c.gridy = 1;
        add(num1Field, c);
        c.gridy = 2;
        add(new JLabel("Number 2: "), c);
        c.gridy = 3;
        add(num2Field, c);
        c.gridy = 4;
        add(new JLabel("Result: "), c);
        c.gridy = 5;
        add(resultField, c);

        c.gridx = 1;
        c.gridy = 2;
        add(btnAdd, c);
        c.gridy = 3;
        add(btnSubtract, c);
        c.gridy = 4;
        add(btnMultiply, c);
        c.gridy = 5;
        add(btnDivide, c);

        // Add action listeners to buttons
        btnAdd.addActionListener(this);
        btnSubtract.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);

        // Set size and make it visible
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1, num2, result;
        try {
            num1 = Double.parseDouble(num1Field.getText());
            num2 = Double.parseDouble(num2Field.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String operation = e.getActionCommand();
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Division by zero is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
                break;
            default:
                result = 0; // Should never happen
        }

        resultField.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}