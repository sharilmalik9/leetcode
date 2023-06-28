// https://leetcode.com/problems/maximum-product-of-word-lengths

class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words,(a,b)->b.length()-a.length());
        
        int ans = 0;
        for(int i=0;i<words.length;i++){
            if(words[i].length() * words[i].length() <= ans) break;
            
            for(int j=i+1;j<words.length;j++){
                
                if(!isCommon(words[i],words[j])){
                    ans = Math.max(ans,words[i].length()*words[j].length());
                    break;
                }
            }
        }
        return ans;
    }
    private boolean isCommon(String a,String b){
        boolean[] freq = new boolean[26];
        for(int i=0;i<a.length();i++){
            freq[a.charAt(i)-'a'] = true;
        }
        for(int i=0;i<b.length();i++){
            if(freq[b.charAt(i)-'a']) return true;
        }
        return false;
    }
}