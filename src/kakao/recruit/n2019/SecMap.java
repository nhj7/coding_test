 package kakao.recruit.n2019;

/**
 * SecMap
 */
public class SecMap {

    /**
     * @param n
     * @param arr1
     * @param arr2
     */
    public static String[] decSecmap(int n, int[] arr1, int[] arr2 ){
    	String[] returnStrings = new String[n];
        for(int i = 0; i < n;i++){
            String tmpArr1 = Integer.toBinaryString(arr1[i]);
            String tmpArr2 = Integer.toBinaryString(arr2[i]);
            tmpArr1 = String.format("%0"+n+"d", Integer.parseInt(tmpArr1));
            tmpArr2 = String.format("%0"+n+"d", Integer.parseInt(tmpArr2));
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n;j++) {
            	sb.append( Character.getNumericValue(tmpArr1.charAt(j)) | Character.getNumericValue(tmpArr2.charAt(j)) );
            }
            returnStrings[i] = sb.toString().replaceAll("0", " ").replaceAll("1", "#");
            System.out.println(returnStrings[i]);
        }
        return returnStrings;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] result = decSecmap(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28} );
        System.out.println(result);
        
        
        decSecmap(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10} );
        
    }
}
