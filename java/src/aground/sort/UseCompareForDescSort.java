package aground.sort;

import java.util.Arrays;

public class UseCompareForDescSort {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(solution(nums));
    }

    public static String solution(int[] numbers) {

        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(Integer::toString)
                                    .toArray(String[]::new);

        // 음수가 나오면 뒤(a+b)가 더 크다는 의미가 되어 a, b 순으로 정렬됨
        // 3 -> 30 순서가 맞음 : 각 요소의 순서가 내림차순이 아니라 두조합의 정렬이 내림차순이 되도록 하기 위해 b+a가 먼저 옴
        /*
            a = "3" b = "30"
            b+a = "303" < a+b = "330"
         */
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // == 비교로 하면 잡히지 않음("0"은 문자 상수열 참조, strNumbers[0]은 배열의 값 참조)
        return strNumbers[0].equals("0") ? "0" : String.join("", strNumbers);
    }

}