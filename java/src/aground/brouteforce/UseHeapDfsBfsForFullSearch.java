package aground.brouteforce;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.*;

public class UseHeapDfsBfsForFullSearch {

    public static void main(String[] args) {

        int[][] mAndN = {{80, 20}, {50, 40}, {30, 10}, {30, 10}};
        System.out.println(solution(80, mAndN));
    }

    // 답은 틀리는데 반례를 찾을 수가 없음
    public static int heap(int k, int[][] dungeons) {
        int answer = 0;

        PriorityQueue<int[]> dungeonsQ = new PriorityQueue<>(comparingInt(o -> o[1]));

        for (int[] dungeon : dungeons) {
            dungeonsQ.add(dungeon);
        }

        while(!dungeonsQ.isEmpty()) {
            int[] dungeon = dungeonsQ.poll();

            if (k >= dungeon[0]) {
                k -= dungeon[1];
                answer++;
            }
        }

        return answer;
    }

    // 추천 방식 dfs
    public static boolean check[];
    public static int ans = 0;

    public static int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return ans;
    }

    public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0]<=tired){
                check[i] = true;
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }

    public static int bfs(int k, int[][] dungeons) {
        int answer = 0;
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(k, 0, new boolean[dungeons.length]));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            answer = Math.max(answer, current.exploredCount);

            for (int i = 0; i < dungeons.length; i++) {
                if (!current.visited[i] && current.remainingFatigue >= dungeons[i][0]) {
                    boolean[] newVisited = current.visited.clone();
                    newVisited[i] = true;
                    queue.add(new State(current.remainingFatigue - dungeons[i][1], current.exploredCount + 1, newVisited));
                }
            }
        }

        return answer;
    }
}

class State {
    int remainingFatigue;
    int exploredCount;
    boolean[] visited;

    State(int remainingFatigue, int exploredCount, boolean[] visited) {
        this.remainingFatigue = remainingFatigue;
        this.exploredCount = exploredCount;
        this.visited = visited.clone();
    }
}