// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary

class Solution {
    public double average(int[] salary) {
        double sum=0;
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<salary.length;i++){
            if(salary[i]<min){
                min=salary[i];
            }
            if(salary[i]>max){
                max=salary[i];
            }
            sum+=salary[i];
        }
        double ans=(sum-max-min)/(salary.length-2);
        return ans;
        
    }
}