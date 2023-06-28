// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p){
        int[] arr= new int[26];
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']+=1;
        }
        int[]  curr= new int[26];
        List<Integer> ls= new ArrayList<>();
        if(p.length()>s.length()){
            return ls;
        }
        int start=0;
        int end=0;
        while(end<p.length()){
            curr[s.charAt(end)-'a']++;
            end++;
        }
        
        if(Arrays.equals(arr,curr)){
            ls.add(start);
        }
        while(end<s.length()){
           
           
            curr[s.charAt(end)-'a']++;
              end++;
            curr[s.charAt(start)-'a']--;
            start++;
            if(Arrays.equals(arr,curr)){
                
                ls.add(start);
            } 
        }
       
        return ls;  
    }
   
}