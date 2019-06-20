package com.steven.hicks.sorting;

import java.util.Arrays;

public class QuickSort2
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{9,40,15,12,5,2,33,6,7,8};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums)
    {
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int[] nums, int left, int right)
    {
        if (left >= right)
            return;

        int pivot = pivot(nums, left, right);
        quickSort(nums, left, pivot-1);
        quickSort(nums, pivot+1, right);
    }

    public static int pivot(int[] nums, int left, int right)
    {
        while (left < right)
        {
            if (nums[left] > nums[right])
            {
                swap(nums, left, right-1);
                swap(nums, right, right-1);
                right--;
            }
            else
                left++;
        }

        return right;
    }

    private static void swap(int[] nums, int from, int to)
    {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
