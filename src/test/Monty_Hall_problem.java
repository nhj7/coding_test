package test;

public class Monty_Hall_problem {
    public static void main(String[] args) {

        int normal_win_rate=0; // 바꾸지 않아서 이긴 횟수
        int normal_lose_rate=0; // 바꾸지 않아서 진 횟수
        int change_win_rate=0; // 바꿔서 이긴 횟수
        int change_lose_rate=0; // 바꿔서 진 횟수

        for(int i=0;i<100000;i++){ // 총 10만 번 반복한다.
            int reward = (int)(Math.random()*3+1); // 주최자는 1~3중 정답을 하나 숨김
            int answer = (int)(Math.random()*3+1); // 참가자는 1~3중 하나를 고름

            /*이때 주최자는 염소를 고른 뒤 참가자에게 바꿀지 말지 제안한다.*/
            
            //주최자는 참가자의 답과 보상이 아닌 것을 택함
            int val = (int)(Math.random()*3+1);
            while(reward == val || answer == val){
                val = (int)(Math.random()*3+1);
            }

            //바꾸지 않았을 시
            if(reward == answer) normal_win_rate++; //바꾸지 않아서 이겼을 경우 1승 추가
            else normal_lose_rate++; //바꾸지 않아서 졌을 경우 1패 추가

            //바꿨을 시
            int change = (int)(Math.random()*3+1);
            while(val == change || answer == change){ //이때 참가자는 바꾸기로 결정
                change = (int)(Math.random()*3+1);
            }
            if(reward == change) change_win_rate++; //바꿔서 이겼을 경우 1승 추가
            else change_lose_rate++; //바꿔서 졌을 경우 1패 추가

        }

        System.out.println("normal_win_rate : "+normal_win_rate); // 바꾸지 않아서 이긴 횟수 출력
        System.out.println("normal_lose_rate : "+normal_lose_rate); // 바꾸지 않아서 진 횟수 출력
        long normal_rate = (normal_win_rate*100)/(normal_win_rate+normal_lose_rate); //확률계산
        System.out.println("rate : "+normal_rate+"%"); //바꾸지 않아서 이길 확률
        System.out.println();

        System.out.println("change_win_rate : "+change_win_rate); // 바꿔서 이긴 횟수 출력
        System.out.println("change_lose_rate : "+change_lose_rate); // 바꿔서 진 횟수 출력
        long change_rate = (change_win_rate*100)/(change_win_rate+change_lose_rate); //확률계산
        System.out.println("rate : "+change_rate+"%"); //바꿔서 이길 확률

    }
}
