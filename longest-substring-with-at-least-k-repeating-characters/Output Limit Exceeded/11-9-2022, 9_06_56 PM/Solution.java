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
                 //  System.out.println("hello");
                  
                   arr[s.charAt(end)-'a']--;
                    end--;
               }
               else{
                    System.out.println("hii");
                   ans=Math.max(ans,end-start+1);
                   break;
               }
           }
           
       }
        
        return ans;
        
    }
    public boolean check(int[] arr,int k){
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<26;i++){
            if(arr[i]==0 || arr[i]>=k){
                continue;
            }
            
                return false;
            
        }
        return true;
    }
}