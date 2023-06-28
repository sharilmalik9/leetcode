// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++){
                    char[] c = cur.toCharArray();
                    for(char x = 'a'; x <= 'z'; x++){
                        c[j] = x;
                        String temp = new String(c);
                        if(set.contains(temp)){
                            if(temp.equals(endWord)) return level + 1;
                            queue.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
            level++;
        }

        return 0;

    }
}