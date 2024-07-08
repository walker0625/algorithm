package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    public static int countShortestPath(int[][] grid) {

        int shortestCount = -1;

        int row = grid.length;
        int col = grid[0].length;

        if(grid[0][0] != 0 || grid[row-1][col-1] != 0) {
            return shortestCount;
        }

        int[][] directions = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };

        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        Queue<int []> queue = new LinkedList();
        queue.add(new int[] {0,0,1});


        while(!queue.isEmpty()) {
            int[] curQue = queue.poll();

            int curX = curQue[0];
            int curY = curQue[1];
            int curL = curQue[2];

            shortestCount = curL;

            if (curX == row -1 && curY == col -1) {
                break;
            }

            for (int[] d : directions) {
                int nextX  = curX + d[0];
                int nextY = curY + d[1];

                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col &&
                    grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, curL + 1});
                }
            }
        }

        return shortestCount;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0},
                        {1, 1, 0},
                        {1, 1, 0}};

        System.out.println(countShortestPathBfs(grid));
    }

    private static int countShortestPathBfs(int[][] grid) {

        int pathLength = -1;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0},
                              {-1,1}, {1,1}, {-1,-1}, {1,-1}};

        if (grid[0][0] != 0 && grid[row-1][col-1] != 0) {
            return pathLength;
        }

        visited[0][0] = true;
        queue.add(new int[]{0,0,1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for(int[] d : directions) {
                int nextX = current[0] + d[0];
                int nextY = current[1] + d[1];

                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col
                    && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY, current[2] + 1});
                    pathLength = current[2] + 1;
                }
            }
        }

        return pathLength;
    }

}