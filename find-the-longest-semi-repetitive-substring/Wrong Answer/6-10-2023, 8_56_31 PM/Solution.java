// https://leetcode.com/problems/find-the-longest-semi-repetitive-substring

class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            int j=i;
            boolean  first=false;
            boolean got=false;
            while(j<s.length() && !got ){
                if( j !=i && s.charAt(j)==s.charAt(j-1)){
                    if(!first){
                        first=true;
                    }
                    else{
                        got=true;
                    }
                    
                }
                j++;
                
                
            }
           
            if(got){
                ans=Math.max(ans,j-i-1);
            }
            else{
                ans=Math.max(ans,j-i);
                
            }
            
        }
        return ans;
    }
}