package aground.hash;

import java.util.HashMap;

/**
 *  m,n,k 개를 조합 하는 경우의 수 = (m+1) * (n+1) * (k+1) - 1(공집합)
 */
public class UseMapForCombination {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> kindAndClothes = new HashMap<>();

        for (String[] cloth : clothes) {
            String kind = cloth[1];

            if (kindAndClothes.containsKey(kind)) {
               kindAndClothes.put(kind, kindAndClothes.get(kind) + 1);
            } else {
               kindAndClothes.put(kind, 1);
            }
        }

        for (Integer value : kindAndClothes.values()) {
            answer = answer * (value + 1); // +1은 아무 것도 선택하지 않는 경우
        }

        return answer - 1; // -1은 아무것도 입지 않은 경우
    }

}