package models;

import java.util.Stack;

public class GenericStackClass<T> {
    private Stack<T> stack;

    public GenericStackClass() {}

    public Stack<T> getStack() {
        return stack;
    }

    public void setStack(Stack<T> stack) {
        this.stack = stack;
    }
}
