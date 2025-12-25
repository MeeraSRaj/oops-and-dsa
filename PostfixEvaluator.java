package project;

public class PostfixEvaluator {
    private Stack stack;

    public PostfixEvaluator(int stackSize) {
        this.stack = new Stack(stackSize);
    }

    public int evaluatePostfix(String postfix) {

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); //subtrcting the ASCII number of zero(48) to get the ASCII number of our character
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                if (stack.isEmpty()) {
                    System.out.println("Invalid Expression: Insufficient operands");
                    return 0;
                }
                int operand2 = stack.pop();
                if (stack.isEmpty()) {
                    System.out.println("Invalid Expression: Insufficient operands");
                    return 0;
                }
                int operand1 = stack.pop();

                int result = 0;
                switch (ch) {
                    case '+': result = operand1 + operand2; break;
                    case '-': result = operand1 - operand2; break;
                    case '*': result = operand1 * operand2; break;
                    case '^': result = operand1 ^ operand2; break;
                    case '/':
                        if (operand2 == 0) {
                            System.out.println("Invalid Expression: Division by zero");
                            return 0;
                        }
                        result = operand1 / operand2;
                        break;
                }
                stack.push(result);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Invalid Expression: No result");
            return 0;
        }
        int result = stack.pop();
        if (!stack.isEmpty()) {
            System.out.println("Invalid Expression: Extra operands");
            return 0;
        }
        return result;
    }
}