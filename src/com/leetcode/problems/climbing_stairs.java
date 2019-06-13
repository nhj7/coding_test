package com.leetcode.problems;

public class climbing_stairs {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Note: Given n will be a positive integer.

    Example 1:

    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    Example 2:

    Input: 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

    input 4
    1. 1 + 1 + 1 + 1
    2. 2 + 1 + 1
    3. 2 + 2
    4. 1 + 2 + 1
    5. 1 + 1 + 2

    input 5
    1. 1 + 1 + 1 + 1 + 1
    2. 2 + 1 + 1 + 1
    3. 2 + 2 + 1
    4. 2 + 1 + 2
    5. 1 + 2 + 1 + 1
    6. 1 + 2 + 2
    7. 1 + 1 + 2 + 1
    8. 1 + 1 + 1 + 2


    */

    // A recursive function used by countWays
    static int countWaysUtil(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
            res[i] = 0;
            for (int j=1; j<=m && j<=i; j++)
                res[i] += res[i-j];
        }
        for (int i = 0; i < res.length;i++){
            System.out.println("res["+i+"] = " + res[i]);
        }
        return res[n-1];
    }

    static int climbStairs(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }

    public static void main(String[] args) {
        System.out.println("hello wolrd.....");
        System.out.println("climbStairs : "+climbStairs(6, 2));
    }
}
