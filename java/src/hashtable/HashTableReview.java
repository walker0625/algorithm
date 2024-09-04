package hashtable;

import java.util.*;

/*
    <Hash Table을 사용하는 이유>

    hashTable[hashFunction(key)] = key : value

    ??? : 그냥 key를 바로 index로 삼으면 더 간단하지 않나?(ex : int[0] = 2024 -> 0 : 2024)

    cause : 1. key의 값이 0부터 시작하지 않는 경우(202123), 앞의 index가 낭비됨
            2. key의 값이 문자열인 경우(test1234), index로 사용이 불가함

    * key 충돌이 발생하면 다음 빈 index를 사용(최악의 경우 contain()에서 O(1)이 아니라 O(n)이 될 수 있음 - 매우 드문 경우)
 */
public class HashTableReview {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(twoSum(nums, 14));

        int[] nums1 = {6, 7, 100, 5, 4, 4};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(consecutiveCntBySort(nums2));
        System.out.println(consecutiveCntByHash(nums2));
    }

    private static int consecutiveCntBySort(int[] nums) {

        int maxCnt = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int curIdx = i; // 중복이 제거되지 않아 현 위치 필요
            int curCnt = 1;

            while (curIdx + 1 < nums.length && // outOfIndex 방지
                   nums[curIdx] + 1 == nums[curIdx + 1]) {
                curIdx++;
                curCnt++;
            }

            maxCnt = Math.max(curCnt, maxCnt);
        }

        return maxCnt;
    }

    private static int consecutiveCntByHash(int[] nums) {

        int maxCnt = 0;

        HashSet<Integer> set = new HashSet<>(); // Hash + 중복도 함께 제거

        for (int num : nums) {
            set.add(num);
        }
        
        for (int n : set) {
            // 정렬된게 아니라 tableIndex(0~16)를 처리하다 순서가 맞춰진 것
            // https://jwdeveloper.tistory.com/278
            // System.out.println("n = " + n);

            int curCnt = 1;

            if (!set.contains(n - 1)) { // 시작 위치인지 확인

                int target = n + 1;

                while (set.contains(target)) {
                    curCnt++;
                    target++;
                }

                maxCnt = Math.max(curCnt, maxCnt);
            }
        }

        return maxCnt;
    }

    // O(n)
    private static boolean twoSum(int[] nums, int target) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int findNum = target - num;

            // 같은 숫자 중복 사용 방지
            if(findNum != num && set.contains(findNum)) {
                return true;
            }
        }

        return false;
    }

}