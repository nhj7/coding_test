package com.leetcode.problems;

import java.util.*;


public class Kth_Smallest_Element_in_a_BST {
    /*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
    Output: 1
    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    Output: 3

    Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
    Memory Usage: 37.8 MB, less than 98.78% of Java online submissions for Kth Smallest Element in a BST.
     */
    int curIdx = 0;
    void _kthSmallest(TreeNode root, int k, int[] smallestInts){
        if( root == null ) return;
        _kthSmallest( root.left, k, smallestInts);
        if( curIdx == k ) return;
        smallestInts[curIdx++] = (root.val);
        _kthSmallest( root.right, k, smallestInts);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] smallestInts = new int[k];
        _kthSmallest(root, k, smallestInts);
        return smallestInts[k-1];
    }
    public static void main(String[] args) {

    }
}
