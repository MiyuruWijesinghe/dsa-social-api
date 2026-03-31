package com.dsa.dsa_social_api.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class CustomQueue<T> {

    private Queue<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.poll(); // removes first (FIFO)
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        return queue.peek();
    }
}
