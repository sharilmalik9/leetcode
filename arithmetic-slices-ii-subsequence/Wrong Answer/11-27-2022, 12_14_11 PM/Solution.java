// https://leetcode.com/problems/arithmetic-slices-ii-subsequence

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ansf=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        for(int i=0;i<nums.length-2;i++){
            int ans=0;
            for(int j=i+1;j<nums.length;j++){
                int elements=0;
                int diff=nums[j]-nums[i];
                int element=j;
                while(hm.containsKey(diff+nums[element]) && hm.get(diff+nums[element])>element){
                    elements++;
                    element=hm.get(diff+nums[element]);
                    
                }
                 ans+=elements;
                
                
            }
           
             ansf+=ans;
        }
        
         return ansf;
    }
}