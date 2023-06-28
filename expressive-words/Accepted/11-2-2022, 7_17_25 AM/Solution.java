// https://leetcode.com/problems/expressive-words

class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans=0;
        for(String str:words){
            if(check(s,str)){
                ans+=1;
                System.out.println(str);
            }
        }
        return ans;
    }
    public boolean check(String s ,String str){
        if(s.equals(str)){
            return true;
        }
        if(!s.equals(str) && s.length()<=str.length()){
            return false;
        }
        int idx1=0;
        int idx2=0;
        while(idx1<s.length() && idx2<str.length()){
            if(s.charAt(idx1)==str.charAt(idx2)){
                char ch=s.charAt(idx1);
                int cnt1=0;
                int cnt2=0;
                while(idx1<s.length() &&  s.charAt(idx1)==ch){
                    idx1++;
                    cnt1++;
                }
                while(idx2<str.length() && str.charAt(idx2)==ch){
                    idx2++;
                    cnt2++;
                }
                if(cnt1<3){
                    if(cnt1!=cnt2){
                        return false;
                    }
                }
                else if(cnt2>cnt1){
                    return false;
                }
                
                
            }
            else{
                return false;
            }
           
        }
        if(idx1!=s.length() || idx2!=str.length()){
            return false;
        }
        return true;
    }
}