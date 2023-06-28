// https://leetcode.com/problems/4sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> st = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0;i < nums.length - 3;i++) {
            for(int j = i + 1;j < nums.length - 2;j++){
                int l = j + 1;
                int r = nums.length - 1;
                while(l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    
                    if(sum == target) {
                        ArrayList<Integer> tmap = new ArrayList<>();
                        tmap.add(nums[i]);
                        tmap.add(nums[j]);
                        tmap.add(nums[l]);
                        tmap.add(nums[r]);
                        st.add(tmap);
                        l++;
                        r--;
                    } else if(sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> i : st){
            res.add(i);
        }
        return res;
    }
}