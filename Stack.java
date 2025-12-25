package project;

public class Stack {
    private int[] array;
    private int top; // Number of elements

    public Stack(int size) {
        array = new int[size];
        top = 0; // Empty stack has 0 elements
    }

    public void push(int item) {
        if (top < array.length) {
            array[top] = item; // Assign to current top index
            top = top + 1;     
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public int pop() {
        if (top > 0) {
            top = top - 1;     // Decrement top first
            return array[top]; // Return the last element
        } else {
            System.out.println("Stack Underflow");
            return 0; // Default value for underflow
        }
    }

    public int peek() {
        if (top > 0) {
            return array[top - 1]; // Return the last element without removing
        } else {
            System.out.println("Stack is empty");
            return 0; // Default value for empty stack
        }
    }

    public boolean isEmpty() {
        return top == 0;
    }
}