// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters

class Solution {
    public int longestSubstring(String s, int k){
        int ans=0;
        int start=0;
       for(;start<s.length();start++){
           int[] arr= new int[26];
           for(int i=start;i<s.length();i++){
               arr[s.charAt(i)-'a']++;
           }
           int end=s.length()-1;
           while(end>=start){
               if(!check(arr,k)){
                
                  
                   arr[s.charAt(end)-'a']--;
                    end--;
               }
               else{
                   
                   ans=Math.max(ans,end-start+1);
                   break;
               }
           }
           
       }
        
        return ans;
        
    }
    public boolean check(int[] arr,int k){
      
        for(int i=0;i<26;i++){
            if(arr[i]==0 || arr[i]>=k){
                continue;
            }
            
                return false;
            
        }
        return true;
    }
}