package aground.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class UsePriorityQueueForAverage {

    public static void main(String[] args) {
        int[][] msAndTask = {{0, 3}, {2, 6}, {1, 9}};

        System.out.println(solution2(msAndTask));
    }

    // 미해결(아래 답 참조)
    public static int solution(int[][] jobs) {
        int ms = 0;
        int jobSize = jobs.length;

        // int[]은 자연 순서가 없으므로 compare()가 필수(int는 상관 없음)
        // PriorityQueue는 poll()을 할 때 정렬이 일어남(그냥 for 순회하면 정렬 되어 있지 않은 데이터가 나옴)
        PriorityQueue<int[]> jobQ = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        jobQ.addAll(Arrays.asList(jobs));

        while(!jobQ.isEmpty()) {

            for (int i = 0; i < jobQ.size(); i++) {
                if (jobQ.peek()[0] <= ms) {
                    ms = ms + ms + jobQ.poll()[1];
                }
            }
        }

        return ms/jobSize;
    }

    // 참조 답안 - https://junboom.tistory.com/24
    public static int solution2(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        int time = 0;
        int idx = 0;

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (idx < len || !q.isEmpty()) {
            while (idx < len && jobs[idx][0] <= time)
                q.offer(jobs[idx++]); // add와 동작은 같으나 용량제한이 있는 queue의 경우 Exception이 아니라 false 반환(java11)

            if (q.isEmpty())
                time = jobs[idx][0];
            else {
                int[] job = q.poll();
                answer += time - job[0] + job[1];
                time += job[1];
            }
        }

        return answer / len;
    }

}
