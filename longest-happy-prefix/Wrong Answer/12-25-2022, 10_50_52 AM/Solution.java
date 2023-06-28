// https://leetcode.com/problems/longest-happy-prefix

// KMP algo 
class Solution {
    public String longestPrefix(String s) {
int max=-1;
    int[] pref=new int[s.length()];
    int i=1;
    int j=0;
    while(i<s.length()){
        if(s.charAt(i)==s.charAt(j)){
            pref[i]=j;
            i++;
            j++;
        }
        else if(j>0){
            j=pref[j-1];
            j++;

        }
        else{
            i++;
        }
    }


        max = pref[s.length() - 1];
        return s.substring(0, max + 1);
        
    }
}