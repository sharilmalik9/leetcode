// https://leetcode.com/problems/task-scheduler

class Tuple{
    char ch;
    int cnt;
    int cooldown;
    Tuple(char ch, int cnt, int cooldown){
        this.cnt = cnt;
        this.ch = ch;
        this.cooldown =cooldown ;
    }
}

class Solution {
    static int leastInterval(char tasks[], int K) {
        // code here
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> a.cooldown == b.cooldown ? b.cnt - a.cnt : a.cooldown - b.cooldown );

        HashMap<Character,Integer> mp = new HashMap<>();
        
        for(char i : tasks){
            mp.put(i, mp.getOrDefault(i,0) + 1);
        }
        System.out.println(mp);
        for(char c : mp.keySet()){
            pq.add(new Tuple(c, mp.get(c), 1));
        }
        // A,3,0
        // B,3,0


        int days = 1;
        
        while(!pq.isEmpty()){
            Tuple curr = pq.peek();
            // System.out.print(days  + " ");
            if(curr.cooldown <= days){
                pq.poll();
                // System.out.print(curr.ch);
                int cnt = curr.cnt;
                int cooldown = curr.cooldown;
                if(cnt >  1){
                    pq.add(new Tuple(curr.ch, cnt-1, cooldown + K+1));
                }
            }
            // System.out.println();
            days ++;
        }
        
        return days-1;
        
    }
}