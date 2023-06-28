// https://leetcode.com/problems/construct-smallest-number-from-di-string

class Solution {
     public Boolean check(String pattern,int[] nums){
        for(int i=0;i<pattern.length();i++){
           char curr= pattern.charAt(i);
            if(curr=='I'){
                if(nums[i]>nums[i+1]){
                    return false;   
                }
}
            if(curr=='D'){
                if(nums[i]<nums[i+1]){
                    return false; 
                }
}                    
}
        return true;
    }
    public String smallestNumber(String pattern) {
         List<List<Integer>> ans = new ArrayList<>();
        int[] nums= new int[pattern.length()+1];
        for(int i=0;i<pattern.length()+1;i++){
            nums[i]=i+1;
        }
        combo(ans,nums,0,pattern);
        String ans1="";
        for(int i:ans.get(0)){
            ans1+=i;
        }
        return ans1;
        
        
        
        
    }
     public void combo(List<List<Integer>> ans,int[] nums,int idx,String pattern){
        
        if(idx>=nums.length){
           if(check(pattern,nums)){
            List<Integer> ls= new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ls.add(nums[i]);
            }
            
            ans.add(ls);
           }
        
            return;
            
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);
            combo(ans,nums,idx+1,pattern);
            swap(nums,i,idx);
        }
   
    }
    public void swap(int[] nums,int i,int idx){
        int curr= nums[i];
        nums[i]=nums[idx];
        nums[idx]=curr;
    }
    
  
}