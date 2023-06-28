// https://leetcode.com/problems/orderly-queue

class Solution {
    public String orderlyQueue(String s, int k){
    
        if(k==1){
          String res = s;
        for(int i=0;i<s.length();i++){
            s = s.substring(1, s.length())+s.charAt(0);
            if(res.compareTo(s)>0) res = s;
        }
        return res;
             
            
            
        }
     char[] arr=s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}