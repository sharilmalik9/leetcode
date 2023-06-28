// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k

class Solution {
     HashSet<String> hs= new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
      //  HashSet<String> hs= new HashSet<>();
        
        makeComb(k,0,"");
        String curr="";
        int st= s.length();
        for(int i=0;i<st;i++){
           // curr+=s.charAt(i);
            if(curr.length()==k){
                System.out.println(curr);
                if(hs.contains(curr)){
                    hs.remove(curr);
                }
                curr=curr.substring(1); 
                System.out.println(curr);
            }
            curr+=s.charAt(i);
            
        }
         if(curr.length()==k){
                System.out.println(curr);
                if(hs.contains(curr)){
                    hs.remove(curr);
                }
         }
        
        
        
       return hs.size()==0 ? true : false;
        
    }
    public void makeComb(int k,int idx,String str){
        if(idx==k){
            hs.add(str);
           // System.out.println(str);
            return;
        }
        makeComb(k,idx+1,str+"0");
        makeComb(k,idx+1,str+"1");
        
        
    }
   
}