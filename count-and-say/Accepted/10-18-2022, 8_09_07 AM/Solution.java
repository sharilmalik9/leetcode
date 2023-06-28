// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
      return helper(n-1,"1");
    } 

    private String helper(int n, String needToGet){
        if(n==0) return needToGet;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<needToGet.length();i++){
            int count =1;
            while( i+1 < needToGet.length() && needToGet.charAt(i) == needToGet.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(String.valueOf(count)+needToGet.charAt(i));
        }
        n--;
        return helper(n,sb.toString());
    }
}