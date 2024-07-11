package aground.hash;

import java.util.HashMap;
import java.util.Map;

public class UseMapValueForDuplicateKeys {

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav", "mislav"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> pMap = new HashMap<>();

        for(String p : participant) {
            if(pMap.containsKey(p)) {
                pMap.put(p, pMap.get(p) + 1);
            } else {
                pMap.put(p, 1);
            }
        }

        for(String c : completion) {
            if(pMap.get(c) > 1) {
                pMap.put(c, pMap.get(c) -1);
            } else {
                pMap.remove(c);
            }
        }

        return pMap.keySet().iterator().next();
    }

}