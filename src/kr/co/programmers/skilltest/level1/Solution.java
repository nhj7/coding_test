package kr.co.programmers.skilltest.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public static int solution(int n) {
    	int rtnVal = 0;
    	for(int i = 1; i <= n;i++) {
    		if( n%i==0) {
    			rtnVal += i;
    		}
    	} 
        return rtnVal;
    }
    
    public static void p2(String s) {
    	char[] arrChar = s.toCharArray();
    	Arrays.sort(arrChar);    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = arrChar.length-1; i > -1 ;i--) {
    		sb.append(arrChar[i]);
    	}    	
    	System.out.println(sb);
    }
    
    public static int p3(int n, int[] lost, int[] reserve) {
    	Arrays.sort(lost); Arrays.sort(reserve);
    	List<String> listLost = new ArrayList<String>();
    	for(int i = 0; i < lost.length;i++) {
    		listLost.add(String.valueOf(lost[i]));    	
    	}
    	List<String> listReserve = new ArrayList<String>();
    	for(int i = 0; i < reserve.length;i++) {
    		if( !listLost.contains(String.valueOf(reserve[i]))) {
    			listReserve.add(String.valueOf(reserve[i]));
    		}    			
    	}    	
    	for(Iterator<String> it = listReserve.iterator();it.hasNext();) {
    		//System.out.println("listLost : "+listLost);
    		//System.out.println("listReserve : "+listReserve);
    		Object key = it.next();
    		int reservor = Integer.parseInt(key.toString());
    		if( listLost.contains( String.valueOf(reservor-1) ) ) {
    			it.remove();
    			listLost.remove( String.valueOf(reservor-1) );
    		}else if( listLost.contains(String.valueOf(reservor+1)) ) {
    			it.remove();
    			listLost.remove(String.valueOf(reservor+1));
    		}
    	}
    	return n - listLost.size();
    	
    }
    
    public static int[] p5(int n, int m) {
    	int min = n > m ? m : n;
    	int[] rtnInt = new int[2];
    	for(int i = min; i > -1;i--) {
    		if( n % i == 0 && m % i == 0 ) {
    			rtnInt[0] = i;
    			rtnInt[1] = n*m/i;
    			break;
    		}
    	}    	
    	return rtnInt;
    }
    
    public static int p6(String s) {
    	int sign = 1;
    	if( s.startsWith("-")) {
    		sign = -1;
    	}    	
    	int answer = Integer.parseInt(s.replaceAll("[+-]", ""));
    	answer = answer * sign;
    	return answer;
    }
    
    public static int p7(int[][] board) {
    	int answer = 0;         
    	for(int i = 0 ; i < board[0].length;i++) {
    		for(int j = board.length;j > 0;j--) {
    			// devtool 이용했더니 뭔가 엄청 느리고 답답해서 그냥 삭제 해버렸음. 
    			// 테마를 쓰기 위해서 엄청 느린속도를 감당할 필요는 없겠지.... 
    		}
    	}
    	
    	return answer;
    }
    
    public static void main(String[] args) {
		//solution(626331);
    	
    	//p2("bcdZefg");
    	
    	//System.out.println( p3( 3, new int[] {3}, new int[] {1}) );
	}
}