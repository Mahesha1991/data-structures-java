package org.mahesha.heap;

public class HeapOps {

    int[] minHeap;
    int capacity;
    int size;

    public HeapOps(int length) {
        minHeap = new int[length + 1];
        capacity = length;
    }

//    public void push(int val){
//
//        minHeap.add(val);
//        int i = minHeap.size() - 1;
//
//        while(i > 1 && minHeap.get(i) < minHeap.get(i/2)){
//            int temp = minHeap.get(i);
//            minHeap.set(i, minHeap.get(i/2));
//            minHeap.set(i/2, temp);
//            i = i / 2;
//        }
//
//    }


    public int getLeftChild(int i) {
        return i * 2 + 1;
    }

    public int getRightChild(int i) {
        return i * 2 + 2;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

    public void print() {
        int size = minHeap.length - 1;
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(minHeap[i] + " ");
        }
        System.out.println();
    }

//    public void insert(int ele){
//
//        if(size < capacity){
//            minHeap[size] = ele;
//            size++;
//            return;
//        }
//        minHeap[capacity] = ele;
//
//        for(int i = capacity; i != 0 && minHeap[i] < minHeap[getParent(i)]; i = getParent(i)){
//            swap(i, getParent(i));
//        }
//
//    }

    private void swap(int i, int parent) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[parent];
        minHeap[parent] = temp;
    }

    public void heapify(int i) {

        int leftChild = getLeftChild(i);
        int righChild = getRightChild(i);
        int small = i;
        if (leftChild < size && minHeap[leftChild] < minHeap[small]) {
            small = leftChild;
        }
        if (righChild < size && minHeap[righChild] < minHeap[small]) {
            small = righChild;
        }
        if (small != i) {
            swap(i, small);
            heapify(small);
        }

    }

    public int deleteFirst() {
        int size = minHeap.length - 1;
        if (size == 0) {
            return -1;
        }
        if (size == 1) {
            size = 0;
            return minHeap[0];
        }
        int min = minHeap[0];
        swap(0, size - 1);
        size--;
        heapify(0);
        return min;
    }


}
