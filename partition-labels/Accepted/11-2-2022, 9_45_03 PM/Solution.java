// https://leetcode.com/problems/partition-labels

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        HashMap<Character,Integer> hm= new HashMap<>();
        int start=0;
        int end=0;
        List<Integer> ls= new ArrayList<>();
        while(end<s.length()){
            char ch=s.charAt(end);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(hm.get(ch)==freq[ch-'a']){
                hm.remove(ch);
            }
            if(hm.size()==0){
                ls.add(end-start+1);
                start=end+1;
            }
           end++; 
        }
        return ls;
    }
}