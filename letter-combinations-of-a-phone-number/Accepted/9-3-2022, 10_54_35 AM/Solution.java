// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    List<String> ans= new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        getCombo(digits,"");
        return ans;
    }
    public void getCombo(String str,String sol){
        if(str.length()==0){
            ans.add(sol);
            return;
        }
        String curr= get(str.charAt(0));
        for(int i=0;i<curr.length();i++){
            getCombo(str.substring(1),sol+curr.charAt(i));
        }
        
}
    public  String get(char ch) {
        if (ch == '2') {
            return "abc";
        } else if (ch == '3') {

            return "def";
        } else if (ch == '4') {

            return "ghi";
        } else if (ch == '5') {

            return "jkl";
        } else if (ch == '6') {

            return "mno";
        } else if (ch == '7') {

            return "pqrs";
        } else if (ch == '8') {

            return "tuv";
        } else if (ch == '9') {

            return "wxyz";
        }
        return "";
    }
}