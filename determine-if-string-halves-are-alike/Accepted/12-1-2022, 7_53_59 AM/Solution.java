// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        int left  =  0 ; // count vowels for first half ;
        int right = 0 ; // count vowels for secound half ;
        for (int i = 0 ; i< s.length()/2 ; i ++){
            char com = s.charAt(i); // char at first half ;
            char co = s.charAt(s.length()/2+i); //char at secound half ;
            if (com=='a'||com=='A'||com=='e'||com=='E'||com=='i'||com=='I'||com=='o'||com=='O'||com=='u'||com=='U'){
                left++;
            }
            if (co=='a'||co=='A'||co=='e'||co=='E'||co=='i'||co=='I'||co=='o'||co=='O'||co=='u'||co=='U'){
                right++;
            }
        }
        if (right==left){
            return true ;
        }else{
          return  false;
        }
        
    }
}