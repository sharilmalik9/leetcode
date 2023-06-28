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
        for(int i=0;i<queries.length;i++){
            int count=0;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                if(check[j]){
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;

        
        
    }
}