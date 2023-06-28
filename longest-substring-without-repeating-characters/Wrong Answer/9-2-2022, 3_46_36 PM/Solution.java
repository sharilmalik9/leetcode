// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int max=0;
        int start=0;
        int end=0;
        HashSet<Character> mp = new HashSet<>();
        while(end<s.length()){
            if(mp.contains(s.charAt(end))){
               Math.max(max,mp.size());
                start++;
                mp.remove(s.charAt(end));
                
            }
            else{
                mp.add(s.charAt(end));
                end++;
            }
        
            
          
            
           
            
         
            
}
       return Math.max(mp.size(),max);
      
    }
}