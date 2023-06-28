// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k

class Solution {
   //  HashSet<String> hs= new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> hs= new HashSet<>();
        
      //  makeComb(k,0,"");
        String curr="";
        int st= s.length();
        for(int i=0;i<st-k;i++){
            curr=s.substring(i,i+k);
            hs.add(curr);
           
            
        }
        
        double exp=Math.pow(2,k);
        exp=(int)exp;
        
        
       return hs.size()==exp ? true : false;
        
    }
    
   
}