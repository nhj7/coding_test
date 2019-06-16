package com.leetcode.problems;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if( nums.length==0) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        int cntTmp = 0;
        for(int i = 0; i < nums.length-1;i++){
            if( nums[i] + 1 == nums[i+1]){
                cntTmp++;
                if( cntTmp > cnt ){
                    cnt = cntTmp;
                }
            }else if( nums[i] == nums[i+1] ){
                continue;
            }else{
                cntTmp = 0;
            }
        }
        //System.out.println("cntTmp = " + cntTmp);
        return cnt+1;
    }

    public static void main(String[] args) {
        Longest_Consecutive_Sequence o = new Longest_Consecutive_Sequence();
        int r = o.longestConsecutive(
                new int[]{
                    1,2,0,1
                }
        );

        System.out.println("r = " + r);
    }
}
