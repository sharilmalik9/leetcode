// https://leetcode.com/problems/combination-sum-iii

class Solution {
 //   List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        help(ls,k,n,1,ans);
        return ans;
        
        
    }
    public void help(List<Integer> ls,int k,int n,int i, List<List<Integer>> ans){
        if(k==0 && n==0){
            System.out.println(ls);
            ans.add(new ArrayList<>(ls));
            return;
}
        else if(k==0 || n==0){
            return;
        }
        else if(n<0){
            return;
        }
        for(int j=i;j<=9;j++){
            ls.add(j);
            help(ls,k-1,n-j,j+1,ans);
            ls.remove(ls.size()-1);
        }
    }
}