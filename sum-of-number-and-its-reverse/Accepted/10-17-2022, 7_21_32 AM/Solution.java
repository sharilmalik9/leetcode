// https://leetcode.com/problems/sum-of-number-and-its-reverse

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++){
            if(i+reverse(i)==num){
                return true;
            }
            
        }
        return false;
        
    }
    public int reverse(int i){
        int ans=0;
        int rem=0;
        while(i>0){
            rem=i%10;
            i=i/10;
            ans=ans*10 + rem;
        }
        return ans;
    }
}