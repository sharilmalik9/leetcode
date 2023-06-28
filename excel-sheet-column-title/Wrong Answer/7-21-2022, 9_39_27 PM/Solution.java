// https://leetcode.com/problems/excel-sheet-column-title

class Solution {
    
 
    
    public String convertToTitle(int n) {
        var sb = new StringBuilder();
        while (n > 0) {
            var letterIdx = n % 26 == 0 ? 26 : n % 26;
            sb.append((char) ('A' + letterIdx - 1));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}