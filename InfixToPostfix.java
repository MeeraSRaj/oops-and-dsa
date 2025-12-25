package project;

public class InfixToPostfix {
    private Stack stack;

    public InfixToPostfix(int stackSize) {
        this.stack = new Stack(stackSize);
    }

    private int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    public String convertToPostfix(String infix) {
        stack = new Stack(infix.length()); // initialize stack
        StringBuilder postfix = new StringBuilder();
        int i = 0;

        while (i < infix.length()) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } 
            else if (ch == '(') {
                stack.push(ch);
            } 
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append((char)stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } 
                else {
                    return "Invalid Expression";
                }
            } 
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (!stack.isEmpty() && stack.peek() != '(' && getPrecedence((char)stack.peek()) >= getPrecedence(ch)) {
                    postfix.append((char)stack.pop());
                }
                stack.push(ch);
            }
            i++;
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            postfix.append((char)stack.pop());
        }
        return postfix.toString();
    }
}