package com.leetcode.problems;

import com.leetcode.RunUtil;


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
        Kth_Smallest_Element_in_a_BST main = new Kth_Smallest_Element_in_a_BST();

        System.out.println(
                main.kthSmallest(
                RunUtil.stringToTreeNode("[41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23]")
                , 25
                )
        );

    }
}
