package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsecutiveSeq {

    public static int consecutiveSeq1(int[] nums) {

        int longest = 0;
        Map<Integer, Boolean> numMap = new HashMap<>();

        for (int n : nums) {
            numMap.put(n, true);
        }

        for (int n : numMap.keySet()) {
            if (!numMap.containsKey(n-1)) {
                int count = 1;
                int target = n+1;

                while(numMap.containsKey(target)) {
                    count++;
                    target++;
                }

                longest = Integer.max(longest, count);
            }
        }

        return longest;
    }

    public static int consecutiveSeq2(int[] nums) {

        int longest = 0;
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int n : nums) {
            numMap.put(n, n+1);
        }

        for (int n : numMap.keySet()) {
            if (!numMap.containsKey(n-1)) {
                int count = 1;
                int target = numMap.get(n);

                while(numMap.containsKey(target)) {
                    count++;
                    target++;
                }

                longest = Integer.max(longest, count);
            }
        }

        return longest;
    }

    public static int consecutiveSeq3(int[] nums) {

        int longest = 0;
        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            numSet.add(n);
        }

        for (int n : numSet) {
            if (!numSet.contains(n-1)) {
                int count = 1;
                int target = n+1;

                while(numSet.contains(target)) {
                    count++;
                    target++;
                }

                longest = Integer.max(longest, count);
            }
        }

        return longest;
    }


    public static void main(String[] args) {
        int[] nums = {6, 7, 100, 5, 4, 4};
        System.out.println(consecutiveSeq1(nums));
        System.out.println(consecutiveSeq2(nums));
        System.out.println(consecutiveSeq3(nums));
    }

}