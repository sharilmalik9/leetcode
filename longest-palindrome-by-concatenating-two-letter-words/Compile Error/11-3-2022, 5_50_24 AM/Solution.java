// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words

class Solution {
    public int longestPalindrome(String[] words) {
        public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int longestPalin = 0;
        int max = 0;

        for(String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if(map.containsKey(reversed) && map.get(reversed) > 0) {
                max += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else 
                map.put(word, map.getOrDefault(word, 0) + 1);  
        }

        for(String key : map.keySet()) {
            if(key.charAt(0) == key.charAt(1)) 
                longestPalin = Math.max(longestPalin, map.get(key));
        }

        return max + longestPalin * 2;
    }
        
    }
}