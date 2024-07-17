package aground.queue;

import java.util.PriorityQueue;

public class UsePriorityQueueForStandard {

    public static void main(String[] args) {
        int[] sc = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(sc, 7));
    }

    public static int solution(int[] scoville, int k) {
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (!pq.isEmpty()) {
            if(pq.peek() >= k) {
                break;
            }

            Integer first = pq.poll();

            if(pq.isEmpty()) {
                return -1;
            }

            pq.add(first + (pq.poll() * 2));
            count++;
        }

        return count;
    }

}
