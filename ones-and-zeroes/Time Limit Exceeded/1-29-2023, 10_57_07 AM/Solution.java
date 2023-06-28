// https://leetcode.com/problems/ones-and-zeroes

class Solution {
    HashMap<Integer,Integer> one= new HashMap<>();
    HashMap<Integer,Integer> zero=new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {

        for(int i=0;i<strs.length;i++){
            int cntone=0;
            int cntzero=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='1'){
                    cntone++;
                }
                else{
                    cntzero++;
                }
            }
            one.put(i,cntone);
            zero.put(i,cntzero);
            
        }
        return help(strs,0,m,n);
    }
    public int help(String[] strs,int idx,int m,int n ){
        if(idx==strs.length){
            return 0;
        }
        if(m==0 && n==0){
            return 0;
        }
        int ones=one.get(idx);
        int zeros=zero.get(idx);
        
        int include=0;
        if(m-zeros>=0 && n-ones>=0){
            include=1+help(strs,idx+1,m-zeros,n-ones);


        }
        int dont=help(strs,idx+1,m,n);
        return Math.max(include,dont);
    }
}