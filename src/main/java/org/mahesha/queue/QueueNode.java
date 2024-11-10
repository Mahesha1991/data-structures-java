package org.mahesha.queue;

public class QueueNode<T> {
    T data;
    QueueNode next;

    public QueueNode(T data){
        this.data = data;
        this.next = null;
    }
}
