package aground.sort;

import java.util.PriorityQueue;

public class UsePriorityQueueForLessLoof {

    public static void main(String[] args) {
        int[] ci = {6, 5, 5, 5, 3, 2, 1, 0};
        System.out.println(solution(ci));
    }

    public static int solution(int[] citations) {
        int hIndex = 0;

        PriorityQueue<Integer> hIndexQ = new PriorityQueue<>();

        for (int c : citations) {
            hIndexQ.add(c);
        }

        while (!hIndexQ.isEmpty()) {
            int ciSize = hIndexQ.size();
            Integer curCi = hIndexQ.poll();

            int tempHIndex = ciSize <= curCi ? ciSize : 0;
            hIndex = Math.max(tempHIndex, hIndex);
        }

        return hIndex;
    }

}
