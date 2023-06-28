// https://leetcode.com/problems/reorganize-string


class Solution {
    
    class Pair{
    int ch ;
    int freq;
    Pair(int ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}

    
    public String reorganizeString(String s) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        
        int[] arr = new int[26];
        
        
        for(int i = 0; i<s.length(); i++){
            arr[s.charAt(i) - 'a'] +=1;
        }
        
        for(int i = 0; i<26; i++){
            if(arr[i] > 0){
                pq.add(new Pair(i,arr[i]));
            }
            
        }
        
        Pair prev = new Pair(-1,0);
        String ans = "";
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            
            
            if(curr.ch != prev.ch){
                ans+= (char)(curr.ch + 'a');
                curr.freq--;
                if(curr.freq!=0){
                    pq.add(curr);
                }
                prev = curr;
                
            }else{
                if(pq.isEmpty()){
                    return "";
                }
                Pair hello = pq.poll();
                ans+= (char)(hello.ch + 'a');
                hello.freq--;
                if(hello.freq!=0){
                pq.add(hello);
                }
                prev = hello;
                pq.add(curr);
            }
        }
        
        return s.length() == ans.length() ? ans : "";
        
    }
}