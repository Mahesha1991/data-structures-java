package org.mahesha.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapMain {

    public static void main(String[] args) {
        HeapOps heapOps = new HeapOps(3);

//        heapOps.insert(5);
//        heapOps.insert(8);
//        heapOps.insert(9);
//        heapOps.insert(1);
//        heapOps.insert(2);
//        heapOps.insert(4);

        PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());

        pq.offer(8);
        pq.offer(6);
        pq.offer(1);
        pq.offer(9);
        pq.offer(4);
        pq.offer(3);

        System.out.println(pq);

       // heapOps.push(8);
        heapOps.print();

    }

}
