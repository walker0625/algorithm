package array;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {

        int[] arr = {1,3,2,4,5};
        int target = 7;
        //System.out.println(twoSumFullScan(arr, target));
        System.out.println(twoSumTwoPointers(arr, target));
    }

    public static boolean twoSumTwoPointers(int[] nums, int target) {

        Arrays.sort(nums);

        int leftPointer = 0, rightPointer = nums.length - 1;

        while (leftPointer < rightPointer) {
            if (nums[leftPointer] + nums[rightPointer] == target) {
                return true;
            } else if (nums[leftPointer] + nums[rightPointer] < target) {
                leftPointer++;
            } else if (nums[leftPointer] + nums[rightPointer] > target) {
                rightPointer--;
            }
        }

        return false;
    }

    public static boolean twoSumFullScan(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

}