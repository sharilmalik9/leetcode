// https://leetcode.com/problems/power-of-two

class Solution {
    public boolean isPowerOfTwo(int n) {
        int counter = 0;
        boolean found = false;
        while(!found)
        {
            if(Math.pow(2,counter) == n)
            {
                return true;
            }
            else if(Math.pow(2,counter) > n)
            {
                return false;
            }
            counter++;
        }
        return false;
    }
}