package aground.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UseQueueForRemoveBefore {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        for (Object i : solution(prices)){
            System.out.println(i);
        }

    }

    public static Object[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for(int p : prices) {
            queue.add(p);
        }

        while (!queue.isEmpty()) {
            int time = 0;

            int curPrice = queue.poll();

            // 가장 간단한 queue 순회 방법(iterator 미사용)
            for(Integer nextPrice : queue) {
                time++;
                if (curPrice > nextPrice) {
                    break;
                }
            }

            answer.add(time);
        }

        return answer.toArray();
    }

}