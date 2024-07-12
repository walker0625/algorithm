package aground.queue;

import java.util.*;

public class UseQueueForWhileCondition {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        for (Object i : solution(progresses, speeds)) {
            System.out.println(i);
        }
    }

    public static Object[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployCount = new ArrayList<>();
        Queue<Integer> deployQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int needDays = (100 - progresses[i]) % speeds[i] == 0 ?
                    (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            deployQueue.add(needDays);
        }

        int days = 0;

        while (!deployQueue.isEmpty()) {
            int oneDaydeployCount = 0;
            days++;

            if(deployQueue.peek() == days) {
                deployQueue.poll();
                oneDaydeployCount++;

                while (!deployQueue.isEmpty() && deployQueue.peek() <= days) {
                    deployQueue.poll();
                    oneDaydeployCount++;
                }

                deployCount.add(oneDaydeployCount);
            }
        }

        return deployCount.toArray();
    }

}
