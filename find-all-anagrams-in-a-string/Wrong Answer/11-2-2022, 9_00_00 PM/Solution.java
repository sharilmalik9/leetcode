// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p){
        int[] arr= new int[26];
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']+=1;
        }
        int[]  curr= new int[26];
        List<Integer> ls= new ArrayList<>();
        int start=0;
        int end=0;
        while(end<p.length()){
            curr[s.charAt(end)-'a']=+1;
            end++;
        }
        
        if(check(arr,curr)){
            ls.add(start);
        }
        while(end<s.length()){
           
          
             System.out.println(end);
            curr[s.charAt(end)-'a']+=1;
              end++;
            curr[s.charAt(start)-'a']-=1;
            start++;
            System.out.println(start);
            System.out.println(Arrays.toString(curr));
            if(Arrays.equals(arr,curr)){
                
                ls.add(start);
            }
            
            
        }
       
        return ls;
            
    }
    public boolean check(int[] arr,int[] curr){
        for(int i=0;i<26;i++){
            if(arr[i]!=curr[i]){
                return false;
            }
}
        return true;
    }
}