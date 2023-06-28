// https://leetcode.com/problems/excel-sheet-column-title

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder st= new StringBuilder();
        while(columnNumber>0){
            int i= columnNumber %26;
            columnNumber=columnNumber/26;
            st.append((char)(i-1+'A'));
}
        st=st.reverse();
        return st.toString();
        
    }
}