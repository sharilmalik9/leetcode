// https://leetcode.com/problems/find-the-k-sum-of-an-array

class Solution {
    public  void printSubsequences(int[] arr, int index,
                                     ArrayList<Integer> path,PriorityQueue<Integer> max)
{
     
    
    if(index == arr.length)
    {
            int sum=0;
            for(int i:path){
                sum+=i;
        max.add(sum);
                

    }
    }
     
    else{
        printSubsequences(arr, index + 1, path,max);
        path.add(arr[index]);
        printSubsequences(arr, index + 1, path,max);
        path.remove(path.size() - 1);
    }
        return;
    
   
}

    public long kSum(int[] nums, int k) {
       
      ArrayList<Integer> path = new ArrayList<>();
      PriorityQueue<Integer> max= new PriorityQueue<>();
      printSubsequences(nums, 0, path,max);
       k= max.size()-k;
        long ans =0;
        for(int i=0;i<k;i++){
            ans=max.poll();
            
}
        return ans;
        
        
        
        
    }
}