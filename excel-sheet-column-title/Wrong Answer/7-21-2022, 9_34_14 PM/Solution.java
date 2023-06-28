// https://leetcode.com/problems/excel-sheet-column-title

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder st= new StringBuilder();
        while(columnNumber>0){
            int i= columnNumber %10;
            columnNumber=columnNumber/10;
            st.append((char)(i-1+'A'));
}
        return st.toString();
        
    }
}