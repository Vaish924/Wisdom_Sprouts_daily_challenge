import java.util.Stack;

public class ReverseStack {

    // Function to insert element at the bottom of stack
    public static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        // Remove top element
        int top = stack.pop();
        // Recursive call
        insertAtBottom(stack, item);
        // Push the top back after inserting at bottom
        stack.push(top);
    }

    // Function to reverse the stack
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // Remove top element
        int top = stack.pop();
        // Recursive call to reverse the rest of stack
        reverse(stack);
        // Insert the removed element at bottom
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        reverse(stack);

        System.out.println("Reversed Stack: " + stack);
    }
}
