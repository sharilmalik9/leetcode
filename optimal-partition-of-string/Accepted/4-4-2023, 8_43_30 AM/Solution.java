// https://leetcode.com/problems/optimal-partition-of-string

class Solution {
    public int partitionString(String s) {
        int ans=0;
        int[] arr= new int[26];
        for(int i=0;i<s.length();i++){
            Character ch=s.charAt(i);
            if(arr[ch-'a']>0){
                Arrays.fill(arr,0);
               
                ans++;
            }
             arr[ch-'a']=1;
            
        }
        ans++;
        return ans;
        
    }
}