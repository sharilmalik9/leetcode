// https://leetcode.com/problems/dota2-senate

class Solution {
    // 0=r
    //1=d
    public String predictPartyVictory(String senate) {
     Stack<Character> st= new Stack<>();
     int vote0=0;
     int vote1=0;
     if(senate.length()==1){
         return senate.charAt(0)=='R' ? "Radiant" : "Dire";
     }
     st.push(senate.charAt(0));
     for(int i=1;i<senate.length();i++){
         if(st.size()==0){
             if(senate.charAt(i)-'A'==3){
                 vote0--;
                 vote1++;
             }
             else{
                 vote1--;
                 vote0++;
             }

         }
         else if(st.peek()-'A'!=senate.charAt(i)-'A'){
             if(st.pop()-'A'==3){
                 vote1++;
             }
             else{
                 vote0++;
             }
         }
         else {
             st.push(senate.charAt(i));


         }
         
     }
     if(st.size()!=0){
         while(st.size()!=0){
             if(st.pop()-'A'==3){
                 vote1++;

             }
             else{
                 vote0++;

             }
         }
     }
     return vote0>=vote1 ? "Radiant" : "Dire";

    }
}