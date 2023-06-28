// https://leetcode.com/problems/score-of-parentheses

class Solution {
    public int scoreOfParentheses(String s) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        int level=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(level);
                level++;
            }
            else{
                int val=0;
                boolean been=false;
                if(hm.containsKey(level)){
                    val=hm.get(level)*2;
                    hm.remove(level);
                    been=true;
                }
                 if(hm.containsKey(level-1)){
                    val+=hm.get(level-1);
                    hm.remove(level-1);
                }
                level--;
                if(val==0){
                    hm.put(level,1);
                }
                else if(!been ){
                    hm.put(level,1+val);

                }
                else{
                    hm.put(level,val);
                } 
                
            }
        }
        return hm.get(1);

        
    }
}