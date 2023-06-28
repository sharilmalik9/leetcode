// https://leetcode.com/problems/interval-list-intersections

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> ls= new ArrayList<>();
        int idx1=0;
        int idx2=0;
        while(idx1<firstList.length && idx2<secondList.length){
           List<Integer> curr= new ArrayList<>();
            curr.add(Math.max(firstList[idx1][0],secondList[idx2][0]));
            curr.add(Math.min(firstList[idx1][1],secondList[idx2][1]));
            if(curr.get(0)<=curr.get(1)){
                ls.add(curr);
            }
          if(firstList[idx1][1]<secondList[idx2][1]){
              idx1++;
          }
            else{
                 idx2++;
            }
        }
        int[][] ans= new int[ls.size()][2];
        for(int i=0;i<ls.size();i++){
            int[] curr= new int[2];
            curr[0]=ls.get(i).get(0);
            curr[1]=ls.get(i).get(1);
            ans[i]=curr;
        }
        return ans;
    }
}