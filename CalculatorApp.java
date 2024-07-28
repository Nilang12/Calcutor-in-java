import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp {
    private JFrame frame;
    private JTextField display;
    private double number1, number2, result;
    private char operation;

    public CalculatorApp() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Calculator App");
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        frame.add(panel, BorderLayout.CENTER);

        String[] buttons = {"7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "0", ".", "=", "+"};

        for (String button : buttons) {
            JButton jButton = new JButton(button);
            jButton.addActionListener(new ButtonListener());
            panel.add(jButton);
        }

        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ClearButtonListener());
        frame.add(clearButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                number1 = Double.parseDouble(display.getText());
                operation = command.charAt(0);
                display.setText("");
            } else if (command.equals("=")) {
                number2 = Double.parseDouble(display.getText());
                calculate();
            } else {
                display.setText(display.getText() + command);
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText("");
            number1 = 0;
            number2 = 0;
            result = 0;
        }
    }

    private void calculate() {
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
        }
        display.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}