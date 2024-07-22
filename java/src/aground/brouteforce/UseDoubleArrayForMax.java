package aground.brouteforce;

public class UseDoubleArrayForMax {

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int x = 0;
        int y = 0;

        int[][] arrangedSizes = new int[sizes.length][sizes.length];

        // 가장 큰 값을 x쪽으로 모음
        for (int i = 0; i < sizes.length; i++) {
            arrangedSizes[i] = sizes[i][0] >= sizes[i][1] ?
                    new int[]{sizes[i][0], sizes[i][1]} : new int[]{sizes[i][1], sizes[i][0]};
        }

        for (int i = 0; i < arrangedSizes.length; i++) {
            x = Math.max(x, arrangedSizes[i][0]);
            y = Math.max(y, arrangedSizes[i][1]);
        }

        return x * y;
    }

    // 다른 풀이
    public int solution2(int[][] sizes) {
        int length = 0, height = 0;

        for (int[] card : sizes) {
            // 각 명함의 가로와 세로 중 큰 값을 길이(length) 후보로, 작은 값을 높이(height) 후보로 사용
            // 긴 쪽으로 돌린 다음에 각 가로/세로에서 최대 값 구하는 것과 같음
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }

        int answer = length * height;

        return answer;
    }

}
