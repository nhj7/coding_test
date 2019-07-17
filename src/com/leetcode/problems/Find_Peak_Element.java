package com.leetcode.problems;

public class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if( nums.length == 1 ) return 0;
        int i = 0;
        while (nums[i] < nums[i+1]) {
            i++;
            if( nums.length == i+1) break;
        }
        return i;
    }

    public static void main(String[] args) {
        Find_Peak_Element o = new Find_Peak_Element();
        o.findPeakElement(
                new int[]{ 1,2,1,3,5,6,4 }
        );
    }
}
