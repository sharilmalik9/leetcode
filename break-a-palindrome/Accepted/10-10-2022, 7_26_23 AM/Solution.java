// https://leetcode.com/problems/break-a-palindrome

class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        char[] palindromeArray = palindrome.toCharArray();
        for(int i = 0; i < n / 2; ++i){
            if(palindromeArray[i] != 'a'){
                palindromeArray[i] = 'a';
                break;
            }
            else{
                if(i + 1 == n / 2){
				    // At this point our string only consists of 'a'
                    palindromeArray[n - 1] = 'b';
                }
            }
        }
        return n == 1 ? new String() : String.valueOf(palindromeArray);
    }
}