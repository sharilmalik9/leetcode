// https://leetcode.com/problems/ways-to-split-array-into-three-subarrays

class Solution {
    public int waysToSplit(int[] nums) {
        int mod = 1_000_000_007;
        int length = nums.length;
        for (int i = 1; i < length; i ++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        int max = nums[length - 1];

        int result = 0;
        for (int i = 0; i < length; i ++) {
            int leftSum = nums[i];
            if (leftSum > (max - leftSum) / 2) break;
            int minIndex = binarySearch(nums, i + 1, length - 2, leftSum, max, true);
            int maxIndex = binarySearch(nums, i + 1, length - 2, leftSum, max, false);
            // System.out.println("--------");
            // System.out.println(i);
            // System.out.println(minIndex);
            // System.out.println(maxIndex);
            if (minIndex == -1 || maxIndex == -1) continue;
            result = (result + (maxIndex - minIndex + 1) % mod) % mod;
        }

        return result;
    }

    private int binarySearch(int[] nums, int left, int right, int leftSum, int max, boolean searchMin) {
        int result = -1;
        int leftIndex = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midSum = nums[mid] - nums[leftIndex];
            int rightSum = max - nums[mid];
            if (midSum >= leftSum && rightSum >= midSum) {
                result = mid;
                if (searchMin) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (midSum < leftSum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}