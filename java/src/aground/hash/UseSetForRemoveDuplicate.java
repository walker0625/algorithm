package aground.hash;

import java.util.HashSet;
import java.util.Set;

public class UseSetForRemoveDuplicate {

    public static int solution(int[] pos) {

        int ablePickCnt = pos.length/2;

        Set<Integer> kind = new HashSet<>();

        for (int po : pos) {
            kind.add(po);
        }

        return ablePickCnt >= kind.size() ? kind.size() : ablePickCnt ;
    }

    public static void main(String[] args) {

        int[] pos = {3,3,3,2,2,4};

        System.out.println(solution(pos));
    }

}
