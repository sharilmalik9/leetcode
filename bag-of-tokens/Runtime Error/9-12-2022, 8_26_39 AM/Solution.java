// https://leetcode.com/problems/bag-of-tokens

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int start=0;
        int end=tokens.length;
        int score=0;
        while(start<end){
           if(power>=tokens[start]){
               power-=tokens[start];
               score++;
               start++;
           }
            else if(score>=1){
                power+=tokens[end];
                score--;
                end--;
            }
            else{
                return 0;
            }
            
            
}
        return score;
    }
}