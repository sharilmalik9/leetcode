// https://leetcode.com/problems/additive-number

class Solution {
  
    String num;
    public boolean isAdditiveNumber(String nums) {
        num=nums;
        return help(0,"","",0);
    }
    public boolean help(int idx,String prev1,String prev2,int count){
        if(idx>=num.length()){
            if(count>=3){
            
                return true;
            }
            return false;
        }
        boolean ans=false;
        for(int i=idx;i<num.length();i++){
            if(i!=idx && num.charAt(idx)=='0'){
                continue;
            }
            String curr=num.substring(idx,i+1);
            
         
            if(prev1.length()==0 && prev2.length()==0){
                ans=ans || help(i+1,curr,prev2,count+1);
            }
            if(prev1.length()!=0 && prev2.length()==0){
                ans=ans|| help(i+1,prev1,curr,count+1);
            }
            if(prev1.length()!=0 && prev2.length()!=0 && check(prev1,prev2,curr)){
                ans=ans || help(i+1,prev2,curr,count+1);

            }  
        }
        return ans;
    }
    public boolean check(String prev1,String prev2,String curr){
       
        if(curr.length()<prev1.length() || curr.length()<prev2.length()){
            return false;
        }
        int idx1=prev1.length()-1;
        int idx2=prev2.length()-1;
        int carry=0;
        int idx3=curr.length()-1;
        while(idx1>=0 && idx2>=0){
            int one=prev1.charAt(idx1)-'0';
            int two=prev2.charAt(idx2)-'0';
            int three=curr.charAt(idx3)-'0';
            if((carry+one+two)%10!=three){
                return false;
            }
            carry=(one+two)/10;
            idx1--;
            idx2--;
            idx3--;
        }
        while(idx1>=0){
            if((carry+prev1.charAt(idx1)-'0')%10!=curr.charAt(idx3)-'0'){
                return false;
            }
            carry=(carry+prev1.charAt(idx1)-'0')/10;
            idx1--;
            idx3--;
        }
        while(idx2>=0){
            if((carry+prev2.charAt(idx2)-'0')%10!=curr.charAt(idx3)-'0'){
                return false;
            }
            carry=(carry+prev2.charAt(idx2)-'0')/10;
            idx2--;
            idx3--;
        }
        if(idx3>0){
            return false;
        }
        while(idx3>=0){
            if(curr.charAt(idx3)-'0'!=carry){
                return false;
            }
            idx3--;
        }
      
        return true;
    }
}