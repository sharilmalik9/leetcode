// https://leetcode.com/problems/find-the-k-sum-of-an-array

class Solution {
    public  void printSubsequences(int[] arr, int index,
                                     ArrayList<Integer> path,List<Long> max)
{
     
    
    if(index == arr.length)
    {
            long sum=0;
            for(int i:path){
                sum+=i;
               
      
    }
         System.out.println(sum);
         max.add(sum);
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
      List<Long> max= new ArrayList<>();
      printSubsequences(nums, 0, path,max);
      
        long ans =0;
        Collections.sort(max);
        ans=max.get(max.size()-k);
        
        return ans;
        
        
        
        
    }
}