Here is a Java console application that implements a stack with a function to retrieve the minimum element in constant time.

```java
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());     // Returns 0.
        System.out.println(minStack.getMin());  // Returns -2.
    }
}
```

This program uses two stacks: one to store all the elements (the `stack`), and another to store the minimum elements (the `minStack`). The top of the `minStack` always contains the current minimum element. When a new element is pushed onto the `stack`, if it is less than or equal to the current minimum, it is also pushed onto the `minStack`. When an element is popped from the `stack`, if it is the current minimum, it is also popped from the `minStack`. This ensures that the `minStack` always contains the minimum elements in the order they were encountered, so the current minimum can be retrieved in constant time by calling `peek()` on the `minStack`.