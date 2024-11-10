package org.mahesha.queue;

public class QueueOps<T> {
    QueueNode front;
    QueueNode back;

    public void insert(T data){
        if(back == null){
            back = front = new QueueNode<T>(data);
            return;
        }
        back.next = new QueueNode<T>(data);
        back = back.next;
    }

    public <T extends Object> T remove(){
        if(front == null){
            return null;
        }
        T temp = (T) front.data;
        front = front.next;
        if (front == null){
            back = null;
        }
        return temp;
    }

    public void display(){
        QueueNode temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
