package aground.hash;

import java.util.Arrays;

public class UserSortForStartWithString {

    public static void main(String[] args) {
        String[] pb = {"97674223", "1195524421", "11567", "115"};
        System.out.println(solution(pb));
    }

    public static boolean solution(String[] pb) {
        // 정렬(nlogn)을 하지 않으면 이중 for문(n제곱)을 사용 해야 함
        // 정렬을 하게되면 앞문자부터 정렬되기 때문에 바로 다음 요소만 비교하면 됨
        // (바로 다음 요소가 일치하지 않으면 다다음은 일치 할 수 없음 - 이미 정렬된 상태)
        Arrays.sort(pb);

        for (int i = 0; i < pb.length - 1; i++) {
            if (pb[i + 1].startsWith(pb[i])) {
                return false;
            }
        }

        return true;
    }

}