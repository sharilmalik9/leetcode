// https://leetcode.com/problems/make-array-empty

class Solution {
    public long countOperationsToEmptyArray(int[] nums){
      long ans=0;
      HashMap<Integer,Integer> hm= new HashMap<>();
         int[] copy= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
            copy[i]=nums[i];
        }
       Arrays.sort(copy);
        for(int i=0;i<copy.length;i++){
            copy[i]=Math.abs(hm.get(copy[i])-i);
        }
        List<Integer> smaller=countSmaller(nums);
        for(int i=0;i<nums.length;i++){
            ans+=copy[i]-smaller.get(i)+1;
        }
        return ans;
       
        
    }
   
    public List<Integer> countSmaller(int[] nums) {
        int min = 20001;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        min--;
        int[] count = new int[max-min+1];
        Integer[] result = new Integer[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            int k = nums[i]-min-1;
            int c = 0;
            do {
                c += count[k];
                k -= (-k&k);
            } while (k > 0);
            result[i] = c;
            
            k = nums[i]-min;
            while (k < count.length) {
                count[k]++;
                k += (-k&k);
            }
        }
        
        return Arrays.asList(result);
    
}

}