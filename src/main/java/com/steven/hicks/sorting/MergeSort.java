package com.steven.hicks.sorting;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{9,40,15,12,5,2,33,6,7,8};
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums)
    {
        mergeSort(nums, 0, nums.length-1);
    }

    public static void mergeSort(int[] nums, int left, int right)
    {
        if (left >= right)
            return;

        int half = (left+right)/2;
        mergeSort(nums, left, half);
        mergeSort(nums, half+1, right);
        mergeHalves(nums, left, right);
    }

    public static void mergeHalves(int[] nums, int left, int right)
    {
        int half = (left + right)/2;

        int tempSizeLeft = half-left+1;
        int tempSizeRight = right-half;

        int[] tempArrayLeft = new int[tempSizeLeft];
        int[] tempArrayRight = new int[tempSizeRight];

        for (int i = 0; i < tempSizeLeft; i++)
            tempArrayLeft[i] = nums[left+1];

        for (int i = 0; i < tempSizeRight; i++)
            tempArrayRight[i] = nums[half+i+1];

        int l = 0;
        int r = 0;
        int counter = left;
        while (l<tempSizeLeft && r<tempSizeRight)
        {
            if (tempArrayLeft[l] < tempArrayRight[r])
                nums[left++] = tempArrayLeft[l++];
            else
                nums[left++] = tempArrayRight[r++];
        }

        while (l < tempSizeLeft)
            nums[left++] = tempArrayLeft[l++];
        while (r < tempSizeRight)
            nums[left++] = tempArrayRight[r++];
    }
}
