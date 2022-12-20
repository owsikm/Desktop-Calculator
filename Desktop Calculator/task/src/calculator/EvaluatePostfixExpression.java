package calculator;

import java.util.Stack;

public class EvaluatePostfixExpression {
    public static double evaluated;

    static double evaluatePostfix(String expPostFixed) {
        Stack<Double> stack = new Stack<>();
        Double val2 = 0.0;

        for (int i = 0; i < expPostFixed.length(); i++) {

            char c = expPostFixed.charAt(i);

            if (c == ' ')
                continue;

            else if (Character.isDigit(c) || c == '.') {
                int n = 0;
                int divider = 1;
                boolean hasDecimal = false;

                while (Character.isDigit(c) || c == '.') {
                    if (c == '.') {
                        hasDecimal = true;
                    } else {
                        if (hasDecimal) {
                            divider *= 10;
                        }
                        n = n * 10 + (c - '0');
                    }
                    i++;
                    c = expPostFixed.charAt(i);
                }

                i--;
                stack.push((double) n / divider);
            } else {
                Double val1 = stack.pop();
                if (c == '\u221A') {
                } else {
                    if (stack.size() == 0) {
                        stack.push(0.0);
                    }
                    val2 = stack.pop();
                }

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;

                    case '*':
                        stack.push(val2 * val1);
                        break;

                    case '\u221A':
                        stack.push(Math.sqrt(val1));
                        break;

                    case '^':
                        if (val2 == 0) {
                            stack.push(Math.pow(2, val1));
                        }
                        stack.push(Math.pow(val2, val1));
                        break;
                }
            }
        }
        return stack.pop();
    }

    public EvaluatePostfixExpression(String expPostFixed) {
        evaluated = (evaluatePostfix(expPostFixed));
        System.out.println(evaluated);
    }
}
