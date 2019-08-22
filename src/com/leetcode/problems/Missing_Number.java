package com.leetcode.problems;

import java.util.Arrays;

public class Missing_Number {
    /*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

    Example 1:

    Input: [3,0,1]
    Output: 2
    Example 2:

    Input: [9,6,4,2,3,5,7,0,1]
    Output: 8
    Note:
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */
    public int missingNumber(int[] nums) {
        int t = 0, i = 0;
        for( ; i < nums.length ; i++)
            t += nums[i] - i;
        return i-t;
    }

    public int missingNumber3(int[] nums) {
        int[] newNums = new int[nums.length+1];
        for(int i = 0; i < nums.length;i++){
            newNums[nums[i]] = nums[i]+1;
        }
        for(int i = 0; i < newNums.length;i++){
            if( newNums[i] != i+1 ) return i;
        }
        return newNums[newNums.length-1]+1;
    }

    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            if( nums[i] != i )
                return i;
        }
        return nums[nums.length-1]+1;
    }
    public static void main(String[] args) {
        
        int[] a = new int[2];
        
        a[1] = 2;

        System.out.println("a[0] = " + a[0]);
        
        Missing_Number o = new Missing_Number();
        int r = o.missingNumber( new int[] { 1 } );
        System.out.println("r = " + r);
    }
}
