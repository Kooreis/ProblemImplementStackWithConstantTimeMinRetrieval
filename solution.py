Here is a Python console application that implements a stack with a function to retrieve the minimum element in constant time.

```python
class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, x):
        self.stack.append(x)
        if not self.min_stack or x <= self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self):
        if self.stack:
            if self.stack[-1] == self.min_stack[-1]:
                self.min_stack.pop()
            return self.stack.pop()

    def top(self):
        if self.stack:
            return self.stack[-1]

    def getMin(self):
        if self.min_stack:
            return self.min_stack[-1]


def main():
    min_stack = MinStack()
    min_stack.push(-2)
    min_stack.push(0)
    min_stack.push(-3)
    print(min_stack.getMin())  # Returns -3
    min_stack.pop()
    print(min_stack.top())  # Returns 0
    print(min_stack.getMin())  # Returns -2


if __name__ == "__main__":
    main()
```

This program creates a stack that supports push, pop, top, and getMin operations. The getMin operation retrieves the minimum element in the stack in constant time. This is achieved by maintaining a separate stack (min_stack) that keeps track of the minimum element at each state of the main stack. When a new element is pushed onto the main stack, if it is less than or equal to the current minimum, it is also pushed onto the min_stack. When an element is popped from the main stack, if it is equal to the current minimum, it is also popped from the min_stack. This ensures that the top of the min_stack always contains the minimum element of the main stack.