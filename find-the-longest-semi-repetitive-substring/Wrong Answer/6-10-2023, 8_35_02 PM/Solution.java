// https://leetcode.com/problems/find-the-longest-semi-repetitive-substring

class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int[] cnt=new int[10];
        int start=0;
        int end=0;
        int curr=0;
        int ans=0;
        while(end<s.length()){
            int no=s.charAt(end)-'0';
            cnt[no]++;
            if(cnt[no]>=2 ){
                    curr+=1;
            }
            if(curr>1){
                    ans=Math.max(ans,end-start);
                    while(start<end && curr>1){
                        if(cnt[s.charAt(start)-'0']!=0){
                            cnt[s.charAt(start)-'0']--;
                            curr--;
                            // if(cnt[s.charAt(start)-'0']<2){
                            //     curr--;
                            // }
                            
                        }
                        start++; 
                    
                      }
               }
            
            
            end++;
            
        }
        ans=Math.max(end-start,ans);
        return ans;
        
    }
}