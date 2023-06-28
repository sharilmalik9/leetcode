// https://leetcode.com/problems/adding-spaces-to-a-string

class Solution {
    public String addSpaces(String s, int[] spaces) {
        String ans="";
        int pnt=0;
        for(int i=0;i<s.length();i++){
            if( pnt<spaces.length && i==spaces[pnt]-1 ){
                ans+=s.charAt(i);
                    ans+=" ";
                pnt++;
            }
            else{
                ans+=s.charAt(i);
                
}
            
        }
        return ans;
        
        
    }
}