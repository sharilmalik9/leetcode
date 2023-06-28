// https://leetcode.com/problems/take-k-of-each-character-from-left-and-right

class Solution {
    public int takeCharacters(String s, int k) {
        int start=0;
        int end=s.length()-1;
        int[] freq=new int[3];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<3;i++){
            if(freq[i]<k){
                return -1;
            }
        }
        int l=s.length();
        int ans=Integer.MAX_VALUE;
        while(start<s.length()){
            freq[s.charAt(start)-'a']--;
            start++;
            l--;
            System.out.println(start+ " " +end+ " " + l);
            while(!check(freq,k)){
                end=(end+1)%s.length();
                freq[s.charAt(end)-'a']++;
                l++;
            }
            ans=Math.min(l,ans);
            
        }
        return ans;
    }
    public boolean check(int[] freq,int k){
        for(int i=0;i<3;i++){
            if(freq[i]<k){
                return false;
            }
        }
        return  true;
    }
}