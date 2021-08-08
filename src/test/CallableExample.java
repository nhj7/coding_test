package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableExample {
    /*

    https://thswave.github.io/java/2015/04/12/threadpoolexecutor-callable-future.html

    Callable 객체를 실행시키기 위해 executor의 submit() 메서드에 전달하여 실행하였습니다. 이 메서드는 Callable 객체를 파라미터로 받아 Future 객체를 리턴으로 돌려주는데 이는 두가지 목적이 있습니다.

    a) task의 상태(status) 제어: task를 취소할수 있고 끝났는지 체크할 수 있습니다. isDone() 메서드를 통해 task들이 끝났는지 확인할 수 있습니다.

    b) call() 메서드의 return 결과를 얻을 수 있습니다. get() 메서드를 사용하여 Callable 객체의 call() 메서드의 실행이 끝날때까지 기다려 return되는 결과를 받을 수 있습니다.
    만약 thread가 get() 메서드로 결과를 기다리고 있는 도중에 interrupt 되면 InterruptedException 예외를 던집니다.

    c) Future 인터페이스는 또다른 버전의 get() 메서드를 제공해 줍니다. i.e. get(long timeout, TimeUnit unit).
    이 버전의 get 메서드는 task의 결과를 얻을 수 없다면 특정 시간만큼 기다립니다. 만약 특정 시간이 지난 뒤에도 결과를 여전히 얻을수 없다면 메서드는 null 값을 return합니다.
     */
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            System.out.println(i+";;");
            Integer number = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        System.out.println("222222");

        try {
            //TimeUnit.MILLISECONDS.sleep(1000);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("333333");

        int idx = 1;
        for (Future<Integer> future : resultList) {
            try {
                System.out.println(idx++ +
                        "Future result is - " + " - " + future.get(	) + "; And Task done is " + future.isDone());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        // shut down the executor service now
        executor.shutdown();
    }
}