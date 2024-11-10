package org.mahesha.queue;

import org.mahesha.RandomGenerator;

public class QueueMain {

    public static void main(String[] args) {
        QueueOps ops = new QueueOps();

        for(int i = 0; i < 6; i++){
            ops.insert(RandomGenerator.generateNumber(10, 140));
        }

        ops.display();

        ops.remove();
        ops.remove();
        ops.remove();
        ops.remove();
        ops.remove();
        System.out.println();
        ops.display();

        for(int i = 0; i < 6; i++){
            ops.insert(RandomGenerator.generateNumber(10, 140));
        }

        System.out.println();
        ops.display();
    }
}
