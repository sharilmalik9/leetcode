// https://leetcode.com/problems/minimum-average-difference

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[]prefix = new long[n];
        long[]suffix = new long[n];
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];
        for(int i = 1; i<nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i = n-2; i>=0; i--){
            suffix[i] = suffix[i+1] + nums[i];
        }

        long minimum = Long.MAX_VALUE;
        int answer = 0;
        for(int i = 0; i<nums.length; i++){

            long sumLeftHalf = prefix[i];
            long sumRightHalf = i+1 < n ? suffix[i+1] : 0;
            int leftHalfElements = i+1;
            int rightHalfElements = n-i-1;
            long leftAvg = (sumLeftHalf)/leftHalfElements;
            long rightAvg = rightHalfElements == 0 ? 0 : sumRightHalf/rightHalfElements;
            long averageDifference = Math.abs(leftAvg - rightAvg);
            if(minimum > averageDifference){
                answer = i;
                minimum = averageDifference;
            }
        }

        return answer;

    }
}