package com.dsa.dsa_social_api.dsa;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {

    private List<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }
}
