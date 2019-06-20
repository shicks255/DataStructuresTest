package com.steven.hicks.sorting;

import java.util.Arrays;

public class HeapSort
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

        int counter = nums.length-1;
        for (int i = 0; i < nums.length; i++)
        {
            swap(nums, 0, counter);
            heapifyDown(nums, counter--);
        }
    }

    public static void heapifyUp(int[] nums)
    {
        int current = nums.length-1;
        while (current > 0)
        {
            if (nums[current] > nums[getParent(current)])
                swap(nums, current, getParent(current));
            current--;
        }
    }

    public static void heapifyDown(int[] nums, int counter)
    {
        int current = 0;
        while (current < counter && getLeftChild(current) < counter && getRightChild(current) < counter)
        {
            int lc = nums[getLeftChild(current)];
            int rc = nums[getRightChild(current)];

            if (nums[current] < lc)
                swap(nums, current, getLeftChild(current));
            if (nums[current] < rc)
                swap(nums, current, getRightChild(current));
            current++;
        }
    }

    public static int getParent(int index)
    {
        if (index % 2 == 0)
            return (index/2)-1;
        return index/2;
    }

    public static int getLeftChild(int index)
    {
        return (index*2) + 1;
    }

    public static int getRightChild(int index)
    {
        return (index * 2) + 2;
    }

    private static void swap(int[] nums, int from, int to)
    {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
