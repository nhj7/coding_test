package com.leetcode.problems;

/*

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1

*/

public class Reverse_Integer {
    public static int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
                rev = 0;
                break;
            }
            rev += x % 10;
            x /= 10;
        }
        return (int)rev;
    }

    public static void main(String[] args) {
        // 2147483647
        // 1534236469
        System.out.println( reverse(1534236469) );
    }
}
