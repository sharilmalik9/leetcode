// https://leetcode.com/problems/sort-colors

class Solution {
    public void sortColors(int[] nums) {
        int one=0;
        int two=0;
        int three=0;
        for(int i:nums){
            switch(i){
                case 0:
                    one++;
                    break;
                case 1:
                    two++;
                    break;
                case 2:
                    three++;
                    break;
            }
        }
        int idx=0;
        while(one!=0){
            nums[idx]=0;
            one--;
            idx++;
        }
        while(two!=0){
            nums[idx]=1;
            two--;
            idx++;
        }
        while(three!=0){
            nums[idx]=2;
            three--;
            idx++;
        }
        
    }
}