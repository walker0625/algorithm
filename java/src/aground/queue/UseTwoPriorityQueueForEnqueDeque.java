package aground.queue;

import java.util.*;

/*
    peek() : O(1) - 하위 요소 정렬은 이뤄지지 않음
    poll() : O(log n) - 하위 요소 정렬과 함께 해당 요소 제거(return 해당 요소)
    remove(arg) : O(n) - remove()도 가능하나 poll()이 더 효율적 : arg에 해당하는 요소 제거(return boolean)
 */
public class UseTwoPriorityQueueForEnqueDeque {

    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {

        int[] answer = {0, 0};

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {

            String action = operation.split(" ")[0];
            Integer value = Integer.parseInt(operation.split(" ")[1]);

            if ("I".equals(action)) {
                minQ.add(value);
                maxQ.add(value);
            } else {
                if (value == -1) {
                    maxQ.remove(minQ.poll());
                } else {
                    minQ.remove(maxQ.poll());
                }
            }
        }

        if(!minQ.isEmpty() && !maxQ.isEmpty()) {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }

        return answer;
    }

}