// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start=0;
        boolean first=true;
        int end=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                if(first){
                    start=i;
                    first=false;
                }
                else{
                     start=Math.min(start,i);
                }
                 end=Math.max(end,i+1);
                while(end!=nums.length-1 && nums[end] ==nums[end+1]){
                    end++;
                    i++;
                }
               // start=Math.min(start,i);
               
            }
        }
        if(start-end==0){
            return 0;
        }
        return end-start+1;
//         class Solution {
//     public int findUnsortedSubarray(int[] nums) {
//         int n = nums.length;
//         int[] temp = new int[n];
//         for (int i = 0; i < n; i++) {
//             temp[i] = nums[i];
//         }
//         Arrays.sort(temp);
//         int si = n;
//         int ei = 0;
//         for (int i = 0; i < n; i++) {
//             if (temp[i] != nums[i]) {
//                 si = Math.min(si, i);
//                 ei = Math.max(ei, i);
//             }
//         }
//         if (ei - si + 1 > 0) {
//             return ei - si + 1;
//         }
//         return 0;
//     }
// }
        
    }
}