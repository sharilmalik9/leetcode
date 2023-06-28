// https://leetcode.com/problems/greatest-common-divisor-of-strings

class Solution {
    public String gcdOfStrings(String str1, String str2) {
         String ans="";
 for(int i=0;i<str2.length();i++){
     String cur=str2.substring(0,i+1);
     String curArray[]=str2.split(cur);
     boolean flag=true;
     for(int j=0;j<curArray.length;j++){
         if(!curArray[j].equals("")) {
             flag=false;
             break;
         }
     }
     if(flag){
         boolean falg2=true;
         String cur2Array[]=str1.split(cur);
         for(int j=0;j<cur2Array.length;j++){
             if(!cur2Array[j].equals("")) {
                 flag=false;
                 break;
             }
         }
         if(flag){
             ans=cur;
         }

     }

 }
 return  ans;
    }
}