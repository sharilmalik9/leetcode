// https://leetcode.com/problems/multiply-strings

class Solution {
    public String multiply(String num1, String num2) {
        long number1=0;
        for(int i=0;i<num1.length();i++){
            number1=number1*10+num1.charAt(i)-'0';
            
}
        System.out.println(number1);
        long number2=0;
        for(int i=0;i<num2.length();i++){
            number2=number2*10+num2.charAt(i)-'0';
            
}
         System.out.println(number2);
        long ans=number1*number2;
        return String.valueOf(ans);
        
        
    }
}