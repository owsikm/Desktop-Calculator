package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

class ConvertToPostfix {

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
            case '\u221A':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String str) {
        StringBuilder result = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            char e = '1';

            if (i < str.length() - 1) {
                e = str.charAt(i + 1);
            }

            if (Character.isLetterOrDigit(e) && ('.' == (c))) {
                result.append(c);
            } else if (Character.isLetterOrDigit(c) && '.' == (e)) {
                result.append(c);
            } else if (Character.isLetterOrDigit(c) && (!Character.isLetterOrDigit(e))) {
                result.append(c).append(" ");
            } else if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(')
                stack.push(c);

            else if (c == ')') {
                while (!stack.isEmpty()
                        && stack.peek() != '(') {
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && Prec(c) <= Prec(stack.peek())) {

                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.peek());
            stack.pop();
        }
        System.out.println(result);

        return result.toString();
    }

    public ConvertToPostfix(String str) {
        String expPostFixed = (infixToPostfix(str));
        new EvaluatePostfixExpression(expPostFixed);
    }
}
