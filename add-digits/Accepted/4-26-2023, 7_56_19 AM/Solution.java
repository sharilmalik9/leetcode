// https://leetcode.com/problems/add-digits

class Solution {
    public int addDigits(int num) {
        int sum=0;
        int digits=0;
        while(true){
            while(num>0){
                 digits+=num%10;
                num=num/10;  
            }
            if(digits<10){
                return digits;
            }
            num=digits;
            digits=0;
        }
      
        
        
    }
}