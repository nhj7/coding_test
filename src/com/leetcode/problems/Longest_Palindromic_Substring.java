package com.leetcode.problems;

public class Longest_Palindromic_Substring  {
    /*
    Given a string s, find the longest palindromic substring in s.
    You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: "cbbd"
    Output: "bb"

    Runtime: 7 ms, faster than 75.56% of Java online submissions for Longest Palindromic Substring.
    Memory Usage: 36 MB, less than 99.98% of Java online submissions for Longest Palindromic Substring.

    */

    int max_left = 0;
    int max_right = 0;
    public String longestPalindrome(String s) {
        if( s.length() < 2 ) return s;
        char[] arrChar = s.toCharArray();
        int idxLen = arrChar.length;
        for (int i = 1; i < idxLen;i++) {
            //System.out.println("i : "+i + " : " +arrChar[i]);
            int left = 0;
            int right = 0;
            if( arrChar[i-1] == arrChar[i] ){
                left = i-1;
                right = i;
            }
            getPalindrome(arrChar, left, right);
            if( i + 1 < arrChar.length && arrChar[i-1] == arrChar[i+1]){
                left = i-1;
                right = i+1;
                getPalindrome(arrChar, left, right);
            }
            //System.out.println(i + ": r = " + tmp[0] +", "+ tmp[1]);
        }
        return new String(arrChar, max_left, max_right-max_left+1);
    }

    public void getPalindrome(char[] arrChar, int left, int right){
        for(int j = 1 ; left-1 >= 0 && right+1 < arrChar.length ;j++){
            if( arrChar[left-1] == arrChar[right+1] ){
                left--;
                right++;
            }else{
                break;
            }
        }
        if( right - left > max_right - max_left ){
            max_left = left;
            max_right = right;
        }
    }

    public static void main(String[] args) {
        Longest_Palindromic_Substring o = new Longest_Palindromic_Substring();
        System.out.println(o.longestPalindrome("babad"));
        //System.out.println(longestPalindrome("abcda"));
    }
}

/*
int max_left = 0;
    int max_right = 0;
    public String longestPalindrome(String s) {
        if( s.length() < 2 ) return s;
        char[] arrChar = s.toCharArray();
        int idxLen = arrChar.length;
        int idxHalf = s.length()/2 + ( s.length() % 2);

        for (int i = 1; i < idxLen;i++) {
            //System.out.println("i : "+i + " : " +arrChar[i]);
            int left = 0;
            int right = 0;
            if( arrChar[i-1] == arrChar[i] ){
                left = i-1;
                right = i;
            }
            getPalindrome(arrChar, left, right);
            if( i + 1 < arrChar.length && arrChar[i-1] == arrChar[i+1]){
                left = i-1;
                right = i+1;
                getPalindrome(arrChar, left, right);
            }
            //System.out.println(i + ": r = " + tmp[0] +", "+ tmp[1]);
        }
        return new String(arrChar, max_left, max_right-max_left+1);
    }

    public void getPalindrome(char[] arrChar, int left, int right){
        for(int j = 1 ; left-1 >= 0 && right+1 < arrChar.length ;j++){
            if( arrChar[left-1] == arrChar[right+1] ){
                left--;
                right++;
            }else{
                break;
            }
        }
        if( right - left > max_right - max_left ){
            max_left = left;
            max_right = right;
        }
    }
 */