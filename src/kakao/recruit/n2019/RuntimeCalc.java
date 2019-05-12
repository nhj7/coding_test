package kakao.recruit.n2019;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * RuntimeCalc
 */
public class RuntimeCalc {


    public static int getRuntime( int cacheSize, String[] cities ){
        LRUCache lc = new LRUCache(cacheSize);
        int runTime = 0;
        for(int i = 0; i < cities.length;i++){
          String city = cities[i].toLowerCase();
          if( lc.get(city) != null ){
            runTime += 1;
          }else{
            runTime += 5;
            lc.put(city, "");
          }
        }
        return runTime;
    }
    public static void main(String[] args) {
        String[] p1 = new String[]{
          "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };

        System.out.println("1. "+getRuntime(3, p1));

        String[] p2 = new String[]{
          "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
        };

        System.out.println("2. "+getRuntime(3, p2));

        String[] p3 = new String[]{
          "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
        };

        System.out.println("3. "+getRuntime(2, p3));

        String[] p4 = new String[]{
          "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
        };

        System.out.println("4. "+getRuntime(5, p4));

        String[] p5 = new String[]{
          "Jeju", "Pangyo", "NewYork", "newyork"
        };

        System.out.println("5. "+getRuntime(2, p5));

        String[] p6 = new String[]{
          "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };

        System.out.println("6. "+getRuntime(0, p6));

    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    
  private static final long serialVersionUID = -1242121612914715750L;
  private int cacheSize;
  
    public LRUCache(int cacheSize) {
      super(16, (float) 0.75, true);
      this.cacheSize = cacheSize;
    }
  
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
      return size() > cacheSize;
    }

    
    public static void testLRUCache() {
      LRUCache lc = new LRUCache(3);
        lc.put("a", "1");
        lc.put("b", "2");
        lc.put("c", "3");

        System.out.println(lc);

        lc.get("a");

        System.out.println(lc);

        lc.put("d", "4");

        System.out.println(lc);

        if( lc.containsKey("a")){
            System.out.println("contains key.");
        }

        System.out.println(lc);

        lc.get("a");

        System.out.println(lc);
    }
  }