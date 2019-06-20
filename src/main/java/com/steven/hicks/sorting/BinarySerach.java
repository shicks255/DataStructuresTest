package com.steven.hicks.sorting;

import java.util.Arrays;

public class BinarySerach
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{9,40,15,12,5,2,33,6,7,8};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(binarySearch(nums, 40));
    }

    public static int binarySearch(int[] nums, int value)
    {
        int left = 0;
        int right = nums.length-1;

        while (left <= right)
        {
           int mid = (right+left)/2;

           if (nums[mid] == value)
               return mid;

           if (value > nums[mid])
               left = mid+1;
           if (value < nums[mid])
               right = mid-1;
        }

        return -1;
    }
}
