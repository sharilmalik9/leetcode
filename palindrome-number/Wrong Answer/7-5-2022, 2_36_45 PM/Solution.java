// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        int safe=x;
        int ans=0;
        int hell=x;
        int pow=0;
        while(hell>0){
            hell=hell/10;
            pow++;
        }
        pow--;
        
        while(x>0){
            int reminder=x%10;
            x=x/10;
            ans+=reminder*Math.pow(10,pow);
            System.out.println(ans);
            pow--;
        }
        
       return (ans==safe ? true : false);
    }
}