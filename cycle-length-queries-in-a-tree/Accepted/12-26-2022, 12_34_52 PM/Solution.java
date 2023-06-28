// https://leetcode.com/problems/cycle-length-queries-in-a-tree

class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int[] ans= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=getAnswer(queries,i);
        }
        return ans;






    }
    public int getAnswer(int[][] queries,int i){
        int first=queries[i][0];
        int second=queries[i][1];
        List<Integer> patha=new ArrayList<>();
        List<Integer> pathb= new ArrayList<>();
        while(first!=0){
            patha.add(first);
            first=first/2;
        }
        while(second!=0){
            pathb.add(second);
            second=second/2;
        }
        while(patha.size()>0 && pathb.size()>0 && 
        patha.get(patha.size()-1).equals(pathb.get(pathb.size()-1))){
            patha.remove(patha.size()-1);
            pathb.remove(pathb.size()-1);
        }
        return patha.size()+pathb.size()+1;


    }
}