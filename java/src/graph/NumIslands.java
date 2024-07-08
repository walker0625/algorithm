package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    public static int countNumIslands(String[][] grid) {

        int countNumIslands = 0;
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j].equals("1") && !visited[i][j]) {
                    visited = bfs(grid, visited, i, j);
                    countNumIslands++;
                }
            }
        }

        return countNumIslands;
    }

    // java는 python과 다르게 inner method가 불가
    public static boolean[][] bfs(String[][] grid, boolean[][] visited, int i, int j) {

        int row = grid.length;
        int col = grid[0].length;

        visited[i][j] = true;

        Queue<int[]> queue = new LinkedList<>();
        // python의 tuple과 유사한 형태
        queue.add(new int[] {i, j});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int[] curQue = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nextX = curQue[0] + dx[d];
                int nextY = curQue[1] + dy[d];

                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col
                    && grid[nextX][nextY].equals("1")
                    && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        String[][] grid = {
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };

        System.out.println(countNumIslandsOne(grid));
    }

    private static int countNumIslandsOne(String[][] grid) {
        int count = 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j].equals("1")&& !visited[i][j]) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    count++;
                    while(!queue.isEmpty()) {
                        int[] currentVertex = queue.poll();
                        for (int[] direction : directions) {
                            int nextX = currentVertex[0] + direction[0];
                            int nextY = currentVertex[1] + direction[1];
                            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col
                                    && grid[nextX][nextY].equals("1") && !visited[nextX][nextY]) {
                                queue.add(new int[] {nextX, nextY});
                                visited[nextX][nextY] = true;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

}