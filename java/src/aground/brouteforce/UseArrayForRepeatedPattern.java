package aground.brouteforce;

import java.util.ArrayList;

public class UseArrayForRepeatedPattern {

    public static void main(String[] args) {
        int[] answer = {1,2,3,4,5};

        for (int i : solution(answer)) {
            System.out.println(i);
        }
    }

    public static Integer[] solution(int[] answers) {
        ArrayList<Integer> topRankers = new ArrayList<>();

        int firstPoint = 0;
        int secondPoint = 0;
        int thirdPoint = 0;

        int[] first = {1, 2, 3, 4, 5};
        int firstLength = first.length;
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int secondLength = second.length;
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int thirdLength = third.length;

        // 정답 배열만큼 덜어내고, 다음 index를 따라간다고 이해하면 빠름
        for (int i = 0; i < answers.length; i++) {
            int curAnswer = answers[i];
            if (first[i%firstLength] == curAnswer) firstPoint++;
            if (second[i%secondLength] == curAnswer) secondPoint++;
            if (third[i%thirdLength] == curAnswer) thirdPoint++;
        }

        // key : value 구조로 여러개를 중복으로 넣고 싶을 때 쓸만한 자료구조 형태(key 중복이 가능)
        ArrayList<int[]> indexAndScore = new ArrayList<>();
        if(firstPoint != 0 ) indexAndScore.add(new int[]{1, firstPoint});
        if(secondPoint != 0 ) indexAndScore.add(new int[]{2, secondPoint});
        if(thirdPoint != 0 ) indexAndScore.add(new int[]{3, thirdPoint});

        int maxScore = 0;

        for(int[] is : indexAndScore) {
           maxScore = Math.max(maxScore, is[1]);
        }

        for(int[] is : indexAndScore) {
            if(is[1] == maxScore) topRankers.add(is[0]);
        }

        return topRankers.toArray(new Integer[topRankers.size()]);
    }

}