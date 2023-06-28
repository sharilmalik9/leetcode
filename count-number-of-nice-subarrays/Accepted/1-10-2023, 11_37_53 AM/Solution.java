// https://leetcode.com/problems/count-number-of-nice-subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                ls.add(i);
            }
        }
        if(ls.size()<k){
            return 0;
        }
        int left=0;
        int right=k-1;
        int ans=0;
       
        while(right<ls.size()){
           if(left==0 && right!=ls.size()-1){
               ans+=(ls.get(left)-0+1)*(ls.get(right+1)-ls.get(right));
               


           }
           else if(left!=0 && right==ls.size()-1){
               ans+=(ls.get(left)-ls.get(left-1))*(nums.length-1 +1- ls.get(right));
               

           }
           else if(left==0 && right==ls.size()-1){
               ans+=(ls.get(0)+1) * (nums.length-ls.get(right));

           }
           else{
               ans+=(ls.get(left)-ls.get(left-1))*(ls.get(right+1)-ls.get(right));

           }
           left++;
           right++;
        }
        return ans;
    
    }
}