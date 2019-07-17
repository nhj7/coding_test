package com.leetcode.problems;

public class Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        while (A[i] < A[i+1]) i++;
        return i;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        Peak_Index_in_a_Mountain_Array o = new Peak_Index_in_a_Mountain_Array();
        int r = o.peakIndexInMountainArray(
                new int[]{ 0, 1,2, 1, 2, 3, 2, 1, 0}
        );

        System.out.println("r = " + r);
    }
}
