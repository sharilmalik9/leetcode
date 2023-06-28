// https://leetcode.com/problems/lexicographically-smallest-palindrome

class Solution {
    public String makeSmallestPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
       while(start<=end){
           if(s.charAt(start)-'a'==s.charAt(end)-'a'){
               start++;
               end--;
           }
           else{
               if(s.charAt(start)-'a'<s.charAt(end)-'a'){
                   s= s.substring(0,end)+s.charAt(start)+s.substring(end+1,s.length());
                   
               }
               else{
                   s= s.substring(0,start)+s.charAt(end)+s.substring(start+1,s.length());
                   
               }
               start++;
               end--;
           }
           
           
       }
        return s;
    }
}