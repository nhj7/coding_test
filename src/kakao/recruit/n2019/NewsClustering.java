package kakao.recruit.n2019;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewsClustering {
	
	public static void getJaccardSimilarity(String str1, String str2) {		
		System.out.println("kakao news clustering : ["+ str1+ "], ["+str2+"]");		
		char[] arrChar1 = str1.toLowerCase().toCharArray();
		char[] arrChar2 = str2.toLowerCase().toCharArray();
		List listStr1 = getCharList(arrChar1);
		List listStr2 = getCharList(arrChar2);		
		System.out.println("listStr1 : "+listStr1);
		System.out.println("listStr2 : "+listStr2);		
		List unionAll = new ArrayList();
		List interSection = new ArrayList();
		for(Iterator it = listStr1.iterator();it.hasNext();) {
			String item = it.next().toString();
			unionAll.add(item);
			it.remove();
			if( listStr2.contains(item)) {
				interSection.add(listStr2.remove(listStr2.indexOf(item)));
			}
		}		
		for(Iterator it = listStr2.iterator();it.hasNext();) {
			String item = it.next().toString();
			unionAll.add(item);
		}
		double similarity = 0.0;
		if( unionAll.size() == 0 || interSection.size() == 0 ) {
			similarity = 1;
		}else {
			similarity = (double)interSection.size() / (double)unionAll.size();
		}
		similarity = similarity==0?65536:similarity*65536;
		System.out.println("unionAll : "+unionAll);
		System.out.println("interSection : "+interSection);		
		System.out.println( "similarity : "+ similarity );
		System.out.println("========================================================");
		System.out.println();
	}	
	public static List getCharList( char[] arrChar ) {
		List listStr = new ArrayList();
		for(int i = 0; i < arrChar.length-1;i++) {
			String tmpItem = String.valueOf(arrChar[i]) + String.valueOf(arrChar[i+1]);
			//if( Pattern.matches("[a-z]{2}", tmpItem)) {
			if( tmpItem.matches("[a-z]{2}")) {
				listStr.add(tmpItem);				
			}		
		}
		return listStr;
	}
	public static void main(String[] args) {
		getJaccardSimilarity("FRANCE", "french");
		getJaccardSimilarity("handshake", "shake hands");
		getJaccardSimilarity("aa1+aa2", "AAAA12");
		getJaccardSimilarity("E=M*C^2", "e=m*c^2");
	}
}
