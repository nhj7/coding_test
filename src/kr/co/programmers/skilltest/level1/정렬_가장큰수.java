package kr.co.programmers.skilltest.level1;

import java.util.*;

public class 정렬_가장큰수 {
    public String solution(int[] numbers) {

        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length;i++){
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>(){
            public int compare(String s1, String s2){
                char[] ch1 = s1.toCharArray();
                char[] ch2 = s2.toCharArray();

                int idx1 = 0;
                int idx2 = 0;

                for(int i = 0;  ch1[idx1] == ch2[idx2] ;i++){
                    if( ch1.length - 1 == idx1 && ch2.length - 1 == idx2 ){
                        break;
                    }
                    if( idx1 < ch1.length - 1)
                        idx1++;
                    else
                        idx1 = 0;
                    if( idx2 < ch2.length - 1)
                        idx2++;
                    else
                        idx2 = 0;
                }
                if( ch2[idx2] == ch1[idx1] )
                    return ch2.length - ch1.length;
                return ch2[idx2] - ch1[idx1];
            }
        });

        String answer = String.join("",strNumbers);
        if( answer.charAt(0) == '0')
            answer = "0";
        return answer;
    }
}
