// https://leetcode.com/problems/beautiful-arrangement

class Solution {
    List<Integer> ls;
    public int countArrangement(int n) {
        ls=new ArrayList<>();
        for(int i=1;i<=n;i++){
            ls.add(i);
        }
        return rec(0);

    }
    public int rec(int idx){
        if(ls.size()==0){
            return 1;
        }
        int ans=0;
        for(int i=0;i<ls.size();i++){
            if((idx!=0 && ls.get(i)%idx==0) || idx% ls.get(i)==0){
                int sup=ls.get(i);
                ls.remove(i);
                ans+=rec(idx+1);
                ls.add(sup);
            }

        }
        return ans;
    }
}