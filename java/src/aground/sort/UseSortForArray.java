package aground.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class UseSortForArray {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4}	;
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}	;

        System.out.println(Arrays.toString(solution(array, command)));
    }

    public static Integer[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            int[] partArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(partArr);
            answer.add(partArr[commands[i][2] - 1]);
        }

        return answer.toArray(new Integer[commands.length]);
    }

}
