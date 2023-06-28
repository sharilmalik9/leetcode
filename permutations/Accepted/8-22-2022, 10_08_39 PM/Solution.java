// https://leetcode.com/problems/permutations

class Solution {
    public void combo(List<List<Integer>> ans,int[] nums,int idx){
        
        if(idx>=nums.length){
            List<Integer> ls= new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ls.add(nums[i]);
            }
            ans.add(ls);
            return;
            
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            combo(ans,nums,idx+1);
            swap(nums,i,idx);
        }
        
        
        
        
        
        
    }
    public void swap(int[] nums,int i,int idx){
        int curr= nums[i];
        nums[i]=nums[idx];
        nums[idx]=curr;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        combo(ans,nums,0);
        return ans ;
        
        
        
    }
}