// https://leetcode.com/problems/string-compression-ii

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
       return rec(0,0,26,k,s);        
    }
    public int rec(int idx,int len,int prev,int k,String s){
        if(k<0){
            return Integer.MAX_VALUE;
        }
        if(idx>=s.length()){
          return 0;
        }
        // delete
        int ans=rec(idx+1,len,prev,k-1,s);
        //keep
        int cnt=0;
        if(s.charAt(idx)-'0'==prev){
            if(len==1|| len==9||len==99){
                cnt++;    
            }
            ans=Math.min(ans,cnt+rec(idx+1,len+1,prev,k,s));
        }
        else{
            ans=Math.min(ans,1+rec(idx+1,1,s.charAt(idx)-'0',k,s));
        }
        return ans;    
    }

}