package calculator;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static calculator.EvaluatePostfixExpression.evaluated;

public class Calculator extends JFrame {
    boolean removeOperandBefore = false;

    public Calculator() {

        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Calculator");
        setName("Calculator");
        setVisible(true);

        JLabel EquationLabel = new JLabel();
        EquationLabel.setBounds(30, 40, 250, 30);
        EquationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        EquationLabel.setForeground(Color.GREEN);
        EquationLabel.setName("EquationLabel");
        add(EquationLabel);

        JLabel ResultLabel = new JLabel();
        ResultLabel.setBounds(30, 5, 250, 50);
        ResultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ResultLabel.setName("ResultLabel");
        Font font = new Font("Courier", Font.BOLD, 30);
        ResultLabel.setFont(font);
        ResultLabel.setFont(ResultLabel.getFont().deriveFont(26f));
        add(ResultLabel);

        JButton one = new JButton("1");
        one.setBounds(40, 440, 60, 50);
        one.setName("One");
        add(one);
        one.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "1");
        });

        JButton two = new JButton("2");
        two.setBounds(110, 440, 60, 50);
        two.setName("Two");
        add(two);
        two.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "2");
        });

        JButton three = new JButton("3");
        three.setBounds(180, 440, 60, 50);
        three.setName("Three");
        add(three);
        three.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "3");
        });

        JButton four = new JButton("4");
        four.setBounds(40, 370, 60, 50);
        four.setName("Four");
        add(four);
        four.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "4");
        });

        JButton five = new JButton("5");
        five.setBounds(110, 370, 60, 50);
        five.setName("Five");
        add(five);
        five.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "5");
        });

        JButton six = new JButton("6");
        six.setBounds(180, 370, 60, 50);
        six.setName("Six");
        add(six);
        six.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "6");
        });

        JButton seven = new JButton("7");
        seven.setBounds(40, 300, 60, 50);
        seven.setName("Seven");
        add(seven);
        seven.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "7");
        });

        JButton eight = new JButton("8");
        eight.setBounds(110, 300, 60, 50);
        eight.setName("Eight");
        add(eight);
        eight.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "8");
        });

        JButton nine = new JButton("9");
        nine.setBounds(180, 300, 60, 50);
        nine.setName("Nine");
        add(nine);
        nine.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "9");
        });

        JButton zero = new JButton("0");
        zero.setBounds(110, 510, 60, 50);
        zero.setName("Zero");
        add(zero);
        zero.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + "0");
        });

        JButton Equals = new JButton("=");
        Equals.setBounds(250, 510, 60, 50);
        Equals.setName("Equals");
        add(Equals);

        JButton Divide = new JButton("\u00F7");
        Divide.setBounds(250, 230, 60, 50);
        Divide.setName("Divide");
        add(Divide);
        Divide.addActionListener(e -> {
            removeOperandBefore = true;
            String str = EquationLabel.getText();
            str = stringCheck(str);
            if (!EquationLabel.getText().isEmpty()) {
                EquationLabel.setText(str + "\u00F7");
            }
        });

        JButton Multiply = new JButton("\u00D7");
        Multiply.setBounds(250, 300, 60, 50);
        Multiply.setName("Multiply");
        add(Multiply);
        Multiply.addActionListener(e -> {
            removeOperandBefore = true;
            String str = EquationLabel.getText();
            str = stringCheck(str);
            if (!EquationLabel.getText().isEmpty()) {
                EquationLabel.setText(str + "\u00D7");
            }
        });

        JButton Add = new JButton("\u002B");
        Add.setBounds(250, 440, 60, 50);
        Add.setName("Add");
        add(Add);
        Add.addActionListener(e -> {
            removeOperandBefore = true;
            String str = EquationLabel.getText();
            str = stringCheck(str);
            if (!EquationLabel.getText().isEmpty()) {
                EquationLabel.setText(str + "\u002B");
            }
        });

        JButton Subtract = new JButton("-");
        Subtract.setBounds(250, 370, 60, 50);
        Subtract.setName("Subtract");
        add(Subtract);
        Subtract.addActionListener(e -> {
            removeOperandBefore = true;
            String str = EquationLabel.getText();
            str = stringCheck(str);
            if (!EquationLabel.getText().isEmpty())
                EquationLabel.setText(str + "-");
        });

        JButton Clear = new JButton("C");
        Clear.setBounds(180, 160, 60, 50);
        Clear.setName("Clear");
        add(Clear);
        Clear.addActionListener(e -> {
            EquationLabel.setText("");
            ResultLabel.setText("");
        });

        JButton Delete = new JButton("DEL");
        Delete.setBounds(250, 160, 60, 50);
        Delete.setName("Delete");
        add(Delete);
        Delete.addActionListener(e -> {
            String str = EquationLabel.getText();
            if (!EquationLabel.getText().isEmpty())
                EquationLabel.setText(str.substring(0, str.length() - 1));
        });

        JButton Parentheses = new JButton("( )");
        Parentheses.setBounds(40, 160, 60, 50);
        Parentheses.setName("Parentheses");
        add(Parentheses);
        Parentheses.addActionListener(e -> {
            removeOperandBefore = false;
            String str = EquationLabel.getText();
            str = stringCheck(str);
            if (str.endsWith("(") || str.isEmpty() || str.endsWith("\u00F7")
                    || str.endsWith("\u00D7") || str.endsWith("\u002B")
                    || str.endsWith("-")) {
                EquationLabel.setText(str + "(");
            } else {
                EquationLabel.setText(str + ")");
            }
        });

        JButton CE = new JButton("CE");
        CE.setBounds(110, 160, 60, 50);
        CE.setName("CE");
        add(CE);

        JButton PowerTwo = new JButton("X^2");
        PowerTwo.setBounds(40, 230, 60, 50);
        PowerTwo.setName("PowerTwo");
        add(PowerTwo);
        PowerTwo.addActionListener(e -> {
            String str = EquationLabel.getText();
            str = stringCheck(str);
            if (!EquationLabel.getText().isEmpty()) {
                EquationLabel.setText(str + "^(2)");
            }
        });

        JButton PowerY = new JButton("x^y");
        PowerY.setBounds(110, 230, 60, 50);
        PowerY.setName("PowerY");
        add(PowerY);

        JButton SquareRoot = new JButton("\u221A");
        SquareRoot.setBounds(180, 230, 60, 50);
        SquareRoot.setName("SquareRoot");
        add(SquareRoot);
        SquareRoot.addActionListener(e -> {
            removeOperandBefore = false;
            String str = EquationLabel.getText();
            str = stringCheck(str);
            EquationLabel.setText(str + "\u221A" + "(");
        });

        JButton PlusMinus = new JButton("+-");
        PlusMinus.setBounds(40, 510, 60, 50);
        PlusMinus.setName("PlusMinus");
        add(PlusMinus);
        PlusMinus.addActionListener(e -> {
            String str = EquationLabel.getText();
            str = stringCheck(str);
            if (str.startsWith("-")) {
                str = str.replaceFirst("-", "\u002B");
            } else if (str.startsWith("(-")) {
                str = str.replaceFirst("\\(" + "-", "");
            } else if (str.startsWith("\u002B")) {
                str = str.replaceFirst("\\u002B", "-");
            } else if (str.startsWith("(" + "\u002B")) {
                str = str.replaceFirst(("\\(" + "\\u002B"), "(-");
            } else if (str.startsWith("(")) {
                str = str.replaceFirst("\\(", "(-");
            } else if (str.isEmpty()) {
                str = "(-";
            } else {
                str = "(-" + str;
            }
            EquationLabel.setText(str);
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(180, 510, 60, 50);
        Dot.setName("Dot");
        add(Dot);
        Dot.addActionListener(e -> {
            String str = EquationLabel.getText();
            EquationLabel.setText(str + ".");
        });

        Equals.addActionListener(e -> {
            String str = EquationLabel.getText();
            str = str.replace('\u00D7', '*');
            str = str.replace('\u00F7', '/');
            if (str.contains("/0")) {
                EquationLabel.setForeground(Color.RED.darker());
            }
            char strEnd = (str.substring(str.length() - 1)).charAt(0);
            if ((!Character.isDigit(strEnd)) && !(str.endsWith(")")))
                EquationLabel.setForeground(Color.RED.darker());
            else {
                System.out.println(str);
                new ConvertToPostfix(str);

                DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
                DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);

                ResultLabel.setText(df.format(evaluated));
            }

        });
    }

    public String stringCheck(String str) {
        if (str.matches("\\w*")) {
            return str;
        } else if (str.charAt(0) == '.') {
            str = str.replace(".", "0.");
        }
        for (int i = 2; i < str.length() - 1; i++) {
            if (str.charAt(i) == '.' && !Character.isDigit(str.charAt(i - 1))) {
                System.out.println(str.charAt(i));
                System.out.println(str.charAt(i - 1));
                System.out.println(!Character.isDigit(str.charAt(i - 1)));
                StringBuilder newStr = new StringBuilder(str);
                char[] cArr = {'0'};
                StringBuilder temp = newStr.insert(i, cArr, 0, 1);
                System.out.println(temp);
                str = String.valueOf(newStr);
            }
        }
        char strEnd = (str.substring(str.length() - 1)).charAt(0);
        String text;
        if (str.endsWith(".")) {
            str = str + '0';
        }
        if ((removeOperandBefore) && (str.endsWith("\u00D7") || str.endsWith("\u002B")
                || str.endsWith("\u00F7"))) {
            str = str.substring(0, str.length() - 1);
        }
        if (!Character.isDigit(strEnd) && str.endsWith(".")) {
            text = str.substring(0, str.length() - 1);
        } else text = str;
        return text;
    }

    public static void main(String[] args) throws Exception {
        Runnable initFrame = ApplicationRunner::new;
        SwingUtilities.invokeAndWait(initFrame);
    }
}
