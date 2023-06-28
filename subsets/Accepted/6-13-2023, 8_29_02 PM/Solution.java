// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>>res=new ArrayList<>();

     for(int num=0;num<Math.pow(2,n);num++){
       
       List<Integer>set=new ArrayList<>();
         for(int idx=0;idx<n;idx++){
             int bit=(num>>idx)&1;
             if(bit==1){
                 set.add(nums[idx]);

             }
         }

         res.add(set);

     }

     return res;
    }
}