package com.steven.hicks.Heap;

public class Driver
{
    public static void main(String[] args)
    {
        MaxHeap heap = new MaxHeap();

        heap.put(1);
        heap.put(2);
        heap.put(3);
        heap.put(4);
        heap.put(5);
        heap.put(6);
        heap.put(7);
        heap.put(9);
        heap.put(10);
        heap.put(12);
        heap.put(11);

        System.out.println(heap);
        System.out.println(heap.count);

        heap.pop();
        System.out.println(heap);
        System.out.println(heap.count);
    }

}
