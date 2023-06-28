// https://leetcode.com/problems/make-number-of-distinct-characters-equal

class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] fre1=new int[26];
        int uni1=0;
        for(int i=0;i<word1.length();i++){
            int idx=word1.charAt(i)-'a';
            if(fre1[idx]==0){
                fre1[idx]++;
                uni1++;
            }
            else{
              fre1[idx]++;
            }
        }
        int[] fre2= new int[26];
        int uni2=0;
        for(int i=0;i<word2.length();i++){
            int idx=word2.charAt(i)-'a';
            if(fre2[idx]==0){
                fre2[idx]++;
                uni2++;
            }
            else{
                fre2[idx]++;
            }
        }
        if(uni1==uni2 && word1.length()==word2.length()){
            return true;
        }
        if(uni1>uni2){
            if(uni1-uni2>1){
                return false;
            }
           
            return check(fre1,uni1,fre2,uni2);
        }
        else{
            if(uni2-uni1>1){
                return false;
            }
           
            return check(fre2,uni2,fre1,uni1);
        }
        
    }
    public boolean check(int[] one,int uni1,int[] two,int uni2){
        for(int i=0;i<26;i++){
            if(one[i]==0){
                continue;
            }
            for(int j=0;j<26;j++){
                if(two[j]==0) continue;
                one[i]--;
                one[j]++;
                two[i]++;
                two[j]--;
                if(size(one)==size(two)){
                    return true;
                }
                one[i]++;
                one[j]--;
                two[i]--;
                two[j]++;
            }
        }
       
        return false;
    }
     public int size(int aa[]) {
        int c = 0;
        for(int i = 0;i<26;i++) {
            if(aa[i] > 0) {
                c++;
            }
        }
        return c;
    } 
}