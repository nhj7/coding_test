package com.leetcode.problems;

import java.util.Arrays;

public class Rotate_Array {
    public void rotate(int[] nums, int k) {
        if( k == 0 || nums.length < 2 ) return;
        int[] newNums = new int[nums.length];
        for(int i = nums.length-1 ; i >= 0 ; i-- ){
            int newIdx = i + k >= nums.length ? (i + k) % nums.length : i + k ;
            newNums[newIdx] = nums[i];
        }

        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Rotate_Array o = new Rotate_Array();
        int[] nums = new int[]{1,2};
        o.rotate(
                nums
                , 0
        );

        for(int i = 0; i < nums.length;i++){
            System.out.println(nums[i]);
        }

        Arrays.copyOf(nums, nums.length);
    }
}
