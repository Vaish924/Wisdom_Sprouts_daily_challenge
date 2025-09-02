import java.util.*;

public class PostfixEvaluation {
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        for (String token : expr.split(" ")) {
            if ("+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String input = "2 1 + 3 *";
        System.out.println(evaluatePostfix(input));
    }
}
