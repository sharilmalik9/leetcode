// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();

        int bulls =0;
        int cows = 0;
        Set<Integer> visited  = new HashSet<>();
        for(int i =0 ;i< secret.length(); i++){
            char c = secret.charAt(i);
            char g = guess.charAt(i);
            if(c==g) { 
                bulls++; 
                visited.add(i);
            }
            else { // Increase the Frequency map.
                map.put(c, map.getOrDefault(c,0)+1);
            }
        }
        for(int i =0; i <guess.length(); i++){
            char curr = guess.charAt(i);
           if(visited.contains(i)) continue; // Bulls
            if(map.containsKey(curr)){ // Cows
                cows++;
                if(map.get(curr) <=1) { 
                    map.remove(curr);
                } else 
                map.put(curr, map.get(curr)-1);
            }
        }

        return bulls+"A"+cows+"B";
    }
}