// https://leetcode.com/problems/remove-trailing-zeros-from-a-string

class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder sb= new StringBuilder();
        int idx=num.length()-1;
        while(idx>=0 && num.charAt(idx)=='0'){
            idx--;
        }
        if(idx==-1){
            return "";
        }
        
        return num.substring(0,idx+1);
        
        
        
    }
}