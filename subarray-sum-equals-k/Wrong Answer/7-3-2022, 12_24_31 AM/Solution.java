// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] nums, int k) {
        
       int start=0;
        int end=0;
        int count=0;
        int sum=0;
        if(k==0){
            return 0;
        }
        else{
            sum=nums[start];
        }
        while(end<nums.length && start<=end){
            System.out.println(sum);

            if(sum<k){
                end++;
                System.out.println("huh");
            }
            else if(sum==k){
                System.out.println(start +" " +end);
                count++;
                start++;
                end=start;
                sum=0;
                System.out.println("heh");

            }
            else if(sum>k){
                sum=sum-nums[start];
                System.out.println("huii  " + sum );
                start++;
                System.out.println("hola");
                if(end<start){
                    end=start;
                    sum+=nums[end];
                }
                continue;

            }
            if(end<nums.length) {
               // System.out.print("noww  ");
             //   System.out.println(sum);
                sum += nums[end];
                System.out.print("noww  ");
                System.out.println(sum);

            }
            else{
                break;
            }
        }
        return count;
    }
}