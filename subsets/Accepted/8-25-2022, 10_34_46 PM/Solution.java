// https://leetcode.com/problems/subsets

class Solution {
    List<List<Integer>> ansf= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans= new ArrayList<>();
        subs(nums,0,ans);
        return ansf;
        
        
    }
    public void subs(int[] nums,int index,List<Integer> ans){
        if(index==nums.length){
            ansf.add(new ArrayList(ans));
            return;
            
        }
        subs(nums,index+1,ans);
        ans.add(nums[index]);
        subs(nums,index+1,ans);
        ans.remove(ans.size()-1);
        
    }
}