// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=0;
        int start=0;
        int end=0;
        HashMap<Character,Integer> mp = new HashMap<>();
        while(end!=s.length() && start<=end){
            
            if(mp.size()==0){
                mp.put(s.charAt(end),end);
                end++;
                
            }
            else{
                if(mp.containsKey(s.charAt(end))){
                    int size=mp.size();
                    mp.clear();
                    max=Math.max(size,max);
                    start=end;
                    
                }
                else{
                    mp.put(s.charAt(end),end);
                    end++;
                }
            }
            
         
            
}
       return Math.max(mp.size(),max);
       // return max;
    }
}