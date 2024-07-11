package aground.hash;

import java.util.*;
import java.util.Map.Entry;

public class UseMapForSort {

    public static void main(String[] args) {
        String[] genres = {"classic", "classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 500, 600, 150, 800, 2500};

        for(Integer i : solution(genres, plays)) {
            System.out.println(i);
        }

    }

    public static Integer[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>();

        // 장르별 합계
        HashMap<String, Integer> genreTotal = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if (genreTotal.containsKey(genres[i])) {
                genreTotal.merge(genres[i], plays[i], Integer::sum);
            } else {
               genreTotal.put(genres[i], plays[i]);
            }
        }

        // 장르별 합계 내림차순
        List<Entry<String, Integer>> entryList = new ArrayList<>(genreTotal.entrySet());
        entryList.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        // <장르, <인덱스, 재생수>>
        LinkedHashMap<String, Map<Integer, Integer>> gAndIc = new LinkedHashMap<>();

        for (Entry<String, Integer> entry : entryList) {
            // 인덱스를 키로 하고 재생수를 값으로 하는 TreeMap 생성
            TreeMap<Integer, Integer> indexToPlay = new TreeMap<>((i1, i2) -> {
                // 값(value)이 같으면 인덱스(key)가 낮은 것이 먼저 오도록 정렬
                if (plays[i1] == plays[i2]) {
                    return Integer.compare(i1, i2); // 인덱스(key) 오름차순
                }
                return Integer.compare(plays[i2], plays[i1]); // 값(value) 내림차순
            });
            gAndIc.put(entry.getKey(), indexToPlay);
        }

        for (int i = 0; i < genres.length; i++) {
            if(gAndIc.containsKey(genres[i])) {
                Map<Integer, Integer> indexAndCount = gAndIc.get(genres[i]);
                indexAndCount.put(i, plays[i]);
            }
        }

        for(Entry<String, Map<Integer, Integer>> e : gAndIc.entrySet()) {
            Map trees = e.getValue();
            int count = 0; // 두 개씩 꺼내기 위한 카운터 변수
            for (Object key : trees.keySet()) {
                answerList.add((Integer) key);
                count++;
                if (count == 2) { // 두 개를 추가했으면 반복문 종료
                    break;
                }
            }
        }

        return answerList.toArray(new Integer[answerList.size()]);
    }

}
