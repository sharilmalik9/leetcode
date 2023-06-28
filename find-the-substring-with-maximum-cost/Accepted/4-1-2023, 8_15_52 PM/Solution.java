// https://leetcode.com/problems/find-the-substring-with-maximum-cost

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<chars.length();i++){
            hm.put(chars.charAt(i),vals[i]);
        }
        int[] nums= new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                nums[i]=hm.get(s.charAt(i));
                continue;
            }
            nums[i]=s.charAt(i)-'a'+1;
            
            
        }
        int curval=nums[0];
        int maxval=nums[0];
        for(int i=1;i<nums.length;i++){
            if(curval>0){
                curval=curval+nums[i];
            }
            else{
                curval=nums[i];
            }
            maxval=Math.max(curval,maxval);
        }
        if(maxval<0){
            return 0;
        }
        return maxval;
        
        
    }
}