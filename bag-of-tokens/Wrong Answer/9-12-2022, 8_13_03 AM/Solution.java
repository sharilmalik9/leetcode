// https://leetcode.com/problems/bag-of-tokens

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int start=0;
        int end=tokens.length-1;
        int score=0;
        while(start<end){
            if(score==0){
                if(power>=tokens[start]){
                    score++;
                    power-=tokens[start];
                    start++;
                }
                else{
                    start++;
                }
            }else{
                power+=tokens[end];
                score--;
                end--;
            }
            
            
}
        return score;
    }
}