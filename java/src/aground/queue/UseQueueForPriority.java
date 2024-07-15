package aground.queue;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class UseQueueForPriority {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<SimpleEntry> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            boolean isTarget = false;

            if (i == location) {
                isTarget = true;
            }

            queue.add(new SimpleEntry(priorities[i], isTarget));
        }

        Integer[] boxedPriorities = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedPriorities, Collections.reverseOrder());

        Queue<Integer> maxPriorityQueue = new LinkedList<>();
        for(int priority : boxedPriorities) {
            maxPriorityQueue.add(priority);
        }

        while (!queue.isEmpty()) {
            SimpleEntry task = queue.poll();
            if((Integer) task.getKey() >= maxPriorityQueue.peek()) {
                maxPriorityQueue.remove();
                answer++;
                if((Boolean) task.getValue() == true) {
                    break;
                }
            } else {
                queue.add(task);
            }
        }

        return answer;
    }

}
