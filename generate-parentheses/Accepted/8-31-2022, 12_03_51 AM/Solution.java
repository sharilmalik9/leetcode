// https://leetcode.com/problems/generate-parentheses

class Solution {
    List<String> finalans= new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        util(n,n,n,"");
        return finalans;
    }
    public void util(int n,int cO,int cC,String ans){
        if(cO==0 && cC==0){
            finalans.add(ans);
            return;
        }
        if(cC<cO){
            return;
        }
        if(cO>0){
            util(n,cO-1,cC,ans+"(");
        }
        if(cC>0){
            util(n,cO,cC-1,ans+")");
        }
    }
}