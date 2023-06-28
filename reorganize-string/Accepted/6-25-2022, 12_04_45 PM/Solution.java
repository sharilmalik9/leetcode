// https://leetcode.com/problems/reorganize-string

class Solution {
    public String reorganizeString(String s) {
        
        StringBuilder st= new StringBuilder();
        Map<Character,Integer> mp= new HashMap<>();
        for(char c: s.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> pq= new PriorityQueue<>((a,b)->mp.get(b)-mp.get(a));
        pq.addAll(mp.keySet());
       
       
            while(pq.size()>1){
                char current=pq.poll();
                char next= pq.poll();
                st.append(current);
                st.append(next);
                
                    mp.put(current,mp.get(current)-1);
                mp.put(next,mp.get(next)-1);
                if(mp.get(current)>0){
                    pq.add(current);
                }
                if(mp.get(next)>0){
                    pq.add(next);
                }
                    

                
            }
        
        if(pq.size()>0){
            char last=pq.poll();
            if(mp.get(last)>1){
                return "";
            }
            
            st.append(last);
        }
        return st.toString();
        
    }
}