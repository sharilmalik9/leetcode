// https://leetcode.com/problems/count-vowel-strings-in-ranges

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries){
        char[] arr={'a','e','i','o','u'};
        HashSet<Character> hs= new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        boolean[] check= new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(hs.contains(words[i].charAt(0)) && hs.contains(words[i].charAt(words[i].length()-1))){
                check[i]=true;
            }
        }
        int[] ans= new int[queries.length];
        int[] cum=new int[check.length];
        int curr=0;
        for(int i=0;i<cum.length;i++){
            if(check[i]){
                curr++;
            }
            cum[i]=curr;
        }
        for(int i=0;i<queries.length;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(start==end){
                ans[i]=check[start]==true ? 1:0;
            }
            else{
                 ans[i]=cum[queries[i][1]]-cum[queries[i][0]];
                 if(check[start]){
                     ans[i]++;
                 }

            }
           
        }
        return ans;

        
        
    }
}