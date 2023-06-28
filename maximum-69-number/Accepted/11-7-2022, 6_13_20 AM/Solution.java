// https://leetcode.com/problems/maximum-69-number

class Solution {
    public int maximum69Number (int num) {
        StringBuilder number = new StringBuilder(String.valueOf(num));

        for (int i=0; i<number.length(); i++){
            if(number.charAt(i) == '6'){
                number.replace(i, i+1, "9");
                break;
            }
        }

        return Integer.valueOf(number.toString());
    }
}