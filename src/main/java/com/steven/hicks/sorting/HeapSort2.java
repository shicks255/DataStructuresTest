package com.steven.hicks.sorting;

import java.util.Arrays;

public class HeapSort2
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{9,40,15,12,5,2,33,6,7,8};
        System.out.println(Arrays.toString(nums));
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums)
    {
        heapifyUp(nums);

        int swapper = nums.length-1;
        for (int i = 0; i < nums.length; i++)
        {
            swap(nums, 0, swapper);
            heapifyDown(nums, swapper--);
        }
    }

    public static int getParent(int index)
    {
        if (index % 2 == 0)
            return (index/2)-1;
        return index/2;
    }

    public static int getRightChild(int index)
    {
        return (index * 2)+2;
    }

    public static int getLeftChild(int index)
    {
        return (index * 2)+1;
    }

    public static void heapifyUp(int[] nums)
    {
        int pointer = nums.length-1;

        while (pointer > 0)
        {
            if (nums[pointer] > nums[getParent(pointer)])
                swap(nums, pointer, getParent(pointer));

            pointer--;
        }
    }

    public static void heapifyDown(int[] nums, int length)
    {
        int pointer = 0;
        while (pointer < length && getLeftChild(pointer) < length && getRightChild(pointer) < length)
        {
            if (nums[pointer] < nums[getLeftChild(pointer)])
                swap(nums, pointer, getLeftChild(pointer));
            if (nums[pointer] < nums[getRightChild(pointer)])
                swap(nums, pointer, getRightChild(pointer));
            pointer++;
        }
    }

    public static void swap(int[] nums, int from, int to)
    {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
