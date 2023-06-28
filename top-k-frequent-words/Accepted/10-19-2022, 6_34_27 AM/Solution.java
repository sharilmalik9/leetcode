// https://leetcode.com/problems/top-k-frequent-words

class Solution {
    static class Pair implements Comparable<Pair>{
        String word;
        int f;
        public Pair(String word,int f){
            this.word=word;
            this.f=f;
        }
        public int compareTo(Pair o){
            if(o.f==this.f)return (this.word).compareTo(o.word);
            return o.f-this.f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        
        for(String word:words){
            if(map.containsKey(word))map.put(word,map.get(word)+1);
            else map.put(word,1);
        }
        
        List<Pair> l=new ArrayList<>();
        for(String key:map.keySet()){
            l.add(new Pair(key,map.get(key)));
        }
		
        Collections.sort(l);
		
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++)ans.add(l.get(i).word);
        return ans;
    }
}