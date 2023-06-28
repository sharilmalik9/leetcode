// https://leetcode.com/problems/arithmetic-subarrays

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans= new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int start=l[i];
            int end=r[i];
            ans.add(check(nums,start,end));
           // System.out.println(Arrays.toString(nums));
        }
        return ans;
    }
    public boolean check(int[] nums, int start,int end){
        int[] arr= new int[end-start+1];
        int index=0;
        for(int i=start;i<=end;i++){
            arr[index]=nums[i];
            index++;
        }
      //   System.out.println(Arrays.toString(arr));
       Arrays.sort(arr);
    //   System.out.println(Arrays.toString(arr));
        if(arr.length==0){
            return true;
        }
        if(arr.length==1){
            return true;
        }
        int difference=arr[1]-arr[0];
        for(int i=1;i<arr.length-1;i++){
            int currd=arr[i+1]-arr[i];
            if(difference!=currd){
                return false;
            }
            
        }
        
        
        
        return true;
        
                }
}