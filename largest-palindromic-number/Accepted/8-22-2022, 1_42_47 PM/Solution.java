// https://leetcode.com/problems/largest-palindromic-number

class Solution {
    public String reverse(String str){
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        return rev;
    }
    public String largestPalindromic(String num) {
        
        int[] curr= new int[10];
        String ans="";
        for(int i=0;i<num.length();i++){
            int number= num.charAt(i)-'0';
            curr[number] +=1;
        }
        for(int i=9;i>0;i--){
            while(curr[i]>1){
                ans+=Integer.toString(i);
                curr[i]-=2;
            }
            
        }
        while(curr[0]>1 && ans.length()!=0){
            ans+='0';
            curr[0]-=2;
            
        }
        String rev= reverse(ans);
        for(int i=9;i>=0;i--){
            if(curr[i]==1){
                ans+=Integer.toString(i);
               break;
            }
            
        }
        ans+=rev;
        return (ans.length()==0)? "0" :ans;
        
      
       
        
    }
}