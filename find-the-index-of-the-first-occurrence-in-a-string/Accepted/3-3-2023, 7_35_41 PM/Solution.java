// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(!haystack.contains(needle)){
          return -1;  
        }
        else{
           for(int i=0;i<haystack.length();i++){
             if((haystack.substring(i,needle.length()+i)).equals(needle)){
                return i;
             }
           }    
        }
        return 0;
    }
}