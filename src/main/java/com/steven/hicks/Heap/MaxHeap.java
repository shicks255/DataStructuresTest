package com.steven.hicks.Heap;

import java.util.Arrays;

public class MaxHeap
{
    int[] heap;
    int count;

    public MaxHeap()
    {
        heap = new int[10];
        count = 0;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(heap);
    }

    public void put(int i)
    {
        if (isFull())
            resize();

        heap[count++] = i;
        heapifyUp();
    }
    public void heapifyUp()
    {
        int index = count;
        while (index > 0)
        {
            if (heap[index] > heap[getParentIndex(index)])
                swap(index, getParentIndex(index));
            index--;
        }
    }

    public int pop()
    {
        int temp = heap[0];
        heap[0] = heap[--count];
        heap[count] = 0;

        heapifyDown();
        return temp;
    }

    public void heapifyDown()
    {
        int temp = 0;
        while (temp < count && getLeftChildIndex(temp)<count && getRightChildIndex(temp)<count)
        {
            int lc = heap[getLeftChildIndex(temp)];
            int rc = heap[getRightChildIndex(temp)];

            if (heap[temp] < lc)
                swap(temp, getLeftChildIndex(temp));
            if (heap[temp] < rc)
                swap(temp, getRightChildIndex(temp));
            temp++;
        }
    }

    public boolean isFull()
    {
        return count >= heap.length-1;
    }

    public void resize()
    {
        heap = Arrays.copyOf(heap, heap.length*2);
    }

    public int getParentIndex(int index)
    {
        if (index % 2 == 0)
            return (index/2)-1;
        return index/2;
    }

    public int getLeftChildIndex(int index)
    {
        return (index * 2) + 1;
    }
    public int getRightChildIndex(int index)
    {
        return (index * 2) + 2;
    }

    private void swap(int from, int to)
    {
        int temp = heap[from];
        heap[from] = heap[to];
        heap[to] = temp;
    }
}
