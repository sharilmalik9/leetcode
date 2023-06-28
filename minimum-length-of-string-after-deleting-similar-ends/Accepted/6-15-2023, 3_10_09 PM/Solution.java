// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends

class Solution {
    public int minimumLength(String s) {
        int low = 0, high = s.length() - 1;
            
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) break;
            
            char curr = s.charAt(low);
            while (low <= high && s.charAt(low) == curr) low++;
            while (high >= low && s.charAt(high) == curr) high--;
        }

        return high - low + 1;
    }
}