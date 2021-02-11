package models;

import java.util.Queue;

public class GenericQueueClass<T> {
    private Queue<T> queue;

    public GenericQueueClass() {}

    public Queue<T> getQueue() {
        return queue;
    }

    public void setQueue(Queue<T> queue) {
        this.queue = queue;
    }
}
