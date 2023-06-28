// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {
    public int maxLength(List<String> arr) {
        int[] dp= new int[arr.size()+1];
        String ans="";
        for(int idx=arr.size()-1;idx>=0;idx--){
             int len=0+dp[idx+1];        
            if(checkSub(ans,arr.get(idx))){
                    len=arr.get(idx).length()+dp[idx+1];
                    ans=ans+arr.get(idx);
        }
             dp[idx]=len;
        }
        return ans.length();
        // return help(arr,0,"");
        
    }
//     public int help(List<String> arr,int idx,String ans){
//         if(idx==arr.size()){
//             return 0;
// }
//         int len=0+help(arr,idx+1,ans);
//         if(checkSub(ans,arr.get(idx))){
//            len=Math.max(len,arr.get(idx).length()+help(arr,idx+1,ans+arr.get(idx)));
//         }
//         return len;
//     }
    public boolean checkSub(String s, String t){
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                return false;
            }
            hm.put(s.charAt(i),1);
        }
        for(int i=0;i<t.length();i++){
            if(hm.containsKey(t.charAt(i))){
                return false;
            }
            hm.put(t.charAt(i),1);
        }
        return true;
    }
}