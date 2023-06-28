// https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation

class Solution {
    public String smallestString(String s) {
        char[] arr=s.toCharArray();
        int start=0;
        while(start<s.length() && arr[start]=='a'){
            start++;
        }
        if(start==s.length()){
           arr[arr.length-1]='z';
        }
        
        for(int i=start;i<s.length();i++){
            if(arr[i]=='a'){
                break;
            }
            arr[i]=(char)(arr[i]-1);
            
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
        
    }
}