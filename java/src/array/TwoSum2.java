package array;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 9;

        //System.out.println(fullSum(nums, target));
        System.out.println(twoPointer(nums, target));
    }

    public static boolean twoPointer(int[] nums, int target) {

        Arrays.sort(nums);

        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer < rightPointer) {
            if (nums[leftPointer] + nums[rightPointer] == target) {
                return true;
            } else if (nums[leftPointer] + nums[rightPointer] > target) {
                rightPointer--;
            } else if (nums[leftPointer] + nums[rightPointer] < target) {
                leftPointer++;
            }
        }

        return false;
    }

    public static boolean fullSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }


}
