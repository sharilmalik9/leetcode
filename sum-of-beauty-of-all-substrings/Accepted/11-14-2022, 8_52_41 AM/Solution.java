// https://leetcode.com/problems/sum-of-beauty-of-all-substrings

class Solution {
    public int beautySum(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int[] freq=new int[26];
            freq[s.charAt(i)-'a']++;
            for(int j=i+1;j<s.length();j++){
                int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
                char ch=s.charAt(j);
                freq[s.charAt(j)-'a']++;
                int count=0;
                for(int k=0;k<26;k++){
                    if(freq[k]!=0){
                        min=Math.min(freq[k],min);
                        max=Math.max(freq[k],max);
                        count++;
                    }
                }
                if(count>1)
                ans+=(max-min);
            }
        }
        return ans;
    }
}