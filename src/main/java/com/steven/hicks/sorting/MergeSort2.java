package com.steven.hicks.sorting;

import java.util.Arrays;

public class MergeSort2
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{9,40,15,12,5,2,33,6,7,8};
        System.out.println(Arrays.toString(nums));
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums, int left, int right)
    {
        if (left >= right)
            return;

        int mid = (left+right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        mergeHalves(nums, left, right);
    }

    private static void mergeHalves(int[] nums, int left, int right)
    {
        int mid = (left+right)/2;

        int leftSize = mid-left+1;
        int rightSize = right-mid;

        int[] tempLeft = new int[leftSize];
        for (int i = 0; i < leftSize; i++)
            tempLeft[i] = nums[left+i];

        int[] tempRight = new int[rightSize];
        for (int i = 0; i < rightSize; i++)
            tempRight[i] = nums[mid+1+i];

        int l = 0;
        int r = 0;
        int counter = left;

        while (l < leftSize && r < rightSize)
        {
            if (tempLeft[l] < tempRight[r])
                nums[counter] = tempLeft[l++];
            else
                nums[counter] = tempRight[r++];
            counter++;
        }

        while (l < leftSize)
            nums[counter++] = tempLeft[l++];
        while (r < rightSize)
            nums[counter++] = tempRight[r++];
    }

}
