package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    public static void main(String[] args) {
        String[][] grid = {
                {"1", "1", "0", "0", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "1", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };

        System.out.println(countNumIslands(grid));
    }

    private static int countNumIslands(String[][] grid) {

        int count = 0;

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int[][] directions = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j].equals("1")&& !visited[i][j]) {

                    // 아래 내용을 bfs()로 분리해도 됨
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    count++; // while 문이 한번 끝날 때 마다 1개의 섬(bfs()가 한번 끝남)이 식별됨

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