// https://leetcode.com/problems/find-the-punishment-number-of-an-integer

class Solution {
    public int punishmentNumber(int n) {
        if(n==1 || n==2){
            return 1;
        }
        int ans=1;
        int curr=3;
        while(curr<=n){
            String str=Integer.toString(curr*curr);
           
            if(check(curr,0,str)){
               
                ans+=curr*curr;
            }
            curr++;
        }
        return ans;  
    }
    public boolean check(int curr,int idx,String str){
       if(idx==str.length()){
           if(curr==0){
               return true;
           }
           return false;
       }
        boolean hey=false;
        for(int i=idx;i<str.length();i++){
            String sub=str.substring(idx,i+1);
            int  num=Integer.parseInt(sub);
            if(curr>=num){
                hey=hey|| check(curr-num,i+1,str);  
            }
            
        }
        return hey;
            
        
    }
}