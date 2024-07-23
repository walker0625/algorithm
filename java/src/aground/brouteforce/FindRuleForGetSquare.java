package aground.brouteforce;

import java.util.Arrays;

public class FindRuleForGetSquare {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        int area = brown + yellow;

        int w;
        int h = 3; // 최소는 3

        while(true) {

            if(area%h != 0) {
                h++;
                continue;
            }

            w = area/h;

            // 각 4개의 모서리 길이를 제외하고 곱한 값이 중앙값(yellow)의 크기
            if((w-2)*(h-2) == yellow) {
                return new int[]{w, h};
            }

            h++;
        }
    }

}
