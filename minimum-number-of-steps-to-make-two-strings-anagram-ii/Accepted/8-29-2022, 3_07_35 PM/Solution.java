// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii

class Solution {
    public int minSteps(String s, String t) {
     int[] arr1= new int[26];
     int[] arr2= new int[26];
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            arr1[c-'a']+=1;
            
        }
         for(int i=0;i<t.length();i++){
            char c= t.charAt(i);
            arr2[c-'a']+=1;
            
        }
        int ans=0;
        for(int i=0;i<26;i++){
            
            if(arr1[i]!=arr2[i]){
                ans+=Math.abs(arr1[i]-arr2[i]);
                System.out.println(ans);
                
            }
        }
        return ans;
        
    }
}