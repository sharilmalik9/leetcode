// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product

class Solution {
    public int getMaxLen(int[] nums) {
        int start=0;
        int end=0;
        int ans=0;
       while(end<nums.length){
           if(nums[end]==0){
               ans=Math.max(fnc(nums,start,end),ans);
               start=end+1;
           }
           end++;
       }

       ans=Math.max(ans,fnc(nums,start,end));
       return ans;
    }
  

   public int fnc(int[] nums,int start,int end){
       System.out.println(start +" " + end);
       List<Integer> ls=new ArrayList<>();
       for(int i=start;i<end;i++){
           if(nums[i]<0){
               ls.add(i);
           }
       }
      
       if(ls.size()%2==0){
           return end-start;
       }
       else{
           return Math.max(end-ls.get(0)-1,ls.get(ls.size()-1)-start);
       }
        
    }
}