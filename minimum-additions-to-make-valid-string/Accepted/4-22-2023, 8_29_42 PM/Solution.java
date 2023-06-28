// https://leetcode.com/problems/minimum-additions-to-make-valid-string

class Solution {
    public int addMinimum(String word) {
        int idx1=0;
        int ans=0;
        int idx2=0;
        String str="abc";
        while(idx2<word.length()){
            if(word.charAt(idx2)==str.charAt(idx1)){
                idx2++;
                idx1=(idx1+1)%3;
            }
            else{
                idx1=(idx1+1)%3;
                ans++;
            }

        }
        idx2=word.length()-1;
        if(word.charAt(idx2)=='a'){
            ans+=2;
        }
        if(word.charAt(idx2)=='b'){
            ans+=1;
        }
        //ans+=(2-idx1);
        return ans;
        
    }
}