// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

class Solution {
    public int maxVowels(String s, int k) {
        int[] vowels=new int[26];
        int start=0;
        int end=k;
        for(int i=start;i<end;i++){
            vowels[s.charAt(i)-'a']++;
        }
        int ans=no(vowels);
        while(end<s.length()){
            vowels[s.charAt(start)-'a']--;
            vowels[s.charAt(end)-'a']++;
            ans=Math.max(ans,no(vowels));
            start++;
            end++;

        }
        return ans;


        
    }
    public int no(int[] v){
        int ans=0;
        ans+=v[0];
        ans+=v[4];
        ans+=v[8];
        ans+=v[14];
        ans+=v[20];
        return ans;

    }
}