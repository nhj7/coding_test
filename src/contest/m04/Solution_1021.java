package contest.m04;

public class Solution_1021 {
	public String removeOuterParentheses(String S) {
		if( S == null || S.length() == 0 )
		return "";		
		char[] arrChar = S.toCharArray();		
		int startIdx = -1;		
		int endIdx = -1;		
		int dupBracket = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arrChar.length;i++){
			if( arrChar[i] == '(' ){
				if( startIdx == -1 )
					startIdx = i;
				else
					dupBracket++;
			}else if( arrChar[i] == ')' ){
				if( dupBracket > 0 ) dupBracket--;
				else if( endIdx == -1 )				
					endIdx = i;				
			}
			System.out.println("startIdx : "+ startIdx + ", endIdx : " + endIdx);
			if( startIdx != -1 && endIdx != -1 ){				
				if( startIdx+1 < endIdx )
					sb.append( new String(arrChar, startIdx+1 , endIdx - startIdx - 1 ) );
				startIdx = -1;
				endIdx = -1;
			}
		}		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Solution_1021().removeOuterParentheses("()()()()(())"));
		
	}
}
