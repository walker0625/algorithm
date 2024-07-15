package aground.queue;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

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

        Queue<Integer> maxPriorityQueue = Arrays.stream(priorities)
                                                .boxed()
                                                .sorted(Collections.reverseOrder())
                                                .collect(Collectors.toCollection(LinkedList::new));

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
