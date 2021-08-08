package test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("aaaaa.tif",new Object[]{1, "c:/edms_path/aaaa.tif"});
        m.put("222","3434343");
        Integer[] arrKey = new Integer[m.size()];
        m.keySet().toArray(arrKey);
        System.out.println(arrKey[0]);

        String[] arrValue = new String[m.size()];
        m.values().toArray(arrValue);
        System.out.println(arrValue[0]);

        //List list = new ArrayList();
        //list.contains();
    }
}
