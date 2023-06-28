// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int present=0;
        int absent=0;
        int i=0;
       while(i<s.length()){
            char ch= s.charAt(i);
            if(ch=='A'){
                absent++;
            }
            if(ch=='P'){
                present++;
            }
            else{
                int cnt=0;
                
                while(i<s.length() && s.charAt(i)=='L' ){
                    cnt++;
                    i++;
                    
                }
                if(cnt>=3){
                    return false;
                }
            }
           i++;
        }
        if(absent>=2){
            return false;
        }
        
        return true;
    }
}