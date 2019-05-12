package kakao.recruit.n2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * ShuttleBus
 */
public class ShuttleBus {
    public static void getBoardingPossibleLastestTime(int n, int t, int m, String[] timeTable) {
        List listTimeTable = new ArrayList();
        for (int i = 0; i < timeTable.length; i++) {
            listTimeTable.add(timeTable[i]);
        }
        Collections.sort(listTimeTable);
        String busStopTime = "09:00";
        List boardingCrew = new ArrayList();        
        String boardingPossibleLastestTime = busStopTime;
        for(int i = 0; i < n;i++){
            int i_busStopTime = Integer.parseInt(busStopTime.replace(":", ""));
            for(Iterator it = listTimeTable.iterator(); it.hasNext();  ){
                String crew_on_time = it.next().toString();
                int i_TimeTable = Integer.parseInt(crew_on_time.replace(":", ""));
                if( i_busStopTime >= i_TimeTable ){
                    System.out.println("크루가 버스를 기다립니다 : " + crew_on_time);
                    boardingCrew.add(crew_on_time);
                    it.remove();
                }
                if( boardingCrew.size() + 1 == m && i + 1 == n ){
                    System.out.println("여기서 타야 함 : " + crew_on_time + " ~ " + busStopTime );
                    if( i_busStopTime > i_TimeTable ){                        
                        while( true ){
                            if( listTimeTable.contains(crew_on_time)){
                                boardingPossibleLastestTime = addTime(crew_on_time, -1);
                                break;
                            }
                            if( busStopTime.equals(crew_on_time)){
                                boardingPossibleLastestTime = crew_on_time;
                                break;
                            }
                            crew_on_time = addTime(crew_on_time, 1);                            
                        }
                        break;
                    }                    
                }
                if( boardingCrew.size() >= m ){
                    System.out.println(busStopTime+" 시간 버스 탑승이 끝났어요. break;");
                    break;
                }                
            } // for iterator
            if( i + 1 == n && boardingCrew.size()+listTimeTable.size() < m){
                System.out.println("무조건 막차 탑승 : " + busStopTime + ", " + boardingCrew.size());                
                boardingPossibleLastestTime = busStopTime;
            }
            if( i < n ){                
                busStopTime = addTime(busStopTime, t);
                boardingCrew.clear();
                System.out.println("다음 버스를 기다립니다. " + busStopTime);
            }else{
                boardingPossibleLastestTime = busStopTime;
            }
        }
        System.out.println("★★★ 마지막 버스는 " + boardingPossibleLastestTime + "시에 타러 와주세요~! ");
    }

    public static String addTime(String busStopTime, int t){
        String[] times = busStopTime.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]) + t;
        if( 60 <= min  ){
            hour++;
            min -= 60;
        }else if( min < 0 ){
            hour--; min = 59;
        }
        if( 24 <= hour ) hour = 9;                    
        return ( hour < 10 ? "0"+ hour : hour ) + ":" + (min<10?"0"+min:min);
    }

    public static void main(String[] args) {
        getBoardingPossibleLastestTime(
            1, 1, 5
            , new String[]{
                "08:03", "08:00","08:01","08:02"
            }
        );
        getBoardingPossibleLastestTime(
            2, 10, 2
            , new String[]{
                "09:10", "09:09","08:00"
            }
        );
        getBoardingPossibleLastestTime(
            2, 1, 2
            , new String[]{
                "09:00", "09:00","09:00", "09:00"
            }
        );
        getBoardingPossibleLastestTime(
            1, 1, 5
            , new String[]{
                "00:01", "00:01","00:01", "00:01", "00:01"
            }
        );
        getBoardingPossibleLastestTime(
            1, 1, 1
            , new String[]{
                "23:59"
            }
        );
        getBoardingPossibleLastestTime(
            10, 60, 45
            , new String[]{
                "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"
            }
        );
    }
}