// https://leetcode.com/problems/maximum-units-on-a-truck

class Solution {
    public int maximumUnits(int[][] bt, int truckSize) {
        Arrays.sort(bt,Comparator.comparingDouble(o -> o[1]));
        int max = 0, cap = truckSize;
        //1st column contains no. of boxes
        //2nd column contains units per box
        for(int i=bt.length-1; i>=0; i--){
            if(cap >= bt[i][0] ){
                cap -= bt[i][0]; 
                max += bt[i][1] * bt[i][0]; 
            }
            else{
                max += bt[i][1] * cap; // cap < no. of box
                break;
            }
        }
        return max;
    }
}