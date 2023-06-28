// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs= new HashSet<>();
        Queue<String> que= new LinkedList<>();
        que.add(beginWord);
        for(String s: wordList){
            hs.add(s);
        }
        if(!hs.contains(endWord)){
            return 0;
        }
        String curr=beginWord;
      
        int level=1;
        while(que.size()!=0){
            int size=que.size();
            while(size!=0){
                 curr=que.poll();
                for(int j=0;j<curr.length();j++){
                    char[] c = curr.toCharArray();
                    for(char x = 'a'; x <= 'z'; x++){
                        c[j] = x;
                        String temp = new String(c);
                        if(hs.contains(temp)){
                             if(temp.equals(endWord)){
                            return level+1;
                        }
                            que.add(temp);
                            hs.remove(temp);
                        }
                       
                    }
                    

                }

                size--;
            }
             level++;
           
        }
        
        return 0;
    }
}