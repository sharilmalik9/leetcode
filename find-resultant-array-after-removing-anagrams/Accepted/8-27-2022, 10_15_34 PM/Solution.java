// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans= new ArrayList<>();
        int[] arr= new int[26];
        for(int i=0;i<words[0].length();i++){
            arr[words[0].charAt(i)-'a']+=1;
}
        ans.add(words[0]);
        
        for(int i=1;i<words.length;i++){
            int[] curr= new int[26];
            for(int j=0;j<words[i].length();j++){
                curr[words[i].charAt(j)-'a']+=1;
                      }
            
            if(!check(arr,curr)){
                System.out.println(ans);
                ans.add(words[i]);
                arr=curr;
                
            } 
        }
        return ans;
    }
    public boolean check(int[] arr , int[] curr){
        for(int i=0;i<26;i++){
            if(arr[i]!=curr[i]){
                return false;
            }
        }
        return true;
    }
    
    
}