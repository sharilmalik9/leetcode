// https://leetcode.com/problems/sum-in-a-matrix

class Solution {
    public int matrixSum(int[][] nums) {
     List<PriorityQueue<Integer>> ls= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ls.add(new PriorityQueue<Integer>());
            for(int j=0;j<nums[0].length;j++){
                ls.get(i).add(nums[i][j]); 
            }
        }
        int finalans=0;
        while(ls.get(0).size()!=0){
            int currans=0;
            
            for(int i=0;i<ls.size();i++){
                if(ls.get(i).peek()>currans){
                    currans=ls.get(i).peek();
                }
                ls.get(i).poll();
            }
            finalans+=currans;
        }
        return finalans;
        
    }
}