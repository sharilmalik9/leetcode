// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k

class Solution {
   //  HashSet<String> hs= new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs= new HashSet<>();
        
      //  makeComb(k,0,"");
        String curr="";
        int st= s.length();
        for(int i=0;i<st;i++){
           // curr+=s.charAt(i);
            if(curr.length()==k){
                System.out.println(curr);
               hs.add(curr);
                curr=curr.substring(1); 
                System.out.println(curr);
            }
            curr+=s.charAt(i);
            
        }
         if(curr.length()==k){
                System.out.println(curr);
                hs.add(curr);
         }
        double exp=Math.pow(2,k);
        exp=(int)exp;
        
        
       return hs.size()==exp ? true : false;
        
    }
    
   
}