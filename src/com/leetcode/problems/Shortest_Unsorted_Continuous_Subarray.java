package com.leetcode.problems;

import java.util.*;

public class Shortest_Unsorted_Continuous_Subarray {
    /*
    Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

    You need to find the shortest such subarray and output its length.

    Example 1:
    Input: [2, 6, 4, 8, 10, 9, 15]
    Output: 5
    Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
    Note:
    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

     */


    public int findUnsortedSubarray(int[] nums) {
        int dataMin = nums[nums.length-1];
        int idxMin = 0;
        int dataMax = nums[0];
        int idxMax = -1;
        for(int i = 0, j = nums.length-1 ; i < nums.length ; i++, j--){
            if( nums[j] < dataMin ){
                dataMin = nums[j];
            }else if( nums[j] > dataMin ){
                idxMin = j;
            }
            if( nums[i] > dataMax ){
                dataMax = nums[i];
            }else if( nums[i] < dataMax ){
                idxMax = i;
            }
        }
        //System.out.println("dataMin="+dataMin+", idxMin = " + idxMin);
        //System.out.println("dataMax="+dataMax+", idxMax = " + idxMax);
        return idxMax-idxMin+1;
    }

    public static void main(String[] args) {
        Shortest_Unsorted_Continuous_Subarray o = new Shortest_Unsorted_Continuous_Subarray();
        o.findUnsortedSubarray(
          new int[]{ 2,6,4,8,10,9,15 }
        );
    }
}


/*

// backup quickSort method.

    int idxLeft = 10000;
    int idxRight = -1;
    public void quickSort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){
                if( data[left] != data[right]){
                    if( left < idxLeft ) idxLeft = left;
                    if( right > idxRight ) idxRight = right;
                    int temp = data[left];
                    data[left] = data[right];
                    data[right] = temp;
                }
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) quickSort(data, l, right);
        if(r > left) quickSort(data, left, r);
    }
    public int findUnsortedSubarray(int[] nums) {
        quickSort(nums, 0 , nums.length-1);
        System.out.print("[");
        for(int i = 0; i < nums.length;i++){
            System.out.print(nums[i]+",");
        }
        System.out.println("]");
        System.out.println("idxLeft = " + idxLeft);
        System.out.println("idxRight = " + idxRight);
        return (idxLeft==10000 || idxRight==idxLeft)?0:idxRight-idxLeft+1;
    }
 */