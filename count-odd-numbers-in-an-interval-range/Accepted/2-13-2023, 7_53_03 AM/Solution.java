// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range

class Solution {
    public int countOdds(int low, int high) {
        // Initialize odd with the number of even numbers between low and high.
        int odd = (high - low) / 2;
        
        // If either low or high is odd, increment odd by 1.
        if (low % 2 == 1 || high % 2 == 1) {
            odd++;
        }
        
        // Return the number of odd numbers between low and high.
        return odd;
    }
}